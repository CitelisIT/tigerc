package symtab.symbol;

import java.util.ArrayList;

public class SimpleTypeSymbol extends TypeSymbol {

    private final String aliasedType;

    public SimpleTypeSymbol(String aliasedType, String rootType, String name) {
        super(name, rootType);
        this.aliasedType = aliasedType;
    }

    public ArrayList<String> getSymtabLine() {
        ArrayList<String> line = new ArrayList<String>();
        line.add(getCategory().toString());
        line.add(getName());
        line.add(getAliasedType() + " (@" + getRootType() + ")");
        line.add("" + getDisplacement());
        return line;
    }

    public String getAliasedType() {
        return aliasedType;
    }

    public String getName() {
        return super.getName();
    }
}
