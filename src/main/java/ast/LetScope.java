package ast;

import java.util.ArrayList;

public class LetScope implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> exprs;

    public LetScope(ArrayList<Ast> exprs) {
        this.exprs = exprs;
    }
}
