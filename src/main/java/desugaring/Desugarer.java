package desugaring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import ast.*;
import symtab.scope.Scope;
import symtab.symbol.RecordTypeSymbol;

public class Desugarer implements AstVisitor<Ast> {

    public Map<String, Scope> symtab;

    public Desugarer(Map<String, Scope> symtab) {
        this.symtab = symtab;
    }

    public Ast visit(Program program) {
        int lineNumber = program.getLineNumber();
        int columnNumber = program.getColumnNumber();
        Ast exp = program.exp;
        return new Program(exp.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Assign assign) {
        int lineNumber = assign.getLineNumber();
        int columnNumber = assign.getColumnNumber();
        Ast lValue = assign.lValue;
        Ast expr = assign.expr;
        return new Assign(lValue.accept(this), expr.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Or or) {
        int lineNumber = or.getLineNumber();
        int columnNumber = or.getColumnNumber();
        Ast left = or.left;
        Ast right = or.right;
        return new Or(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(And and) {
        int lineNumber = and.getLineNumber();
        int columnNumber = and.getColumnNumber();
        Ast left = and.left;
        Ast right = and.right;
        return new And(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Eq eq) {
        int lineNumber = eq.getLineNumber();
        int columnNumber = eq.getColumnNumber();
        Ast left = eq.left;
        Ast right = eq.right;
        return new Eq(left.accept(this), right.accept(this), lineNumber, columnNumber, eq.type);
    }

    public Ast visit(NotEq notEq) {
        int lineNumber = notEq.getLineNumber();
        int columnNumber = notEq.getColumnNumber();
        Ast left = notEq.left;
        Ast right = notEq.right;
        return new NotEq(left.accept(this), right.accept(this), lineNumber, columnNumber, notEq.type);
    }

    public Ast visit(InfEq infEq) {
        int lineNumber = infEq.getLineNumber();
        int columnNumber = infEq.getColumnNumber();
        Ast left = infEq.left;
        Ast right = infEq.right;
        return new InfEq(left.accept(this), right.accept(this), lineNumber, columnNumber, infEq.type);
    }

    public Ast visit(Inf inf) {
        int lineNumber = inf.getLineNumber();
        int columnNumber = inf.getColumnNumber();
        Ast left = inf.left;
        Ast right = inf.right;
        return new Inf(left.accept(this), right.accept(this), lineNumber, columnNumber, inf.type);
    }

    public Ast visit(SupEq supEq) {
        int lineNumber = supEq.getLineNumber();
        int columnNumber = supEq.getColumnNumber();
        Ast left = supEq.left;
        Ast right = supEq.right;
        return new SupEq(left.accept(this), right.accept(this), lineNumber, columnNumber, supEq.type);
    }

    public Ast visit(Sup sup) {
        int lineNumber = sup.getLineNumber();
        int columnNumber = sup.getColumnNumber();
        Ast left = sup.left;
        Ast right = sup.right;
        return new Sup(left.accept(this), right.accept(this), lineNumber, columnNumber, sup.type);
    }

    public Ast visit(Add add) {
        int lineNumber = add.getLineNumber();
        int columnNumber = add.getColumnNumber();
        Ast left = add.left;
        Ast right = add.right;
        return new Add(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Sub sub) {
        int lineNumber = sub.getLineNumber();
        int columnNumber = sub.getColumnNumber();
        Ast left = sub.left;
        Ast right = sub.right;
        return new Sub(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Mult mult) {
        int lineNumber = mult.getLineNumber();
        int columnNumber = mult.getColumnNumber();
        Ast left = mult.left;
        Ast right = mult.right;
        return new Mult(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(Div div) {
        int lineNumber = div.getLineNumber();
        int columnNumber = div.getColumnNumber();
        Ast left = div.left;
        Ast right = div.right;
        return new Div(left.accept(this), right.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(SeqExp seqExp) {
        int lineNumber = seqExp.getLineNumber();
        int columnNumber = seqExp.getColumnNumber();
        ArrayList<Ast> exprs = seqExp.exprs;
        return new SeqExp(new ArrayList<Ast>(exprs.stream().map(elt -> elt.accept(this)).toList()), lineNumber,
                columnNumber);
    }

    public Ast visit(Neg neg) {
        int lineNumber = neg.getLineNumber();
        int columnNumber = neg.getColumnNumber();
        Ast expr = neg.expr;
        return new Neg(expr.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(IfThenElse ifThenElse) {
        int lineNumber = ifThenElse.getLineNumber();
        int columnNumber = ifThenElse.getColumnNumber();
        Ast condition = ifThenElse.condition;
        Ast thenExpr = ifThenElse.thenExpr;
        Ast elseExpr = ifThenElse.elseExpr;
        if (elseExpr != null)
            return new IfThenElse(condition.accept(this), thenExpr.accept(this), elseExpr.accept(this), lineNumber,
                    columnNumber);
        else
            return new IfThenElse(condition.accept(this), thenExpr.accept(this), null, lineNumber,
                    columnNumber);
    }

    public Ast visit(WhileExp whileExp) {
        int lineNumber = whileExp.getLineNumber();
        int columnNumber = whileExp.getColumnNumber();
        Ast condition = whileExp.condition;
        Ast doExpr = whileExp.doExpr;
        return new WhileExp(condition.accept(this), doExpr.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(ForExp forExp) {
        int lineNumber = forExp.getLineNumber();
        int columnNumber = forExp.getColumnNumber();
        Id forId = forExp.forId;
        Ast startValue = forExp.startValue;
        Ast endValue = forExp.endValue;
        Ast doExpr = forExp.doExpr;

        Ast increment = new Assign(forId,
                new Add(forId, new IntLiteral(1, lineNumber, columnNumber), lineNumber, columnNumber), lineNumber,
                columnNumber);
        Ast newBody = new SeqExp(new ArrayList<Ast>(Arrays.asList(doExpr.accept(this), increment)), lineNumber,
                columnNumber);
        Ast newCond = new Inf(forId, endValue.accept(this), lineNumber, columnNumber, "int_TYPE");
        LetScope newLoop = new LetScope(
                new ArrayList<Ast>(Arrays.asList(new WhileExp(newCond, newBody, lineNumber, columnNumber))), lineNumber,
                columnNumber);
        Ast varDec = new VarDecNoType(forId, startValue.accept(this), lineNumber, columnNumber);
        LetDecls letDecl = new LetDecls(new ArrayList<Ast>(Arrays.asList(varDec)), lineNumber, columnNumber);
        return new LetExp(letDecl, newLoop, lineNumber, columnNumber, forExp.ScopeID);
    }

    public Ast visit(LetDecls letDecls) {
        int lineNumber = letDecls.getLineNumber();
        int columnNumber = letDecls.getColumnNumber();
        ArrayList<Ast> decls = letDecls.decls;
        return new LetDecls(new ArrayList<Ast>(decls.stream().map(elt -> elt.accept(this)).toList()), lineNumber,
                columnNumber);
    }

    public Ast visit(LetScope letScope) {
        int lineNumber = letScope.getLineNumber();
        int columnNumber = letScope.getColumnNumber();
        ArrayList<Ast> exprs = letScope.exprs;
        return new LetScope(new ArrayList<Ast>(exprs.stream().map(elt -> elt.accept(this)).toList()), lineNumber,
                columnNumber);
    }

    public Ast visit(LetExp letExp) {
        int lineNumber = letExp.getLineNumber();
        int columnNumber = letExp.getColumnNumber();
        LetDecls letDecls = letExp.letDecls;
        LetScope letScope = letExp.letScope;
        return new LetExp((LetDecls) letDecls.accept(this), (LetScope) letScope.accept(this), lineNumber, columnNumber,
                letExp.ScopeID);
    }

    public Ast visit(CallExpArgs callExpArgs) {
        int lineNumber = callExpArgs.getLineNumber();
        int columnNumber = callExpArgs.getColumnNumber();
        ArrayList<Ast> args = callExpArgs.args;
        return new CallExpArgs(new ArrayList<Ast>(args.stream().map(elt -> elt.accept(this)).toList()), lineNumber,
                columnNumber);
    }

    public Ast visit(CallExp callExp) {
        int lineNumber = callExp.getLineNumber();
        int columnNumber = callExp.getColumnNumber();
        Id id = callExp.id;
        CallExpArgs args = callExp.args;
        return new CallExp(id, (CallExpArgs) args.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(FieldDec fieldDec) {
        int lineNumber = fieldDec.getLineNumber();
        int columnNumber = fieldDec.getColumnNumber();
        Id id = fieldDec.id;
        TypeId typeId = fieldDec.typeId;
        return new FieldDec(id, typeId, lineNumber, columnNumber);
    }

    public Ast visit(TypeDec typeDec) {
        int lineNumber = typeDec.getLineNumber();
        int columnNumber = typeDec.getColumnNumber();
        TypeId typeId = typeDec.typeId;
        Type typeValue = typeDec.typeValue;
        return new TypeDec(typeId, (Type) typeValue.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(TypeDecs typeDecs) {
        int lineNumber = typeDecs.getLineNumber();
        int columnNumber = typeDecs.getColumnNumber();
        ArrayList<TypeDec> tydecs = typeDecs.tydecs;
        return new TypeDecs(new ArrayList<TypeDec>(tydecs.stream().map(elt -> (TypeDec) elt.accept(this)).toList()),
                lineNumber,
                columnNumber);
    }

    public Ast visit(VarDecType varDecType) {
        int lineNumber = varDecType.getLineNumber();
        int columnNumber = varDecType.getColumnNumber();
        Id varId = varDecType.varId;
        Ast varValue = varDecType.varValue;
        return new VarDecNoType(varId, varValue.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(VarDecNoType varDecNoType) {
        int lineNumber = varDecNoType.getLineNumber();
        int columnNumber = varDecNoType.getColumnNumber();
        Id varId = varDecNoType.varId;
        Ast varValue = varDecNoType.varValue;
        return new VarDecNoType(varId, varValue.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(FunArgs funArgs) {
        int lineNumber = funArgs.getLineNumber();
        int columnNumber = funArgs.getColumnNumber();
        ArrayList<FieldDec> tydecs = funArgs.args;
        return new FunArgs(new ArrayList<FieldDec>(tydecs.stream().map(elt -> (FieldDec) elt.accept(this)).toList()),
                lineNumber,
                columnNumber);
    }

    public Ast visit(FunDec funDec) {
        int lineNumber = funDec.getLineNumber();
        int columnNumber = funDec.getColumnNumber();
        Id id = funDec.id;
        FunArgs args = funDec.args;
        TypeId returnTypeId = funDec.returnTypeId;
        Ast body = funDec.body;
        return new FunDec(id, (FunArgs) args.accept(this), returnTypeId, body.accept(this), lineNumber, columnNumber, funDec.ScopeID);
    }

    public Ast visit(Id id) {
        return id;
    }

    public Ast visit(TypeId typeId) {
        return typeId;
    }

    public Ast visit(ArrType arrType) {
        return arrType;
    }

    public Ast visit(RecType recType) {
        return recType;
    }

    public Ast visit(Subscript subscript) {
        int lineNumber = subscript.getLineNumber();
        int columnNumber = subscript.getColumnNumber();
        Ast lValue = subscript.lValue;
        Ast expr = subscript.expr;
        return new Subscript(lValue.accept(this), expr.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(FieldExp fieldExp) {
        int lineNumber = fieldExp.getLineNumber();
        int columnNumber = fieldExp.getColumnNumber();
        Ast lValue = fieldExp.lValue;
        Id id = fieldExp.id;
        RecordTypeSymbol recordType = fieldExp.recordType;
        int fieldIndex = recordType.getFieldIndex(id.name);
        return new Subscript(lValue.accept(this), new IntLiteral(fieldIndex, lineNumber, columnNumber), lineNumber, columnNumber);
    }

    public Ast visit(ArrCreate arrCreate) {
        int lineNumber = arrCreate.getLineNumber();
        int columnNumber = arrCreate.getColumnNumber();
        TypeId typeId = arrCreate.typeId;
        Ast index = arrCreate.index;
        Ast of = arrCreate.of;
        return new ArrCreate(typeId, index.accept(this), of.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(FieldCreate fieldCreate) {
        int lineNumber = fieldCreate.getLineNumber();
        int columnNumber = fieldCreate.getColumnNumber();
        Id id = fieldCreate.id;
        Ast expr = fieldCreate.expr;
        return new FieldCreate(id, expr.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(RecCreateFields recCreateFields) {
        int lineNumber = recCreateFields.getLineNumber();
        int columnNumber = recCreateFields.getColumnNumber();
        ArrayList<FieldCreate> fields = recCreateFields.fields;
        return new RecCreateFields(
                new ArrayList<FieldCreate>(fields.stream().map(elt -> (FieldCreate) elt.accept(this)).toList()),
                lineNumber,
                columnNumber);
    }

    public Ast visit(RecCreate recCreate) {
        int lineNumber = recCreate.getLineNumber();
        int columnNumber = recCreate.getColumnNumber();
        TypeId typeId = recCreate.typeId;
        RecCreateFields fields = recCreate.fields;
        return new RecCreate(typeId, (RecCreateFields) fields.accept(this), lineNumber, columnNumber);
    }

    public Ast visit(IntLiteral intLitteral) {
        return intLitteral;
    }

    public Ast visit(StringLiteral stringLiteral) {
        return stringLiteral;
    }

    public Ast visit(NilLiteral nilLitteral) {
        return nilLitteral;
    }

    public Ast visit(BreakLiteral breakLitteral) {
        return breakLitteral;
    }
}
