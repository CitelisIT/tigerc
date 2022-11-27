package ast;

public class InfEq implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public InfEq(Ast left, Ast right) {
        this.left = left;
        this.right = right;
    }
}
