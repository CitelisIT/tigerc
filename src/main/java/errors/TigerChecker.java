package errors;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ast.Ast;
import ast.AstCreator;
import parser.tigerLexer;
import parser.tigerParser;
import parser.tigerParser.ProgramContext;
import symtab.SymTabCreator;

public class TigerChecker {

    private String file;
    private List<String> syntaxErrors;
    private List<String> semanticErrors;
    tigerLexer lexer;
    tigerParser parser;
    ProgramContext program;
    public Ast ast;

    public TigerChecker(String file) {
        this.file = file;
    }

    public boolean checkProgram() throws IOException {
        CharStream input = CharStreams.fromFileName(this.file);
        this.lexer = new tigerLexer(input);

        CommonTokenStream stream = new CommonTokenStream(lexer);
        this.parser = new tigerParser(stream);
        this.parser.removeErrorListeners();
        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
        this.parser.addErrorListener(syntaxErrorListener);
        this.syntaxErrors = syntaxErrorListener.getSyntaxErrors();

        this.program = this.parser.program();

        if (this.syntaxErrors.size() == 0) {

            AstCreator astCreator = new AstCreator();
            this.ast = this.program.accept(astCreator);

            SymTabCreator symTabCreator = new SymTabCreator();
            this.ast.accept(symTabCreator);
            this.semanticErrors = symTabCreator.getSemanticErrors();

            if (this.semanticErrors.size() != 0) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    public void reportSyntaxErrors() {
        for (String error : this.syntaxErrors) {
            System.err.println(error);
        }
    }

    public void reportSemanticErrors() {
        for (String error : this.semanticErrors) {
            System.err.println(error);
        }
    }

    public void reportAllErrors() {
        if (this.syntaxErrors != null) {
            this.reportSyntaxErrors();
        }
        if (this.semanticErrors != null) {
            this.reportSemanticErrors();
        }
    }

    public TreeViewer getTreeViewer() {
        return new TreeViewer(Arrays.asList(this.parser.getRuleNames()), this.program);
    }

    public Ast getAst() {
        return this.ast;
    }

}
