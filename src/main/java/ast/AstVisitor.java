package ast;

public interface AstVisitor<T> {

    public T visit(Program program);

    public T visit(Exp exp);

    public T visit(OrExp orExp);

    public T visit(AndExp andExp);

    public T visit(EqExp eqExp);

    public T visit(AddExp addExp);

    public T visit(MultExp multExp);

    public T visit(SimpleExp simpleExp);

    public T visit(IdExp idExp);

    public T visit(SeqExp seqExp);

    public T visit(Neg neg);

    public T visit(IfThen ifThen);

    public T visit(WhileExp whileExp);

    public T visit(ForExp forExp);

    public T visit(LetExp letExp);

    public T visit(FieldCreate fieldCreate);

    public T visit(Dec dec);

    public T visit(TypeDec typeDec);

    public T visit(VarDec varDec);

    public T visit(VarDecFact varDecFact);

    public T visit(FunDec funDec);

    public T visit(EndDec endDec);

    public T visit(Type type);

    public T visit(ArrType arrType);

    public T visit(RecType recType);

    public T visit(IntLitteral intLitteral);

    public T visit(StringLitteral stringLitteral);

    public T visit(NilLitteral nilLitteral);

    public T visit(BreakLitteral breakLitteral);
}
