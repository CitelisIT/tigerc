package symtab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ast.Add;
import ast.And;
import ast.ArrCreate;
import ast.ArrType;
import ast.Assign;
import ast.Ast;
import ast.AstVisitor;
import ast.BreakLiteral;
import ast.CallExp;
import ast.CallExpArgs;
import ast.Div;
import ast.Eq;
import ast.FieldCreate;
import ast.FieldDec;
import ast.FieldExp;
import ast.ForExp;
import ast.FunArgs;
import ast.FunDec;
import ast.Id;
import ast.IfThenElse;
import ast.Inf;
import ast.InfEq;
import ast.IntLiteral;
import ast.LetDecls;
import ast.LetExp;
import ast.LetScope;
import ast.Mult;
import ast.Neg;
import ast.NilLiteral;
import ast.NotEq;
import ast.Or;
import ast.Program;
import ast.RecCreate;
import ast.RecCreateFields;
import ast.RecType;
import ast.SeqExp;
import ast.StringLiteral;
import ast.Sub;
import ast.Subscript;
import ast.Sup;
import ast.SupEq;
import ast.Type;
import ast.TypeDec;
import ast.TypeDecs;
import ast.TypeId;
import ast.VarDecNoType;
import ast.VarDecType;
import ast.WhileExp;
import symtab.scope.GlobalScope;
import symtab.scope.LocalScope;
import symtab.scope.PredefinedScope;
import symtab.scope.Scope;
import symtab.symbol.ArrayTypeSymbol;
import symtab.symbol.FuncSymbol;
import symtab.symbol.RecordTypeSymbol;
import symtab.symbol.SimpleTypeSymbol;
import symtab.symbol.Symbol;
import symtab.symbol.SymbolCat;
import symtab.symbol.VarSymbol;

public class SymTabCreator implements AstVisitor<String> {

    private Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();
    private String currentScopeId;
    private int loopCounter = 0;
    private Map<String, String> typeAliases = new HashMap<String, String>();
    private List<Integer> scopesByDepth = new ArrayList<Integer>();
    private Set<Symbol> loopVariables = new HashSet<Symbol>();

    private List<String> semanticErrors = new ArrayList<String>();

    public SymTabCreator() {
        this.symtab.put("predefined", new PredefinedScope());
        this.symtab.put("global", new GlobalScope());
        this.currentScopeId = "global";

        this.typeAliases.put("int_TYPE", null);
        this.typeAliases.put("string_TYPE", null);
        this.typeAliases.put("void_TYPE", null);
    }

    public Map<String, Scope> getSymTab() {
        return this.symtab;
    }

    private void addSymbol(String name, Symbol symbol) {
        Scope scope = this.symtab.get(this.currentScopeId);
        scope.addSymbol(name, symbol);
    }

    private Symbol lookup(String name, String suffix) {
        Scope scope = this.symtab.get(this.currentScopeId);
        while (scope != null) {
            Symbol symbol = scope.getSymbol(name + "_" + suffix);
            if (symbol != null) {
                return symbol;
            }
            scope = this.symtab.get(scope.getParentScope());
        }
        return null;
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
        Scope scope = new LocalScope(newScopeId, this.currentScopeId, this.getImbricationLevel() + 1);
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
        String expType = assign.expr.accept(this);
        String lvalueType = assign.lValue.accept(this);

        if (assign.lValue instanceof Id) {
            Id id = (Id) assign.lValue;
            Symbol symbol = this.lookup(id.name, "VAR");
            if (symbol == null) {
                this.semanticErrors.add("Variable " + id.name + " is not defined");
            } else {
                if (symbol.getCategory() != SymbolCat.VAR) {
                    this.semanticErrors.add("Variable " + id.name + " cannot be assigned to");
                }
                if (this.loopVariables.contains(symbol)) {
                    this.semanticErrors.add("Variable " + id.name + " is a loop variable and cannot be assigned to");
                }
            }
        }

        if (!expType.equals(lvalueType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot assign " + expType + " to " + lvalueType);
        }

        return "void_TYPE";
    }

    public String visit(Or or) {
        or.left.accept(this);
        or.right.accept(this);
        return "int_TYPE";
    }

    public String visit(And and) {
        and.left.accept(this);
        and.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Eq eq) {
        eq.left.accept(this);
        eq.right.accept(this);
        return "int_TYPE";
    }

    public String visit(NotEq notEq) {
        notEq.left.accept(this);
        notEq.right.accept(this);
        return "int_TYPE";
    }

    public String visit(InfEq infEq) {
        infEq.left.accept(this);
        infEq.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Inf inf) {
        inf.left.accept(this);
        inf.right.accept(this);
        return "int_TYPE";
    }

    public String visit(SupEq supEq) {
        supEq.left.accept(this);
        supEq.left.accept(this);
        return "int_TYPE";
    }

    public String visit(Sup sup) {
        sup.left.accept(this);
        sup.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Add add) {
        add.left.accept(this);
        add.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Sub sub) {
        sub.left.accept(this);
        sub.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Mult mult) {
        mult.left.accept(this);
        mult.right.accept(this);
        return "int_TYPE";
    }

    public String visit(Div div) {
        div.left.accept(this);
        div.right.accept(this);
        return "int_TYPE";
    }

    public String visit(SeqExp seqExp) {
        String type = "void_TYPE";
        for (Ast exp : seqExp.exprs) {
            type = exp.accept(this);
        }
        return this.resolveTypeAlias(type);
    }

    public String visit(Neg neg) {
        neg.expr.accept(this);
        return "int_TYPE";
    }

    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        String thenType = ifThenElse.thenExpr.accept(this);
        if (!thenType.equals("void_TYPE")) {
            this.semanticErrors.add("Then branch is of type " + thenType + " but should be void");
        }
        if (ifThenElse.elseExpr == null) {
            return "void_TYPE";
        } else {
            String elseType = ifThenElse.elseExpr.accept(this);
            if (!elseType.equals("void_TYPE")) {
                this.semanticErrors
                        .add("Else branch is of type " + elseType + " but should be void");
            }
            return this.resolveTypeAlias(thenType);
        }
    }

