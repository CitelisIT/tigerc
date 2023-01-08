package symtab.symbol;

public class ArrayTypeSymbol extends TypeSymbol {

    private String type;

    public ArrayTypeSymbol(String type, String name) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return super.getName();
    }
}
