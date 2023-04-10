package codegen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import ast.Ast;
import ast.AstVisitor;
import ast.FieldCreate;
import ast.ForExp;
import ast.FunDec;
import ast.Id;
import ast.RecCreate;
import ast.RecCreateFields;
import ast.RecType;
import ast.Subscript;
import ast.TypeDec;
import ast.TypeDecs;
import ast.VarDecNoType;
import symtab.scope.Scope;
import symtab.symbol.Symbol;

public class CodegenVisitor implements AstVisitor<String> {

    public String IncludeSection;
    public String DataSection;
    public String TextSection;
    public Map<String, Scope> TDS;
    public LinkedList<ast.Ast> funDecQueue = new LinkedList<ast.Ast>();
    public Stack<Integer> break_stack = new Stack<Integer>();

    public int currentWhileLoop = 0;
    public int AND_count = 0;
    public int OR_count = 0;

    public CodegenVisitor(Map<String, Scope> symtab) {
        this.TDS = symtab;
        int ImbLvlMax = -1;
        for (String key : symtab.keySet()) {
            int ImbLvl = symtab.get(key).getImbricationLevel();
            ImbLvlMax = ImbLvlMax < ImbLvl ? ImbLvl : ImbLvlMax;
        }
        this.DataSection = ".data\n\n\tDISPLAY: .space " + 4 * (ImbLvlMax + 1) + "\n";
        this.TextSection = ".text\n\n.global _start\n\n_start:\n\n";
        this.TextSection += "\tLDR R10,=DISPLAY\n";
        this.IncludeSection = ".include     \"Base_function.s\"\n";
    }

    public void dumpOutput(String filepath) throws IOException {

        FileOutputStream output = new FileOutputStream(filepath);

        String compiledText =
                this.IncludeSection + "\n" + this.DataSection + "\n" + this.TextSection;
        byte[] compiledBytes = compiledText.getBytes();

        output.write(compiledBytes);
        output.close();
    }

    public String searchScope(String currentScopeId, String symbolname) {
        Scope Scope = this.TDS.get(currentScopeId);
        Symbol symbol = Scope.getSymbol(symbolname);
        if (symbol == null) {
            return searchScope(Scope.getParentScope(), symbolname);
        } else {
            return currentScopeId;
        }
    }

    public String infixValueCodeGen(ast.Ast left, ast.Ast right) {
        String leftValueCode;
        String rightValueCode;

        if (left instanceof ast.IntLiteral) {
            ast.IntLiteral leftInt = (ast.IntLiteral) left;
            leftValueCode = "\tMOV     R8,#" + leftInt.value + "\n";
        } else {
            left.accept(this);
            this.TextSection += "\tPUSH       {R8}\n";
            leftValueCode = "\tPOP     {R8}\n";
        }
        if (right instanceof ast.IntLiteral) {
            ast.IntLiteral rightInt = (ast.IntLiteral) right;
            rightValueCode = "\tMOV     R9,#" + rightInt.value + "\n";
        } else {
            right.accept(this);
            this.TextSection += "\tPUSH       {R8}\n";
            rightValueCode = "\tPOP     {R9}\n";
        }
        return rightValueCode + leftValueCode;
    }

    public String visit(ast.Program program) {
        program.exp.accept(this);
        this.TextSection += "\n@  EXIT WITH 0 VALUE\n";
        this.TextSection += "\tMOV      R8,#0\n";
        this.TextSection += "\tPUSH     {R8}\n";
        this.TextSection += "\tBL     exit\n\n";
        this.TextSection += "\n@____________________________\n@ Function Section \n\n";

        while (this.funDecQueue.size() > 0) {
            this.TextSection += "\n";
            funDecQueue.poll().accept(this);
        }

        return null;
    }

