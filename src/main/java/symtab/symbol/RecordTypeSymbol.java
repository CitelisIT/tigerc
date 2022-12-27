package symtab.symbol;

import java.util.Map;
import java.util.Set;

public class RecordTypeSymbol extends TypeSymbol {

    private Map<String, String> fields;

    public RecordTypeSymbol(Map<String, String> fields) {
        this.fields = fields;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public Set<String> getFieldNames() {
        return this.fields.keySet();
    }

    public boolean hasField(String name) {
        return this.fields.containsKey(name);
    }

    public String getFieldType(String name) {
        return this.fields.get(name);
    }
}