    public String visit(WhileExp whileExp) {
        this.loopCounter++;
        String whileConditionType = whileExp.condition.accept(this);
        if (!whileConditionType.equals("int_TYPE")) {
            this.semanticErrors.add("While loop condition is of type " + whileConditionType
                    + " but should be of type int");
        }
        String whileBodyType = whileExp.doExpr.accept(this);
        if (!whileBodyType.equals("void_TYPE")) {
            this.semanticErrors.add(
                    "While loop body is of type " + whileBodyType + " but should be of type void");
        }
        this.loopCounter--;
        return "void_TYPE";
    }

    public String visit(ForExp forExp) {
        this.openScope();
        Symbol forIdSymbol = this.lookup(forExp.forId.name, "VAR");
        if (forIdSymbol == null) {
            forIdSymbol = new VarSymbol("int_TYPE", "int_TYPE", forExp.forId.name);
            this.addSymbol(forExp.forId.name + "_VAR", forIdSymbol);
        }
        this.loopVariables.add(forIdSymbol);
        this.loopCounter++;
        String forBodyType = forExp.doExpr.accept(this);
        if (!forBodyType.equals("void_TYPE")) {
            this.semanticErrors
                    .add("For loop body is of type " + forBodyType + " but should be of type void");
        }
        String forStartIndexType = forExp.startValue.accept(this);
        if (!forStartIndexType.equals("int_TYPE")) {
            this.semanticErrors.add("For loop start index is of type " + forStartIndexType
                    + " but should be of type int");
        }
        String forEndIndexType = forExp.endValue.accept(this);
        if (!forEndIndexType.equals("int_TYPE")) {
            this.semanticErrors.add("For loop end index is of type " + forEndIndexType
                    + " but should be of type int");
        }
        String forVarValueType = forExp.forId.accept(this);
        if (!forVarValueType.equals("int_TYPE")) {
            this.semanticErrors.add("For loop variable " + forExp.forId.name + " is of type "
                    + forVarValueType + " but should be of type int");
        }
        this.loopVariables.remove(forIdSymbol);
        this.loopCounter--;
        this.closeScope();
        return "void_TYPE";
    }

    public String visit(LetDecls letDecls) {
        for (Ast decl : letDecls.decls) {
            decl.accept(this);
        }
        return null;
    }

    public String visit(LetScope letScope) {
        String type = "void_TYPE";
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
        FuncSymbol funcSymbol = (FuncSymbol) this.lookup(functionId, "VAR");
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
            String rootType = this.resolveTypeAlias(typeIdValue.name + "_TYPE");
            this.addSymbol(typeName + "_TYPE",
                    new SimpleTypeSymbol(typeIdValue.name + "_TYPE", rootType, typeName));
            this.typeAliases.put(typeName + "_TYPE", typeIdValue.name + "_TYPE");
        }
        if (typeValue instanceof ArrType) {
            ArrType arrTypeValue = (ArrType) typeValue;
            this.addSymbol(typeName + "_TYPE", new ArrayTypeSymbol(arrTypeValue.name + "_TYPE",
                    arrTypeValue.name + "_TYPE", typeName));
        }
        if (typeValue instanceof RecType) {

            RecType recTypeValue = (RecType) typeValue;
            Map<String, String> fields = new HashMap<String, String>();

            for (FieldDec field : recTypeValue.fields) {
                fields.put(field.id.name, field.typeId.name + "_TYPE");
            }

            this.addSymbol(typeName + "_TYPE",
                    new RecordTypeSymbol(fields, typeName + "_TYPE", typeName));
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
        Symbol varDecTypeSymbol = this.lookup(varDecType.varTypeId.name, "TYPE");
        if (varDecTypeSymbol == null) {
            this.semanticErrors.add("Undeclared type : " + varDecType.varTypeId.name);
            String varType = varDecType.varValue.accept(this);
            this.addSymbol(varDecType.varId.name + "_VAR",
                    new VarSymbol(varType, varType, varDecType.varId.name));
        } else {
            String varDecRootType = varDecTypeSymbol.getRootType();
            this.addSymbol(varDecType.varId.name + "_VAR", new VarSymbol(
                    varDecType.varTypeId.name + "_TYPE", varDecRootType, varDecType.varId.name));
            String varType = varDecType.varValue.accept(this);
            if (!varType.equals(varDecRootType)) {
                this.semanticErrors.add("Incompatible declaration type : the variable "
                        + varDecType.varId.name + " must be a value of " + varDecType.varTypeId.name
                        + " type, not " + varType + " type");
            }
        }
        // No type for declartations
        return null;
    }

