package ast;

public class Program implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast exp;
    public final int lineNumber;
    public final int columnNumber;

    public Program(Ast exp, int lineNumber, int columnNumber) {
        this.exp = exp;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
