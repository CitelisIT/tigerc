package symtab;

import ast.AstVisitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ast.*;
import symtab.symbol.ArrayTypeSymbol;
import symtab.symbol.FuncSymbol;
import symtab.symbol.RecordTypeSymbol;
import symtab.symbol.SimpleTypeSymbol;
import symtab.symbol.Symbol;
import symtab.symbol.VarSymbol;
import symtab.scope.Scope;
import symtab.scope.PredefinedScope;
import symtab.scope.GlobalScope;
import symtab.scope.LocalScope;

public class SymTabCreator implements AstVisitor<String> {

    private Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();
    private String currentScopeId;
    private boolean insideLoop = false;
    private Map<String, String> typeAliases = new HashMap<String, String>();
    private List<Integer> scopesByDepth = new ArrayList<Integer>();

    private List<String> semanticErrors = new ArrayList<String>();

    public SymTabCreator() {
        this.symtab.put("predefined", new PredefinedScope());
        this.symtab.put("global", new GlobalScope());
        this.currentScopeId = "global";

        this.typeAliases.put("int", null);
        this.typeAliases.put("string", null);
        this.typeAliases.put("void", null);
    }

    public Map<String, Scope> getSymTab() {
        return this.symtab;
    }

    private void addSymbol(String name, Symbol symbol) {
        Scope scope = this.symtab.get(this.currentScopeId);
        scope.addSymbol(name, symbol);
    }

    private Symbol lookup(String name) {
        Scope scope = this.symtab.get(this.currentScopeId);
        while (scope != null) {
            Symbol symbol = scope.getSymbol(name);
            if (symbol != null) {
                return symbol;
            }
            scope = this.symtab.get(scope.getParentScope());
        }
        return null;
    }

    private int getImbricationLevel() {
        return this.symtab.get(this.currentScopeId).getImbricationLevel();
    }

    private void openScope() {
        String base = this.currentScopeId;
        if (base == "global") {
            base = "local";
        }
        int currentDepth = this.getImbricationLevel();
        if (this.scopesByDepth.size() <= currentDepth) {
            this.scopesByDepth.add(0);
        } else {
            this.scopesByDepth.set(currentDepth, this.scopesByDepth.get(currentDepth) + 1);
        }
        String newScopeId = base + "_" + this.scopesByDepth.get(currentDepth);
        Scope scope =
                new LocalScope(newScopeId, this.currentScopeId, this.getImbricationLevel() + 1);
        this.symtab.put(newScopeId, scope);
        this.currentScopeId = newScopeId;
    }

    private void closeScope() {
        this.currentScopeId = this.symtab.get(this.currentScopeId).getParentScope();
    }

    private String resolveTypeAlias(String type) {
        String resolvedType = type;
        while (this.typeAliases.get(resolvedType) != null) {
            resolvedType = this.typeAliases.get(resolvedType);
        }
        return resolvedType;
    }

    public String visit(Program program) {
        program.exp.accept(this);
        return null;
    }

    public String visit(Assign assign) {
        assign.expr.accept(this);
        assign.lValue.accept(this);
        return "void";
    }

    public String visit(Or or) {
        or.left.accept(this);
        or.right.accept(this);
        return "int";
    }

    public String visit(And and) {
        and.left.accept(this);
        and.right.accept(this);
        return "int";
    }

    public String visit(Eq eq) {
        eq.left.accept(this);
        eq.right.accept(this);
        return "void";
    }

    public String visit(NotEq notEq) {
        notEq.left.accept(this);
        notEq.right.accept(this);
        return "int";
    }

    public String visit(InfEq infEq) {
        infEq.left.accept(this);
        infEq.right.accept(this);
        return "int";
    }

    public String visit(Inf inf) {
        inf.left.accept(this);
        inf.right.accept(this);
        return "int";
    }

    public String visit(SupEq supEq) {
        supEq.left.accept(this);
        supEq.left.accept(this);
        return "int";
    }

    public String visit(Sup sup) {
        sup.left.accept(this);
        sup.right.accept(this);
        return "int";
    }

    public String visit(Add add) {
        add.left.accept(this);
        add.right.accept(this);
        return "int";
    }

