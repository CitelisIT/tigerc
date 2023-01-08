package symtab.symbol;

public class VarSymbol implements Symbol {

    private String name;
    private String type;
    private String rootType;
    private int displacement;

    public VarSymbol(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public SymbolCat getCategory() {
        return SymbolCat.FUNC;
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
