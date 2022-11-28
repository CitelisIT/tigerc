package ast;

public class FieldCreate implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public Ast expr;

    public FieldCreate(Id id, Ast expr) {
        this.id = id;
        this.expr = expr;
    }
}
