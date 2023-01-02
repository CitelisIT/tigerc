package symtab.symbol;

public class ArrayTypeSymbol extends TypeSymbol {

    private String type;
    private String name;

    public ArrayTypeSymbol(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }
}
