package ast;

public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Id id;
    public final FunArgs args;
    public final TypeId returnTypeId;
    public final Ast body;
    public final int lineNumber;
    public final int columnNumber;

    public FunDec(Id id, FunArgs args, TypeId returnTypeId, Ast body, int lineNumber,
            int columnNumber) {
        this.id = id;
        this.args = args;
        this.returnTypeId = returnTypeId;
        this.body = body;
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
