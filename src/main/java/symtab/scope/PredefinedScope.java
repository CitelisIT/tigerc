package symtab.scope;

import java.util.*;

import symtab.symbol.Symbol;
import symtab.symbol.FuncSymbol;
import symtab.symbol.TypeSymbol;

public class PredefinedScope implements Scope {

        private final Map<String, Symbol> symbols = new HashMap<String, Symbol>();

        public String getScopeId() {
                return "predefined";
        }

        public String getParentScope() {
                return "";
        }

        public int getImbricationLevel() {
                return -1;
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
                this.addSymbol("int_TYPE", new TypeSymbol("int", "int_TYPE"));
                this.addSymbol("string_TYPE", new TypeSymbol("string", "string_TYPE"));
                this.addSymbol("void_TYPE", new TypeSymbol("void", "void_TYPE"));

                // Predefined functions
                this.addSymbol("print_VAR", new FuncSymbol("void_TYPE", "void_TYPE",
                                new ArrayList<String>(List.of("string_TYPE")), "print"));
                this.addSymbol("printi_VAR", new FuncSymbol("void_TYPE", "void_TYPE",
                                new ArrayList<String>(List.of("int_TYPE")), "printi"));
                this.addSymbol("flush_VAR", new FuncSymbol("void_TYPE", "void_TYPE",
                                new ArrayList<String>(), "flush"));
                this.addSymbol("getchar_VAR", new FuncSymbol("string_TYPE", "string_TYPE",
                                new ArrayList<String>(), "getchar"));
                this.addSymbol("ord_VAR", new FuncSymbol("int_TYPE", "int_TYPE",
                                new ArrayList<String>(List.of("string_TYPE")), "ord"));
                this.addSymbol("chr_VAR", new FuncSymbol("string_TYPE", "string_TYPE",
                                new ArrayList<String>(List.of("int_TYPE")), "chr"));
                this.addSymbol("size_VAR", new FuncSymbol("int_TYPE", "int_TYPE",
                                new ArrayList<String>(List.of("string_TYPE")), "size"));
                this.addSymbol("substring_VAR",
                                new FuncSymbol("string_TYPE", "string_TYPE",
                                                new ArrayList<String>(Arrays.asList("string_TYPE",
                                                                "int_TYPE", "int_TYPE")),
                                                "substring"));
                this.addSymbol("strcmp_VAR",
                                new FuncSymbol("int_TYPE", "int_TYPE", new ArrayList<String>(
                                                Arrays.asList("string_TYPE", "string_TYPE")),
                                                "strcmp"));
                this.addSymbol("concat_VAR",
                                new FuncSymbol("string_TYPE", "string_TYPE", new ArrayList<String>(
                                                Arrays.asList("string_TYPE", "string_TYPE")),
                                                "concat"));
                this.addSymbol("not_VAR", new FuncSymbol("int_TYPE", "int_TYPE",
                                new ArrayList<String>(List.of("int_TYPE")), "not"));
                this.addSymbol("exit_VAR", new FuncSymbol("void_TYPE", "void_TYPE",
                                new ArrayList<String>(List.of("int_TYPE")), "exit"));
                this.addSymbol("getrandom_VAR",
                                new FuncSymbol("int_TYPE", "int_TYPE", new ArrayList<String>(
                                                Arrays.asList("int_TYPE", "int_TYPE")),
                                                "getrandom"));
        }

}
