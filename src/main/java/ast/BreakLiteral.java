package ast;

public class BreakLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value = "break";
    public int lineNumber;
    public int columnNumber;

    public BreakLiteral(int lineNumber, int columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
