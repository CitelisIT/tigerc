package ast;

import java.util.ArrayList;

public class RecCreateFields implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldCreate> fields;
    public int lineNumber;
    public int columnNumber;

    public RecCreateFields(ArrayList<FieldCreate> fields, int lineNumber, int columnNumber) {
        this.fields = fields;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
