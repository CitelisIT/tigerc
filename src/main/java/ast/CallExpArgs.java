package ast;

import java.util.ArrayList;

public class CallExpArgs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<Ast> args;
    public final int lineNumber;
    public final int columnNumber;

    public CallExpArgs(ArrayList<Ast> args, int lineNumber, int columnNumber) {
        this.args = args;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
