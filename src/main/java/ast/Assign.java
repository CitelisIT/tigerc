package ast;

public class Assign implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast lValue;
    public final Ast expr;
    public final int lineNumber;
    public final int columnNumber;

    public Assign(Ast lValue, Ast expr, int lineNumber, int columnNumber) {
        this.lValue = lValue;
        this.expr = expr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
