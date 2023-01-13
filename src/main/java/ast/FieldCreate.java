package ast;

public class FieldCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public Ast expr;
    public int lineNumber;
    public int columnNumber;

    public FieldCreate(Id id, Ast expr, int lineNumber, int columnNumber) {
        this.id = id;
        this.expr = expr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
