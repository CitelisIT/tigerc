package ast;

public class Neg implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast expr;

    public Neg(Ast expr) {
        this.expr = expr;
    }
}
