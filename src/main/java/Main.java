import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import ast.Ast;
import ast.AstCreator;
import graphviz.GraphVizVisitor;
import parser.tigerLexer;
import parser.tigerParser;
import parser.tigerParser.ProgramContext;
import symtab.SymTabCreator;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Error : Expecting 'inFile' and 'mode' arguments.");
            System.exit(1);
        }

        String inFile = args[0];
        String mode = args[1];
        try {
            // chargement du fichier et construction du parser
            CharStream input = CharStreams.fromFileName(inFile);
            tigerLexer lexer = new tigerLexer(input);
            CommonTokenStream stream = new CommonTokenStream(lexer);
            tigerParser parser = new tigerParser(stream);

            // Récupération du noeud program (le noeud à la racine)
            ProgramContext program = parser.program();

            AstCreator astCreator = new AstCreator();
            Ast ast = program.accept(astCreator);

            SymTabCreator symTabCreator = new SymTabCreator();
            ast.accept(symTabCreator);

            switch (mode) {
                case "--parse-tree":
                    // code d'affichage de l'arbre syntaxique
                    JFrame frame = new JFrame("Antlr AST");
                    JPanel panel = new JPanel();
                    TreeViewer viewer =
                            new TreeViewer(Arrays.asList(parser.getRuleNames()), program);
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
                    ast.accept(graphViz);

                    graphViz.dumpGraph(outFile);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}
