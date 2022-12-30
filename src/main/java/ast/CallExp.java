package ast;

public class CallExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public CallExpArgs args;
    public int lineNumber;
    public int columnNumber;

    public CallExp(Id id, CallExpArgs args, int lineNumber, int columnNumber) {
        this.id = id;
        this.args = args;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
