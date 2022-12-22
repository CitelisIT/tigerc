package symtab.scope;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import symtab.symbol.Symbol;
import symtab.symbol.FuncSymbol;
import symtab.symbol.TypeSymbol;

public class PredefinedScope implements Scope {

    private String scopeId = "predefined";
    private String parentScopeId = "";
    private int imbricationLevel = -1;

    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

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

    public PredefinedScope() {
        // Predefined types
        this.addSymbol("int", new TypeSymbol());
        this.addSymbol("string", new TypeSymbol());
        this.addSymbol("void", new TypeSymbol());

        // Predefined functions
        this.addSymbol("print",
                new FuncSymbol("void", new ArrayList<String>(Arrays.asList("string"))));
        this.addSymbol("printi",
                new FuncSymbol("void", new ArrayList<String>(Arrays.asList("int"))));
        this.addSymbol("flush", new FuncSymbol("void", new ArrayList<String>()));
        this.addSymbol("getchar", new FuncSymbol("string", new ArrayList<String>()));
        this.addSymbol("ord",
                new FuncSymbol("int", new ArrayList<String>(Arrays.asList("string"))));
        this.addSymbol("chr",
                new FuncSymbol("string", new ArrayList<String>(Arrays.asList("int"))));
        this.addSymbol("size",
                new FuncSymbol("int", new ArrayList<String>(Arrays.asList("string"))));
        this.addSymbol("substring", new FuncSymbol("string",
                new ArrayList<String>(Arrays.asList("string", "int", "int"))));
        this.addSymbol("concat",
                new FuncSymbol("string", new ArrayList<String>(Arrays.asList("string", "string"))));
        this.addSymbol("not", new FuncSymbol("int", new ArrayList<String>(Arrays.asList("int"))));
        this.addSymbol("exit", new FuncSymbol("void", new ArrayList<String>(Arrays.asList("int"))));
    }

}
