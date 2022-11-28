package ast;

public class BreakLiteral implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value = "break";

}
