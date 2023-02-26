package ast;

public class ArrCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final TypeId typeId;
    public final Ast index;
    public final Ast of;
    public final int lineNumber;
    public final int columnNumber;

    public ArrCreate(TypeId typeId, Ast index, Ast of, int lineNumber, int columnNumber) {
        this.typeId = typeId;
        this.index = index;
        this.of = of;
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
