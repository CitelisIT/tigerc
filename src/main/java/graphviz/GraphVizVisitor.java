package main.java.graphviz;

import java.io.FileOutputStream;
import java.io.IOException;
import main.java.ast.AstVisitor;

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

}
