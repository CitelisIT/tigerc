package ast;

import java.util.ArrayList;

public class FunArgs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldDec> args;

    public FunArgs(ArrayList<FieldDec> args) {
        this.args = args;
    }

}
