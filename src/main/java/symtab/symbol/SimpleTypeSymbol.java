package symtab.symbol;

public class SimpleTypeSymbol extends TypeSymbol {

    private String aliasedType;

    public SimpleTypeSymbol(String aliasedType, String rootType, String name) {
        super(name, rootType);
        this.aliasedType = aliasedType;
    }

    public String getAliasedType() {
        return aliasedType;
    }

    public String getName() {
        return super.getName();
    }
}
