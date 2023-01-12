package errors;

import java.util.Stack;

public class BreakChecker {
    private Stack<Boolean> breakStack;

    public BreakChecker() {
        Stack<Boolean> stack = new Stack<Boolean>();
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
