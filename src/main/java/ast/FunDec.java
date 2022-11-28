package ast;

public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public FunArgs args;
    public TypeId returnTypeId;
    public Ast body;

    public FunDec(Id id, FunArgs args, TypeId returnTypeId, Ast body) {
        this.id = id;
        this.args = args;
        this.returnTypeId = returnTypeId;
        this.body = body;
    }

}
