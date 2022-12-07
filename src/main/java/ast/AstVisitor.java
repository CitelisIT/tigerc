package ast;

public interface AstVisitor<T> {

    public T visit(Program program);

    public T visit(Assign assign);

    public T visit(Or or);

    public T visit(And and);

    public T visit(Eq eq);

    public T visit(NotEq notEq);

    public T visit(InfEq infEq);

    public T visit(Inf inf);

    public T visit(SupEq supEq);

    public T visit(Sup sup);

    public T visit(Add add);

    public T visit(Sub sub);

    public T visit(Mult mult);

    public T visit(Div div);

    public T visit(SeqExp seqExp);

    public T visit(Neg neg);

    public T visit(IfThen ifThen);

    public T visit(IfThenElse ifThenElse);

    public T visit(WhileExp whileExp);

    public T visit(ForExp forExp);

    public T visit(LetDecls letDecls);

    public T visit(LetScope letScope);

    public T visit(LetExp letExp);

    public T visit(CallExpArgs callExpArgs);

    public T visit(CallExp callExp);

    public T visit(FieldDec fieldDec);

    public T visit(TypeDec typeDec);

    public T visit(VarDecType varDecType);

    public T visit(VarDecNoType varDecNoType);

    public T visit(FunArgs funArgs);

    public T visit(FunDec funDec);

    public T visit(Id id);

    public T visit(TypeId typeId);

    public T visit(ArrType arrType);

    public T visit(RecType recType);

    public T visit(Subscript subscript);

    public T visit(FieldExp fieldExp);

    public T visit(ArrCreate arrCreate);

    public T visit(FieldCreate fieldCreate);

    public T visit(RecCreateFields recCreateFields);

    public T visit(RecCreate recCreate);

    public T visit(IntLiteral intLitteral);

    public T visit(StringLiteral stringLiteral);

    public T visit(NilLiteral nilLitteral);

    public T visit(BreakLiteral breakLitteral);
}
