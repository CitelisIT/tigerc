package ast;

public class TypeId extends Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name;

    public TypeId(String name) {
        this.name = name;
    }

}
