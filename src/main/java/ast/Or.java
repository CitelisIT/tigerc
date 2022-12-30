package ast;

public class Or implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;
    public int lineNumber;
    public int columnNumber;

    public Or(Ast left, Ast right, int lineNumber, int columnNumber) {
        this.left = left;
        this.right = right;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
