package symtab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import symtab.scope.Scope;

public class SymTabPrinter {
    private Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();

    public SymTabPrinter(Map<String, Scope> symtab) {
        this.symtab = symtab;
        this.print();
    }

    public void print() {
        ArrayList<Scope> scopes = new ArrayList<Scope>();
        for (String key : symtab.keySet()) {
            scopes.add(symtab.get(key));
        }
        scopes.sort(Comparator.comparing(Scope::getScopeId));

        // scopes.forEach(scope -> scope.print());
        scopes.forEach(scope -> new ScopePrinter(scope));

    }
}
