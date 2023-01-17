package ast;

public class WhileExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast condition;
    public final Ast doExpr;
    public final int lineNumber;
    public final int columnNumber;

    public WhileExp(Ast condition, Ast doExpr, int lineNumber, int columnNumber) {
        this.condition = condition;
        this.doExpr = doExpr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
