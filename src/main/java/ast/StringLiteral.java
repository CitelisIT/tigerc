package ast;

public class StringLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final String value;
    public final int lineNumber;
    public final int columnNumber;

    public StringLiteral(String value, int lineNumber, int columnNumber) {
        this.value = value;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
