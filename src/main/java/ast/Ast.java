package ast;

public interface Ast {

    <T> T accept(AstVisitor<T> visitor);

}

