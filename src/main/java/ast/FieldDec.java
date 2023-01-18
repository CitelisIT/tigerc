package ast;

public class FieldDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id id;
    public final TypeId typeId;
    public final int lineNumber;
    public final int columnNumber;

    public FieldDec(Id id, TypeId typeId, int lineNumber, int columnNumber) {
        this.id = id;
        this.typeId = typeId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
