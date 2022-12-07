package ast;

public class IfThenElse implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Condition condition;
    public Then thenExpr;
    public Else elseExpr;

    public IfThenElse(Condition condition, Then thenExpr, Else elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }


}
