package ast;

public class ArrCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public Ast index;
    public Ast of;

    public ArrCreate(TypeId typeId, Ast index, Ast of) {
        this.typeId = typeId;
        this.index = index;
        this.of = of;
    }
}
