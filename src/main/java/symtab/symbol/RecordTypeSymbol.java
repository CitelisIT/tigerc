package symtab.symbol;

import java.util.Map;
import java.util.Set;

public class RecordTypeSymbol extends TypeSymbol {

    private Map<String, Symbol> fields;

    public RecordTypeSymbol(Map<String, Symbol> fields) {
        this.fields = fields;
    }

    public Map<String, Symbol> getFields() {
        return fields;
    }

    public Set<String> getFieldNames() {
        return this.fields.keySet();
    }

    public boolean hasField(String name) {
        return this.fields.containsKey(name);
    }
}
