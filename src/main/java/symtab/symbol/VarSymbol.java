package symtab.symbol;

import java.util.ArrayList;

public class VarSymbol implements Symbol {

    private final String name;
    private final String type;
    private final String rootType;
    private int displacement;

    public VarSymbol(String type, String rootType, String name, int displacement) {
        this.type = type;
        this.rootType = rootType;
        this.name = name;
        this.displacement = displacement;
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
        return SymbolCat.VAR;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return name;
    }

    public String getRootType() {
        return this.rootType;
    }
}
