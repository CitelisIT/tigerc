package symtab.symbol;

import java.util.ArrayList;

public class TypeSymbol implements Symbol {

    private final String name;
    private final String rootType;

    public TypeSymbol(String name, String rootType) {
        this.name = name;
        this.rootType = rootType;
    }

    public ArrayList<String> getSymtabLine() {
        ArrayList<String> line = new ArrayList<String>();
        line.add(getCategory().toString());
        line.add(getName());
        line.add(getPrintType());
        line.add("" + getDisplacement());
        return line;
    }

    public SymbolCat getCategory() {
        return SymbolCat.TYPE;
    }

    public int getDisplacement() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.name + "_TYPE";
    }

    public String getRootType() {
        return this.rootType;
    }
}
