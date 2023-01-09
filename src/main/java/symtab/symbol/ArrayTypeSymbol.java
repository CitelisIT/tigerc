package symtab.symbol;

public class ArrayTypeSymbol extends TypeSymbol {

    private String type;

    public ArrayTypeSymbol(String elementType, String rootType, String name) {
        super(name, rootType);
        this.type = elementType;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return super.getName();
    }
}
