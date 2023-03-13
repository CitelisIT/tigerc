package codegen;

import java.util.Map;
import ast.AstVisitor;
import symtab.scope.Scope;

public class codegenVisitor implements AstVisitor<String> {

    public String IncludeSection;
    public String DataSection;
    public String TextSection;
    public String FuncSection;
    public Map<String, Scope> TDS;



    public codegenVisitor(Map<String, Scope> symtab) {
        this.DataSection = ".data\n\n";
        this.TextSection = ".text\n\n.global _start\n\n_start:\n\n";
        this.IncludeSection = ".include     \"Base_function.s\"";
        this.TDS = symtab;
    }

    public String infixValueCodeGen(ast.Ast left, ast.Ast right) {
        String leftValueCode;
        String rightValueCode;

        if (left instanceof ast.IntLiteral) {
            ast.IntLiteral leftInt = (ast.IntLiteral) left;
            leftValueCode = "MOV     R8,#" + leftInt.value + "\n";
        } else {
            left.accept(this);
            leftValueCode = "POP     {R8}\n";
        }
        if (right instanceof ast.IntLiteral) {
            ast.IntLiteral rightInt = (ast.IntLiteral) right;
            rightValueCode = "MOV     R9,#" + rightInt.value + "\n";
        } else {
            right.accept(this);
            rightValueCode = "POP     {R9}\n";
        }
        return rightValueCode + leftValueCode;
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
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(add.left, add.right);
        this.TextSection += "ADD     R8,R8,R9\n";
        this.TextSection += "PUSH       {R8}\n";
        return null;
    }

    public String visit(ast.Sub sub) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(sub.left, sub.right);
        this.TextSection += "SUB     R8,R8,R9\n";
        this.TextSection += "PUSH       {R8}\n";
        return null;
    }

    public String visit(ast.Mult mult) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(mult.left, mult.right);
        this.TextSection += "MUL     R8,R8,R9\n";
        this.TextSection += "PUSH       {R8}\n";
        return null;
    }

    public String visit(ast.Div div) {
        this.TextSection += "\n";
        this.TextSection += infixValueCodeGen(div.left, div.right);
        this.TextSection += "SDIV     R8,R8,R9\n";
        this.TextSection += "PUSH       {R8}\n";
        return null;
    }

    public String visit(ast.SeqExp seqExp) {
        for (ast.Ast exp : seqExp.exprs) {
            this.TextSection += "\n";
            exp.accept(this);
        }
        return null;
    }

    public String visit(ast.Neg neg) {
        String exprValueCode;

        if (neg.expr instanceof ast.IntLiteral) {
            ast.IntLiteral intValue = (ast.IntLiteral) neg.expr;
            exprValueCode = "MOV     R8,#" + intValue.value + "\n";
        } else {
            neg.expr.accept(this);
            exprValueCode = "POP     {R8}\n";
        }
        this.TextSection += exprValueCode;
        this.TextSection += "MOV    R9,#0\n";
        this.TextSection += "SUB    R8,R9,R8\n";
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
