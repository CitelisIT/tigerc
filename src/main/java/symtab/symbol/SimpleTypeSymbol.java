package symtab.symbol;

public class SimpleTypeSymbol extends TypeSymbol {

    private String name;
    private String aliasedType;

    public SimpleTypeSymbol(String aliasedType, String name) {
        this.aliasedType = aliasedType;
        this.name = name;
    }

    public String getAliasedType() {
        return aliasedType;
    }

    public String getName() {
        return name;
    }
}
