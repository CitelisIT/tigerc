package ast;

import java.util.ArrayList;

public class RecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> fieldIds = new ArrayList<Ast>();
    public ArrayList<Ast> fieldTypes = new ArrayList<Ast>();

    public RecType(ArrayList<Ast> fieldIds, ArrayList<Ast> fieldTypes) {
        this.fieldIds = fieldIds;
        this.fieldTypes = fieldTypes;
    }

}
