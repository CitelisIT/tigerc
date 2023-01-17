package errors;

public class SemanticError {
    private final int line;
    private final int column;
    private final String message;

    public SemanticError(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public void print() {
        System.err.println(line + ":" + column + " -> " + message);
    }
}
