package ast;

public class IfThen implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenExpr;

    public IfThen(Ast condition, Ast thenExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
    }


}
