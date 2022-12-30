package ast;

public class StringLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;
    public int lineNumber;
    public int columnNumber;

    public StringLiteral(String value, int lineNumber, int columnNumber) {
        this.value = value;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
