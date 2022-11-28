package ast;

public class Id implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name;

    public Id(String name) {
        this.name = name;
    }
}
