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
import symtab.symbol.TypeSymbol;
import symtab.symbol.VarSymbol;
import symtab.scope.Scope;
import symtab.scope.PredefinedScope;
import symtab.scope.GlobalScope;
import symtab.scope.LocalScope;

public class SymTabCreator implements AstVisitor<Void> {

    private Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();
    private String currentScopeId;

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

    public Void visit(Program program) {
        program.exp.accept(this);
        return null;
    }

    public Void visit(Assign assign) {
        assign.expr.accept(this);
        assign.lValue.accept(this);
        return null;
    }

    public Void visit(Or or) {
        or.left.accept(this);
        or.right.accept(this);
        return null;
    }

    public Void visit(And and) {
        and.left.accept(this);
        and.right.accept(this);
        return null;
    }

    public Void visit(Eq eq) {
        eq.left.accept(this);
        eq.right.accept(this);
        return null;
    }

    public Void visit(NotEq notEq) {
        notEq.accept(this);
        return null;
    }

    public Void visit(InfEq infEq) {
        infEq.accept(this);
        return null;
    }

    public Void visit(Inf inf) {
        inf.left.accept(this);
        inf.right.accept(this);
        return null;
    }

    public Void visit(SupEq supEq) {
        supEq.left.accept(this);
        supEq.left.accept(this);
        return null;
    }

    public Void visit(Sup sup) {
        sup.left.accept(this);
        sup.right.accept(this);
        return null;
    }

    public Void visit(Add add) {
        add.left.accept(this);
        add.right.accept(this);
        return null;
    }

    public Void visit(Sub sub) {
        sub.left.accept(this);
        sub.right.accept(this);
        return null;
    }

    public Void visit(Mult mult) {
        mult.left.accept(this);
        mult.right.accept(this);
        return null;
    }

    public Void visit(Div div) {
        div.left.accept(this);
        div.right.accept(this);
        return null;
    }

    public Void visit(SeqExp seqExp) {
        for (Ast exp : seqExp.exprs) {
            exp.accept(this);
        }
        return null;
    }

    public Void visit(Neg neg) {
        neg.expr.accept(this);
        return null;
    }

    public Void visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        ifThenElse.elseExpr.accept(this);
        ifThenElse.thenExpr.accept(this);
        return null;
    }

    public Void visit(WhileExp whileExp) {
        whileExp.condition.accept(this);
        whileExp.doExpr.accept(this);
        return null;
    }

    public Void visit(ForExp forExp) {
        forExp.doExpr.accept(this);
        forExp.endValue.accept(this);
        forExp.startValue.accept(this);
        forExp.forId.accept(this);
        return null;
    }

    public Void visit(LetDecls letDecls) {
        for (Ast decl : letDecls.decls) {
            decl.accept(this);
        }
        return null;
    }

    public Void visit(LetScope letScope) {
        for (Ast exp : letScope.exprs) {
            exp.accept(this);
        }
        return null;
    }

    public Void visit(LetExp letExp) {
        this.openScope(currentScopeId);
        letExp.letDecls.accept(this);
        letExp.letScope.accept(this);
        this.closeScope();
        return null;
    }

    public Void visit(CallExpArgs callExpArgs) {
        for (Ast arg : callExpArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public Void visit(CallExp callExp) {
        callExp.id.accept(this);
        callExp.args.accept(this);
        return null;
    }

    public Void visit(FieldDec fieldDec) {
        return null;
    }

    public Void visit(TypeDec typeDec) {
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

    public Void visit(TypeDecs typeDecs) {
        for (Ast typdec : typeDecs.tydecs) {
            typdec.accept(this);
        }
        return null;
    }

    public Void visit(VarDecType varDecType) {
        this.addSymbol(varDecType.varId.name, new VarSymbol(varDecType.varTypeId.name));
        varDecType.varValue.accept(this);
        return null;
    }

    public Void visit(VarDecNoType varDecNoType) {
        varDecNoType.varValue.accept(this);
        // utiliser le typeCheker pour récup le type de varValue pour remplir la TDS
        // this.addSymbol(varDecNoType.varId.name, new VarSymbol(#TYPE DE varValue#));
        return null;
    }

    public Void visit(FunArgs funArgs) {
        for (Ast arg : funArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public Void visit(FunDec funDec) {
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

    public Void visit(Id id) {
        return null;
    }

    public Void visit(TypeId typeId) {
        return null;
    }

    public Void visit(ArrType arrType) {
        return null;
    }

    public Void visit(RecType recType) {

        return null;
    }

    public Void visit(Subscript subscript) {
        subscript.expr.accept(this);
        subscript.lValue.accept(this);
        return null;
    }

    public Void visit(FieldExp fieldExp) {
        return null;
    }

    public Void visit(ArrCreate arrCreate) {
        return null;
    }

    public Void visit(FieldCreate fieldCreate) {
        return null;
    }

    public Void visit(RecCreateFields recCreateFields) {
        return null;
    }

    public Void visit(RecCreate recCreate) {
        return null;
    }

    public Void visit(IntLiteral intLitteral) {
        return null;
    }

    public Void visit(StringLiteral stringLiteral) {
        return null;
    }

    public Void visit(NilLiteral nilLitteral) {
        return null;
    }

    public Void visit(BreakLiteral breakLitteral) {
        return null;
    }
}
