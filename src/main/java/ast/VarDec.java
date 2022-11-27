package ast;

public class VarDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast varId;
    public Ast varTypeId;
    public Ast varValue;

    public VarDec(Ast varId, Ast varValue) {
        this.varId = varId;
        this.varValue = varValue;
    }

    public VarDec(Ast varId, Ast varTypeId, Ast varValue) {
        this.varId = varId;
        this.varTypeId = varTypeId;
        this.varValue = varValue;
    }
}
