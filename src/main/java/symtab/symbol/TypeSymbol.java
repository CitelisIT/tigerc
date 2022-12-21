package symtab.symbol;

public class TypeSymbol implements Symbol {

    public SymbolCat getCategory() {
        return SymbolCat.TYPE;
    }

    public int getDisplacement() {
        return 0;
    }
}
