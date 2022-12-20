package symtab;

public class ArrayTypeSymbol extends TypeSymbol {

    private String type;

    public ArrayTypeSymbol(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
