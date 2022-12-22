package symtab;

import ast.AstVisitor;
import java.util.Map;
import ast.*;
import symtab.symbol.Symbol;
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
        return null;
    }

    public Void visit(Assign assign) {
        return null;
    }

    public Void visit(Or or) {
        return null;
    }

    public Void visit(And and) {
        return null;
    }

    public Void visit(Eq eq) {
        return null;
    }

    public Void visit(NotEq notEq) {
        return null;
    }

    public Void visit(InfEq infEq) {
        return null;
    }

    public Void visit(Inf inf) {
        return null;
    }

    public Void visit(SupEq supEq) {
        return null;
    }

    public Void visit(Sup sup) {
        return null;
    }

    public Void visit(Add add) {
        return null;
    }

    public Void visit(Sub sub) {
        return null;
    }

    public Void visit(Mult mult) {
        return null;
    }

    public Void visit(Div div) {
        return null;
    }

    public Void visit(SeqExp seqExp) {
        return null;
    }

    public Void visit(Neg neg) {
        return null;
    }

    public Void visit(IfThenElse ifThenElse) {
        return null;
    }

    public Void visit(WhileExp whileExp) {
        return null;
    }

    public Void visit(ForExp forExp) {
        return null;
    }

    public Void visit(LetDecls letDecls) {
        return null;
    }

    public Void visit(LetScope letScope) {
        return null;
    }

    public Void visit(LetExp letExp) {
        return null;
    }

    public Void visit(CallExpArgs callExpArgs) {
        return null;
    }

    public Void visit(CallExp callExp) {
        return null;
    }

    public Void visit(FieldDec fieldDec) {
        return null;
    }

    public Void visit(TypeDec typeDec) {
        return null;
    }

    public Void visit(TypeDecs typeDecs) {
        return null;
    }

    public Void visit(VarDecType varDecType) {
        return null;
    }

    public Void visit(VarDecNoType varDecNoType) {
        return null;
    }

    public Void visit(FunArgs funArgs) {
        return null;
    }

    public Void visit(FunDec funDec) {
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
