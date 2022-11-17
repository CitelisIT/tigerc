// Generated from tiger.g4 by ANTLR 4.9.2

	package main.java.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tigerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tigerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tigerParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(tigerParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(tigerParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#orExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExp(tigerParser.OrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#andExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(tigerParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(tigerParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(tigerParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#multExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExp(tigerParser.MultExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#simpleExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExp(tigerParser.SimpleExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#idExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExp(tigerParser.IdExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#seqexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqexp(tigerParser.SeqexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(tigerParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#ifThen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(tigerParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#elseRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseRule(tigerParser.ElseRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#whileExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExp(tigerParser.WhileExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#forExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExp(tigerParser.ForExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#letExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExp(tigerParser.LetExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#fieldCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldCreate(tigerParser.FieldCreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(tigerParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#typeDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDec(tigerParser.TypeDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(tigerParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#varDecFact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecFact(tigerParser.VarDecFactContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDec(tigerParser.FunDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(tigerParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#arrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrType(tigerParser.ArrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tigerParser#recType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecType(tigerParser.RecTypeContext ctx);
}