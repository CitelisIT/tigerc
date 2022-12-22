package symtab.scope;

import java.util.HashMap;
import java.util.Map;
import symtab.symbol.Symbol;

public class LocalScope implements Scope {

    private String scopeId;
    private String parentScopeId;
    private int imbricationLevel;

    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    private int maxDisplacement = 0;

    public LocalScope(String scopeId, String parentScopeId, int imbricationLevel) {
        this.scopeId = scopeId;
        this.parentScopeId = parentScopeId;
        this.imbricationLevel = imbricationLevel;
    }

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
