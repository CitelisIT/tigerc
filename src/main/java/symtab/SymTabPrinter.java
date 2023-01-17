package symtab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

import symtab.scope.Scope;

public class SymTabPrinter {
    private Map<String, Scope> symtab;

    public SymTabPrinter(Map<String, Scope> symtab) {
        this.symtab = symtab;
    }

    public void print() {
        ArrayList<Scope> scopes = new ArrayList<Scope>();

        for (String key : symtab.keySet()) {
            if (!Objects.equals(key, "predefined")) {
                scopes.add(symtab.get(key));
            }
        }
        scopes.sort(Comparator.comparing(Scope::getScopeId));
        scopes.add(0, symtab.get("predefined"));
        // scopes.forEach(scope -> scope.print());
        scopes.forEach(scope -> new ScopePrinter(scope));

    }
}
