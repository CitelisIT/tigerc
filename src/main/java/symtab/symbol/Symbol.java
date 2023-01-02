package symtab.symbol;

public interface Symbol {

    public SymbolCat getCategory();

    public int getDisplacement();

    public String getName();

}
