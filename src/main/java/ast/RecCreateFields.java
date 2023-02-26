package ast;

import java.util.ArrayList;

public class RecCreateFields implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final ArrayList<FieldCreate> fields;
    public final int lineNumber;
    public final int columnNumber;

    public RecCreateFields(ArrayList<FieldCreate> fields, int lineNumber, int columnNumber) {
        this.fields = fields;
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
