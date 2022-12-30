package ast;

public class FieldDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public TypeId typeId;
    public int lineNumber;
    public int columnNumber;

    public FieldDec(Id id, TypeId typeId, int lineNumber, int columnNumber) {
        this.id = id;
        this.typeId = typeId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