    public String visit(Sub sub) {
        sub.left.accept(this);
        sub.right.accept(this);
        return "int";
    }

    public String visit(Mult mult) {
        mult.left.accept(this);
        mult.right.accept(this);
        return "int";
    }

    public String visit(Div div) {
        div.left.accept(this);
        div.right.accept(this);
        return "int";
    }

    public String visit(SeqExp seqExp) {
        String type = "void";
        for (Ast exp : seqExp.exprs) {
            type = exp.accept(this);
        }
        return this.resolveTypeAlias(type);
    }

    public String visit(Neg neg) {
        neg.expr.accept(this);
        return "int";
    }

    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        String thenType = ifThenElse.thenExpr.accept(this);
        if (ifThenElse.elseExpr == null) {
            return "void";
        } else {
            String elseType = ifThenElse.elseExpr.accept(this);
            return this.resolveTypeAlias(thenType);
        }
    }

    public String visit(WhileExp whileExp) {
        this.insideLoop = true;
        whileExp.condition.accept(this);
        whileExp.doExpr.accept(this);
        this.insideLoop = false;
        return "void";
    }

    public String visit(ForExp forExp) {
        this.insideLoop = true;
        forExp.doExpr.accept(this);
        forExp.endValue.accept(this);
        forExp.startValue.accept(this);
        forExp.forId.accept(this);
        this.insideLoop = false;
        return "void";
    }

    public String visit(LetDecls letDecls) {
        for (Ast decl : letDecls.decls) {
            decl.accept(this);
        }
        return null;
    }

    public String visit(LetScope letScope) {
        String type = "void";
        for (Ast exp : letScope.exprs) {
            type = exp.accept(this);
        }
        return this.resolveTypeAlias(type);
    }

    public String visit(LetExp letExp) {
        this.openScope();
        letExp.letDecls.accept(this);
        String scopeExpType = letExp.letScope.accept(this);
        this.closeScope();
        return scopeExpType;
    }

    public String visit(CallExpArgs callExpArgs) {
        for (Ast arg : callExpArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public String visit(CallExp callExp) {
        callExp.id.accept(this);
        callExp.args.accept(this);
        String functionId = callExp.id.name;
        FuncSymbol funcSymbol = (FuncSymbol) this.lookup(functionId);
        String callType = funcSymbol.getType();
        return callType;
    }

    public String visit(FieldDec fieldDec) {
        // No type for declartations
        return null;
    }

    public String visit(TypeDec typeDec) {
        String typeName = typeDec.typeId.name;
        Type typeValue = typeDec.typeValue;

        if (typeValue instanceof TypeId) {
            TypeId typeIdValue = (TypeId) typeValue;
            this.addSymbol(typeName, new SimpleTypeSymbol(typeIdValue.name));
            this.typeAliases.put(typeName, typeIdValue.name);
        }
        if (typeValue instanceof ArrType) {
            ArrType arrTypeValue = (ArrType) typeValue;
            this.addSymbol(typeName, new ArrayTypeSymbol(arrTypeValue.name));
        }
        if (typeValue instanceof RecType) {

            RecType recTypeValue = (RecType) typeValue;
            Map<String, String> fields = new HashMap<String, String>();

            for (FieldDec field : recTypeValue.fields) {
                fields.put(field.id.name, field.typeId.name);
            }

            this.addSymbol(typeName, new RecordTypeSymbol(fields));

        }
        // No type for declartations
        return null;
    }

    public String visit(TypeDecs typeDecs) {
        for (Ast typdec : typeDecs.tydecs) {
            typdec.accept(this);
        }
        // No type for declartations
        return null;
    }

    public String visit(VarDecType varDecType) {
        this.addSymbol(varDecType.varId.name, new VarSymbol(varDecType.varTypeId.name));
        varDecType.varValue.accept(this);

        // No type for declartations
        return null;
    }

    public String visit(VarDecNoType varDecNoType) {
        String varType = varDecNoType.varValue.accept(this);
        this.addSymbol(varDecNoType.varId.name, new VarSymbol(varType));

        // No type for declartations
        return null;
    }

    public String visit(FunArgs funArgs) {
        for (Ast arg : funArgs.args) {
            arg.accept(this);
        }
        return null;
    }

    public String visit(FunDec funDec) {
        ArrayList<String> argTypes = new ArrayList<String>();
        for (FieldDec arg : funDec.args.args) {
            argTypes.add(arg.typeId.name);
        }
        this.addSymbol(funDec.id.name, new FuncSymbol(funDec.returnTypeId.name, argTypes));
        this.openScope();
        funDec.body.accept(this);
        this.closeScope();
        // No type for declartations
        return null;
    }

    public String visit(Id id) {
        Symbol symbol = this.lookup(id.name);
        if (symbol instanceof VarSymbol) {
            VarSymbol varSymbol = (VarSymbol) symbol;
            return this.resolveTypeAlias(varSymbol.getType());
        } else if (symbol instanceof FuncSymbol) {
            FuncSymbol funcSymbol = (FuncSymbol) symbol;
            return this.resolveTypeAlias(funcSymbol.getType());
        }
        return null;
    }

    public String visit(TypeId typeId) {
        // Type IDs themselves have no type
        return null;
    }

    public String visit(ArrType arrType) {
        // Type IDs themselves have no type
        return null;
    }

    public String visit(RecType recType) {
        // Type IDs themselves have no type
        return null;
    }

    public String visit(Subscript subscript) {
        String accessExprType = subscript.expr.accept(this);
        String arrayType = subscript.lValue.accept(this);
        String resolvedArrayType = this.resolveTypeAlias(arrayType);
        ArrayTypeSymbol arrayTypeSymbol = (ArrayTypeSymbol) this.lookup(resolvedArrayType);
        return this.resolveTypeAlias(arrayTypeSymbol.getType());
    }

    public String visit(FieldExp fieldExp) {
        String recordType = fieldExp.lValue.accept(this);
        String resolvedRecordType = this.resolveTypeAlias(recordType);
        RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) this.lookup(resolvedRecordType);
        return this.resolveTypeAlias(recordTypeSymbol.getFields().get(fieldExp.id.name));
    }

    public String visit(ArrCreate arrCreate) {
        String arrayType = arrCreate.typeId.name;
        String sizeExpType = arrCreate.index.accept(this);
        String initializerExpType = arrCreate.of.accept(this);
        return this.resolveTypeAlias(arrayType);
    }

    public String visit(FieldCreate fieldCreate) {
        return null;
    }

    public String visit(RecCreateFields recCreateFields) {
        return null;
    }

    public String visit(RecCreate recCreate) {
        Symbol recordType = this.lookup(recCreate.typeId.name);
        if (recordType == null) {
            this.semanticErrors.add("Record type " + recCreate.typeId.name + " not found");
        } else {
            RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) recordType;
            ArrayList<FieldCreate> fields = recCreate.fields.fields;
            for (FieldCreate field : fields) {
                Map<String, String> fieldsMap = recordTypeSymbol.getFields();
                if (!fieldsMap.containsKey(field.id.name)) {
                    this.semanticErrors.add("Field " + field.id.name + " not found in record type "
                            + recCreate.typeId.name);
                } else {
                    String fieldType = fieldsMap.get(field.id.name);
                    // Typechecker doit être appelé pour récupérer le type de field
                    // String declarationType = TypeChecker.getType(field.expr);
                    // if (!fieldType.equals(declarationType)) {
                    // System.err.println("Field " + field.id.name + " has type " + fieldType
                    // + " but is initialized with type " + declarationType);
                    // }
                    // Reste à ajouter le record dans la TDS

                }
            }
        }
        return null;
    }

    public String visit(IntLiteral intLiteral) {
        return "int";
    }

    public String visit(StringLiteral stringLiteral) {
        return "string";
    }

    public String visit(NilLiteral nilLiteral) {
        return null;
    }

    public String visit(BreakLiteral breakLiteral) {
        // Check if break is only used in a loop
        if (!this.insideLoop) {
            this.semanticErrors.add("Break statement used outside a loop");
        }
        return "void";
    }

    public List<String> getSemanticErrors() {
        return this.semanticErrors;
    }

}
