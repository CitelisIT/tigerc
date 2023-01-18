package ast;

public class VarDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id varId;
    public final TypeId varTypeId;
    public final Ast varValue;
    public final int lineNumber;
    public final int columnNumber;

    public VarDecType(Id varId, TypeId varTypeId, Ast varValue, int lineNumber, int columnNumber) {
        this.varId = varId;
        this.varTypeId = varTypeId;
        this.varValue = varValue;
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
