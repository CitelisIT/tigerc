package ast;

public class IntLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final int value;
    public final int lineNumber;
    public final int columnNumber;

    public IntLiteral(int value, int lineNumber, int columnNumber) {
        this.value = value;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
