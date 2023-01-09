package symtab.symbol;

public class TypeSymbol implements Symbol {

    private String name;
    private String rootType;

    public TypeSymbol(String name, String rootType) {
        this.name = name;
        this.rootType = rootType;
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
