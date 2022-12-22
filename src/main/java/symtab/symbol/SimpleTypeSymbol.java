package symtab.symbol;

public class SimpleTypeSymbol extends TypeSymbol {

    private String aliasedType;

    public SimpleTypeSymbol(String aliasedType) {
        this.aliasedType = aliasedType;
    }

    public String getAliasedType() {
        return aliasedType;
    }
}
