package ast;

import java.util.ArrayList;

public class SeqExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> exprs;
    public final int lineNumber;
    public final int columnNumber;

    public SeqExp(ArrayList<Ast> exprs, int lineNumber, int columnNumber) {
        this.exprs = exprs;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
