package errors;

import java.util.Stack;

public class BreakChecker {
    private final Stack<Boolean> breakStack;

    public BreakChecker() {
        Stack<Boolean> stack = new Stack<>();
        this.breakStack = stack;
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
