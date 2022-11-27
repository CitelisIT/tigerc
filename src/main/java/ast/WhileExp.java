package ast;

public class WhileExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast doExpr;

    public WhileExp(Ast condition, Ast doExpr) {
        this.condition = condition;
        this.doExpr = doExpr;
    }

}
