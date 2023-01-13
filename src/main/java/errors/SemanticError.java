package errors;

public class SemanticError {
    private int line;
    private int column;
    private String message;

    public SemanticError(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public void print() {
        System.err.println(line + ":" + column + " -> " + message);
    }
}
