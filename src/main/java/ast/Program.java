package ast;

public class Program implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;

    public Program(Ast exp) {
        this.exp = exp;
    }
}
