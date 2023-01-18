// Generated from tiger.g4 by ANTLR 4.9.2

package ast;

import parser.tigerParser;
import parser.tigerParser.ExpContext;
import parser.tigerBaseVisitor;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class AstCreator extends tigerBaseVisitor<Ast> {

	private String getTokenString(ParserRuleContext ctx) {
		return ctx.getChild(0).toString();
	}

	private Ast skipUnary(ParserRuleContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	@Override
	public Ast visitProgram(tigerParser.ProgramContext ctx) {
		Ast exp = skipUnary(ctx);
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new Program(exp, lineNumber, columnNumber);
	}

	@Override
	public Ast visitExp(tigerParser.ExpContext ctx) {
		Ast first = ctx.first.accept(this);
		if (ctx.right != null) {
			Ast right = ctx.right.accept(this);
			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			return new Assign(first, right, lineNumber, columnNumber);
		} else {
			return first;
		}
	}

	@Override
	public Ast visitOrExp(tigerParser.OrExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.right.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			tempNode = new Or(tempNode, right, lineNumber, columnNumber);
		}
		return tempNode;
	}

	@Override
	public Ast visitAndExp(tigerParser.AndExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.right.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			tempNode = new And(tempNode, right, lineNumber, columnNumber);
		}
		return tempNode;
	}

	@Override
	public Ast visitEqExp(tigerParser.EqExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.ops.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			Token tok = ctx.ops.get(i);
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "=":
					tempNode = new Eq(tempNode, right, lineNumber, columnNumber);
					break;
				case "<>":
					tempNode = new NotEq(tempNode, right, lineNumber, columnNumber);
					break;
				case ">":
					tempNode = new Sup(tempNode, right, lineNumber, columnNumber);
					break;
				case "<":
					tempNode = new Inf(tempNode, right, lineNumber, columnNumber);
					break;
				case ">=":
					tempNode = new SupEq(tempNode, right, lineNumber, columnNumber);
					break;
				case "<=":
					tempNode = new InfEq(tempNode, right, lineNumber, columnNumber);
					break;
				default:
					break;
			}
		}
		return tempNode;
	}

	@Override
	public Ast visitAddExp(tigerParser.AddExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.ops.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			Token tok = ctx.ops.get(i);
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "+":
					tempNode = new Add(tempNode, right, lineNumber, columnNumber);
					break;
				case "-":
					tempNode = new Sub(tempNode, right, lineNumber, columnNumber);
					break;
				default:
					break;
			}
		}
		return tempNode;
	}

	@Override
	public Ast visitMultExp(tigerParser.MultExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.ops.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			Token tok = ctx.ops.get(i);
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "*":
					tempNode = new Mult(tempNode, right, lineNumber, columnNumber);
					break;
				case "/":
					tempNode = new Div(tempNode, right, lineNumber, columnNumber);
					break;
				default:
					break;
			}
		}
		return tempNode;

	}

	@Override
	public Ast visitSimpleExp(tigerParser.SimpleExpContext ctx) {
		return skipUnary(ctx);
	}

	@Override
	public Ast visitIntLitteral(tigerParser.IntLitteralContext ctx) {
		String intValue = getTokenString(ctx);
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new IntLiteral(Integer.parseInt(intValue), lineNumber, columnNumber);
	}

	@Override
	public Ast visitStringLitteral(tigerParser.StringLitteralContext ctx) {
		String stringValue = getTokenString(ctx);
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new StringLiteral(stringValue, lineNumber, columnNumber);
	}

	@Override
	public Ast visitNilLitteral(tigerParser.NilLitteralContext ctx) {
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new NilLiteral(lineNumber, columnNumber);
	}

	@Override
	public Ast visitBreakLitteral(tigerParser.BreakLitteralContext ctx) {
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new BreakLiteral(lineNumber, columnNumber);
	}

	@Override
	public Ast visitIdExp(tigerParser.IdExpContext ctx) {
		// CallExp
		if (ctx.isCall != null) {
			ArrayList<Ast> callArgs = new ArrayList<Ast>();
			for (ExpContext exp : ctx.callArgs) {
				callArgs.add(exp.accept(this));
			}
			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();

			int argsLineNumber, argsColumnNumber;

			if (ctx.callArgs.size() != 0) {
				Token argsTok = ctx.callArgs.get(0).getStart();
				argsLineNumber = argsTok.getLine();
				argsColumnNumber = argsTok.getCharPositionInLine();
			} else {
				argsLineNumber = ctx.isCall.getLine();
				argsColumnNumber = ctx.isCall.getCharPositionInLine();
			}

			String idName = ctx.id.getText();
			int idLineNumber = ctx.id.getLine();
			int idColumnNumber = ctx.id.getCharPositionInLine();
			return new CallExp(new Id(idName, idLineNumber, idColumnNumber),
					new CallExpArgs(callArgs, argsLineNumber, argsColumnNumber), lineNumber,
					columnNumber);
		}

		// RecCreate
		if (ctx.isRecord != null) {
			ArrayList<Id> fieldIds = new ArrayList<Id>();
			for (Token id : ctx.recIds) {
				String idName = id.getText();
				int idLineNumber = id.getLine();
				int idColumnNumber = id.getCharPositionInLine();
				fieldIds.add(new Id(idName, idLineNumber, idColumnNumber));
			}

			ArrayList<Ast> fieldValues = new ArrayList<Ast>();
			for (ExpContext exp : ctx.recValues) {
				fieldValues.add(exp.accept(this));
			}

			assert fieldIds.size() == fieldValues.size();

			ArrayList<FieldCreate> fields = new ArrayList<FieldCreate>();
			for (int i = 0; i < fieldIds.size(); i++) {
				Id id = fieldIds.get(i);
				Ast value = fieldValues.get(i);
				Token tok = ctx.recIds.get(i);
				int fieldLineNumber = tok.getLine();
				int fieldColumnNumber = tok.getCharPositionInLine();
				fields.add(new FieldCreate(id, value, fieldLineNumber, fieldColumnNumber));
			}

			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();

			int argsLineNumber, argsColumnNumber;

			if (ctx.recValues.size() != 0) {
				Token argsTok = ctx.recValues.get(0).getStart();
				argsLineNumber = argsTok.getLine();
				argsColumnNumber = argsTok.getCharPositionInLine();
			} else {
				Token argsTok = ctx.isRecord;
				argsLineNumber = argsTok.getLine();
				argsColumnNumber = argsTok.getCharPositionInLine();
			}

			String typeIdName = ctx.id.getText();
			int typeIdLineNumber = ctx.id.getLine();
			int typeIdColumnNumber = ctx.id.getCharPositionInLine();
			return new RecCreate(new TypeId(typeIdName, typeIdLineNumber, typeIdColumnNumber),
					new RecCreateFields(fields, argsLineNumber, argsColumnNumber), lineNumber,
					columnNumber);
		}

		// ArrCreate
		if (ctx.arrCreateType != null) {

			Token tok = ctx.getStart();
			int lineNumber = tok.getLine();
			int columnNumber = tok.getCharPositionInLine();

			String idName = ctx.id.getText();
			int idLineNumber = ctx.id.getLine();
			int idColumnNumber = ctx.id.getCharPositionInLine();
			return new ArrCreate(new TypeId(idName, idLineNumber, idColumnNumber),
					ctx.getChild(2).accept(this), ctx.arrCreateType.accept(this), lineNumber,
					columnNumber);
		}

		// Accesses
		int expIndex = 2;

		String idName = ctx.id.getText();
		int idLineNumber = ctx.id.getLine();
		int idColumnNumber = ctx.id.getCharPositionInLine();
		Ast tempNode = new Id(idName, idLineNumber, idColumnNumber);

		for (Token accessOp : ctx.accessOps) {
			int lineNumber = accessOp.getLine();
			int columnNumber = accessOp.getCharPositionInLine();
			switch (accessOp.getText()) {
				case "[":
					tempNode = new Subscript(tempNode, ctx.getChild(expIndex).accept(this),
							lineNumber, columnNumber);
					expIndex += 3;
					break;
				case ".":
					String fieldName = ctx.getChild(expIndex).getText();
					Token fieldTok = ((TerminalNodeImpl) ctx.getChild(expIndex)).getSymbol();
					int fieldLineNumber = fieldTok.getLine();
					int fieldColumnNumber = fieldTok.getCharPositionInLine();
					tempNode = new FieldExp(tempNode,
							new Id(fieldName, fieldLineNumber, fieldColumnNumber), lineNumber,
							columnNumber);
					expIndex += 2;
					break;
				default:
					break;
			}
		}
		return tempNode;
	}

	@Override
	public Ast visitSeqExp(tigerParser.SeqExpContext ctx) {
		ArrayList<Ast> exps = new ArrayList<Ast>();
		for (ExpContext exp : ctx.exprs) {
			exps.add(exp.accept(this));
		}
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new SeqExp(exps, lineNumber, columnNumber);
	}

	@Override
	public Ast visitNeg(tigerParser.NegContext ctx) {
		Ast expr = ctx.expr.accept(this);
		Token tok = ctx.expr.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new Neg(expr, lineNumber, columnNumber);
	}

	@Override
	public Ast visitIfThen(tigerParser.IfThenContext ctx) {
		Ast condition = ctx.condition.accept(this);
		Ast thenExp = ctx.thenExpr.accept(this);
		ExpContext elseExpContext = ctx.elseExpr;

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();

		if (elseExpContext != null) {
			return new IfThenElse(condition, thenExp, elseExpContext.accept(this), lineNumber,
					columnNumber);
		} else {
			return new IfThenElse(condition, thenExp, null, lineNumber, columnNumber);
		}

	}

	@Override
	public Ast visitWhileExp(tigerParser.WhileExpContext ctx) {
		Ast condition = ctx.condition.accept(this);
		Ast doExp = ctx.doExpr.accept(this);
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new WhileExp(condition, doExp, lineNumber, columnNumber);
	}

	@Override
	public Ast visitForExp(tigerParser.ForExpContext ctx) {
		String idName = ctx.forId.getText();
		int idLineNumber = ctx.forId.getLine();
		int idColumnNumber = ctx.forId.getCharPositionInLine();

		Id forId = new Id(idName, idLineNumber, idColumnNumber);
		Ast startValue = ctx.startValue.accept(this);
		Ast endValue = ctx.endValue.accept(this);
		Ast doExp = ctx.doExp.accept(this);

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();

		return new ForExp(forId, startValue, endValue, doExp, lineNumber, columnNumber);
	}

	@Override
	public Ast visitLetExp(tigerParser.LetExpContext ctx) {
		ArrayList<Ast> decls = new ArrayList<Ast>();

		for (tigerParser.DecContext decl : ctx.decls) {
			decls.add(decl.accept(this));
		}
		Token declsTok = ctx.decls.get(0).getStart();
		int declsLineNumber = declsTok.getLine();
		int declsColumnNumber = declsTok.getCharPositionInLine();
		ArrayList<Ast> exps = new ArrayList<Ast>();

		for (tigerParser.ExpContext exp : ctx.inExprs) {
			exps.add(exp.accept(this));
		}

		int expsLineNumber, expsColumnNumber;

		if (ctx.inExprs.size() != 0) {
			Token expsTok = ctx.inExprs.get(0).getStart();
			expsLineNumber = expsTok.getLine();
			expsColumnNumber = expsTok.getCharPositionInLine();
		} else {
			Token expsTok = ctx.inToken;
			expsLineNumber = expsTok.getLine();
			expsColumnNumber = expsTok.getCharPositionInLine();
		}

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();

		LetDecls letDecls = new LetDecls(decls, declsLineNumber, declsColumnNumber);
		LetScope letScope = new LetScope(exps, expsLineNumber, expsColumnNumber);
		return new LetExp(letDecls, letScope, lineNumber, columnNumber);
	}

	@Override
	public Ast visitDec(tigerParser.DecContext ctx) {
		return skipUnary(ctx);
	}

	@Override
	public Ast visitTypeDec(tigerParser.TypeDecContext ctx) {
		String typeName = ctx.typeId.getText();
		int typeLineNumber = ctx.typeId.getLine();
		int typeColumnNumber = ctx.typeId.getCharPositionInLine();
		TypeId typeId = new TypeId(typeName, typeLineNumber, typeColumnNumber);
		Type typeValue = (Type) ctx.typeValue.accept(this);
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new TypeDec(typeId, typeValue, lineNumber, columnNumber);
	}

	@Override
	public Ast visitTypeDecs(tigerParser.TypeDecsContext ctx) {
		ArrayList<Ast> typeDecs = new ArrayList<Ast>();
		for (tigerParser.TypeDecContext typeDec : ctx.tydecs) {
			typeDecs.add(typeDec.accept(this));
		}
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new TypeDecs(typeDecs, lineNumber, columnNumber);
	}

	@Override
	public Ast visitVarDec(tigerParser.VarDecContext ctx) {
		String varName = ctx.varId.getText();
		int varLineNumber = ctx.varId.getLine();
		int varColumnNumber = ctx.varId.getCharPositionInLine();
		Id varId = new Id(varName, varLineNumber, varColumnNumber);
		TypeId varType;
		Ast varValue = ctx.varValue.accept(this);

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();

		if (ctx.typeId == null) {
			return new VarDecNoType(varId, varValue, lineNumber, columnNumber);
		} else {
			String typeName = ctx.typeId.getText();
			int typeLineNumber = ctx.typeId.getLine();
			int typeColumnNumber = ctx.typeId.getCharPositionInLine();
			varType = new TypeId(typeName, typeLineNumber, typeColumnNumber);
			return new VarDecType(varId, varType, varValue, lineNumber, columnNumber);
		}
	}

	@Override
	public Ast visitFunDec(tigerParser.FunDecContext ctx) {
		String funName = ctx.functionId.getText();
		int funLineNumber = ctx.functionId.getLine();
		int funColumnNumber = ctx.functionId.getCharPositionInLine();
		Id functionId = new Id(funName, funLineNumber, funColumnNumber);
		ArrayList<FieldDec> funArgsFields = new ArrayList<FieldDec>();
		ArrayList<Id> argNames = new ArrayList<Id>();
		ArrayList<TypeId> argTypes = new ArrayList<TypeId>();
		TypeId returnType;
		Ast functionBody = ctx.body.accept(this);

		for (Token argName : ctx.argNames) {
			String argNameString = argName.getText();
			int argNameLineNumber = argName.getLine();
			int argNameColumnNumber = argName.getCharPositionInLine();
			argNames.add(new Id(argNameString, argNameLineNumber, argNameColumnNumber));
		}
		for (Token argType : ctx.argTypes) {
			String argTypeString = argType.getText();
			int argTypeLineNumber = argType.getLine();
			int argTypeColumnNumber = argType.getCharPositionInLine();
			argTypes.add(new TypeId(argTypeString, argTypeLineNumber, argTypeColumnNumber));
		}

		assert argNames.size() == argTypes.size();

		for (int i = 0; i < argNames.size(); i++) {
			Token tok = ctx.argNames.get(i);
			int argsNameLineNumber = tok.getLine();
			int argsNameColumnNumber = tok.getCharPositionInLine();
			funArgsFields.add(new FieldDec(argNames.get(i), argTypes.get(i), argsNameLineNumber,
					argsNameColumnNumber));
		}

		int argsNameLineNumber, argsNameColumnNumber;

		Token argsNameTok;
		if (ctx.argNames.size() > 0) {
			argsNameTok = ctx.argNames.get(0);
		} else {
			argsNameTok = ctx.callParen;
		}
		argsNameLineNumber = argsNameTok.getLine();
		argsNameColumnNumber = argsNameTok.getCharPositionInLine();

		FunArgs args = new FunArgs(funArgsFields, argsNameLineNumber, argsNameColumnNumber);

		int returnLineNumber;
		int returnColumnNumber;

		if (ctx.returnType == null) {
			returnLineNumber = ctx.endParen.getLine();
			returnColumnNumber = ctx.endParen.getCharPositionInLine();
			returnType = new TypeId("void", returnLineNumber, returnColumnNumber);
		} else {
			returnLineNumber = ctx.returnType.getLine();
			returnColumnNumber = ctx.returnType.getCharPositionInLine();
			returnType = new TypeId(ctx.returnType.getText(), returnLineNumber, returnColumnNumber);
		}

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();

		return new FunDec(functionId, args, returnType, functionBody, lineNumber, columnNumber);
	}

	@Override
	public Ast visitTypeId(tigerParser.TypeIdContext ctx) {
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new TypeId(getTokenString(ctx), lineNumber, columnNumber);
	}

	@Override
	public Ast visitCompositeType(tigerParser.CompositeTypeContext ctx) {
		return skipUnary(ctx);
	}

	@Override
	public Ast visitComplexType(tigerParser.ComplexTypeContext ctx) {
		return skipUnary(ctx);
	}

	@Override
	public Ast visitArrType(tigerParser.ArrTypeContext ctx) {
		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new ArrType(ctx.typeId.getText(), lineNumber, columnNumber);
	}

	@Override
	public Ast visitRecType(tigerParser.RecTypeContext ctx) {
		ArrayList<FieldDec> fields = new ArrayList<FieldDec>();
		ArrayList<Id> fieldNames = new ArrayList<Id>();
		ArrayList<TypeId> fieldTypes = new ArrayList<TypeId>();

		for (Token id : ctx.fieldIds) {
			String idString = id.getText();
			int idLineNumber = id.getLine();
			int idColumnNumber = id.getCharPositionInLine();
			fieldNames.add(new Id(idString, idLineNumber, idColumnNumber));
		}
		for (Token type : ctx.fieldTypes) {
			String typeString = type.getText();
			int typeLineNumber = type.getLine();
			int typeColumnNumber = type.getCharPositionInLine();
			fieldTypes.add(new TypeId(typeString, typeLineNumber, typeColumnNumber));
		}
		assert fieldNames.size() == fieldTypes.size();

		for (int i = 0; i < fieldNames.size(); i++) {
			Token tok = ctx.fieldIds.get(i);
			int fieldIdLineNumber = tok.getLine();
			int fieldIdColumnNumber = tok.getCharPositionInLine();
			fields.add(new FieldDec(fieldNames.get(i), fieldTypes.get(i), fieldIdLineNumber,
					fieldIdColumnNumber));
		}

		Token tok = ctx.getStart();
		int lineNumber = tok.getLine();
		int columnNumber = tok.getCharPositionInLine();
		return new RecType(fields, lineNumber, columnNumber);
	}
}
