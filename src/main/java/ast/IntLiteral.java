package ast;

public class IntLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int value;
    public int lineNumber;
    public int columnNumber;

    public IntLiteral(int value, int lineNumber, int columnNumber) {
        this.value = value;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
