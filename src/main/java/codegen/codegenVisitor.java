package codegen;

import java.util.ArrayList;
import java.util.Map;
import ast.Ast;
import ast.AstVisitor;
import ast.FieldCreate;
import ast.ForExp;
import ast.FunDec;
import ast.RecCreate;
import ast.RecCreateFields;
import ast.RecType;
import ast.TypeDec;
import ast.TypeDecs;
import symtab.scope.Scope;

public class codegenVisitor implements AstVisitor<String> {

    public String IncludeSection;
    public String DataSection;
    public String TextSection;
    public Map<String, Scope> TDS;
    public ArrayList<ast.Ast> funDecList;

    public int currentWhileLoop = 0;

    public codegenVisitor(Map<String, Scope> symtab) {
        this.DataSection = ".data\n\n";
        this.TextSection = ".text\n\n.global _start\n\n_start:\n\n";
        this.IncludeSection = ".include     \"Base_function.s\"";
        this.TDS = symtab;
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
        this.TextSection += "\n\n@ Function Section \n";

        for (ast.Ast fundec : this.funDecList) {
            fundec.accept(this);
        }
        System.out.println(this.IncludeSection + this.DataSection + this.TextSection);
        return null;
    }

    public String visit(ast.Assign assign) {
        // TODO
        return null;
    }

    public String visit(ast.Or or) {
        or.left.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection += "\tBNE      _OR_SKIP_" + or.lineNumber + "_" + or.columnNumber + "\n";
        or.right.accept(this);
        this.TextSection += "_OR_SKIP_" + or.lineNumber + "_" + or.columnNumber + ":\n";
        return null;
    }

    public String visit(ast.And and) {
        and.left.accept(this);
        this.TextSection += "\tCMP      R8,#0\n";
        this.TextSection +=
                "\tBEQ      _AND_SKIP_" + and.lineNumber + "_" + and.columnNumber + "\n";
        and.right.accept(this);
        this.TextSection += "_AND_SKIP_" + and.lineNumber + "_" + and.columnNumber + ":\n";
        return null;
    }

