package ast;

public class IntLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int value;

    public IntLiteral(int value) {
        this.value = value;
    }

}
