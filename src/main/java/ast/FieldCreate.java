package ast;

public class FieldCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id id;
    public final Ast expr;
    public final int lineNumber;
    public final int columnNumber;

    public FieldCreate(Id id, Ast expr, int lineNumber, int columnNumber) {
        this.id = id;
        this.expr = expr;
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
