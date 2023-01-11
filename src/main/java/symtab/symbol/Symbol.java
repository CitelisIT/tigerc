package symtab.symbol;

import java.util.ArrayList;

public interface Symbol {

    public SymbolCat getCategory();

    public int getDisplacement();

    public String getName();

    public String getType();

    public String getRootType();

    public ArrayList<String> getSymtabLine();

}
