package ast;

import java.util.ArrayList;

public class RecCreateFields implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldCreate> fields;

    public RecCreateFields(ArrayList<FieldCreate> fields) {
        this.fields = fields;
    }

}
