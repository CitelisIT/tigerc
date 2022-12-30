package ast;

import java.util.ArrayList;

public class TypeDecs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> tydecs;
    public int lineNumber;
    public int columnNumber;

    public TypeDecs(ArrayList<Ast> tydecs, int lineNumber, int columnNumber) {
        this.tydecs = tydecs;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
