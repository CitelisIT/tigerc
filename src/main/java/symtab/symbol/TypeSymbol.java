package symtab.symbol;

public class TypeSymbol implements Symbol {

    private String name;

    public TypeSymbol(String name) {
        this.name = name;
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
        return this.name;
    }

    public String getRootType() {
        return this.name;
    }
}
