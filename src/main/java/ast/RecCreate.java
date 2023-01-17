package ast;

public class RecCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final TypeId typeId;
    public final RecCreateFields fields;
    public final int lineNumber;
    public final int columnNumber;

    public RecCreate(TypeId typeId, RecCreateFields fields, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.fields = fields;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
