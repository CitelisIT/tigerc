import java.io.IOException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.RecognitionException;
import ast.Ast;
import errors.TigerChecker;
import graphviz.GraphVizVisitor;
import symtab.SymTabPrinter;
import symtab.scope.Scope;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Error : Expecting 'inFile' and 'mode' arguments.");
            System.exit(1);
        }

        String inFile = args[0];
        String mode = args[1];
        try {

            TigerChecker programChecker = new TigerChecker(inFile);
            boolean hasErrors = programChecker.checkProgram();

            if (!hasErrors) {
                switch (mode) {
                    case "--parse-tree":
                        // code d'affichage de l'arbre syntaxique
                        JFrame frame = new JFrame("Antlr AST");
                        JPanel panel = new JPanel();
                        TreeViewer viewer = programChecker.getTreeViewer();
                        viewer.setScale(1);
                        panel.add(viewer);
                        frame.add(panel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;

                    case "--ast":
                        String outFile;
                        if (args.length < 3) {
                            System.out.println(
                                    "Error: '--ast' option expects a path for the output file.");
                            return;
                        } else {
                            outFile = args[2];
                        }
                        // Visiteur de représentation graphique + appel
                        GraphVizVisitor graphViz = new GraphVizVisitor();
                        Ast ast = programChecker.getAst();
                        ast.accept(graphViz);

                        graphViz.dumpGraph(outFile);
                        break;

                    case "--symtab":
                        Map<String, Scope> symtab = programChecker.getSymTab();
                        SymTabPrinter symTabPrinter = new SymTabPrinter(symtab);
                        symTabPrinter.print();
                        break;
                }
            } else {
                switch (mode) {
                    case "--check-syntax":
                        programChecker.reportSyntaxErrors();
                        break;
                    case "--check-semantic":
                        programChecker.reportSemanticErrors();
                        break;
                    default:
                        programChecker.reportAllErrors();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}
