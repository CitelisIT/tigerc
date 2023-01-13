package errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {

    private ArrayList<SemanticError> ErrorList;

    public ErrorList() {
        ArrayList<SemanticError> ErrorList = new ArrayList<>();
        this.ErrorList = ErrorList;
    }

    public void add(SemanticError error) {
        ErrorList.add(error);
    }

    public void print() {
        for (SemanticError error : ErrorList) {
            error.print();
        }
    }

    public int size() {
        return ErrorList.size();
    }

    public boolean isEmpty() {
        return ErrorList.isEmpty();
    }

    public List<SemanticError> getErrorList() {
        return ErrorList;
    }
}
