package errors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import symtab.scope.Scope;

public class TigerChecker {

    private final String file;
    private List<String> syntaxErrors = new ArrayList<String>();
    private ErrorList semanticErrors = new ErrorList();
    private tigerParser parser;
    private ProgramContext program;
    private Ast ast;
    private Map<String, Scope> symtab = new HashMap<String, Scope>();
    final ErrorReportingMode errorReportingMode;

    public TigerChecker(String file, ErrorReportingMode errorReportingMode) {
        this.file = file;
        this.errorReportingMode = errorReportingMode;
    }

    public boolean checkProgram() throws IOException {
        CharStream input = CharStreams.fromFileName(this.file);
        tigerLexer lexer = new tigerLexer(input);

        CommonTokenStream stream = new CommonTokenStream(lexer);
        this.parser = new tigerParser(stream);
        this.parser.removeErrorListeners();
        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
        this.parser.addErrorListener(syntaxErrorListener);
        this.syntaxErrors = syntaxErrorListener.getSyntaxErrors();

        this.program = this.parser.program();

        if (this.syntaxErrors.isEmpty() && this.errorReportingMode != ErrorReportingMode.SYNTAX) {

            AstCreator astCreator = new AstCreator();
            this.ast = this.program.accept(astCreator);

            SymTabCreator symTabCreator = new SymTabCreator();
            this.ast.accept(symTabCreator);
            this.semanticErrors = symTabCreator.getSemanticErrors();
            this.symtab = symTabCreator.getSymTab();

            if (this.semanticErrors.isEmpty()) return true;
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
        this.semanticErrors.print();
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

    public Map<String, Scope> getSymTab() {
        return this.symtab;
    }

    public boolean hasSyntaxErrors() {
        return !this.syntaxErrors.isEmpty();
    }

    public boolean hasSemanticErrors() {
        return this.semanticErrors.isEmpty();
    }

}
