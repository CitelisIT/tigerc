package ast;

public class TypeDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public Type typeValue;
    public int lineNumber;
    public int columnNumber;

    public TypeDec(TypeId typeId, Type typeValue, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.typeValue = typeValue;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
