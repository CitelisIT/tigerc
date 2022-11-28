package ast;

import java.util.ArrayList;

public class CallExpArgs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> args;

    public CallExpArgs(ArrayList<Ast> args) {
        this.args = args;
    }

}
