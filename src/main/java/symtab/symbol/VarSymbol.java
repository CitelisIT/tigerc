package symtab.symbol;

public class VarSymbol implements Symbol {

    private String type;
    private int displacement;

    public VarSymbol(String type) {
        this.type = type;
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

}
