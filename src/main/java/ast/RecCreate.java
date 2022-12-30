package ast;

public class RecCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public RecCreateFields fields;
    public int lineNumber;
    public int columnNumber;

    public RecCreate(TypeId typeId, RecCreateFields fields, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.fields = fields;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
