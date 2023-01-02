package symtab.symbol;

public class TypeSymbol implements Symbol {

    String name;

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
        return name;
    }
}
