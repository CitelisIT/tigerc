package ast;

import java.util.ArrayList;

public class SeqExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> exprs = new ArrayList<Ast>();

    public SeqExp(ArrayList<Ast> exprs) {
        this.exprs = exprs;
    }
}

