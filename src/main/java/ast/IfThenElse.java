package ast;

public class IfThenElse implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast condition;
    public final Ast thenExpr;
    public final Ast elseExpr;
    public final int lineNumber;
    public final int columnNumber;

    public IfThenElse(Ast condition, Ast thenExpr, Ast elseExpr, int lineNumber, int columnNumber) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
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
