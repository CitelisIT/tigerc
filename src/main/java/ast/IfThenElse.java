package ast;

public class IfThenElse implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenExpr;
    public Ast elseExpr;
    int lineNumber;
    int columnNumber;

    public IfThenElse(Ast condition, Ast thenExpr, Ast elseExpr, int lineNumber, int columnNumber) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
