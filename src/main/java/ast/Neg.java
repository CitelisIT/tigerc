package ast;

public class Neg implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast expr;
    public int lineNumber;
    public int columnNumber;

    public Neg(Ast expr, int lineNumber, int columnNumber) {
        this.expr = expr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
