package ast;

import java.util.ArrayList;

public class LetDecls implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> decls;

    public LetDecls(ArrayList<Ast> decls) {
        this.decls = decls;
    }
}
