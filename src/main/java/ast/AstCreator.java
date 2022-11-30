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
		return visitChildren(ctx);
	}


	@Override
	public Ast visitOrExp(tigerParser.OrExpContext ctx) {
		return visitChildren(ctx);
	}


	@Override
	public Ast visitAndExp(tigerParser.AndExpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitEqExp(tigerParser.EqExpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitAddExp(tigerParser.AddExpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitMultExp(tigerParser.MultExpContext ctx) {
		return visitChildren(ctx);
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitIdExp(tigerParser.IdExpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitIdEndExp(tigerParser.IdEndExpContext ctx) {
		return visitChildren(ctx);
	}


	@Override
	public Ast visitCallExp(tigerParser.CallExpContext ctx) {
		ArrayList<Ast> args = new ArrayList<Ast>();

		for (ExpContext arg : ctx.args) {
			args.add(arg.accept(this));
		}

		return new CallExpArgs(args);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitBracketExp(tigerParser.BracketExpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitBracketExpAccess(tigerParser.BracketExpAccessContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitArrCreateEnd(tigerParser.ArrCreateEndContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitArrayAccess(tigerParser.ArrayAccessContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitRecordAccess(tigerParser.RecordAccessContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitRecAccessExp(tigerParser.RecAccessExpContext ctx) {
		return visitChildren(ctx);
	}


	@Override
	public Ast visitRecCreateExp(tigerParser.RecCreateExpContext ctx) {
		ArrayList<FieldCreate> fields = new ArrayList<FieldCreate>();
		ArrayList<Id> fieldIds = new ArrayList<Id>();
		ArrayList<Ast> fieldExps = new ArrayList<Ast>();

		for (Token fieldId : ctx.fieldIds) {
			fieldIds.add(new Id(fieldId.getText()));
		}
		for (ExpContext exp : ctx.fieldValues) {
			fieldExps.add(exp.accept(this));
		}
		assert fieldExps.size() == fieldIds.size();

		for (int i = 0; i < fieldIds.size(); i++) {
			fields.add(new FieldCreate(fieldIds.get(i), fieldExps.get(i)));
		}
		return new RecCreateFields(fields);
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
		Ast elseExp = ctx.elseExpr.accept(this);

		if (elseExp != null) {
			return new IfThenElse(condition, thenExp, elseExp);
		} else {
			return new IfThen(condition, thenExp);
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
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitVarDecNoType(tigerParser.VarDecNoTypeContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitVarDecWithType(tigerParser.VarDecWithTypeContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitFunDec(tigerParser.FunDecContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitFunDecNoType(tigerParser.FunDecNoTypeContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitFunDecWithType(tigerParser.FunDecWithTypeContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitType(tigerParser.TypeContext ctx) {
		return visitChildren(ctx);
	}


	@Override
	public Ast visitArrType(tigerParser.ArrTypeContext ctx) {
		TypeId name = new TypeId(ctx.typeId.getText());
		return new ArrType(name);
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
