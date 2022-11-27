package ast;

public class Sub implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Sub(Ast left, Ast right) {
        this.left = left;
        this.right = right;
    }
}