    public String visit(VarDecNoType varDecNoType) {
        String varType = varDecNoType.varValue.accept(this);
        String rootType = this.resolveTypeAlias(varType);
        this.addSymbol(varDecNoType.varId.name + "_VAR",
                new VarSymbol(varType, rootType, varDecNoType.varId.name));
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
        String rootFunctionType = this.resolveTypeAlias(funDec.returnTypeId.name + "_TYPE");
        this.addSymbol(funDec.id.name + "_VAR", new FuncSymbol(funDec.returnTypeId.name + "_TYPE",
                rootFunctionType, argTypes, funDec.id.name));
        this.openScope();
        for (FieldDec arg : funDec.args.args) {
            String argRootType = this.resolveTypeAlias(arg.typeId.name + "_TYPE");
            this.addSymbol(arg.id.name + "_VAR",
                    new VarSymbol(arg.typeId.name + "_TYPE", argRootType, arg.id.name));
        }

        // if ((this.lookup(funDec.returnTypeId.name) == null)
        // && this.typeAliases.containsKey(funDec.returnTypeId.name)) {
        // this.semanticErrors.add(funDec.returnTypeId.name + " type does'nt exist");
        // }

        String returnType = funDec.body.accept(this);

        if (!funDec.returnTypeId.name.equals(returnType)) {
            this.semanticErrors.add("Incompatible return type : the function " + funDec.id.name
                    + " must return value of " + funDec.returnTypeId.name + " type, not "
                    + returnType + " type");
        }
        // No type for declartations
        this.closeScope();
        return null;
    }

    public String visit(Id id) {
        Symbol symbol = this.lookup(id.name, "VAR");
        return symbol.getRootType();
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
        if (!accessExprType.equals("int_TYPE")) {
            this.semanticErrors.add("Subscript access to an array must be an integer");
        }
        String arrayType = subscript.lValue.accept(this);
        ArrayTypeSymbol arrayTypeSymbol = (ArrayTypeSymbol) this.lookup(arrayType);
        return arrayTypeSymbol.getRootType();
    }

    public String visit(FieldExp fieldExp) {
        String recordType = fieldExp.lValue.accept(this);
        RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) this.lookup(recordType);
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
        Symbol recordType = this.lookup(recCreate.typeId.name, "TYPE");
        if (recordType == null) {
            this.semanticErrors.add("Record type " + recCreate.typeId.name + " not found");
        } else {
            RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) this.lookup(recordType.getRootType());
            ArrayList<FieldCreate> fields = recCreate.fields.fields;
            for (FieldCreate field : fields) {
                Map<String, String> fieldsMap = recordTypeSymbol.getFields();
                if (!fieldsMap.containsKey(field.id.name)) {
                    this.semanticErrors.add("Field " + field.id.name + " not found in record type "
                            + recCreate.typeId.name);
                } else {
                    String fieldType = fieldsMap.get(field.id.name);
                    String declarationType = field.expr.accept(this);
                    if (!fieldType.equals(declarationType)) {
                        System.err.println("Field " + field.id.name + " has type " + fieldType
                                + " but is initialized with type " + declarationType);
                    }
                }
            }
            return recordTypeSymbol.getRootType();
        }
        return null;
    }

    public String visit(IntLiteral intLiteral) {
        return "int_TYPE";
    }

    public String visit(StringLiteral stringLiteral) {
        return "string_TYPE";
    }

    public String visit(NilLiteral nilLiteral) {
        return null;
    }

    public String visit(BreakLiteral breakLiteral) {
        // Check if break is only used in a loop
        if (this.loopCounter == 0) {
            this.semanticErrors.add("Break statement used outside a loop");
        }
        return "void_TYPE";
    }

    public List<String> getSemanticErrors() {
        return this.semanticErrors;
    }

}
