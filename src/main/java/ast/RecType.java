package ast;

import java.util.ArrayList;

public class RecType extends Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldDec> fields;

    public RecType(ArrayList<FieldDec> fields) {
        this.fields = fields;
    }

}
