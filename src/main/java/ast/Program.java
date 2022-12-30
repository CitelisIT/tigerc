package ast;

public class Program implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;
    public int lineNumber;
    public int columnNumber;

    public Program(Ast exp, int lineNumber, int columnNumber) {
        this.exp = exp;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
