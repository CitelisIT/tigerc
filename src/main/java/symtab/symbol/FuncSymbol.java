package symtab.symbol;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol implements Symbol {

    private String type;
    private List<String> argTypes = new ArrayList<String>();
    private int displacement;

    public FuncSymbol(String type, List<String> argTypes) {
        this.type = type;
        this.argTypes = argTypes;
    }

    public SymbolCat getCategory() {
        return SymbolCat.FUNC;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getType() {
        return this.type;
    }

    public List<String> getArgTypes() {
        return this.argTypes;
    }
}
