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
        this.addSymbol("int_TYPE", new TypeSymbol("int"));
        this.addSymbol("string_TYPE", new TypeSymbol("string"));
        this.addSymbol("void_TYPE", new TypeSymbol("void"));

        // Predefined functions
        this.addSymbol("print_VAR",
                new FuncSymbol("void", new ArrayList<String>(Arrays.asList("string")), "print"));
        this.addSymbol("printi_VAR",
                new FuncSymbol("void", new ArrayList<String>(Arrays.asList("int")), "printi"));
        this.addSymbol("flush_VAR", new FuncSymbol("void", new ArrayList<String>(), "flush"));
        this.addSymbol("getchar_VAR", new FuncSymbol("string", new ArrayList<String>(), "getchar"));
        this.addSymbol("ord_VAR",
                new FuncSymbol("int", new ArrayList<String>(Arrays.asList("string")), "ord"));
        this.addSymbol("chr_VAR",
                new FuncSymbol("string", new ArrayList<String>(Arrays.asList("int")), "chr"));
        this.addSymbol("size_VAR",
                new FuncSymbol("int", new ArrayList<String>(Arrays.asList("string")), "size"));
        this.addSymbol("substring_VAR", new FuncSymbol("string",
                new ArrayList<String>(Arrays.asList("string", "int", "int")), "substring"));
        this.addSymbol("concat_VAR", new FuncSymbol("string",
                new ArrayList<String>(Arrays.asList("string", "string")), "concat"));
        this.addSymbol("not_VAR",
                new FuncSymbol("int", new ArrayList<String>(Arrays.asList("int")), "not"));
        this.addSymbol("exit_VAR",
                new FuncSymbol("void", new ArrayList<String>(Arrays.asList("int")), "exit"));
    }

}
