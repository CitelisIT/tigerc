package ast;

public class LetExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LetDecls letDecls;
    public LetScope letScope;
    public int lineNumber;
    public int columnNumber;

    public LetExp(LetDecls letDecls, LetScope letScope, int lineNumber, int columnNumber) {
        this.letDecls = letDecls;
        this.letScope = letScope;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
