package ast;

import java.util.ArrayList;

public class TypeDecs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<Ast> tydecs;
    public final int lineNumber;
    public final int columnNumber;

    public TypeDecs(ArrayList<Ast> tydecs, int lineNumber, int columnNumber) {
        this.tydecs = tydecs;
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
