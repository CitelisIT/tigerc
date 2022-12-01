package ast;

public class ArrType implements Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name;

    public ArrType(String name) {
        this.name = name;
    }
}
