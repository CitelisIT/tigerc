package ast;

public class FieldExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast lValue;
    public Id id;

    public FieldExp(Ast lValue, Id id) {
        this.lValue = lValue;
        this.id = id;
    }
}
