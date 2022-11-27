package ast;

public class TypeDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast typeId;
    public Ast typeValue;

    public TypeDec(Ast typeId, Ast typeValue) {
        this.typeId = typeId;
        this.typeValue = typeValue;
    }


}
