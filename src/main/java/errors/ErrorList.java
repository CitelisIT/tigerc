package errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {

    private final ArrayList<SemanticError> errorList;

    public ErrorList() {
        errorList = new ArrayList<>();
    }

    public void add(SemanticError error) {
        errorList.add(error);
    }

    public void print() {
        for (SemanticError error : errorList) {
            error.print();
        }
    }

    public int size() {
        return errorList.size();
    }

    public boolean isEmpty() {
        return errorList.isEmpty();
    }

    public List<SemanticError> getErrorList() {
        return errorList;
    }
}
