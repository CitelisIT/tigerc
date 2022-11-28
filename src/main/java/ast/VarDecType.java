package ast;

public class VarDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id varId;
    public TypeId varTypeId;
    public Ast varValue;

    public VarDecType(Id varId, TypeId varTypeId, Ast varValue) {
        this.varId = varId;
        this.varTypeId = varTypeId;
        this.varValue = varValue;
    }
}
