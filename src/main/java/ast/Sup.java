package ast;

public class Sup implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast left;
    public final Ast right;
    public final int lineNumber;
    public final int columnNumber;
    public String type;

    public Sup(Ast left, Ast right, int lineNumber, int columnNumber) {
        this.left = left;
        this.right = right;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public Sup(Ast left, Ast right, int lineNumber, int columnNumber, String type) {
        this.left = left;
        this.right = right;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.type = type;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
