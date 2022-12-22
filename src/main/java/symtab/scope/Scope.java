package symtab.scope;

import java.util.Map;
import symtab.symbol.Symbol;

public interface Scope {

    public String getScopeId();

    public String getParentScope();

    public int getImbricationLevel();

    public Map<String, Symbol> getSymbols();

    public Symbol getSymbol(String name);

    public void addSymbol(String name, Symbol symbol);

}
