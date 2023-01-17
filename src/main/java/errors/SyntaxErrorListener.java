package errors;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {

    private final List<String> syntaxErrors = new ArrayList<String>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPositionInLine, String msg, RecognitionException e) {
        syntaxErrors.add(line + ":" + charPositionInLine + " : " + msg);
    }

    public List<String> getSyntaxErrors() {
        return this.syntaxErrors;
    }
}
