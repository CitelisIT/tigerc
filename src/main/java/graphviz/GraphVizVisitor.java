package graphviz;

import java.io.FileOutputStream;
import java.io.IOException;
import ast.Add;
import ast.And;
import ast.ArrCreate;
import ast.ArrType;
import ast.Assign;
import ast.Ast;
import ast.AstVisitor;
import ast.BreakLiteral;
import ast.CallExp;
import ast.CallExpArgs;
import ast.Div;
import ast.Eq;
import ast.FieldCreate;
import ast.FieldDec;
import ast.FieldExp;
import ast.ForExp;
import ast.FunArgs;
import ast.FunDec;
import ast.Id;
import ast.IfThen;
import ast.IfThenElse;
import ast.Inf;
import ast.InfEq;
import ast.IntLiteral;
import ast.LetDecls;
import ast.LetExp;
import ast.LetScope;
import ast.Mult;
import ast.Neg;
import ast.NilLiteral;
import ast.NotEq;
import ast.Or;
import ast.Program;
import ast.RecCreate;
import ast.RecCreateFields;
import ast.RecType;
import ast.SeqExp;
import ast.StringLiteral;
import ast.Sub;
import ast.Subscript;
import ast.Sup;
import ast.SupEq;
import ast.TypeDec;
import ast.TypeId;
import ast.VarDecNoType;
import ast.VarDecType;
import ast.WhileExp;

