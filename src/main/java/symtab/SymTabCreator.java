package symtab;

import ast.AstVisitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ast.*;
import symtab.symbol.ArrayTypeSymbol;
import symtab.symbol.FuncSymbol;
import symtab.symbol.RecordTypeSymbol;
import symtab.symbol.SimpleTypeSymbol;
import symtab.symbol.Symbol;
import symtab.symbol.VarSymbol;
import symtab.scope.Scope;
import symtab.scope.PredefinedScope;
import symtab.scope.GlobalScope;
import symtab.scope.LocalScope;

public class SymTabCreator implements AstVisitor<String> {

    private Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();
    private String currentScopeId;
    private boolean insideLoop = false;

    public SymTabCreator() {
        this.symtab.put("predefined", new PredefinedScope());
        this.symtab.put("global", new GlobalScope());
        this.currentScopeId = "global";
    }

    private void addSymbol(String name, Symbol symbol) {
        Scope scope = this.symtab.get(this.currentScopeId);
        scope.addSymbol(name, symbol);
    }

    private Symbol lookup(String name) {
        Scope scope = this.symtab.get(this.currentScopeId);
        while (scope != null) {
            Symbol symbol = scope.getSymbol(name);
            if (symbol != null) {
                return symbol;
            }
            scope = this.symtab.get(scope.getParentScope());
        }
        return null;
    }

    private int getImbricationLevel() {
        return this.symtab.get(this.currentScopeId).getImbricationLevel();
    }

    private void openScope(String scopeId) {
        Scope scope = new LocalScope(scopeId, this.currentScopeId, this.getImbricationLevel() + 1);
        this.symtab.put(scopeId, scope);
        this.currentScopeId = scopeId;
    }

    private void closeScope() {
        this.currentScopeId = this.symtab.get(this.currentScopeId).getParentScope();
    }

    public String visit(Program program) {
        program.exp.accept(this);
        return null;
    }

    public String visit(Assign assign) {
        assign.expr.accept(this);
        assign.lValue.accept(this);
        return null;
    }

    public String visit(Or or) {
        or.left.accept(this);
        or.right.accept(this);
        return null;
    }

    public String visit(And and) {
        and.left.accept(this);
        and.right.accept(this);
        return null;
    }

    public String visit(Eq eq) {
        eq.left.accept(this);
        eq.right.accept(this);
        return null;
    }

    public String visit(NotEq notEq) {
        notEq.accept(this);
        return null;
    }

    public String visit(InfEq infEq) {
        infEq.accept(this);
        return null;
    }

    public String visit(Inf inf) {
        inf.left.accept(this);
        inf.right.accept(this);
        return null;
    }

    public String visit(SupEq supEq) {
        supEq.left.accept(this);
        supEq.left.accept(this);
        return null;
    }

    public String visit(Sup sup) {
        sup.left.accept(this);
        sup.right.accept(this);
        return null;
    }

    public String visit(Add add) {
        add.left.accept(this);
        add.right.accept(this);
        return null;
    }

    public String visit(Sub sub) {
        sub.left.accept(this);
        sub.right.accept(this);
        return null;
    }

    public String visit(Mult mult) {
        mult.left.accept(this);
        mult.right.accept(this);
        return null;
    }

    public String visit(Div div) {
        div.left.accept(this);
        div.right.accept(this);
        return null;
    }

    public String visit(SeqExp seqExp) {
        for (Ast exp : seqExp.exprs) {
            exp.accept(this);
        }
        return null;
    }

