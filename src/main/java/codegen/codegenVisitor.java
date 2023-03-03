package codegen;

import java.util.Map;
import ast.AstVisitor;
import symtab.scope.Scope;

public class codegenVisitor implements AstVisitor<String> {

    public codegenVisitor(Map<String, Scope> symtab) {
        // TODO
    }



    public String visit(ast.Program program) {
        // TODO
        return null;
    }

    public String visit(ast.Assign assign) {
        // TODO
        return null;
    }

    public String visit(ast.Or or) {
        // TODO
        return null;
    }

    public String visit(ast.And and) {
        // TODO
        return null;
    }

    public String visit(ast.Eq eq) {
        // TODO
        return null;
    }

    public String visit(ast.NotEq notEq) {
        // TODO
        return null;
    }

    public String visit(ast.InfEq infEq) {
        // TODO
        return null;
    }

    public String visit(ast.Inf inf) {
        // TODO
        return null;
    }

    public String visit(ast.SupEq supEq) {
        // TODO
        return null;
    }

    public String visit(ast.Sup sup) {
        // TODO
        return null;
    }

    public String visit(ast.Add add) {
        // TODO
        return null;
    }

    public String visit(ast.Sub sub) {
        // TODO
        return null;
    }

    public String visit(ast.Mult mult) {
        // TODO
        return null;
    }

    public String visit(ast.Div div) {
        // TODO
        return null;
    }

    public String visit(ast.SeqExp seqExp) {
        // TODO
        return null;
    }

    public String visit(ast.Neg neg) {
        // TODO
        return null;
    }

    public String visit(ast.IfThenElse ifThenElse) {
        // TODO
        return null;
    }

    public String visit(ast.WhileExp whileExp) {
        // TODO
        return null;
    }

    public String visit(ast.ForExp forExp) {
        // TODO
        return null;
    }

    public String visit(ast.LetDecls letDecls) {
        // TODO
        return null;
    }

    public String visit(ast.LetScope letScope) {
        // TODO
        return null;
    }

    public String visit(ast.LetExp letExp) {
        // TODO
        return null;
    }

    public String visit(ast.CallExpArgs callExpArgs) {
        // TODO
        return null;
    }

    public String visit(ast.CallExp callExp) {
        // TODO
        return null;
    }

    public String visit(ast.FieldDec fieldDec) {
        // TODO
        return null;
    }


    public String visit(ast.TypeDec typeDec) {
        // TODO
        return null;
    }

    public String visit(ast.TypeDecs typeDecs) {
        // TODO
        return null;
    }

    public String visit(ast.VarDecType varDecType) {
        // TODO
        return null;
    }

    public String visit(ast.VarDecNoType varDecNoType) {
        // TODO
        return null;
    }

    public String visit(ast.FunArgs funArgs) {
        // TODO
        return null;
    }

    public String visit(ast.FunDec funDec) {
        // TODO
        return null;
    }

    public String visit(ast.Id id) {
        // TODO
        return null;
    }

    public String visit(ast.TypeId typeId) {
        // TODO
        return null;
    }

    public String visit(ast.ArrType arrType) {
        // TODO
        return null;
    }

    public String visit(ast.RecType recType) {
        // TODO
        return null;
    }

    public String visit(ast.Subscript subscript) {
        // TODO
        return null;
    }

    public String visit(ast.FieldExp fieldExp) {
        // TODO
        return null;
    }

    public String visit(ast.ArrCreate arrCreate) {
        // TODO
        return null;
    }

    public String visit(ast.FieldCreate fieldCreate) {
        // TODO
        return null;
    }

    public String visit(ast.RecCreateFields recCreateFields) {
        // TODO
        return null;
    }

    public String visit(ast.RecCreate recCreate) {
        // TODO
        return null;
    }

    public String visit(ast.IntLiteral intLiteral) {
        // TODO
        return null;
    }

    public String visit(ast.StringLiteral stringLiteral) {
        // TODO
        return null;
    }

    public String visit(ast.NilLiteral nilLiteral) {
        // TODO
        return null;
    }

    public String visit(ast.BreakLiteral breakLiteral) {
        // TODO
        return null;
    }

}
