package ast;

public class VarDecNoType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id varId;
    public final Ast varValue;
    public final int lineNumber;
    public final int columnNumber;

    public VarDecNoType(Id varId, Ast varValue, int lineNumber, int columnNumber) {
        this.varId = varId;
        this.varValue = varValue;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
