package ast;

import java.util.ArrayList;

public class LetDecls implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> decls;
    public int lineNumber;
    public int columnNumber;

    public LetDecls(ArrayList<Ast> decls, int lineNumber, int columnNumber) {
        this.decls = decls;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
