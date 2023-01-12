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
import errors.BreakChecker;
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
    private BreakChecker breakStack = new BreakChecker();
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
        breakStack.changeStatus(false);
        String expType = assign.expr.accept(this);
        String lvalueType = assign.lValue.accept(this);
        breakStack.restoreStatus();
        if (lvalueType == null) {
            return "void_TYPE";
        }

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
                    this.semanticErrors.add("Variable " + id.name
                            + " is a loop variable and cannot be assigned to");
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
        String leftType = or.left.accept(this);
        String rightType = or.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator | to left operand: is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator | to right operand: is of type "
                            + rightType + " instead of type INT");
        }
        return "int_TYPE";
    }

    public String visit(And and) {
        String leftType = and.left.accept(this);
        String rightType = and.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator & to left operand: is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator & to right operand: is of type "
                            + rightType + " instead of type INT");
        }
        return "int_TYPE";
    }

    public String visit(Eq eq) {
        String leftType = eq.left.accept(this);
        String rightType = eq.right.accept(this);
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator = to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(NotEq notEq) {
        String leftType = notEq.left.accept(this);
        String rightType = notEq.right.accept(this);
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator <> to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(InfEq infEq) {
        String leftType = infEq.left.accept(this);
        String rightType = infEq.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator <= to left operand of type "
                            + leftType + " instead of type INT or STRING");
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator <= to right operand of type  "
                            + rightType + " instead of type INT or STRING");
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator <= to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Inf inf) {
        String leftType = inf.left.accept(this);
        String rightType = inf.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator < to operands of type  " + leftType);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            this.semanticErrors.add(
                    "Type mismatch: cannot apply operator < to operands of type  " + rightType);
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator < to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(SupEq supEq) {
        String leftType = supEq.left.accept(this);
        String rightType = supEq.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            this.semanticErrors.add(
                    "Type mismatch: cannot apply operator >= to operands of type  " + leftType);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            this.semanticErrors.add(
                    "Type mismatch: cannot apply operator >= to operands of type  " + rightType);
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator >= to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Sup sup) {
        String leftType = sup.left.accept(this);
        String rightType = sup.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator > to operands of type  " + leftType);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            this.semanticErrors.add(
                    "Type mismatch: cannot apply operator > to operands of type  " + rightType);
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator > to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Add add) {
        String leftType = add.left.accept(this);
        String rightType = add.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator + to left operand : is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator + to right operand : is of type "
                            + rightType + " instead of type INT");
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator + to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Sub sub) {
        String leftType = sub.left.accept(this);
        String rightType = sub.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator - to left operand : is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator - to right operand : is of type "
                            + rightType + " instead of type INT");
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator - to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Mult mult) {
        String leftType = mult.left.accept(this);
        String rightType = mult.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator * to left operand : is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator * to right operand : is of type "
                            + rightType + " instead of type INT");
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator * to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(Div div) {
        String leftType = div.left.accept(this);
        String rightType = div.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator / to left operand : is of type "
                            + leftType + " instead of type INT");
        }
        if (!rightType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator / to right operand : is of type "
                            + rightType + " instead of type INT");
        }
        if (!leftType.equals(rightType)) {
            this.semanticErrors
                    .add("Type mismatch: cannot apply operator / to operands of different types  "
                            + leftType + " and " + rightType);
        }
        return "int_TYPE";
    }

    public String visit(SeqExp seqExp) {
        String type = "void_TYPE";
        for (Ast exp : seqExp.exprs) {
            type = exp.accept(this);
        }
        return type;
    }

    public String visit(Neg neg) {
        String negExprType = neg.expr.accept(this);
        if (!negExprType.equals("int_TYPE")) {
            this.semanticErrors.add("Type mismatch: cannot apply operator - to operand of type "
                    + negExprType + " instead of type INT");
        }
        return "int_TYPE";
    }

    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        String thenType = ifThenElse.thenExpr.accept(this);
        if (ifThenElse.elseExpr != null) {
            String elseType = ifThenElse.elseExpr.accept(this);
            if (!thenType.equals(elseType)) {
                this.semanticErrors.add("Type mismatch: then branch is of type " + thenType
                        + " but else branch is of type " + elseType);
                return "void_TYPE";
            }
            return thenType;
        } else {
            if (!thenType.equals("void_TYPE")) {
                this.semanticErrors.add(
                        "Conditional without else branch should be of type void but is of type "
                                + thenType);
            }
        }
        return "void_TYPE";
    }

    public String visit(WhileExp whileExp) {
        String whileConditionType = whileExp.condition.accept(this);
        if (!whileConditionType.equals("int_TYPE")) {
            this.semanticErrors.add("While loop condition is of type " + whileConditionType
                    + " but should be of type int");
        }
        breakStack.changeStatus(true);
        String whileBodyType = whileExp.doExpr.accept(this);
        breakStack.restoreStatus();
        if (!whileBodyType.equals("void_TYPE")) {
            this.semanticErrors.add(
                    "While loop body is of type " + whileBodyType + " but should be of type void");
        }
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
        breakStack.changeStatus(true);
        String forBodyType = forExp.doExpr.accept(this);
        breakStack.restoreStatus();
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
        this.closeScope();
        return "void_TYPE";
    }

    public String visit(LetDecls letDecls) {
        breakStack.changeStatus(false);
        for (Ast decl : letDecls.decls) {
            decl.accept(this);
        }
        breakStack.restoreStatus();
        return null;
    }

    public String visit(LetScope letScope) {
        String type = "void_TYPE";
        for (Ast exp : letScope.exprs) {
            type = exp.accept(this);
        }
        return type;
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

            Symbol arrTypeValueSymbol = lookup(arrTypeValue.name, "TYPE");
            if (arrTypeValueSymbol == null) {
                this.semanticErrors.add("Undeclared type : " + arrTypeValue.name);
            }

            String rootType = this.resolveTypeAlias(typeName + "_TYPE");
            String elementRootType = this.resolveTypeAlias(arrTypeValue.name + "_TYPE");
            this.addSymbol(typeName + "_TYPE",
                    new ArrayTypeSymbol(elementRootType, rootType, typeName));
        }
        if (typeValue instanceof RecType) {

            RecType recTypeValue = (RecType) typeValue;
            Map<String, String> fields = new HashMap<String, String>();

            for (FieldDec field : recTypeValue.fields) {
                Symbol fieldTypeSimbol = this.lookup(field.typeId.name, "TYPE");
                String fieldRootType = fieldTypeSimbol.getRootType();
                fields.put(field.id.name, fieldRootType);
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
        Set<String> argNames = new HashSet<String>();
        for (FieldDec arg : funDec.args.args) {
            String argRootType = this.resolveTypeAlias(arg.typeId.name + "_TYPE");
            if (!argNames.add(arg.id.name)) {
                this.semanticErrors.add("Duplicate argument name : " + arg.id.name);
            } else {
                this.addSymbol(arg.id.name + "_VAR",
                        new VarSymbol(arg.typeId.name + "_TYPE", argRootType, arg.id.name));
            }
        }

        if (this.lookup(funDec.returnTypeId.name, "TYPE") == null) {
            this.semanticErrors.add("Undeclared type : " + funDec.returnTypeId.name);
        }

        String returnType = funDec.body.accept(this);
        Symbol functionSymbol = this.lookup(funDec.id.name, "VAR");

        if (!functionSymbol.getRootType().equals(returnType)) {
            this.semanticErrors.add("Incompatible return type : the function " + funDec.id.name
                    + " must return value of " + functionSymbol.getRootType() + " type, not "
                    + returnType + " type");
        }
        // No type for declartations
        this.closeScope();
        return null;
    }

    public String visit(Id id) {
        Symbol symbol = this.lookup(id.name, "VAR");
        if (symbol == null) {
            this.semanticErrors.add("Undeclared variable : " + id.name);
            return null;
        }
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
        if (arrayType == null) {
            return null;
        }
        ArrayTypeSymbol arrayTypeSymbol = (ArrayTypeSymbol) this.lookup(arrayType);
        return arrayTypeSymbol.getElementType();
    }

    public String visit(FieldExp fieldExp) {
        String recordType = fieldExp.lValue.accept(this);
        if (recordType == null) {
            return null;
        }
        RecordTypeSymbol recordTypeSymbol = (RecordTypeSymbol) this.lookup(recordType);
        String fieldName = fieldExp.id.name;
        if (!recordTypeSymbol.getFields().containsKey(fieldName)) {
            this.semanticErrors.add("Record type " + recordType + " does not contain field "
                    + fieldName);
            return null;
        }
        return recordTypeSymbol.getFields().get(fieldExp.id.name);
    }

    public String visit(ArrCreate arrCreate) {
        String arrayType = arrCreate.typeId.name;
        Symbol arrayTypeSymbol = this.lookup(arrayType, "TYPE");
        String sizeExpType = arrCreate.index.accept(this);
        String initializerExpType = arrCreate.of.accept(this);

        if (arrayTypeSymbol == null) {
            this.semanticErrors.add("Undeclared type : " + arrayType);
            return null;
        }
        String rootType = arrayTypeSymbol.getRootType();
        Symbol arrayRootSymbol = this.lookup(rootType);
        if (!(arrayRootSymbol instanceof ArrayTypeSymbol)) {
            this.semanticErrors.add("Type " + arrayType + " is not an array type");
            return null;
        }
        if (!initializerExpType.equals(arrayRootSymbol.getType())) {
            this.semanticErrors
                    .add("Incompatible array initializer : the array was declared with type "
                            + arrayType + ", but was initialized with type " + initializerExpType);
            return null;
        }
        if (!sizeExpType.equals("int_TYPE")) {
            this.semanticErrors
                    .add("Array size must be of type int ,but is of type " + sizeExpType);
        }

        return rootType;
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
            RecordTypeSymbol recordTypeSymbol =
                    (RecordTypeSymbol) this.lookup(recordType.getRootType());
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
                        this.semanticErrors.add("Field " + field.id.name + " has type " + fieldType
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
        if (!breakStack.getStatus()) {
            this.semanticErrors.add("Break statement used outside a loop");
        }
        return "void_TYPE";
    }

    public List<String> getSemanticErrors() {
        return this.semanticErrors;
    }

}
