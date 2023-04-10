package ast;

public class LetExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final LetDecls letDecls;
    public final LetScope letScope;
    public final int lineNumber;
    public final int columnNumber;
    public String ScopeID;

    public LetExp(LetDecls letDecls, LetScope letScope, int lineNumber, int columnNumber) {
        this.letDecls = letDecls;
        this.letScope = letScope;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public LetExp(LetDecls letDecls, LetScope letScope, int lineNumber, int columnNumber, String ScopeID) {
        this.letDecls = letDecls;
        this.letScope = letScope;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.ScopeID = ScopeID;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
