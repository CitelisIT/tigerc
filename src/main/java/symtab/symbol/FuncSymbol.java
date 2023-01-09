package symtab.symbol;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol implements Symbol {

    private String type;
    private String rootType;
    private String name;
    private List<String> argTypes = new ArrayList<String>();
    private int displacement;

    public FuncSymbol(String type, String rootType, List<String> argTypes, String name) {
        this.name = name;
        this.type = type;
        this.rootType = rootType;
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

    public String getName() {
        return this.name;
    }

    public String getRootType() {
        return this.rootType;
    }
}
