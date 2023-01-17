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
import errors.ErrorList;
import errors.SemanticError;
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

    private final Map<String, Scope> symtab = new java.util.HashMap<String, Scope>();
    private String currentScopeId;
    private final BreakChecker breakStack = new BreakChecker();
    private final ErrorList semanticErrors = new ErrorList();
    private final Map<String, String> typeAliases = new HashMap<String, String>();
    private final List<Integer> scopesByDepth = new ArrayList<Integer>();
    private final Set<Symbol> loopVariables = new HashSet<Symbol>();

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
        if (base.equals("global")) {
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
                SemanticError undefinedName = new SemanticError(assign.lineNumber,
                        assign.columnNumber, "Variable " + id.name + " is not defined");
                this.semanticErrors.add(undefinedName);
            } else {
                if (symbol.getCategory() != SymbolCat.VAR) {
                    SemanticError notAssignable = new SemanticError(assign.lineNumber,
                            assign.columnNumber, "Variable " + id.name + " cannot be assigned to");
                    this.semanticErrors.add(notAssignable);
                }
                if (this.loopVariables.contains(symbol)) {
                    SemanticError isALoopVar =
                            new SemanticError(assign.lineNumber, assign.columnNumber, "Variable "
                                    + id.name + " is a loop variable and cannot be assigned to");
                    this.semanticErrors.add(isALoopVar);
                }
            }
        }

        if (!expType.equals(lvalueType)) {
            SemanticError typeMismatch = new SemanticError(assign.lineNumber, assign.columnNumber,
                    "Type mismatch: cannot assign " + expType + " to " + lvalueType);
            this.semanticErrors.add(typeMismatch);
        }

        return "void_TYPE";
    }

    public String visit(Or or) {
        String leftType = or.left.accept(this);
        String rightType = or.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError bitwiseOperationTypeMismatch =
                    new SemanticError(or.lineNumber, or.columnNumber,
                            "Type mismatch: cannot apply operator | to left operand: is of type "
                                    + leftType + " instead of type INT");
            this.semanticErrors.add(bitwiseOperationTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError bitwiseOperationTypeMismatch =
                    new SemanticError(or.lineNumber, or.columnNumber,
                            "Type mismatch: cannot apply operator | to right operand: is of type "
                                    + rightType + " instead of type INT");
            this.semanticErrors.add(bitwiseOperationTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(And and) {
        String leftType = and.left.accept(this);
        String rightType = and.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError bitwiseOperationTypeMismatch =
                    new SemanticError(and.lineNumber, and.columnNumber,
                            "Type mismatch: cannot apply operator & to left operand: is of type "
                                    + leftType + " instead of type INT");
            this.semanticErrors.add(bitwiseOperationTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError bitwiseOperationTypeMismatch =
                    new SemanticError(and.lineNumber, and.columnNumber,
                            "Type mismatch: cannot apply operator & to right operand: is of type "
                                    + rightType + " instead of type INT");
            this.semanticErrors.add(bitwiseOperationTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Eq eq) {
        String leftType = eq.left.accept(this);
        String rightType = eq.right.accept(this);
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(eq.lineNumber, eq.columnNumber,
                    "Type mismatch: cannot apply operator = to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(NotEq notEq) {
        String leftType = notEq.left.accept(this);
        String rightType = notEq.right.accept(this);
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(notEq.lineNumber,
                    notEq.columnNumber,
                    "Type mismatch: cannot apply operator <> to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(InfEq infEq) {
        String leftType = infEq.left.accept(this);
        String rightType = infEq.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(infEq.lineNumber, infEq.columnNumber,
                            "Type mismatch: cannot apply operator <= to left operand of type "
                                    + leftType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(infEq.lineNumber, infEq.columnNumber,
                            "Type mismatch: cannot apply operator <= to right operand of type  "
                                    + rightType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(infEq.lineNumber,
                    infEq.columnNumber,
                    "Type mismatch: cannot apply operator <= to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Inf inf) {
        String leftType = inf.left.accept(this);
        String rightType = inf.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(inf.lineNumber, inf.columnNumber,
                            "Type mismatch: cannot apply operator < to left operand of type "
                                    + leftType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(inf.lineNumber, inf.columnNumber,
                            "Type mismatch: cannot apply operator < to right operand of type  "
                                    + rightType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(inf.lineNumber,
                    inf.columnNumber,
                    "Type mismatch: cannot apply operator < to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(SupEq supEq) {
        String leftType = supEq.left.accept(this);
        String rightType = supEq.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(supEq.lineNumber, supEq.columnNumber,
                            "Type mismatch: cannot apply operator >= to left operand of type "
                                    + leftType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(supEq.lineNumber, supEq.columnNumber,
                            "Type mismatch: cannot apply operator >= to right operand of type  "
                                    + rightType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(supEq.lineNumber,
                    supEq.columnNumber,
                    "Type mismatch: cannot apply operator >= to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Sup sup) {
        String leftType = sup.left.accept(this);
        String rightType = sup.right.accept(this);
        if (!leftType.equals("int_TYPE") && !leftType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(sup.lineNumber, sup.columnNumber,
                            "Type mismatch: cannot apply operator > to left operand of type "
                                    + leftType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!rightType.equals("int_TYPE") && !rightType.equals("string_TYPE")) {
            SemanticError comparisonTypeMismatch =
                    new SemanticError(sup.lineNumber, sup.columnNumber,
                            "Type mismatch: cannot apply operator > to right operand of type  "
                                    + rightType + " instead of type INT or STRING");
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError comparisonTypeMismatch = new SemanticError(sup.lineNumber,
                    sup.columnNumber,
                    "Type mismatch: cannot apply operator > to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(comparisonTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Add add) {
        String leftType = add.left.accept(this);
        String rightType = add.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(add.lineNumber, add.columnNumber,
                    "Type mismatch: cannot apply operator + to left operand : is of type "
                            + leftType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(add.lineNumber, add.columnNumber,
                    "Type mismatch: cannot apply operator + to right operand : is of type "
                            + rightType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError operandTypeMismatch = new SemanticError(add.lineNumber, add.columnNumber,
                    "Type mismatch: cannot apply operator + to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(operandTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Sub sub) {
        String leftType = sub.left.accept(this);
        String rightType = sub.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(sub.lineNumber, sub.columnNumber,
                    "Type mismatch: cannot apply operator - to left operand : is of type "
                            + leftType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(sub.lineNumber, sub.columnNumber,
                    "Type mismatch: cannot apply operator - to right operand : is of type "
                            + rightType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError operandTypeMismatch = new SemanticError(sub.lineNumber, sub.columnNumber,
                    "Type mismatch: cannot apply operator - to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(operandTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Mult mult) {
        String leftType = mult.left.accept(this);
        String rightType = mult.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch =
                    new SemanticError(mult.lineNumber, mult.columnNumber,
                            "Type mismatch: cannot apply operator * to left operand : is of type "
                                    + leftType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch =
                    new SemanticError(mult.lineNumber, mult.columnNumber,
                            "Type mismatch: cannot apply operator * to right operand : is of type "
                                    + rightType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError operandTypeMismatch = new SemanticError(mult.lineNumber,
                    mult.columnNumber,
                    "Type mismatch: cannot apply operator * to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(operandTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(Div div) {
        String leftType = div.left.accept(this);
        String rightType = div.right.accept(this);
        if (!leftType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(div.lineNumber, div.columnNumber,
                    "Type mismatch: cannot apply operator / to left operand : is of type "
                            + leftType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!rightType.equals("int_TYPE")) {
            SemanticError operandTypeMismatch = new SemanticError(div.lineNumber, div.columnNumber,
                    "Type mismatch: cannot apply operator / to right operand : is of type "
                            + rightType + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        if (!leftType.equals(rightType)) {
            SemanticError operandTypeMismatch = new SemanticError(div.lineNumber, div.columnNumber,
                    "Type mismatch: cannot apply operator / to operands of different types  "
                            + leftType + " and " + rightType);
            this.semanticErrors.add(operandTypeMismatch);
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
            SemanticError operandTypeMismatch = new SemanticError(neg.lineNumber, neg.columnNumber,
                    "Type mismatch: cannot apply operator - to operand of type " + negExprType
                            + " instead of type INT");
            this.semanticErrors.add(operandTypeMismatch);
        }
        return "int_TYPE";
    }

    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        String thenType = ifThenElse.thenExpr.accept(this);
        if (ifThenElse.elseExpr != null) {
            String elseType = ifThenElse.elseExpr.accept(this);
            if (!thenType.equals(elseType)) {
                SemanticError branchTypeMismatch = new SemanticError(ifThenElse.lineNumber,
                        ifThenElse.columnNumber, "Type mismatch: then branch is of type " + thenType
                                + " but else branch is of type " + elseType);
                this.semanticErrors.add(branchTypeMismatch);
                return "void_TYPE";
            }
            return thenType;
        } else {
            if (!thenType.equals("void_TYPE")) {
                SemanticError branchTypeMismatch = new SemanticError(ifThenElse.lineNumber,
                        ifThenElse.columnNumber,
                        "Condition without else branch should be of type void but is of type "
                                + thenType);
                this.semanticErrors.add(branchTypeMismatch);
            }
        }
        return "void_TYPE";
    }

    public String visit(WhileExp whileExp) {
        String whileConditionType = whileExp.condition.accept(this);
        if (!whileConditionType.equals("int_TYPE")) {
            SemanticError conditionTypeMismatch = new SemanticError(whileExp.lineNumber,
                    whileExp.columnNumber, "While loop condition is of type " + whileConditionType
                            + " but should be of type int");
            this.semanticErrors.add(conditionTypeMismatch);
        }
        breakStack.changeStatus(true);
        String whileBodyType = whileExp.doExpr.accept(this);
        breakStack.restoreStatus();
        if (!whileBodyType.equals("void_TYPE")) {
            SemanticError bodyTypeMismatch = new SemanticError(whileExp.lineNumber,
                    whileExp.columnNumber,
                    "While loop body is of type " + whileBodyType + " but should be of type void");
            this.semanticErrors.add(bodyTypeMismatch);
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
            SemanticError bodyTypeMismatch = new SemanticError(forExp.lineNumber,
                    forExp.columnNumber,
                    "For loop body is of type " + forBodyType + " but should be of type void");
            this.semanticErrors.add(bodyTypeMismatch);
        }
        String forStartIndexType = forExp.startValue.accept(this);
        if (!forStartIndexType.equals("int_TYPE")) {
            SemanticError indexTypeMismatch = new SemanticError(forExp.lineNumber,
                    forExp.columnNumber, "For loop start index is of type " + forStartIndexType
                            + " but should be of type int");
            this.semanticErrors.add(indexTypeMismatch);
        }
        String forEndIndexType = forExp.endValue.accept(this);
        if (!forEndIndexType.equals("int_TYPE")) {
            SemanticError indexTypeMismatch = new SemanticError(forExp.lineNumber,
                    forExp.columnNumber, "For loop end index is of type " + forEndIndexType
                            + " but should be of type int");
            this.semanticErrors.add(indexTypeMismatch);
        }
        String forVarValueType = forExp.forId.accept(this);
        if (!forVarValueType.equals("int_TYPE")) {
            SemanticError varTypeMismatch = new SemanticError(forExp.lineNumber,
                    forExp.columnNumber, "For loop variable " + forExp.forId.name + " is of type "
                            + forVarValueType + " but should be of type int");
            this.semanticErrors.add(varTypeMismatch);
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
        return funcSymbol.getType();
    }

    public String visit(FieldDec fieldDec) {
        // No type for declartations
        return null;
    }

    public String visit(TypeDec typeDec) {
        String typeName = typeDec.typeId.name;
        Type typeValue = typeDec.typeValue;

        if (this.lookup(typeName, "_TYPE") != null) {
            this.semanticErrors.add(new SemanticError(typeDec.lineNumber, typeDec.columnNumber,
                    "Type redeclaration : the " + typeName + " type already exist"));
            return null;
        }

        if (typeValue instanceof TypeId) {
            TypeId typeIdValue = (TypeId) typeValue;
            Symbol typeIdValueSymbol = lookup(typeIdValue.name, "TYPE");

            if (typeIdValueSymbol == null) {
                SemanticError undeclaredType = new SemanticError(typeDec.lineNumber,
                        typeDec.columnNumber, "Undeclared type : " + typeIdValue.name);
                this.semanticErrors.add(undeclaredType);
                return null;
            }
            String rootType = this.resolveTypeAlias(typeIdValue.name + "_TYPE");
            this.addSymbol(typeName + "_TYPE",
                    new SimpleTypeSymbol(typeIdValue.name + "_TYPE", rootType, typeName));
            this.typeAliases.put(typeName + "_TYPE", typeIdValue.name + "_TYPE");


        }
        if (typeValue instanceof ArrType) {
            ArrType arrTypeValue = (ArrType) typeValue;
            Symbol arrTypeValueSymbol = lookup(arrTypeValue.name, "TYPE");
            if (arrTypeValueSymbol == null) {
                SemanticError undeclaredType = new SemanticError(typeDec.lineNumber,
                        typeDec.columnNumber, "Undeclared type : " + arrTypeValue.name);
                this.semanticErrors.add(undeclaredType);
                return null;
            }

            String rootType = this.resolveTypeAlias(typeName + "_TYPE");
            String elementRootType = this.resolveTypeAlias(arrTypeValue.name + "_TYPE");
            this.addSymbol(typeName + "_TYPE",
                    new ArrayTypeSymbol(elementRootType, rootType, typeName));
        }
        if (typeValue instanceof RecType) {

            RecType recTypeValue = (RecType) typeValue;
            Map<String, String> fields = new HashMap<String, String>();
            boolean flag = false;

            for (FieldDec field : recTypeValue.fields) {
                Symbol fieldTypeSymbol = this.lookup(field.typeId.name, "TYPE");
                if (fieldTypeSymbol == null) {
                    SemanticError undeclaredType = new SemanticError(typeDec.lineNumber,
                            typeDec.columnNumber, "Undeclared type : " + field.typeId.name);
                    this.semanticErrors.add(undeclaredType);
                    flag = true;
                }

                String fieldRootType = fieldTypeSymbol.getRootType();
                fields.put(field.id.name, fieldRootType);
            }
            if (!flag) {
                this.addSymbol(typeName + "_TYPE",
                        new RecordTypeSymbol(fields, typeName + "_TYPE", typeName));
                return null;
            }

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
            SemanticError undeclaredType = new SemanticError(varDecType.lineNumber,
                    varDecType.columnNumber, "Undeclared type : " + varDecType.varTypeId.name);
            this.semanticErrors.add(undeclaredType);
            String varType = varDecType.varValue.accept(this);
            this.addSymbol(varDecType.varId.name + "_VAR",
                    new VarSymbol(varType, varType, varDecType.varId.name));
        } else {
            String varDecRootType = varDecTypeSymbol.getRootType();
            Symbol varDecNameSymbol = this.lookup(varDecType.varId.name, "VAR");
            if (varDecNameSymbol != null) {
                String alreadyDeclaredType = varDecNameSymbol.getType();
                String alreadyDeclaredRootType = varDecNameSymbol.getRootType();
                if (!alreadyDeclaredRootType.equals(varDecRootType)) {
                    SemanticError varRedeclaration = new SemanticError(varDecType.lineNumber,
                            varDecType.columnNumber,
                            "Variable redeclaration : " + varDecType.varId.name
                                    + " was already declared with type " + alreadyDeclaredType
                                    + " and can't be redeclared with type " + varDecRootType);
                    this.semanticErrors.add(varRedeclaration);
                }
            }
            this.addSymbol(varDecType.varId.name + "_VAR", new VarSymbol(
                    varDecType.varTypeId.name + "_TYPE", varDecRootType, varDecType.varId.name));
            String varType = varDecType.varValue.accept(this);
            if (!varType.equals(varDecRootType)) {
                SemanticError varTypeMismatch = new SemanticError(varDecType.lineNumber,
                        varDecType.columnNumber,
                        "Incompatible declaration type : the variable " + varDecType.varId.name
                                + " must be a value of " + varDecType.varTypeId.name + " type, not "
                                + varType + " type");
                this.semanticErrors.add(varTypeMismatch);
            }
        }
        // No type for declartations
        return null;
    }

    public String visit(VarDecNoType varDecNoType) {
        String varType = varDecNoType.varValue.accept(this);
        String rootType = this.resolveTypeAlias(varType);
        Symbol varDecNameSymbol = this.lookup(varDecNoType.varId.name, "VAR");
        if (varDecNameSymbol != null) {
            String alreadyDeclaredVarType = varDecNameSymbol.getType();
            String alreadyDeclaredRootType = this.resolveTypeAlias(alreadyDeclaredVarType);
            if (!alreadyDeclaredRootType.equals(rootType)) {
                SemanticError varNameAlreadyDeclared = new SemanticError(varDecNoType.lineNumber,
                        varDecNoType.columnNumber,
                        "Variable redeclaration : " + varDecNoType.varId.name
                                + " was already declared with type " + alreadyDeclaredVarType
                                + " and can't be redeclared with type " + varType);
                this.semanticErrors.add(varNameAlreadyDeclared);
            }
        }
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
                SemanticError duplicateArgName = new SemanticError(arg.lineNumber, arg.columnNumber,
                        "Duplicate argument name : " + arg.id.name);
                this.semanticErrors.add(duplicateArgName);
            } else {
                this.addSymbol(arg.id.name + "_VAR",
                        new VarSymbol(arg.typeId.name + "_TYPE", argRootType, arg.id.name));
            }
        }

        if (this.lookup(funDec.returnTypeId.name, "TYPE") == null) {
            SemanticError undeclaredType = new SemanticError(funDec.lineNumber, funDec.columnNumber,
                    "Undeclared type : " + funDec.returnTypeId.name);
            this.semanticErrors.add(undeclaredType);
        }

        String returnType = funDec.body.accept(this);
        Symbol functionSymbol = this.lookup(funDec.id.name, "VAR");

        if (!functionSymbol.getRootType().equals(returnType)) {
            SemanticError incompatibleReturnType =
                    new SemanticError(funDec.lineNumber, funDec.columnNumber,
                            "Incompatible return type : the function " + funDec.id.name
                                    + " must return value of " + functionSymbol.getRootType()
                                    + " type, not " + returnType + " type");
            this.semanticErrors.add(incompatibleReturnType);
        }
        // No type for declartations
        this.closeScope();
        return null;
    }

    public String visit(Id id) {
        Symbol symbol = this.lookup(id.name, "VAR");
        if (symbol == null) {
            SemanticError undeclaredVar = new SemanticError(id.lineNumber, id.columnNumber,
                    "Undeclared variable : " + id.name);
            this.semanticErrors.add(undeclaredVar);
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
            SemanticError typeMismatch = new SemanticError(subscript.lineNumber,
                    subscript.columnNumber, "Subscript access to an array must be an integer");
            this.semanticErrors.add(typeMismatch);
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
            SemanticError typeMismatch =
                    new SemanticError(fieldExp.lineNumber, fieldExp.columnNumber,
                            "Record type " + recordType + " does not contain field " + fieldName);
            this.semanticErrors.add(typeMismatch);
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
            SemanticError undeclaredType = new SemanticError(arrCreate.lineNumber,
                    arrCreate.columnNumber, "Undeclared type : " + arrayType);
            this.semanticErrors.add(undeclaredType);
            return null;
        }
        String rootType = arrayTypeSymbol.getRootType();
        Symbol arrayRootSymbol = this.lookup(rootType);
        if (!(arrayRootSymbol instanceof ArrayTypeSymbol)) {
            SemanticError notAnArrayType = new SemanticError(arrCreate.lineNumber,
                    arrCreate.columnNumber, "Type " + arrayType + " is not an array type");
            this.semanticErrors.add(notAnArrayType);
            return null;
        }
        if (!initializerExpType.equals(arrayRootSymbol.getType())) {
            SemanticError incompatibleInitializer =
                    new SemanticError(arrCreate.lineNumber, arrCreate.columnNumber,
                            "Incompatible array initializer : the array was declared with type "
                                    + arrayType + ", but was initialized with type "
                                    + initializerExpType);
            this.semanticErrors.add(incompatibleInitializer);
            return null;
        }
        if (!sizeExpType.equals("int_TYPE")) {
            SemanticError sizeTypeMismatch =
                    new SemanticError(arrCreate.lineNumber, arrCreate.columnNumber,
                            "Array size must be of type int ,but is of type " + sizeExpType);
            this.semanticErrors.add(sizeTypeMismatch);
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
            SemanticError undeclaredType = new SemanticError(recCreate.lineNumber,
                    recCreate.columnNumber, "Undeclared type : " + recCreate.typeId.name);
            this.semanticErrors.add(undeclaredType);
        } else {
            RecordTypeSymbol recordTypeSymbol =
                    (RecordTypeSymbol) this.lookup(recordType.getRootType());
            ArrayList<FieldCreate> fields = recCreate.fields.fields;
            for (FieldCreate field : fields) {
                Map<String, String> fieldsMap = recordTypeSymbol.getFields();
                if (!fieldsMap.containsKey(field.id.name)) {
                    SemanticError fieldNotFound = new SemanticError(field.lineNumber,
                            field.columnNumber, "Field " + field.id.name
                                    + " not found in record type " + recCreate.typeId.name);
                    this.semanticErrors.add(fieldNotFound);
                } else {
                    String fieldType = fieldsMap.get(field.id.name);
                    String declarationType = field.expr.accept(this);
                    if (!fieldType.equals(declarationType)) {
                        SemanticError typeMismatch =
                                new SemanticError(field.lineNumber, field.columnNumber,
                                        "Field " + field.id.name + " has type " + fieldType
                                                + " but is initialized with type "
                                                + declarationType);
                        this.semanticErrors.add(typeMismatch);
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
            SemanticError breakOutsideLoop = new SemanticError(breakLiteral.lineNumber,
                    breakLiteral.columnNumber, "Break statement used outside a loop");
            this.semanticErrors.add(breakOutsideLoop);
        }
        return "void_TYPE";
    }

    public ErrorList getSemanticErrors() {
        return this.semanticErrors;
    }

}
