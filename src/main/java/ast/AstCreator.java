// Generated from tiger.g4 by ANTLR 4.9.2

package ast;

import parser.tigerParser;
import parser.tigerBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;


public class AstCreator extends tigerBaseVisitor<Ast> {

	private String getTokenString(ParserRuleContext ctx) {
		return ctx.getChild(0).toString();
	}

	private Ast skipUnary(ParserRuleContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	@Override
	public Ast visitProgram(tigerParser.ProgramContext ctx) {
		return visitChildren(ctx);
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitSimpleExp(tigerParser.SimpleExpContext ctx) {
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
	public Ast visitIntLitteral(tigerParser.IntLitteralContext ctx) {
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
	public Ast visitStringLitteral(tigerParser.StringLitteralContext ctx) {
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
	public Ast visitNilLitteral(tigerParser.NilLitteralContext ctx) {
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
	public Ast visitBreakLitteral(tigerParser.BreakLitteralContext ctx) {
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitCallExp(tigerParser.CallExpContext ctx) {
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitRecCreateExp(tigerParser.RecCreateExpContext ctx) {
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
	public Ast visitSeqExp(tigerParser.SeqExpContext ctx) {
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
	public Ast visitNeg(tigerParser.NegContext ctx) {
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
	public Ast visitIfThen(tigerParser.IfThenContext ctx) {
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
	public Ast visitWhileExp(tigerParser.WhileExpContext ctx) {
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
	public Ast visitForExp(tigerParser.ForExpContext ctx) {
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
	public Ast visitLetExp(tigerParser.LetExpContext ctx) {
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
	public Ast visitDec(tigerParser.DecContext ctx) {
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
	public Ast visitTypeDec(tigerParser.TypeDecContext ctx) {
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling {@link #visitChildren} on
	 * {@code ctx}.
	 * </p>
	 */
	@Override
	public Ast visitArrType(tigerParser.ArrTypeContext ctx) {
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
	public Ast visitRecType(tigerParser.RecTypeContext ctx) {
		return visitChildren(ctx);
	}
}
