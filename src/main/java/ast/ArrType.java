package ast;

public class ArrType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast typeId;

    public ArrType(Ast typeId) {
        this.typeId = typeId;
    }
}
