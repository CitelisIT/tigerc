package ast;

public class Subscript implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast lValue;
    public final Ast expr;
    public final int lineNumber;
    public final int columnNumber;

    public Subscript(Ast lValue, Ast expr, int lineNumber, int columnNumber) {
        this.lValue = lValue;
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
