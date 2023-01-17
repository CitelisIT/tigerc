package ast;

public interface AstVisitor<T> {

    T visit(Program program);

    T visit(Assign assign);

    T visit(Or or);

    T visit(And and);

    T visit(Eq eq);

    T visit(NotEq notEq);

    T visit(InfEq infEq);

    T visit(Inf inf);

    T visit(SupEq supEq);

    T visit(Sup sup);

    T visit(Add add);

    T visit(Sub sub);

    T visit(Mult mult);

    T visit(Div div);

    T visit(SeqExp seqExp);

    T visit(Neg neg);

    T visit(IfThenElse ifThenElse);

    T visit(WhileExp whileExp);

    T visit(ForExp forExp);

    T visit(LetDecls letDecls);

    T visit(LetScope letScope);

    T visit(LetExp letExp);

    T visit(CallExpArgs callExpArgs);

    T visit(CallExp callExp);

    T visit(FieldDec fieldDec);

    T visit(TypeDec typeDec);

    T visit(TypeDecs typeDecs);

    T visit(VarDecType varDecType);

    T visit(VarDecNoType varDecNoType);

    T visit(FunArgs funArgs);

    T visit(FunDec funDec);

    T visit(Id id);

    T visit(TypeId typeId);

    T visit(ArrType arrType);

    T visit(RecType recType);

    T visit(Subscript subscript);

    T visit(FieldExp fieldExp);

    T visit(ArrCreate arrCreate);

    T visit(FieldCreate fieldCreate);

    T visit(RecCreateFields recCreateFields);

    T visit(RecCreate recCreate);

    T visit(IntLiteral intLitteral);

    T visit(StringLiteral stringLiteral);

    T visit(NilLiteral nilLitteral);

    T visit(BreakLiteral breakLitteral);
}
