package ast;

import java.util.Hashtable;

public class RecType extends Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Hashtable<Id, Type> fields;

    public RecType(Hashtable<Id, Type> fields) {
        this.fields = fields;
    }

}
