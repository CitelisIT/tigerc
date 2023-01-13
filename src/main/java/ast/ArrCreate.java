package ast;

public class ArrCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public Ast index;
    public Ast of;
    public int lineNumber;
    public int columnNumber;

    public ArrCreate(TypeId typeId, Ast index, Ast of, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.index = index;
        this.of = of;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
