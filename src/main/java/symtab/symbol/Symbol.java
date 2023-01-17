package symtab.symbol;

import java.util.ArrayList;

public interface Symbol {

    SymbolCat getCategory();

    int getDisplacement();

    String getName();

    String getType();

    String getRootType();

    ArrayList<String> getSymtabLine();

    default String getPrintType() {
        return this.getType().equals(this.getRootType()) ? getType()
                : getType() + " (@" + getRootType() + ")";
    }

}
