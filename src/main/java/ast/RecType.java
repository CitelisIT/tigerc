package ast;

import java.util.ArrayList;

public class RecType implements Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldDec> fields;
    public int lineNumber;
    public int columnNumber;

    public RecType(ArrayList<FieldDec> fields, int lineNumber, int columnNumber) {
        this.fields = fields;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