    public String visit(Neg neg) {
        neg.expr.accept(this);
        return null;
    }

    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        ifThenElse.elseExpr.accept(this);
        ifThenElse.thenExpr.accept(this);
        return null;
    }

    public String visit(WhileExp whileExp) {
        this.insideLoop = true;
        whileExp.condition.accept(this);
        whileExp.doExpr.accept(this);
        this.insideLoop = false;
        return null;
    }

    public String visit(ForExp forExp) {
        this.insideLoop = true;
        forExp.doExpr.accept(this);
        forExp.endValue.accept(this);
        forExp.startValue.accept(this);
        forExp.forId.accept(this);
        this.insideLoop = false;
        return null;
    }

    public String visit(LetDecls letDecls) {
        for (Ast decl : letDecls.decls) {
            decl.accept(this);
        }
        return null;
    }

    public String visit(LetScope letScope) {
        for (Ast exp : letScope.exprs) {
            exp.accept(this);
        }
        return null;
    }

    public String visit(LetExp letExp) {
        this.openScope(currentScopeId);
        letExp.letDecls.accept(this);
        letExp.letScope.accept(this);
        this.closeScope();
        return null;
    }

    public String visit(CallExpArgs callExpArgs) {
        for (Ast arg : callExpArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public String visit(CallExp callExp) {
        callExp.id.accept(this);
        callExp.args.accept(this);
        return null;
    }

    public String visit(FieldDec fieldDec) {
        return null;
    }

    public String visit(TypeDec typeDec) {
        Type typeValue = typeDec.typeValue;

        if (typeValue instanceof TypeId) {
            TypeId typeId = (TypeId) typeValue;
            this.addSymbol(typeDec.typeId.name, new SimpleTypeSymbol(typeId.name));
        }
        if (typeValue instanceof ArrType) {
            ArrType arrType = (ArrType) typeValue;
            this.addSymbol(typeDec.typeId.name, new ArrayTypeSymbol(arrType.name));
        }
        if (typeValue instanceof RecType) {

            RecType recType = (RecType) typeValue;
            Map<String, String> fields = new HashMap<String, String>();

            for (FieldDec field : recType.fields) {
                fields.put(field.id.name, field.typeId.name);
            }

            this.addSymbol(typeDec.typeId.name, new RecordTypeSymbol(fields));

        }
        return null;
    }

    public String visit(TypeDecs typeDecs) {
        for (Ast typdec : typeDecs.tydecs) {
            typdec.accept(this);
        }
        return null;
    }

    public String visit(VarDecType varDecType) {
        this.addSymbol(varDecType.varId.name, new VarSymbol(varDecType.varTypeId.name));
        varDecType.varValue.accept(this);
        return null;
    }

    public String visit(VarDecNoType varDecNoType) {
        varDecNoType.varValue.accept(this);
        // utiliser le typeCheker pour récup le type de varValue pour remplir la TDS
        // this.addSymbol(varDecNoType.varId.name, new VarSymbol(#TYPE DE varValue#));
        return null;
    }

    public String visit(FunArgs funArgs) {
        for (Ast arg : funArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public String visit(FunDec funDec) {
        ArrayList<String> argTypes = new ArrayList<String>();
        for (FieldDec arg : funDec.args.args) {
            argTypes.add(arg.typeId.name);
        }
        this.addSymbol(funDec.id.name, new FuncSymbol(funDec.returnTypeId.name, argTypes));
        this.openScope(this.currentScopeId);
        funDec.body.accept(this);
        this.closeScope();
        return null;
    }

    public String visit(Id id) {
        return null;
    }

    public String visit(TypeId typeId) {
        return null;
    }

    public String visit(ArrType arrType) {
        return null;
    }

    public String visit(RecType recType) {
        return null;
    }

    public String visit(Subscript subscript) {
        subscript.expr.accept(this);
        subscript.lValue.accept(this);
        return null;
    }

    public String visit(FieldExp fieldExp) {
        return null;
    }

    public String visit(ArrCreate arrCreate) {
        return null;
    }

    public String visit(FieldCreate fieldCreate) {
        return null;
    }

    public String visit(RecCreateFields recCreateFields) {
        return null;
    }

    public String visit(RecCreate recCreate) {
        Symbol recordType = this.lookup(recCreate.typeId.name);
        if (recordType == null) {
            System.err.println("Record type " + recCreate.typeId.name + " not found");
        } else {
            RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) recordType;
            ArrayList<FieldCreate> fields = recCreate.fields.fields;
            for (FieldCreate field : fields) {
                Map<String, String> fieldsMap = recordTypeSymbol.getFields();
                if (!fieldsMap.containsKey(field.id.name)) {
                    System.err.println("Field " + field.id.name + " not found in record type "
                            + recCreate.typeId.name);
                } else {
                    String fieldType = fieldsMap.get(field.id.name);
                    /*
                     * Typechecker doit être appelé pour récupérer le type de field String
                     * declarationType = ; if (!fieldType.equals(declarationType)) {
                     * System.err.println("Field " + field.id.name + " has type " + fieldType +
                     * " but is initialized with type " + declarationType); } Reste à ajouter le
                     * record dans la TDS
                     */
                }
            }
        }
        return null;
    }

    public String visit(IntLiteral intLitteral) {
        return null;
    }

    public String visit(StringLiteral stringLiteral) {
        return null;
    }

    public String visit(NilLiteral nilLitteral) {
        return null;
    }

    public String visit(BreakLiteral breakLitteral) {
        // Check if break is only used in a loop
        if (!this.insideLoop) {
            System.err.println("Break statement used outside a loop");
        }
        return null;
    }
}
