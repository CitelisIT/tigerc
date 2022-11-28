package ast;

public class FieldDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public TypeId typeId;

    public FieldDec(Id id, TypeId typeId) {
        this.id = id;
        this.typeId = typeId;
    }
}
