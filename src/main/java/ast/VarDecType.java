package ast;

public class VarDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id varId;
    public TypeId varTypeId;
    public Ast varValue;
    public int lineNumber;
    public int columnNumber;

    public VarDecType(Id varId, TypeId varTypeId, Ast varValue, int lineNumber, int columnNumber) {
        this.varId = varId;
        this.varTypeId = varTypeId;
        this.varValue = varValue;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
