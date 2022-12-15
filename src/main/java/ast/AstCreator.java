// Generated from tiger.g4 by ANTLR 4.9.2

package ast;

import parser.tigerParser;
import parser.tigerParser.ExpContext;
import parser.tigerBaseVisitor;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;


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
		return new Program(exp);
	}

	@Override
	public Ast visitExp(tigerParser.ExpContext ctx) {
		Ast first = ctx.first.accept(this);
		if (ctx.right != null) {
			Ast right = ctx.right.accept(this);
			return new Assign(first, right);
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
			tempNode = new Or(tempNode, right);
		}
		return tempNode;
	}

	@Override
	public Ast visitAndExp(tigerParser.AndExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.right.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			tempNode = new And(tempNode, right);
		}
		return tempNode;
	}

	@Override
	public Ast visitEqExp(tigerParser.EqExpContext ctx) {
		Ast tempNode = ctx.first.accept(this);
		int nodesCount = ctx.ops.size();

		for (int i = 0; i < nodesCount; i++) {
			Ast right = ctx.right.get(i).accept(this);
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "=":
					tempNode = new Eq(tempNode, right);
					break;
				case "<>":
					tempNode = new NotEq(tempNode, right);
					break;
				case ">":
					tempNode = new Sup(tempNode, right);
					break;
				case "<":
					tempNode = new Inf(tempNode, right);
					break;
				case ">=":
					tempNode = new SupEq(tempNode, right);
					break;
				case "<=":
					tempNode = new InfEq(tempNode, right);
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
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "+":
					tempNode = new Add(tempNode, right);
					break;
				case "-":
					tempNode = new Sub(tempNode, right);
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
			String op = ctx.ops.get(i).getText();
			switch (op) {
				case "*":
					tempNode = new Mult(tempNode, right);
					break;
				case "/":
					tempNode = new Div(tempNode, right);
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
		return new IntLiteral(Integer.parseInt(intValue));
	}

	@Override
	public Ast visitStringLitteral(tigerParser.StringLitteralContext ctx) {
		String stringValue = getTokenString(ctx);
		return new StringLiteral(stringValue);
	}

	@Override
	public Ast visitNilLitteral(tigerParser.NilLitteralContext ctx) {
		return new NilLiteral();
	}

	@Override
	public Ast visitBreakLitteral(tigerParser.BreakLitteralContext ctx) {
		return new BreakLiteral();
	}

	@Override
	public Ast visitIdExp(tigerParser.IdExpContext ctx) {
		// CallExp
		if (ctx.isCall != null) {
			ArrayList<Ast> callArgs = new ArrayList<Ast>();
			for (ExpContext exp : ctx.callArgs) {
				callArgs.add(exp.accept(this));
			}
			return new CallExp(new Id(ctx.id.getText()), new CallExpArgs(callArgs));
		}

		// RecCreate
		if (ctx.isRecord != null) {
			ArrayList<Id> fieldIds = new ArrayList<Id>();
			for (Token id : ctx.recIds) {
				fieldIds.add(new Id(id.getText()));
			}

			ArrayList<Ast> fieldValues = new ArrayList<Ast>();
			for (ExpContext exp : ctx.recValues) {
				fieldValues.add(exp.accept(this));
			}

			assert fieldIds.size() == fieldValues.size();

			ArrayList<FieldCreate> fields = new ArrayList<FieldCreate>();
			for (int i = 0; i < fieldIds.size(); i++) {
				fields.add(new FieldCreate(fieldIds.get(i), fieldValues.get(i)));
			}
			return new RecCreate(new TypeId(ctx.id.getText()), new RecCreateFields(fields));
		}

		// ArrCreate
		if (ctx.arrCreateType != null) {
			return new ArrCreate(new TypeId(ctx.id.getText()), ctx.getChild(2).accept(this),
					ctx.arrCreateType.accept(this));
		}

		// Accesses
		int expIndex = 2;
		Ast tempNode = new Id(ctx.id.getText());
		for (Token accessOp : ctx.accessOps) {
			switch (accessOp.getText()) {
				case "[":
					tempNode = new Subscript(tempNode, ctx.getChild(expIndex).accept(this));
					expIndex += 3;
					break;
				case ".":
					tempNode = new FieldExp(tempNode, new Id(ctx.getChild(expIndex).getText()));
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
		return new SeqExp(exps);
	}

	@Override
	public Ast visitNeg(tigerParser.NegContext ctx) {
		Ast expr = ctx.expr.accept(this);
		return new Neg(expr);
	}

	@Override
	public Ast visitIfThen(tigerParser.IfThenContext ctx) {
		Ast condition = ctx.condition.accept(this);
		Ast thenExp = ctx.thenExpr.accept(this);
		ExpContext elseExpContext = ctx.elseExpr;

		if (elseExpContext != null) {
			return new IfThenElse(condition, thenExp, elseExpContext.accept(this));
		} else {
			return new IfThenElse(condition, thenExp, null);
		}

	}

	@Override
	public Ast visitWhileExp(tigerParser.WhileExpContext ctx) {
		Ast condition = ctx.condition.accept(this);
		Ast doExp = ctx.doExpr.accept(this);
		return new WhileExp(condition, doExp);
	}

	@Override
	public Ast visitForExp(tigerParser.ForExpContext ctx) {
		Id forId = new Id(ctx.forId.getText());
		Ast startValue = ctx.startValue.accept(this);
		Ast endValue = ctx.endValue.accept(this);
		Ast doExp = ctx.doExp.accept(this);

		return new ForExp(forId, startValue, endValue, doExp);
	}


	@Override
	public Ast visitLetExp(tigerParser.LetExpContext ctx) {
		ArrayList<Ast> decls = new ArrayList<Ast>();

		for (tigerParser.DecContext decl : ctx.decls) {
			decls.add(decl.accept(this));
		}
		ArrayList<Ast> exps = new ArrayList<Ast>();

		for (tigerParser.ExpContext exp : ctx.inExprs) {
			exps.add(exp.accept(this));
		}

		LetDecls letDecls = new LetDecls(decls);
		LetScope letScope = new LetScope(exps);
		return new LetExp(letDecls, letScope);
	}


	@Override
	public Ast visitDec(tigerParser.DecContext ctx) {
		return skipUnary(ctx);
	}

	@Override
	public Ast visitTypeDec(tigerParser.TypeDecContext ctx) {
		TypeId typeId = new TypeId(ctx.typeId.getText());
		Type typeValue = (Type) ctx.typeValue.accept(this);
		return new TypeDec(typeId, typeValue);
	}

	@Override
	public Ast visitVarDec(tigerParser.VarDecContext ctx) {
		Id varId = new Id(ctx.varId.getText());
		TypeId varType;
		Ast varValue = ctx.varValue.accept(this);

		if (ctx.typeId == null) {
			return new VarDecNoType(varId, varValue);
		} else {
			varType = new TypeId(ctx.typeId.getText());
			return new VarDecType(varId, varType, varValue);
		}
	}

	@Override
	public Ast visitFunDec(tigerParser.FunDecContext ctx) {
		Id functionId = new Id(ctx.functionId.getText());
		ArrayList<FieldDec> funArgsFields = new ArrayList<FieldDec>();
		ArrayList<Id> argNames = new ArrayList<Id>();
		ArrayList<TypeId> argTypes = new ArrayList<TypeId>();
		TypeId returnType;
		Ast functionBody = ctx.body.accept(this);

		for (Token argName : ctx.argNames) {
			argNames.add(new Id(argName.getText()));
		}
		for (Token argType : ctx.argTypes) {
			argTypes.add(new TypeId(argType.getText()));
		}

		assert argNames.size() == argTypes.size();

		for (int i = 0; i < argNames.size(); i++) {
			funArgsFields.add(new FieldDec(argNames.get(i), argTypes.get(i)));
		}
		FunArgs args = new FunArgs(funArgsFields);

		if (ctx.returnType == null) {
			returnType = new TypeId("void");
		} else {
			returnType = new TypeId(ctx.returnType.getText());
		}

		return new FunDec(functionId, args, returnType, functionBody);
	}

	@Override
	public Ast visitTypeId(tigerParser.TypeIdContext ctx) {
		return new TypeId(getTokenString(ctx));
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
		return new ArrType(ctx.typeId.getText());
	}

	@Override
	public Ast visitRecType(tigerParser.RecTypeContext ctx) {
		ArrayList<FieldDec> fields = new ArrayList<FieldDec>();
		ArrayList<Id> fieldNames = new ArrayList<Id>();
		ArrayList<TypeId> fieldTypes = new ArrayList<TypeId>();

		for (Token id : ctx.fieldIds) {
			fieldNames.add(new Id(id.getText()));
		}
		for (Token type : ctx.fieldTypes) {
			fieldTypes.add(new TypeId(type.getText()));
		}
		assert fieldNames.size() == fieldTypes.size();

		for (int i = 0; i < fieldNames.size(); i++) {
			fields.add(new FieldDec(fieldNames.get(i), fieldTypes.get(i)));
		}
		return new RecType(fields);
	}
}
