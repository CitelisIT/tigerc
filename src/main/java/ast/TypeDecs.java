package ast;

import java.util.ArrayList;

public class TypeDecs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> tydecs;

    public TypeDecs(ArrayList<Ast> tydecs) {
        this.tydecs = tydecs;
    }


}
