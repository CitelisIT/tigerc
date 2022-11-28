package ast;

public class Subscript implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast lValue;
    public Ast expr;

    public Subscript(Ast lValue, Ast expr) {
        this.lValue = lValue;
        this.expr = expr;
    }

}
