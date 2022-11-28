package ast;

public class RecCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public RecCreateFields fields;

    public RecCreate(TypeId typeId, RecCreateFields fields) {
        this.typeId = typeId;
        this.fields = fields;
    }

}
