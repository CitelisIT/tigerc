package ast;

public class TypeDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final TypeId typeId;
    public final Type typeValue;
    public final int lineNumber;
    public final int columnNumber;

    public TypeDec(TypeId typeId, Type typeValue, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.typeValue = typeValue;
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
