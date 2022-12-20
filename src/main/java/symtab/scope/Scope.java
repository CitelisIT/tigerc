package symtab;

import java.util.Map;

public interface Scope {

    public String getScopeId();

    public String getParentScope();

    public int getImbricationLevel();

    public Map<String, Symbol> getSymbols();

    public void addSymbol(String name, Symbol symbol);

}
