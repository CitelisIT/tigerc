package ast;

public class LetExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LetDecls letDecls;
    public LetScope letScope;

    public LetExp(LetDecls letDecls, LetScope letScope) {
        this.letDecls = letDecls;
        this.letScope = letScope;
    }

}
