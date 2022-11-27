package ast;

public class StringLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;

    public StringLiteral(String value) {
        this.value = value;
    }

}
