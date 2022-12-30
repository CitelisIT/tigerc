package ast;

public class ForExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id forId;
    public Ast startValue;
    public Ast endValue;
    public Ast doExpr;
    int lineNumber;
    int columnNumber;

    public ForExp(Id forId, Ast startValue, Ast endValue, Ast doExpr, int lineNumber, int columnNumber) {
        this.forId = forId;
        this.startValue = startValue;
        this.endValue = endValue;
        this.doExpr = doExpr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
