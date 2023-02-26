package ast;

import java.util.ArrayList;

public class FunArgs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<FieldDec> args;
    final int lineNumber;
    final int columnNumber;

    public FunArgs(ArrayList<FieldDec> args, int lineNumber, int columnNumber) {
        this.args = args;
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
