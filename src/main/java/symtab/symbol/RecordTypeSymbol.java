package symtab.symbol;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class RecordTypeSymbol extends TypeSymbol {

    private final Map<String, String> fields;
    // private String name;

    public RecordTypeSymbol(Map<String, String> fields, String rootType, String name) {
        super(name, rootType);
        this.fields = fields;
    }

    public ArrayList<String> getSymtabLine() {
        ArrayList<String> line = new ArrayList<String>();
        line.add(getCategory().toString());
        line.add(getName());
        StringBuilder fieldsTypeString = new StringBuilder("{");
        for (String key : getFields().keySet()) {
            fieldsTypeString.append(" ").append(key).append(" : ").append(getFieldType(key)).append(";");
        }
        fieldsTypeString = new StringBuilder(fieldsTypeString.substring(0, fieldsTypeString.length() - 1) + "}");
        line.add(fieldsTypeString.toString());
        line.add("" + getDisplacement());
        return line;
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