public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;

    public GraphVizVisitor() {
        this.state = 0;
        this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
    }

    public void dumpGraph(String filepath) throws IOException {

        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer + "\n}";
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();
    }

    private String nextState() {
        int returnedState = this.state;
        this.state++;
        return "N" + returnedState;
    }

    private void addTransition(String from, String dest) {
        this.linkBuffer += String.format("\t%s -> %s; \n", from, dest);
    }

    private void addNode(String node, String label) {
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node, label);
    }

    public String visit(Program program) {

        String nodeIdentifier = this.nextState();

        String expIdentifier = program.exp.accept(this);

        this.addNode(nodeIdentifier, "Program");
        this.addTransition(nodeIdentifier, expIdentifier);

        return nodeIdentifier;
    }

    public String visit(Assign assign) {

        String nodeIdentifier = this.nextState();

        String lValueId = assign.lValue.accept(this);
        String expId = assign.expr.accept(this);

        this.addNode(nodeIdentifier, "Assign");
        this.addTransition(nodeIdentifier, lValueId);
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;

    }

    public String visit(Or or) {

        String nodeIdentifier = this.nextState();

        String leftId = or.left.accept(this);
        String rightId = or.right.accept(this);

        this.addNode(nodeIdentifier, "|");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(And and) {

        String nodeIdentifier = this.nextState();

        String leftId = and.left.accept(this);
        String rightId = and.right.accept(this);

        this.addNode(nodeIdentifier, "&");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Eq eq) {

        String nodeIdentifier = this.nextState();

        String leftId = eq.left.accept(this);
        String rightId = eq.right.accept(this);

        this.addNode(nodeIdentifier, "=");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(NotEq notEq) {

        String nodeIdentifier = this.nextState();

        String leftId = notEq.left.accept(this);
        String rightId = notEq.right.accept(this);

        this.addNode(nodeIdentifier, "<>");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(InfEq infEq) {

        String nodeIdentifier = this.nextState();

        String leftId = infEq.left.accept(this);
        String rightId = infEq.right.accept(this);

        this.addNode(nodeIdentifier, "<=");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Inf inf) {

        String nodeIdentifier = this.nextState();

        String leftId = inf.left.accept(this);
        String rightId = inf.right.accept(this);

        this.addNode(nodeIdentifier, "<");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(SupEq supEq) {

        String nodeIdentifier = this.nextState();

        String leftId = supEq.left.accept(this);
        String rightId = supEq.right.accept(this);

        this.addNode(nodeIdentifier, ">=");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Sup sup) {

        String nodeIdentifier = this.nextState();

        String leftId = sup.left.accept(this);
        String rightId = sup.right.accept(this);

        this.addNode(nodeIdentifier, ">");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Add add) {

        String nodeIdentifier = this.nextState();

        String leftId = add.left.accept(this);
        String rightId = add.right.accept(this);

        this.addNode(nodeIdentifier, "+");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Sub sub) {

        String nodeIdentifier = this.nextState();

        String leftId = sub.left.accept(this);
        String rightId = sub.right.accept(this);

        this.addNode(nodeIdentifier, "-");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Mult mult) {

        String nodeIdentifier = this.nextState();

        String leftId = mult.left.accept(this);
        String rightId = mult.right.accept(this);

        this.addNode(nodeIdentifier, "*");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(Div div) {

        String nodeIdentifier = this.nextState();

        String leftId = div.left.accept(this);
        String rightId = div.right.accept(this);

        this.addNode(nodeIdentifier, "/");
        this.addTransition(nodeIdentifier, leftId);
        this.addTransition(nodeIdentifier, rightId);

        return nodeIdentifier;
    }

    public String visit(SeqExp seqExp) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "SeqExp");
        for (Ast exp : seqExp.exprs) {
            String expId = exp.accept(this);
            this.addTransition(nodeIdentifier, expId);
        }

        return nodeIdentifier;
    }

    public String visit(Neg neg) {

        String nodeIdentifier = this.nextState();

        String expId = neg.expr.accept(this);

        this.addNode(nodeIdentifier, "-");
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;
    }

    public String visit(IfThen ifThen) {

        String nodeIdentifier = this.nextState();

        String condId = ifThen.condition.accept(this);
        String thenId = ifThen.thenExpr.accept(this);

        this.addNode(nodeIdentifier, "If Then");
        this.addTransition(nodeIdentifier, condId);
        this.addTransition(nodeIdentifier, thenId);

        return nodeIdentifier;
    }

    public String visit(IfThenElse ifThenElse) {

        String nodeIdentifier = this.nextState();

        String condId = ifThenElse.condition.accept(this);
        String thenId = ifThenElse.thenExpr.accept(this);
        String elseId = ifThenElse.thenExpr.accept(this);

        this.addNode(nodeIdentifier, "If Then Else");
        this.addTransition(nodeIdentifier, condId);
        this.addTransition(nodeIdentifier, thenId);
        this.addTransition(nodeIdentifier, elseId);

        return nodeIdentifier;
    }

    public String visit(WhileExp whileExp) {

        String nodeIdentifier = this.nextState();

        String condId = whileExp.condition.accept(this);
        String expId = whileExp.doExpr.accept(this);

        this.addNode(nodeIdentifier, "While");
        this.addTransition(nodeIdentifier, condId);
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;
    }

    public String visit(ForExp forExp) {

        String nodeIdentifier = this.nextState();

        String varId = forExp.forId.accept(this);
        String startValueId = forExp.startValue.accept(this);
        String endValueId = forExp.endValue.accept(this);
        String expId = forExp.doExpr.accept(this);

        this.addNode(nodeIdentifier, "For");
        this.addTransition(nodeIdentifier, varId);
        this.addTransition(nodeIdentifier, startValueId);
        this.addTransition(nodeIdentifier, endValueId);
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;
    }

    public String visit(LetDecls letDecls) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Declarations");
        for (Ast exp : letDecls.decls) {
            String declId = exp.accept(this);
            this.addTransition(nodeIdentifier, declId);
        }

        return nodeIdentifier;
    }

    public String visit(LetScope letScope) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Expressions");
        for (Ast exp : letScope.exprs) {
            String declId = exp.accept(this);
            this.addTransition(nodeIdentifier, declId);
        }

        return nodeIdentifier;
    }

    public String visit(LetExp letExp) {

        String nodeIdentifier = this.nextState();

        String declsId = letExp.letDecls.accept(this);
        String inId = letExp.letScope.accept(this);

        this.addNode(nodeIdentifier, "Let In");
        this.addTransition(nodeIdentifier, declsId);
        this.addTransition(nodeIdentifier, inId);

        return nodeIdentifier;
    }

    public String visit(CallExpArgs callExpArgs) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Call Arguments");

        for (Ast arg : callExpArgs.args) {
            String argId = arg.accept(this);
            this.addTransition(nodeIdentifier, argId);
        }

        return nodeIdentifier;
    }

    public String visit(CallExp callExp) {

        String nodeIdentifier = this.nextState();

        String callId = callExp.id.accept(this);
        String argsId = callExp.args.accept(this);

        this.addNode(nodeIdentifier, "Call");
        this.addTransition(nodeIdentifier, callId);
        this.addTransition(nodeIdentifier, argsId);

        return nodeIdentifier;
    }

    public String visit(FieldDec fieldDec) {

        String nodeIdentifier = this.nextState();

        String idfId = fieldDec.id.accept(this);
        String typeId = fieldDec.typeId.accept(this);

        this.addNode(nodeIdentifier, "Field");
        this.addTransition(nodeIdentifier, idfId);
        this.addTransition(nodeIdentifier, typeId);

        return nodeIdentifier;
    }

    public String visit(TypeDec typeDec) {

        String nodeIdentifier = this.nextState();

        String idfId = typeDec.typeId.accept(this);
        String typeValueId = typeDec.typeValue.accept(this);

        this.addNode(nodeIdentifier, "Type Declaration");
        this.addTransition(nodeIdentifier, idfId);
        this.addTransition(nodeIdentifier, typeValueId);

        return nodeIdentifier;
    }

    public String visit(VarDecType varDecType) {

        String nodeIdentifier = this.nextState();

        String idfId = varDecType.varId.accept(this);
        String typeId = varDecType.varTypeId.accept(this);
        String valueId = varDecType.varValue.accept(this);

        this.addNode(nodeIdentifier, "Variable Declaration");
        this.addTransition(nodeIdentifier, idfId);
        this.addTransition(nodeIdentifier, typeId);
        this.addTransition(nodeIdentifier, valueId);

        return nodeIdentifier;
    }

    public String visit(VarDecNoType varDecNoType) {

        String nodeIdentifier = this.nextState();

        String idfId = varDecNoType.varId.accept(this);
        String valueId = varDecNoType.varValue.accept(this);

        this.addNode(nodeIdentifier, "Variable Declaration");
        this.addTransition(nodeIdentifier, idfId);
        this.addTransition(nodeIdentifier, valueId);

        return nodeIdentifier;
    }

    public String visit(FunArgs funArgs) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Arguments");

        for (FieldDec arg : funArgs.args) {
            String argId = arg.accept(this);
            this.addTransition(nodeIdentifier, argId);
        }

        return nodeIdentifier;
    }

    public String visit(FunDec funDec) {

        String nodeIdentifier = this.nextState();

        String funId = funDec.id.accept(this);
        String argsId = funDec.args.accept(this);
        String typeId = funDec.returnTypeId.accept(this);
        String bodyId = funDec.body.accept(this);

        this.addNode(nodeIdentifier, "Function");
        this.addTransition(nodeIdentifier, funId);
        this.addTransition(nodeIdentifier, argsId);
        this.addTransition(nodeIdentifier, typeId);
        this.addTransition(nodeIdentifier, bodyId);

        return nodeIdentifier;
    }

    public String visit(Id id) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Id: " + id.name);

        return nodeIdentifier;
    }

    public String visit(TypeId typeId) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Type Id: " + typeId.name);

        return nodeIdentifier;
    }

    public String visit(ArrType arrType) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Array of " + arrType.name);

        return nodeIdentifier;
    }

    public String visit(RecType recType) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Record Type");

        for (FieldDec field : recType.fields) {
            String fieldId = field.accept(this);
            this.addTransition(nodeIdentifier, fieldId);
        }

        return nodeIdentifier;
    }

    public String visit(Subscript subscript) {

        String nodeIdentifier = this.nextState();

        String lValueId = subscript.lValue.accept(this);
        String expId = subscript.expr.accept(this);

        this.addNode(nodeIdentifier, "Array Access");
        this.addTransition(nodeIdentifier, lValueId);
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;
    }

    public String visit(FieldExp fieldExp) {

        String nodeIdentifier = this.nextState();

        String lValueId = fieldExp.lValue.accept(this);
        String idfId = fieldExp.id.accept(this);

        this.addNode(nodeIdentifier, "Field Access");
        this.addTransition(nodeIdentifier, lValueId);
        this.addTransition(nodeIdentifier, idfId);

        return nodeIdentifier;
    }

    public String visit(ArrCreate arrCreate) {

        String nodeIdentifier = this.nextState();

        String typeId = arrCreate.typeId.accept(this);
        String indexId = arrCreate.index.accept(this);
        String ofId = arrCreate.of.accept(this);

        this.addNode(nodeIdentifier, "Array Creation");
        this.addTransition(nodeIdentifier, typeId);
        this.addTransition(nodeIdentifier, indexId);
        this.addTransition(nodeIdentifier, ofId);

        return nodeIdentifier;
    }

    public String visit(FieldCreate fieldCreate) {

        String nodeIdentifier = this.nextState();

        String idfId = fieldCreate.id.accept(this);
        String expId = fieldCreate.expr.accept(this);

        this.addNode(nodeIdentifier, "Field Creation");
        this.addTransition(nodeIdentifier, idfId);
        this.addTransition(nodeIdentifier, expId);

        return nodeIdentifier;
    }

    public String visit(RecCreateFields recCreateFields) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Record Fields");

        for (FieldCreate field : recCreateFields.fields) {
            String fieldId = field.accept(this);
            this.addTransition(nodeIdentifier, fieldId);
        }

        return nodeIdentifier;
    }

    public String visit(RecCreate recCreate) {

        String nodeIdentifier = this.nextState();

        String typeId = recCreate.typeId.accept(this);
        String fieldsId = recCreate.fields.accept(this);

        this.addNode(nodeIdentifier, "Record Creation");
        this.addTransition(nodeIdentifier, typeId);
        this.addTransition(nodeIdentifier, fieldsId);

        return nodeIdentifier;
    }

    public String visit(IntLiteral intLitteral) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, String.valueOf(intLitteral.value));

        return nodeIdentifier;
    }

    public String visit(StringLiteral stringLiteral) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, (stringLiteral.value).replaceAll("\"$|^\"", ""));

        return nodeIdentifier;
    }

    public String visit(NilLiteral nilLitteral) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "nil");

        return nodeIdentifier;
    }

    public String visit(BreakLiteral breakLitteral) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "break");

        return nodeIdentifier;
    }

}
