package ast;

public class Else implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast elsee;

    public Else(Ast elsee) {
        this.elsee = elsee;
    }

}
