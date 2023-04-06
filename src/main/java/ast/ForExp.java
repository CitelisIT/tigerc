package ast;

public class ForExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id forId;
    public final Ast startValue;
    public final Ast endValue;
    public final Ast doExpr;
    public final int lineNumber;
    public final int columnNumber;
    public String ScopeID;

    public ForExp(Id forId, Ast startValue, Ast endValue, Ast doExpr, int lineNumber,
            int columnNumber) {
        this.forId = forId;
        this.startValue = startValue;
        this.endValue = endValue;
        this.doExpr = doExpr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
