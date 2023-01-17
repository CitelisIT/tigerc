package symtab.symbol;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol implements Symbol {

    private final String type;
    private final String rootType;
    private final String name;
    private List<String> argTypes = new ArrayList<String>();
    private int displacement;

    public FuncSymbol(String type, String rootType, List<String> argTypes, String name) {
        this.name = name;
        this.type = type;
        this.rootType = rootType;
        this.argTypes = argTypes;
    }

    public ArrayList<String> getSymtabLine() {
        ArrayList<String> line = new ArrayList<String>();
        line.add(getCategory().toString());
        line.add(getName());
        StringBuilder argsTypeString = new StringBuilder("( ");
        for (String typeString : argTypes) {
            argsTypeString.append(typeString).append(",");
        }
        argsTypeString = new StringBuilder(argsTypeString.substring(0, argsTypeString.length() - 1) + " ) -> "
                + getPrintType());
        line.add(argsTypeString.toString());
        line.add("" + getDisplacement());
        return line;
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
