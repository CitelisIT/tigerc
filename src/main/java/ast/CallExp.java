package ast;

public class CallExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public CallExpArgs args;

    public CallExp(Id id, CallExpArgs args) {
        this.id = id;
        this.args = args;
    }
}
