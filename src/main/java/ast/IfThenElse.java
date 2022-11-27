package ast;

public class IfThenElse implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenExpr;
    public Ast elseExpr;

    public IfThenElse(Ast condition, Ast thenExpr, Ast elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }
}
