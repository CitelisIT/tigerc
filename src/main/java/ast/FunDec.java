package ast;

public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public FunArgs args;
    public TypeId returnTypeId;
    public Ast body;
    int lineNumber;
    int columnNumber;

    public FunDec(Id id, FunArgs args, TypeId returnTypeId, Ast body, int lineNumber, int columnNumber) {
        this.id = id;
        this.args = args;
        this.returnTypeId = returnTypeId;
        this.body = body;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
