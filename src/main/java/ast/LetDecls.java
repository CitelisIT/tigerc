package ast;

import java.util.ArrayList;

public class LetDecls implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<Ast> decls;
    public final int lineNumber;
    public final int columnNumber;

    public LetDecls(ArrayList<Ast> decls, int lineNumber, int columnNumber) {
        this.decls = decls;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
