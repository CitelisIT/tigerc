package graphviz;

import java.io.FileOutputStream;
import java.io.IOException;
import ast.AstVisitor;

import ast.*;

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
        return "";
    }

    public String visit(Assign assign) {
        return "";
    }

    public String visit(Or or) {
        return "";
    }

    public String visit(And and) {
        return "";
    }

    public String visit(Eq eq) {
        return "";
    }

    public String visit(NotEq notEq) {
        return "";
    }

    public String visit(InfEq infEq) {
        return "";
    }

    public String visit(Inf inf) {
        return "";
    }

    public String visit(SupEq supEq) {
        return "";
    }

    public String visit(Sup sup) {
        return "";
    }

    public String visit(Add add) {
        return "";
    }

    public String visit(Sub sub) {
        return "";
    }

    public String visit(Mult mult) {
        return "";
    }

    public String visit(Div div) {
        return "";
    }

    public String visit(IdExp idExp) {
        return "";
    }

    public String visit(SeqExp seqExp) {
        return "";
    }

    public String visit(Neg neg) {
        return "";
    }

    public String visit(IfThen ifThen) {
        return "";
    }

    public String visit(IfThenElse ifThenElse) {
        return "";
    }

    public String visit(WhileExp whileExp) {
        return "";
    }

    public String visit(ForExp forExp) {
        return "";
    }

    public String visit(LetDecls letDecls) {
        return "";
    }

    public String visit(LetScope letScope) {
        return "";
    }

    public String visit(LetExp letExp) {
        return "";
    }

    public String visit(CallExpArgs callExpArgs) {
        return "";
    }

    public String visit(CallExp callExp) {
        return "";
    }

    public String visit(FieldDec fieldDec) {
        return "";
    }

    public String visit(TypeDec typeDec) {
        return "";
    }

    public String visit(VarDecType varDecType) {
        return "";
    }

    public String visit(VarDecNoType varDecNoType) {
        return "";
    }

    public String visit(FunArgs funArgs) {
        return "";
    }

    public String visit(FunDec funDec) {
        return "";
    }

    public String visit(Id id) {
        return "";
    }

    public String visit(TypeId typeId) {
        return "";
    }

    public String visit(ArrType arrType) {
        return "";
    }

    public String visit(RecType recType) {
        return "";
    }

    public String visit(Subscript subscript) {
        return "";
    }

    public String visit(FieldExp fieldExp) {
        return "";
    }

    public String visit(ArrCreate arrCreate) {
        return "";
    }

    public String visit(FieldCreate fieldCreate) {
        return "";
    }

    public String visit(RecCreateFields recCreateFields) {
        return "";
    }

    public String visit(RecCreate recCreate) {
        return "";
    }

    public String visit(IntLiteral intLitteral) {
        return "";
    }

    public String visit(StringLiteral stringLiteral) {
        return "";
    }

    public String visit(NilLiteral nilLitteral) {
        return "";
    }

    public String visit(BreakLiteral breakLitteral) {
        return "";
    }

}
