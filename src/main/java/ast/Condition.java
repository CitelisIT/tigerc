package ast;

public class Condition implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;

    public Condition(Ast condition) {
        this.condition = condition;
    }

}
