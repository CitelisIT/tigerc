package ast;

public class Then implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast then;

    public Then(Ast then) {
        this.then = then;
    }


}