    public String visit(ast.Eq eq) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(eq.left, eq.right);
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVeq   R8,#1\n";
        this.TextSection += "\tMOVne   R8,#0\n";
        return null;
    }

    public String visit(ast.NotEq notEq) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(notEq.left, notEq.right);
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVeq   R8,#0\n";
        this.TextSection += "\tMOVne   R8,#1\n";
        return null;
    }

    public String visit(ast.InfEq infEq) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(infEq.left, infEq.right);
        // TODO disjonction de cas string
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVle   R8,#1\n";
        this.TextSection += "\tMOVgt   R8,#0\n";
        return null;
    }

    public String visit(ast.Inf inf) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(inf.left, inf.right);
        // TODO disjonction de cas string
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVlt   R8,#1\n";
        this.TextSection += "\tMOVge   R8,#0\n";
        return null;
    }

    public String visit(ast.SupEq supEq) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(supEq.left, supEq.right);
        // TODO disjonction de cas string
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVge   R8,#1\n";
        this.TextSection += "\tMOVlt   R8,#0\n";
        return null;
    }

    public String visit(ast.Sup sup) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(sup.left, sup.right);
        // TODO disjonction de cas string
        this.TextSection += "\tCMP     R8,R9\n";
        this.TextSection += "\tMOVgt   R8,#1\n";
        this.TextSection += "\tMOVle   R8,#0\n";
        return null;
    }

    public String visit(ast.Add add) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(add.left, add.right);
        this.TextSection += "\tADD     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.Sub sub) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(sub.left, sub.right);
        this.TextSection += "\tSUB     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.Mult mult) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(mult.left, mult.right);
        this.TextSection += "\tMUL     R8,R8,R9\n";
        return null;
    }

    public String visit(ast.Div div) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(div.left, div.right);
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
        this.TextSection += "\tCMP      R8,#1";
        this.TextSection +=
                "\tBEQ      _IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + "\n";
        this.TextSection +=
                "\tBNE      _ELSE_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + "\n";
        this.TextSection += "_IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        ifThenElse.thenExpr.accept(this);
        this.TextSection +=
                "_ELSE_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        this.TextSection += "\tB        _END_IF_" + ifThenElse.lineNumber + "_"
                + ifThenElse.columnNumber + "\n";
        ifThenElse.elseExpr.accept(this);
        this.TextSection += "\tB        _END_IF_" + ifThenElse.lineNumber + "_"
                + ifThenElse.columnNumber + "\n";
        this.TextSection +=
                "_END_IF_" + ifThenElse.lineNumber + "_" + ifThenElse.columnNumber + ":\n";
        return null;
    }

    public String visit(ast.WhileExp whileExp) {
        this.currentWhileLoop += 1;
        this.TextSection += "_LOOP_" + this.currentWhileLoop + ":\n";
        whileExp.condition.accept(this);
        this.TextSection += "\tCMP      R8,#0";
        this.TextSection += "\tBEQ      _END_LOOP_" + this.currentWhileLoop + "\n";
        whileExp.doExpr.accept(this);
        this.TextSection += "\tB        LOOP_" + this.currentWhileLoop + "\n";
        this.TextSection += "_END_LOOP_" + this.currentWhileLoop + ":\n";
        this.currentWhileLoop -= 1;
        return null;
    }

    public String visit(ast.LetDecls letDecls) {
        for (ast.Ast dec : letDecls.decls) {
            if (dec instanceof FunDec) {
                this.funDecList.add(dec);
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
        letExp.letDecls.accept(this);
        this.TextSection += "\n@ empile les registres de travail \n\tPUSH       {R0-R7}\n";

        letExp.letScope.accept(this);

        this.TextSection += "\n@ dépile les registres de travail \n\tPOP        {R0-R7}\n";

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
        // TODO
        return null;
    }

    public String visit(ast.VarDecNoType varDecNoType) {
        // TODO
        return null;
    }

    public String visit(ast.FunArgs funArgs) {
        // TODO
        return null;
    }

    public String visit(ast.FunDec funDec) {
        String saveR8 = funDec.returnTypeId.name == "void" ? "\tPUSH        {R8}\n" : "";
        String chargeR8 = funDec.returnTypeId.name == "void" ? "\tPOP        {R8}\n" : "";

        this.TextSection += "" + funDec.id.name + ":\n";
        this.TextSection += "\tPUSH        {R11,LR}\n";
        this.TextSection += "\tMOV         R11,R13\n";

        // TODO : empiler le chainage statique et MAJ le DISPLAY

        this.TextSection += saveR8;
        funDec.body.accept(this);
        this.TextSection += chargeR8;

        // TODO : dépiler le chainage statique et MAJ le DISPLAY

        this.TextSection += "\tMOV         R13,R11\n";
        this.TextSection += "\tPOP         {R11,PC}\n";

        return null;
    }

    public String visit(ast.Id id) {
        // TODO
        return null;
    }

    public String visit(ast.TypeId typeId) {
        // TODO
        return null;
    }

    public String visit(ast.ArrType arrType) {
        // TODO
        return null;
    }

    public String visit(ast.Subscript subscript) {
        // TODO
        return null;
    }

    public String visit(ast.FieldExp fieldExp) {
        // TODO
        return null;
    }

    public String visit(ast.ArrCreate arrCreate) {
        // TODO
        return null;
    }

    public String visit(ast.IntLiteral intLiteral) {
        this.TextSection += "\tMOV      R8,#" + intLiteral.value + "\n";
        return null;
    }

    public String visit(ast.StringLiteral stringLiteral) {
        this.DataSection += "STRING_" + stringLiteral.lineNumber + "_" + stringLiteral.columnNumber
                + ": .asciz \"" + stringLiteral.value + "\"\n";
        this.TextSection += "\tLDR      R8,=STRING_" + stringLiteral.lineNumber + "_"
                + stringLiteral.columnNumber + "\n";
        return null;
    }

    public String visit(ast.NilLiteral nilLiteral) {
        // TODO
        return null;
    }

    public String visit(ast.BreakLiteral breakLiteral) {
        this.TextSection += "\tB      _END_LOOP_" + this.currentWhileLoop + "\n";
        this.currentWhileLoop -= 1;
        return null;
    }



    public String visit(FieldCreate fieldCreate) {
        return null;
    }



    public String visit(ast.RecCreate recCreate) {
        // TODO
        return null;
    }

    public String visit(ast.RecCreateFields recCreateFields) {
        // TODO
        return null;
    }

    public String visit(ast.RecType reType) {
        // TODO
        return null;
    }

    public String visit(ast.TypeDecs typeDecs) {
        // TODO
        return null;
    }

    public String visit(ast.TypeDec typeDec) {
        // TODO
        return null;
    }

    public String visit(ast.ForExp forExp) {
        // TODO
        return null;
    }
}
