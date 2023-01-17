package errors;

import java.util.Stack;

public class BreakChecker {
    private final Stack<Boolean> breakStack;

    public BreakChecker() {
        this.breakStack = new Stack<>();
        breakStack.push(false);
    }

    public void changeStatus(boolean status) {
        breakStack.push(status);
    }

    public void restoreStatus() {
        breakStack.pop();
    }

    public boolean getStatus() {
        return breakStack.peek();
    }
}
