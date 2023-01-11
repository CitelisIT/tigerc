package symtab.symbol;

import java.util.ArrayList;

public class ArrayTypeSymbol extends TypeSymbol {

    private String type;

    public ArrayTypeSymbol(String elementType, String rootType, String name) {
        super(name, rootType);
        this.type = elementType;
    }

    public ArrayList<String> getSymtabLine() {
        ArrayList<String> line = new ArrayList<String>();
        line.add(getCategory().toString());
        line.add(getName());
        line.add("Array of " + getPrintType());
        line.add("" + getDisplacement());
        return line;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return super.getName();
    }
}
