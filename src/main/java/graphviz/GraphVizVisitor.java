package main.java.graphviz;

import java.io.FileOutputStream;
import java.io.IOException;
import main.java.ast.AstVisitor;

import main.java.ast.*;

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

    public String visit(Exp exp) {
        return "";
    }

    public String visit(OrExp orExp) {
        return "";
    }

    public String visit(AndExp andExp) {
        return "";
    }

    public String visit(EqExp eqExp) {
        return "";
    }

    public String visit(AddExp addExp) {
        return "";
    }

    public String visit(MultExp multExp) {
        return "";
    }

    public String visit(SimpleExp simpleExp) {
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

    public String visit(WhileExp whileExp) {
        return "";
    }

    public String visit(ForExp forExp) {
        return "";
    }

    public String visit(LetExp letExp) {
        return "";
    }

    public String visit(FieldCreate fieldCreate) {
        return "";
    }

    public String visit(Dec dec) {
        return "";
    }

    public String visit(TypeDec typeDec) {
        return "";
    }

    public String visit(VarDec varDec) {
        return "";
    }

    public String visit(VarDecFact varDecFact) {
        return "";
    }

    public String visit(FunDec funDec) {
        return "";
    }

    public String visit(EndDec endDec) {
        return "";
    }

    public String visit(Type type) {
        return "";
    }

    public String visit(ArrType arrType) {
        return "";
    }

    public String visit(RecType recType) {
        return "";
    }

    public String visit(IntLitteral intLitteral) {
        return "";
    }

    public String visit(StringLitteral stringLitteral) {
        return "";
    }

    public String visit(NilLitteral nilLitteral) {
        return "";
    }

    public String visit(BreakLitteral breakLitteral) {
        return "";
    }

}
