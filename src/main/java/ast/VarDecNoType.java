package ast;

public class VarDecNoType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id varId;
    public Ast varValue;


    public VarDecNoType(Id varId, Ast varValue) {
        this.varId = varId;
        this.varValue = varValue;
    }

}
