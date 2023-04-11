package ast;

import symtab.symbol.RecordTypeSymbol;

public class FieldExp implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public final Ast lValue;
    public final Id id;
    public final int lineNumber;
    public final int columnNumber;
    public RecordTypeSymbol recordType;

    public FieldExp(Ast lValue, Id id, int lineNumber, int columnNumber) {
        this.lValue = lValue;
        this.id = id;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public FieldExp(Ast lValue, Id id, int lineNumber, int columnNumber, RecordTypeSymbol recordType) {
        this.lValue = lValue;
        this.id = id;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.recordType = recordType;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }
}