    public String visit(ast.Assign assign) {
        if (assign.lValue instanceof ast.Subscript) {
            this.TextSection += "\tPUSH     {R0,R1,R2}\n";
            Subscript subscript = (Subscript) assign.lValue;
            subscript.lValue.accept(this);
            this.TextSection += "\tPUSH     {R8}\n";
            subscript.expr.accept(this);
            this.TextSection += "\tPUSH     {R8}\n";
            assign.expr.accept(this);

            this.TextSection += "\tMOV     R2,R8\n";// R2 = valeur
            this.TextSection += "\tPOP     {R1}\n"; // R1 = index
            this.TextSection += "\tPOP     {R0}\n"; // R0 = adress
            this.TextSection += "\tLDR      R8,[R0],#4\n";
            this.TextSection += "\tCMP      R1,R8\n";
            this.TextSection += "\tBge        _ERROR_index_out_of_range\n";
            this.TextSection += "\tCMP      R1,#0\n";
            this.TextSection += "\tBlt        _ERROR_index_out_of_range\n";
            this.TextSection += "\tSTR      R2,[R0,R1,LSL #2]\n";
            this.TextSection += "\tPOP     {R0,R1,R2}\n";

        } else {
            Id id = (Id) assign.lValue;
            String ScopeId = this.searchScope(id.scopeId, id.name + "_VAR");
            int deplacement = TDS.get(ScopeId).getSymbol(id.name + "_VAR").getDisplacement();
            assign.expr.accept(this);
            if (id.scopeId.equals(ScopeId)) {
                this.TextSection += "\tSTR    R8,[R11,#" + deplacement + "*-4]\n";
            } else {
                int imbricationLvl = this.TDS.get(ScopeId).getImbricationLevel();
                this.TextSection += "\tLDR    R12,[R10,#" + imbricationLvl + "*4]\n";
                this.TextSection += "\tSTR    R8,[R12,#" + deplacement + "*-4]\n";
            }
        }
        return null;
    }

    public String visit(ast.Or or) {
        this.OR_count += 1;
        int id = this.OR_count;
        or.left.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection += "\tBNE      _OR_SKIP_" + id + "\n";
        or.right.accept(this);
        this.TextSection += "_OR_SKIP_" + id + ":\n";
        return null;
    }

    public String visit(ast.And and) {
        this.AND_count += 1;
        int id = this.AND_count;
        and.left.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection += "\tBEQ      _AND_SKIP_" + id + "\n";
        and.right.accept(this);
        this.TextSection += "_AND_SKIP_" + id + ":\n";
        return null;
    }

    public String visit(ast.Eq eq) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(eq.left, eq.right);
        this.TextSection += infixValueCode;

