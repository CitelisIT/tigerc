package ast;

public class CallExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id id;
    public final CallExpArgs args;
    public final int lineNumber;
    public final int columnNumber;

    public CallExp(Id id, CallExpArgs args, int lineNumber, int columnNumber) {
        this.id = id;
        this.args = args;
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
