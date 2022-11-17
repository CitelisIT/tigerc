// Generated from tiger.g4 by ANTLR 4.9.2

	package main.java.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tigerParser}.
 */
public interface tigerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tigerParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tigerParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tigerParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(tigerParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(tigerParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#orExp}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(tigerParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#orExp}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(tigerParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#andExp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(tigerParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#andExp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(tigerParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(tigerParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(tigerParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(tigerParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(tigerParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#multExp}.
	 * @param ctx the parse tree
	 */
	void enterMultExp(tigerParser.MultExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#multExp}.
	 * @param ctx the parse tree
	 */
	void exitMultExp(tigerParser.MultExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#simpleExp}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExp(tigerParser.SimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#simpleExp}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExp(tigerParser.SimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#idExp}.
	 * @param ctx the parse tree
	 */
	void enterIdExp(tigerParser.IdExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#idExp}.
	 * @param ctx the parse tree
	 */
	void exitIdExp(tigerParser.IdExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#seqexp}.
	 * @param ctx the parse tree
	 */
	void enterSeqexp(tigerParser.SeqexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#seqexp}.
	 * @param ctx the parse tree
	 */
	void exitSeqexp(tigerParser.SeqexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(tigerParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(tigerParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#ifThen}.
	 * @param ctx the parse tree
	 */
	void enterIfThen(tigerParser.IfThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#ifThen}.
	 * @param ctx the parse tree
	 */
	void exitIfThen(tigerParser.IfThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#elseRule}.
	 * @param ctx the parse tree
	 */
	void enterElseRule(tigerParser.ElseRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#elseRule}.
	 * @param ctx the parse tree
	 */
	void exitElseRule(tigerParser.ElseRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#whileExp}.
	 * @param ctx the parse tree
	 */
	void enterWhileExp(tigerParser.WhileExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#whileExp}.
	 * @param ctx the parse tree
	 */
	void exitWhileExp(tigerParser.WhileExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#forExp}.
	 * @param ctx the parse tree
	 */
	void enterForExp(tigerParser.ForExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#forExp}.
	 * @param ctx the parse tree
	 */
	void exitForExp(tigerParser.ForExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#letExp}.
	 * @param ctx the parse tree
	 */
	void enterLetExp(tigerParser.LetExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#letExp}.
	 * @param ctx the parse tree
	 */
	void exitLetExp(tigerParser.LetExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#fieldCreate}.
	 * @param ctx the parse tree
	 */
	void enterFieldCreate(tigerParser.FieldCreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#fieldCreate}.
	 * @param ctx the parse tree
	 */
	void exitFieldCreate(tigerParser.FieldCreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(tigerParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(tigerParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#typeDec}.
	 * @param ctx the parse tree
	 */
	void enterTypeDec(tigerParser.TypeDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#typeDec}.
	 * @param ctx the parse tree
	 */
	void exitTypeDec(tigerParser.TypeDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(tigerParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(tigerParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#varDecFact}.
	 * @param ctx the parse tree
	 */
	void enterVarDecFact(tigerParser.VarDecFactContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#varDecFact}.
	 * @param ctx the parse tree
	 */
	void exitVarDecFact(tigerParser.VarDecFactContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#funDec}.
	 * @param ctx the parse tree
	 */
	void enterFunDec(tigerParser.FunDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#funDec}.
	 * @param ctx the parse tree
	 */
	void exitFunDec(tigerParser.FunDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(tigerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(tigerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#arrType}.
	 * @param ctx the parse tree
	 */
	void enterArrType(tigerParser.ArrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#arrType}.
	 * @param ctx the parse tree
	 */
	void exitArrType(tigerParser.ArrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tigerParser#recType}.
	 * @param ctx the parse tree
	 */
	void enterRecType(tigerParser.RecTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tigerParser#recType}.
	 * @param ctx the parse tree
	 */
	void exitRecType(tigerParser.RecTypeContext ctx);
}