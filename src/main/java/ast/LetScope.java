package ast;

import java.util.ArrayList;

public class LetScope implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<Ast> exprs;
    final int lineNumber;
    final int columnNumber;

    public LetScope(ArrayList<Ast> exprs, int lineNumber, int columnNumber) {
        this.exprs = exprs;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
