package ast;

public class Id implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final String name;
    public final int lineNumber;
    public final int columnNumber;

    public Id(String name, int lineNumber, int columnNumber) {
        this.name = name;
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
