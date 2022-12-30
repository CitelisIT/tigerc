package ast;

public class FieldExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast lValue;
    public Id id;
    public int lineNumber;
    public int columnNumber;

    public FieldExp(Ast lValue, Id id, int lineNumber, int columnNumber) {
        this.lValue = lValue;
        this.id = id;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
