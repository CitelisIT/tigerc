package symtab.scope;

import java.util.HashMap;
import java.util.Map;
import symtab.symbol.Symbol;

public class GlobalScope implements Scope {

    private String scopeId = "global";
    private String parentScopeId = "predefined";
    private int imbricationLevel = 0;

    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    private int maxDisplacement = 0;

    public String getScopeId() {
        return this.scopeId;
    }

    public String getParentScope() {
        return this.parentScopeId;
    }

    public int getImbricationLevel() {
        return this.imbricationLevel;
    }

    public Map<String, Symbol> getSymbols() {
        return this.symbols;
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
