package ast;

import java.util.ArrayList;

public class LetExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> decls = new ArrayList<Ast>();
    public ArrayList<Ast> inExprs = new ArrayList<Ast>();

    public LetExp(ArrayList<Ast> decls, ArrayList<Ast> inExprs) {
        this.decls = decls;
        this.inExprs = inExprs;
    }

}
