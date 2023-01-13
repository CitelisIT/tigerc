package errors;

import java.util.Stack;

public class ErrorStack {

    private Stack<SemanticError> errorStack;

    public ErrorStack() {
        Stack<SemanticError> errorStack = new Stack<SemanticError>();
        this.errorStack = errorStack;
    }

    public void add(SemanticError error) {
        errorStack.push(error);
    }

    public void print() {
        while (!errorStack.empty()) {
            errorStack.pop().print();
        }
    }
}
