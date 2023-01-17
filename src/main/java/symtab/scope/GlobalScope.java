package symtab.scope;

import java.util.HashMap;
import java.util.Map;
import symtab.symbol.Symbol;

public class GlobalScope implements Scope {

    private final Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    private int maxDisplacement = 0;

    public String getScopeId() {
        String scopeId = "global";
        return scopeId;
    }

    public String getParentScope() {
        String parentScopeId = "predefined";
        return parentScopeId;
    }

    public int getImbricationLevel() {
        int imbricationLevel = 0;
        return imbricationLevel;
    }

    public Map<String, Symbol> getSymbols() {
        return this.symbols;
    }

    public Symbol getSymbol(String name) {
        return this.symbols.get(name);
    }

    public void addSymbol(String name, Symbol symbol) {
        this.symbols.put(name, symbol);
    }

    public int getMaxDisplacement() {
        return this.maxDisplacement;
    }

    public void addDisplacement(int displacement) {
        this.maxDisplacement += displacement;
    }
}
