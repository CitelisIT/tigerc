package symtab.scope;

import java.util.ArrayList;
import java.util.Map;
import symtab.symbol.Symbol;

public interface Scope {

    String getScopeId();

    String getParentScope();

    int getImbricationLevel();

    Map<String, Symbol> getSymbols();

    Symbol getSymbol(String name);

    void addSymbol(String name, Symbol symbol);

}