        if (eq.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        } ;
        this.TextSection += "\tMOVeq   R8,#1\n";
        this.TextSection += "\tMOVne   R8,#0\n";
        return null;
    }

    public String visit(ast.NotEq notEq) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(notEq.left, notEq.right);
        this.TextSection += infixValueCode;
        if (notEq.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        }
        this.TextSection += "\tMOVeq   R8,#0\n";
        this.TextSection += "\tMOVne   R8,#1\n";
        return null;
    }

    public String visit(ast.InfEq infEq) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(infEq.left, infEq.right);
        this.TextSection += infixValueCode;
        if (infEq.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        }
        this.TextSection += "\tMOVle   R8,#1\n";
        this.TextSection += "\tMOVgt   R8,#0\n";
        return null;
    }

    public String visit(ast.Inf inf) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(inf.left, inf.right);
        this.TextSection += infixValueCode;
        if (inf.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        }
        this.TextSection += "\tMOVlt   R8,#1\n";
        this.TextSection += "\tMOVge   R8,#0\n";
        return null;
    }

    public String visit(ast.SupEq supEq) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(supEq.left, supEq.right);
        this.TextSection += infixValueCode;
        if (supEq.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        }
        this.TextSection += "\tMOVge   R8,#1\n";
        this.TextSection += "\tMOVlt   R8,#0\n";
        return null;
    }

    public String visit(ast.Sup sup) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(sup.left, sup.right);
        this.TextSection += infixValueCode;
        if (sup.type.equals("string_TYPE")) {
            this.TextSection += "\tPUSH     {R8,R9}\n";
            this.TextSection += "\tBL       strcmp\n";
            this.TextSection += "\tADD       R13,R13,#8\n";
            this.TextSection += "\tCMP     R8,#0\n";
        } else {
            this.TextSection += "\tCMP     R8,R9\n";
        }
        this.TextSection += "\tMOVgt   R8,#1\n";
        this.TextSection += "\tMOVle   R8,#0\n";
        return null;
    }

    public String visit(ast.Add add) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(add.left, add.right);
        this.TextSection += infixValueCode;
        this.TextSection += "\tADD     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.Sub sub) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(sub.left, sub.right);
        this.TextSection += infixValueCode;
        this.TextSection += "\tSUB     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.Mult mult) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(mult.left, mult.right);
        this.TextSection += infixValueCode;
        this.TextSection += "\tPUSH     {R0}\n";
        this.TextSection += "\tMUL      R0,R8,R9\n";
        this.TextSection += "\tMOV      R8,R0\n";
        this.TextSection += "\tPOP      {R0}\n";
        return null;
    }

    public String visit(ast.Div div) {
        this.TextSection += "\n";
        String infixValueCode = infixValueCodeGen(div.left, div.right);
        this.TextSection += infixValueCode;
        this.TextSection += "\tCMP      R9,#0\n";
        this.TextSection += "\tBEQ      ERROR_divide_by_zero\n";
        this.TextSection += "\tSDIV     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.SeqExp seqExp) {
        for (ast.Ast exp : seqExp.exprs) {
            this.TextSection += "\n";
            exp.accept(this);
        }
        return null;
    }

    public String visit(ast.Neg neg) {
        neg.expr.accept(this);
        this.TextSection += "\tMOV    R9,#0\n";
        this.TextSection += "\tSUB    R8,R9,R8\n";
        return null;
    }

    public String visit(ast.IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection +=
                "\tBNE      _IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + "\n";
        this.TextSection +=
                "\tBEQ      _ELSE_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + "\n";
        this.TextSection += "_IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        ifThenElse.thenExpr.accept(this);
        this.TextSection += "\tB        _END_IF_" + ifThenElse.lineNumber + "_"
                + ifThenElse.columnNumber + "\n";
        this.TextSection +=
                "_ELSE_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        if (ifThenElse.elseExpr != null) {
            ifThenElse.elseExpr.accept(this);
        }
        this.TextSection += "\tB        _END_IF_" + ifThenElse.lineNumber + "_"
                + ifThenElse.columnNumber + "\n";
        this.TextSection +=
                "_END_IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        return null;
    }

    public String visit(ast.WhileExp whileExp) {
        this.currentWhileLoop += 1;
        int id = this.currentWhileLoop;
        this.break_stack.push(id);
        this.TextSection += "_LOOP_" + id + ":\n";
        whileExp.condition.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection += "\tBEQ      _END_LOOP_" + id + "\n";
        whileExp.doExpr.accept(this);
        this.TextSection += "\tB        _LOOP_" + id + "\n";
        this.TextSection += "_END_LOOP_" + id + ":\n";
        this.break_stack.pop();
        return null;
    }

    public String visit(ast.LetDecls letDecls) {
        for (ast.Ast dec : letDecls.decls) {
            if (dec instanceof FunDec) {
                this.funDecQueue.add(dec);
            } else {
                dec.accept(this);
            }
        }
        return null;
    }

    public String visit(ast.LetScope letScope) {
        for (Ast exp : letScope.exprs) {
            this.TextSection += "\n";
            exp.accept(this);
        }
        return null;
    }

    public String visit(ast.LetExp letExp) {
        this.TextSection += "\tPUSH        {R11}\n";
        this.TextSection += "\tMOV         R11,R13\n";

        int imbricationLvl = this.TDS.get(letExp.ScopeID).getImbricationLevel();

        this.TextSection += "\tLDR         R12,[R10,#" + imbricationLvl + "*4]\n";
        this.TextSection += "\tPUSH        {R12}\n";
        this.TextSection += "\tSTR         R11,[R10,#" + imbricationLvl + "*4]\n";

        letExp.letDecls.accept(this);

        this.TextSection += "\n@ empile les registres de travail \n\tPUSH       {R0-R7}\n";

        letExp.letScope.accept(this);

        this.TextSection += "\n@ dépile les registres de travail \n\tPOP        {R0-R7}\n";

        this.TextSection += "\tPOP      {R12}\n";
        this.TextSection += "\tSTR         R12,[R10,#" + imbricationLvl + "*4]\n";

        this.TextSection += "\tMOV         R13,R11\n";
        this.TextSection += "\tPOP         {R11}\n";


        return null;
    }

    public String visit(ast.CallExpArgs callExpArgs) {
        for (ast.Ast arg : callExpArgs.args) {
            arg.accept(this);
            this.TextSection += "\tPUSH     {R8}\n";
        }
        return null;
    }

    public String visit(ast.CallExp callExp) {
        callExp.args.accept(this);
        this.TextSection += "\tBL     " + callExp.id.name + "\n";
        int nbArgs = callExp.args.args.size();
        this.TextSection += "\tADD      R13,R13,#" + 4 * nbArgs + "\n";
        return null;
    }

    public String visit(ast.FieldDec fieldDec) {
        // TODO
        return null;
    }

    public String visit(ast.VarDecType varDecType) {
        varDecType.varValue.accept(this);
        this.TextSection += "\tPUSH     {R8}\n";
        return null;
    }

    public String visit(ast.VarDecNoType varDecNoType) {
        varDecNoType.varValue.accept(this);
        this.TextSection += "\tPUSH     {R8}\n";
        return null;
    }

    public String visit(ast.FunArgs funArgs) {
        // TODO
        return null;
    }

    public String visit(ast.FunDec funDec) {
        // String saveR8 = funDec.returnTypeId.name == "void" ? "\tPUSH {R8}\n" : "";
        // String chargeR8 = funDec.returnTypeId.name == "void" ? "\tPOP {R8}\n" : "";

        this.TextSection += "" + funDec.id.name + ":\n";
        this.TextSection += "\tPUSH        {R11,LR}\n";
        this.TextSection += "\tMOV         R11,R13\n";

        int imbricationLvl = this.TDS.get(funDec.ScopeID).getImbricationLevel();

        this.TextSection += "\tLDR         R12,[R10,#" + imbricationLvl + "*4]\n";
        this.TextSection += "\tPUSH        {R12}\n";
        this.TextSection += "\tSTR         R11,[R10,#" + imbricationLvl + "*4]\n";

        // this.TextSection += saveR8;
        funDec.body.accept(this);
        // this.TextSection += chargeR8;

        this.TextSection += "\tPOP      {R12}\n";
        this.TextSection += "\tSTR         R12,[R10,#" + imbricationLvl + "*4]\n";

        this.TextSection += "\tMOV         R13,R11\n";
        this.TextSection += "\tPOP         {R11,PC}\n";

        return null;
    }

    public String visit(ast.Id id) {
        String ScopeId = this.searchScope(id.scopeId, id.name + "_VAR");
        int deplacement = TDS.get(ScopeId).getSymbol(id.name + "_VAR").getDisplacement();
        if (id.scopeId.equals(ScopeId)) {
            this.TextSection += "\tLDR    R8,[R11,#" + deplacement + "*-4]\n";
        } else {
            int imbricationLvl = this.TDS.get(ScopeId).getImbricationLevel();
            this.TextSection += "\tLDR    R12,[R10,#" + imbricationLvl + "*4]\n";
            this.TextSection += "\tLDR    R8,[R12,#" + deplacement + "*-4]\n";
        }
        return null;
    }

    public String visit(ast.TypeId typeId) {
        return null;
    }

    public String visit(ast.ArrType arrType) {
        return null;
    }

    public String visit(ast.Subscript subscript) {
        this.TextSection += "\tPUSH        {R0,R1}\n";

        // Recupere l'adresse de la lvalue dans R8
        subscript.lValue.accept(this);
        this.TextSection += "\tPUSH        {R8}\n";

        subscript.expr.accept(this);
        this.TextSection += "\tPOP        {R0}        @ adresse du array dans R0\n";

        this.TextSection += "\tMOV        R1,R8         @ indice dans R1\n";
        this.TextSection += "\tCMP        R1,#0\n";
        this.TextSection += "\tBlt        _ERROR_index_out_of_range\n";

        // Recuperarion de la taille du array dans R8
        this.TextSection += "\tLDR        R8,[R0],#4        @ taiile du array dans R8\n";

        // Comparaison de l'indice dans R1 avec la taille dans R8
        this.TextSection += "\tCMP        R1,R8\n";
        this.TextSection += "\tBge        _ERROR_index_out_of_range\n";

        this.TextSection += "\tLDR        R8,[R0,R1,LSL #2]\n";
        this.TextSection += "\tPOP        {R0,R1}\n";
        return null;
    }

    public String visit(ast.FieldExp fieldExp) {
        return null;
    }

    public String visit(ast.ArrCreate arrCreate) {

        this.TextSection += "\tPUSH       {R0,R1,R2}\n";
        arrCreate.of.accept(this);
        this.TextSection += "\tMOV       R0,R8\n";
        arrCreate.index.accept(this);
        this.TextSection += "\tADD       R1,R8,#1\n";
        this.TextSection += "\tLSL       R1,R1,#2\n";
        this.TextSection += "\tPUSH       {R1}\n";
        this.TextSection += "\tBL        malloc\n\n";
        this.TextSection += "\tADD       R13,R13,#4\n";
        this.TextSection += "\tLSR       R1,R1,#2\n";
        this.TextSection += "\tSUB       R1,R1,#1\n";
        this.TextSection += "\tSTR       R1,[R8],#4\n";
        this.TextSection += "\tMOV       R2,#0\n\n";

        // REMPLISSAGE avec R0 :
        this.TextSection +=
                "\t_FILL_ARR_LOOP_" + arrCreate.lineNumber + "_" + arrCreate.columnNumber + ":\n";
        this.TextSection += "\tSTR       R0,[R8,R2,LSL #2]\n";
        this.TextSection += "\tADD       R2,R2,#1\n";
        this.TextSection += "\tCMP       R2,R1\n";
        this.TextSection += "\tBNE       _FILL_ARR_LOOP_" + arrCreate.lineNumber + "_"
                + arrCreate.columnNumber + "\n\n";

        this.TextSection += "\tSUB       R8,R8,#4\n";
        this.TextSection += "\tPOP       {R0,R1,R2}\n";
        return null;
    }

    public String visit(ast.IntLiteral intLiteral) {
        this.TextSection += "\tMOV      R8,#" + intLiteral.value + "\n";
        return null;
    }

    public String visit(ast.StringLiteral stringLiteral) {
        this.DataSection += "\tSTRING_" + stringLiteral.lineNumber + "_"
                + stringLiteral.columnNumber + ": .asciz " + stringLiteral.value + "\n";
        this.TextSection += "\tLDR      R8,=STRING_" + stringLiteral.lineNumber + "_"
                + stringLiteral.columnNumber + "\n";
        return null;
    }

    public String visit(ast.NilLiteral nilLiteral) {
        return null;
    }

    public String visit(ast.BreakLiteral breakLiteral) {
        this.TextSection += "\tB      _END_LOOP_" + this.break_stack.peek() + "\n";
        return null;
    }



    public String visit(FieldCreate fieldCreate) {
        return null;
    }



    public String visit(ast.RecCreate recCreate) {
        this.TextSection += "\tPUSH       {R0,R1,R2}\n";
        ArrayList<ast.FieldCreate> fields = recCreate.fields.fields;
        this.TextSection += "\tMOV          R0,#" + (fields.size() + 1) * 4 + "\n";
        this.TextSection += "\tPUSH         {R0}\n";
        this.TextSection += "\tBL           malloc\n";
        this.TextSection += "\tADD       R13,R13,#4\n";
        this.TextSection += "\tMOV          R0,R8\n";
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).expr.accept(this);
            this.TextSection += "\tSTR          R8,[R0,#" + (i + 1) + "*4]\n";
        }
        this.TextSection += "\tMOV          R8,#" + fields.size() + "\n";
        this.TextSection += "\tSTR          R8,[R0]\n";
        this.TextSection += "\tMOV          R8,R0\n";
        this.TextSection += "\tPOP          {R0,R1,R2}\n";
        return null;
    }

    public String visit(ast.RecCreateFields recCreateFields) {
        return null;
    }

    public String visit(ast.RecType reType) {
        return null;
    }

    public String visit(ast.TypeDecs typeDecs) {
        return null;
    }

    public String visit(ast.TypeDec typeDec) {
        return null;
    }

    public String visit(ast.ForExp forExp) {
        return null;
    }
}
