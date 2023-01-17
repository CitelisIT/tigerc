package ast;

public class SupEq implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast left;
    public final Ast right;
    public final int lineNumber;
    public final int columnNumber;

    public SupEq(Ast left, Ast right, int lineNumber, int columnNumber) {
        this.left = left;
        this.right = right;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
