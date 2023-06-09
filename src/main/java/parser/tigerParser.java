// Generated from tiger.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tigerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, KEYWORD=41, ID=42, INT=43, STRING=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_exp = 1, RULE_orExp = 2, RULE_andExp = 3, RULE_eqExp = 4, 
		RULE_addExp = 5, RULE_multExp = 6, RULE_simpleExp = 7, RULE_litteralExp = 8, 
		RULE_idExp = 9, RULE_seqExp = 10, RULE_neg = 11, RULE_ifThen = 12, RULE_whileExp = 13, 
		RULE_forExp = 14, RULE_letExp = 15, RULE_dec = 16, RULE_typeDec = 17, 
		RULE_typeDecs = 18, RULE_varDec = 19, RULE_funDec = 20, RULE_type = 21, 
		RULE_complexType = 22, RULE_arrType = 23, RULE_recType = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "exp", "orExp", "andExp", "eqExp", "addExp", "multExp", "simpleExp", 
			"litteralExp", "idExp", "seqExp", "neg", "ifThen", "whileExp", "forExp", 
			"letExp", "dec", "typeDec", "typeDecs", "varDec", "funDec", "type", "complexType", 
			"arrType", "recType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'|'", "'&'", "'='", "'<>'", "'>'", "'<'", "'>='", "'<='", 
			"'+'", "'-'", "'*'", "'/'", "'nil'", "'break'", "'('", "','", "')'", 
			"'['", "']'", "'.'", "'of'", "'{'", "'}'", "';'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "'for'", "'to'", "'let'", "'in'", "'end'", "'type'", 
			"'var'", "':'", "'function'", "'array'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "KEYWORD", "ID", "INT", "STRING", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "tiger.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tigerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode EOF() { return getToken(tigerParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			exp();
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public OrExpContext first;
		public OrExpContext right;
		public List<OrExpContext> orExp() {
			return getRuleContexts(OrExpContext.class);
		}
		public OrExpContext orExp(int i) {
			return getRuleContext(OrExpContext.class,i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			((ExpContext)_localctx).first = orExp();
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(54);
				match(T__0);
				setState(55);
				((ExpContext)_localctx).right = orExp();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpContext extends ParserRuleContext {
		public AndExpContext first;
		public AndExpContext andExp;
		public List<AndExpContext> right = new ArrayList<AndExpContext>();
		public List<AndExpContext> andExp() {
			return getRuleContexts(AndExpContext.class);
		}
		public AndExpContext andExp(int i) {
			return getRuleContext(AndExpContext.class,i);
		}
		public OrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitOrExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpContext orExp() throws RecognitionException {
		OrExpContext _localctx = new OrExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_orExp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((OrExpContext)_localctx).first = andExp();
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(59);
				match(T__1);
				setState(60);
				((OrExpContext)_localctx).andExp = andExp();
				((OrExpContext)_localctx).right.add(((OrExpContext)_localctx).andExp);
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(61);
						match(T__1);
						setState(62);
						((OrExpContext)_localctx).andExp = andExp();
						((OrExpContext)_localctx).right.add(((OrExpContext)_localctx).andExp);
						}
						} 
					}
					setState(67);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpContext extends ParserRuleContext {
		public EqExpContext first;
		public EqExpContext eqExp;
		public List<EqExpContext> right = new ArrayList<EqExpContext>();
		public List<EqExpContext> eqExp() {
			return getRuleContexts(EqExpContext.class);
		}
		public EqExpContext eqExp(int i) {
			return getRuleContext(EqExpContext.class,i);
		}
		public AndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitAndExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpContext andExp() throws RecognitionException {
		AndExpContext _localctx = new AndExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_andExp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((AndExpContext)_localctx).first = eqExp();
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(71);
				match(T__2);
				setState(72);
				((AndExpContext)_localctx).eqExp = eqExp();
				((AndExpContext)_localctx).right.add(((AndExpContext)_localctx).eqExp);
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(73);
						match(T__2);
						setState(74);
						((AndExpContext)_localctx).eqExp = eqExp();
						((AndExpContext)_localctx).right.add(((AndExpContext)_localctx).eqExp);
						}
						} 
					}
					setState(79);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqExpContext extends ParserRuleContext {
		public AddExpContext first;
		public Token s4;
		public List<Token> ops = new ArrayList<Token>();
		public Token s5;
		public Token s6;
		public Token s7;
		public Token s8;
		public Token s9;
		public Token _tset100;
		public AddExpContext addExp;
		public List<AddExpContext> right = new ArrayList<AddExpContext>();
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public EqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExpContext eqExp() throws RecognitionException {
		EqExpContext _localctx = new EqExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eqExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((EqExpContext)_localctx).first = addExp();
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(83);
				((EqExpContext)_localctx)._tset100 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
					((EqExpContext)_localctx)._tset100 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((EqExpContext)_localctx).ops.add(((EqExpContext)_localctx)._tset100);
				setState(84);
				((EqExpContext)_localctx).addExp = addExp();
				((EqExpContext)_localctx).right.add(((EqExpContext)_localctx).addExp);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExpContext extends ParserRuleContext {
		public MultExpContext first;
		public Token s10;
		public List<Token> ops = new ArrayList<Token>();
		public Token s11;
		public Token _tset142;
		public MultExpContext multExp;
		public List<MultExpContext> right = new ArrayList<MultExpContext>();
		public List<MultExpContext> multExp() {
			return getRuleContexts(MultExpContext.class);
		}
		public MultExpContext multExp(int i) {
			return getRuleContext(MultExpContext.class,i);
		}
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitAddExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpContext addExp() throws RecognitionException {
		AddExpContext _localctx = new AddExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_addExp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((AddExpContext)_localctx).first = multExp();
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					((AddExpContext)_localctx)._tset142 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__9 || _la==T__10) ) {
						((AddExpContext)_localctx)._tset142 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((AddExpContext)_localctx).ops.add(((AddExpContext)_localctx)._tset142);
					setState(89);
					((AddExpContext)_localctx).multExp = multExp();
					((AddExpContext)_localctx).right.add(((AddExpContext)_localctx).multExp);
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExpContext extends ParserRuleContext {
		public SimpleExpContext first;
		public Token s12;
		public List<Token> ops = new ArrayList<Token>();
		public Token s13;
		public Token _tset168;
		public SimpleExpContext simpleExp;
		public List<SimpleExpContext> right = new ArrayList<SimpleExpContext>();
		public List<SimpleExpContext> simpleExp() {
			return getRuleContexts(SimpleExpContext.class);
		}
		public SimpleExpContext simpleExp(int i) {
			return getRuleContext(SimpleExpContext.class,i);
		}
		public MultExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitMultExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExpContext multExp() throws RecognitionException {
		MultExpContext _localctx = new MultExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multExp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((MultExpContext)_localctx).first = simpleExp();
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					((MultExpContext)_localctx)._tset168 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__11 || _la==T__12) ) {
						((MultExpContext)_localctx)._tset168 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((MultExpContext)_localctx).ops.add(((MultExpContext)_localctx)._tset168);
					setState(97);
					((MultExpContext)_localctx).simpleExp = simpleExp();
					((MultExpContext)_localctx).right.add(((MultExpContext)_localctx).simpleExp);
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpContext extends ParserRuleContext {
		public SeqExpContext seqExp() {
			return getRuleContext(SeqExpContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public IdExpContext idExp() {
			return getRuleContext(IdExpContext.class,0);
		}
		public IfThenContext ifThen() {
			return getRuleContext(IfThenContext.class,0);
		}
		public WhileExpContext whileExp() {
			return getRuleContext(WhileExpContext.class,0);
		}
		public ForExpContext forExp() {
			return getRuleContext(ForExpContext.class,0);
		}
		public LetExpContext letExp() {
			return getRuleContext(LetExpContext.class,0);
		}
		public LitteralExpContext litteralExp() {
			return getRuleContext(LitteralExpContext.class,0);
		}
		public SimpleExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitSimpleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpContext simpleExp() throws RecognitionException {
		SimpleExpContext _localctx = new SimpleExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simpleExp);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				seqExp();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				neg();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				idExp();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				ifThen();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				whileExp();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				forExp();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				letExp();
				}
				break;
			case T__13:
			case T__14:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				litteralExp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LitteralExpContext extends ParserRuleContext {
		public LitteralExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litteralExp; }
	 
		public LitteralExpContext() { }
		public void copyFrom(LitteralExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLitteralContext extends LitteralExpContext {
		public TerminalNode STRING() { return getToken(tigerParser.STRING, 0); }
		public StringLitteralContext(LitteralExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitStringLitteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLitteralContext extends LitteralExpContext {
		public TerminalNode INT() { return getToken(tigerParser.INT, 0); }
		public IntLitteralContext(LitteralExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitIntLitteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakLitteralContext extends LitteralExpContext {
		public BreakLitteralContext(LitteralExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitBreakLitteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NilLitteralContext extends LitteralExpContext {
		public NilLitteralContext(LitteralExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitNilLitteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitteralExpContext litteralExp() throws RecognitionException {
		LitteralExpContext _localctx = new LitteralExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_litteralExp);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntLitteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new StringLitteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(STRING);
				}
				break;
			case T__13:
				_localctx = new NilLitteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new BreakLitteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdExpContext extends ParserRuleContext {
		public Token id;
		public Token isCall;
		public ExpContext exp;
		public List<ExpContext> callArgs = new ArrayList<ExpContext>();
		public Token s19;
		public List<Token> accessOps = new ArrayList<Token>();
		public Token s21;
		public ExpContext arrCreateType;
		public Token isRecord;
		public Token ID;
		public List<Token> recIds = new ArrayList<Token>();
		public List<ExpContext> recValues = new ArrayList<ExpContext>();
		public List<TerminalNode> ID() { return getTokens(tigerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tigerParser.ID, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IdExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitIdExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdExpContext idExp() throws RecognitionException {
		IdExpContext _localctx = new IdExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_idExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((IdExpContext)_localctx).id = match(ID);
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(120);
				((IdExpContext)_localctx).isCall = match(T__15);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__25) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
					{
					setState(121);
					((IdExpContext)_localctx).exp = exp();
					((IdExpContext)_localctx).callArgs.add(((IdExpContext)_localctx).exp);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(122);
						match(T__16);
						setState(123);
						((IdExpContext)_localctx).exp = exp();
						((IdExpContext)_localctx).callArgs.add(((IdExpContext)_localctx).exp);
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(131);
				match(T__17);
				}
				break;
			case T__18:
				{
				setState(132);
				((IdExpContext)_localctx).s19 = match(T__18);
				((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s19);
				setState(133);
				exp();
				setState(134);
				match(T__19);
				setState(148);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EOF:
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__23:
				case T__24:
				case T__26:
				case T__27:
				case T__29:
				case T__31:
				case T__33:
				case T__34:
				case T__35:
				case T__36:
				case T__38:
					{
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__18 || _la==T__20) {
						{
						setState(141);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__18:
							{
							setState(135);
							((IdExpContext)_localctx).s19 = match(T__18);
							((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s19);
							setState(136);
							exp();
							setState(137);
							match(T__19);
							}
							break;
						case T__20:
							{
							setState(139);
							((IdExpContext)_localctx).s21 = match(T__20);
							((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s21);
							setState(140);
							match(ID);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__21:
					{
					setState(146);
					match(T__21);
					setState(147);
					((IdExpContext)_localctx).arrCreateType = exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__20:
				{
				setState(150);
				((IdExpContext)_localctx).s21 = match(T__20);
				((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s21);
				setState(151);
				match(ID);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18 || _la==T__20) {
					{
					setState(158);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__18:
						{
						setState(152);
						((IdExpContext)_localctx).s19 = match(T__18);
						((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s19);
						setState(153);
						exp();
						setState(154);
						match(T__19);
						}
						break;
					case T__20:
						{
						setState(156);
						((IdExpContext)_localctx).s21 = match(T__20);
						((IdExpContext)_localctx).accessOps.add(((IdExpContext)_localctx).s21);
						setState(157);
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__22:
				{
				setState(163);
				((IdExpContext)_localctx).isRecord = match(T__22);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(164);
					((IdExpContext)_localctx).ID = match(ID);
					((IdExpContext)_localctx).recIds.add(((IdExpContext)_localctx).ID);
					setState(165);
					match(T__3);
					setState(166);
					((IdExpContext)_localctx).exp = exp();
					((IdExpContext)_localctx).recValues.add(((IdExpContext)_localctx).exp);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(167);
						match(T__16);
						setState(168);
						((IdExpContext)_localctx).ID = match(ID);
						((IdExpContext)_localctx).recIds.add(((IdExpContext)_localctx).ID);
						setState(169);
						match(T__3);
						setState(170);
						((IdExpContext)_localctx).exp = exp();
						((IdExpContext)_localctx).recValues.add(((IdExpContext)_localctx).exp);
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(178);
				match(T__23);
				}
				break;
			case EOF:
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__16:
			case T__17:
			case T__19:
			case T__23:
			case T__24:
			case T__26:
			case T__27:
			case T__29:
			case T__31:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__38:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeqExpContext extends ParserRuleContext {
		public ExpContext exp;
		public List<ExpContext> exprs = new ArrayList<ExpContext>();
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitSeqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqExpContext seqExp() throws RecognitionException {
		SeqExpContext _localctx = new SeqExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_seqExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__15);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__25) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(182);
				((SeqExpContext)_localctx).exp = exp();
				((SeqExpContext)_localctx).exprs.add(((SeqExpContext)_localctx).exp);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(183);
					match(T__24);
					setState(184);
					((SeqExpContext)_localctx).exp = exp();
					((SeqExpContext)_localctx).exprs.add(((SeqExpContext)_localctx).exp);
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(192);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegContext extends ParserRuleContext {
		public SimpleExpContext expr;
		public SimpleExpContext simpleExp() {
			return getRuleContext(SimpleExpContext.class,0);
		}
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__10);
			setState(195);
			((NegContext)_localctx).expr = simpleExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenContext extends ParserRuleContext {
		public ExpContext condition;
		public ExpContext thenExpr;
		public ExpContext elseExpr;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThen; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitIfThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenContext ifThen() throws RecognitionException {
		IfThenContext _localctx = new IfThenContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifThen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__25);
			setState(198);
			((IfThenContext)_localctx).condition = exp();
			setState(199);
			match(T__26);
			setState(200);
			((IfThenContext)_localctx).thenExpr = exp();
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(201);
				match(T__27);
				setState(202);
				((IfThenContext)_localctx).elseExpr = exp();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileExpContext extends ParserRuleContext {
		public ExpContext condition;
		public ExpContext doExpr;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public WhileExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitWhileExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileExpContext whileExp() throws RecognitionException {
		WhileExpContext _localctx = new WhileExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__28);
			setState(206);
			((WhileExpContext)_localctx).condition = exp();
			setState(207);
			match(T__29);
			setState(208);
			((WhileExpContext)_localctx).doExpr = exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForExpContext extends ParserRuleContext {
		public Token forId;
		public ExpContext startValue;
		public ExpContext endValue;
		public ExpContext doExp;
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ForExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitForExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExpContext forExp() throws RecognitionException {
		ForExpContext _localctx = new ForExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__30);
			setState(211);
			((ForExpContext)_localctx).forId = match(ID);
			setState(212);
			match(T__0);
			setState(213);
			((ForExpContext)_localctx).startValue = exp();
			setState(214);
			match(T__31);
			setState(215);
			((ForExpContext)_localctx).endValue = exp();
			setState(216);
			match(T__29);
			setState(217);
			((ForExpContext)_localctx).doExp = exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetExpContext extends ParserRuleContext {
		public DecContext dec;
		public List<DecContext> decls = new ArrayList<DecContext>();
		public Token inToken;
		public ExpContext exp;
		public List<ExpContext> inExprs = new ArrayList<ExpContext>();
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LetExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitLetExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExpContext letExp() throws RecognitionException {
		LetExpContext _localctx = new LetExpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_letExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__32);
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(220);
				((LetExpContext)_localctx).dec = dec();
				((LetExpContext)_localctx).decls.add(((LetExpContext)_localctx).dec);
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__38))) != 0) );
			setState(225);
			((LetExpContext)_localctx).inToken = match(T__33);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__25) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(226);
				((LetExpContext)_localctx).exp = exp();
				((LetExpContext)_localctx).inExprs.add(((LetExpContext)_localctx).exp);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(227);
					match(T__24);
					setState(228);
					((LetExpContext)_localctx).exp = exp();
					((LetExpContext)_localctx).inExprs.add(((LetExpContext)_localctx).exp);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(236);
			match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecContext extends ParserRuleContext {
		public TypeDecsContext typeDecs() {
			return getRuleContext(TypeDecsContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public FunDecContext funDec() {
			return getRuleContext(FunDecContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dec);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				typeDecs();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				varDec();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				funDec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDecContext extends ParserRuleContext {
		public Token typeId;
		public TypeContext typeValue;
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitTypeDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDecContext typeDec() throws RecognitionException {
		TypeDecContext _localctx = new TypeDecContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__35);
			setState(244);
			((TypeDecContext)_localctx).typeId = match(ID);
			setState(245);
			match(T__3);
			setState(246);
			((TypeDecContext)_localctx).typeValue = type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDecsContext extends ParserRuleContext {
		public TypeDecContext typeDec;
		public List<TypeDecContext> tydecs = new ArrayList<TypeDecContext>();
		public List<TypeDecContext> typeDec() {
			return getRuleContexts(TypeDecContext.class);
		}
		public TypeDecContext typeDec(int i) {
			return getRuleContext(TypeDecContext.class,i);
		}
		public TypeDecsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitTypeDecs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDecsContext typeDecs() throws RecognitionException {
		TypeDecsContext _localctx = new TypeDecsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeDecs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(248);
					((TypeDecsContext)_localctx).typeDec = typeDec();
					((TypeDecsContext)_localctx).tydecs.add(((TypeDecsContext)_localctx).typeDec);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(251); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecContext extends ParserRuleContext {
		public Token varId;
		public Token typeId;
		public ExpContext varValue;
		public List<TerminalNode> ID() { return getTokens(tigerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tigerParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__36);
			setState(254);
			((VarDecContext)_localctx).varId = match(ID);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(255);
				match(T__37);
				setState(256);
				((VarDecContext)_localctx).typeId = match(ID);
				}
			}

			setState(259);
			match(T__0);
			setState(260);
			((VarDecContext)_localctx).varValue = exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDecContext extends ParserRuleContext {
		public Token functionId;
		public Token callParen;
		public Token ID;
		public List<Token> argNames = new ArrayList<Token>();
		public List<Token> argTypes = new ArrayList<Token>();
		public Token endParen;
		public Token returnType;
		public ExpContext body;
		public List<TerminalNode> ID() { return getTokens(tigerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tigerParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FunDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitFunDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDecContext funDec() throws RecognitionException {
		FunDecContext _localctx = new FunDecContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__38);
			setState(263);
			((FunDecContext)_localctx).functionId = match(ID);
			setState(264);
			((FunDecContext)_localctx).callParen = match(T__15);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(265);
				((FunDecContext)_localctx).ID = match(ID);
				((FunDecContext)_localctx).argNames.add(((FunDecContext)_localctx).ID);
				setState(266);
				match(T__37);
				setState(267);
				((FunDecContext)_localctx).ID = match(ID);
				((FunDecContext)_localctx).argTypes.add(((FunDecContext)_localctx).ID);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(268);
					match(T__16);
					setState(269);
					((FunDecContext)_localctx).ID = match(ID);
					((FunDecContext)_localctx).argNames.add(((FunDecContext)_localctx).ID);
					setState(270);
					match(T__37);
					setState(271);
					((FunDecContext)_localctx).ID = match(ID);
					((FunDecContext)_localctx).argTypes.add(((FunDecContext)_localctx).ID);
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(279);
			((FunDecContext)_localctx).endParen = match(T__17);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(280);
				match(T__37);
				setState(281);
				((FunDecContext)_localctx).returnType = match(ID);
				}
			}

			setState(284);
			match(T__3);
			setState(285);
			((FunDecContext)_localctx).body = exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeIdContext extends TypeContext {
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public TypeIdContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompositeTypeContext extends TypeContext {
		public ComplexTypeContext complexType() {
			return getRuleContext(ComplexTypeContext.class,0);
		}
		public CompositeTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitCompositeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new TypeIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(ID);
				}
				break;
			case T__22:
			case T__39:
				_localctx = new CompositeTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				complexType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexTypeContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public RecTypeContext recType() {
			return getRuleContext(RecTypeContext.class,0);
		}
		public ComplexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitComplexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexTypeContext complexType() throws RecognitionException {
		ComplexTypeContext _localctx = new ComplexTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_complexType);
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				arrType();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				recType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrTypeContext extends ParserRuleContext {
		public Token typeId;
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public ArrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitArrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrTypeContext arrType() throws RecognitionException {
		ArrTypeContext _localctx = new ArrTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__39);
			setState(296);
			match(T__21);
			setState(297);
			((ArrTypeContext)_localctx).typeId = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecTypeContext extends ParserRuleContext {
		public Token ID;
		public List<Token> fieldIds = new ArrayList<Token>();
		public List<Token> fieldTypes = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(tigerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tigerParser.ID, i);
		}
		public RecTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitRecType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecTypeContext recType() throws RecognitionException {
		RecTypeContext _localctx = new RecTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_recType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(T__22);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(300);
				((RecTypeContext)_localctx).ID = match(ID);
				((RecTypeContext)_localctx).fieldIds.add(((RecTypeContext)_localctx).ID);
				setState(301);
				match(T__37);
				setState(302);
				((RecTypeContext)_localctx).ID = match(ID);
				((RecTypeContext)_localctx).fieldTypes.add(((RecTypeContext)_localctx).ID);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(303);
					match(T__16);
					setState(304);
					((RecTypeContext)_localctx).ID = match(ID);
					((RecTypeContext)_localctx).fieldIds.add(((RecTypeContext)_localctx).ID);
					setState(305);
					match(T__37);
					setState(306);
					((RecTypeContext)_localctx).ID = match(ID);
					((RecTypeContext)_localctx).fieldTypes.add(((RecTypeContext)_localctx).ID);
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(314);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u013f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\7\4B\n"+
		"\4\f\4\16\4E\13\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5"+
		"\5\5S\n\5\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b"+
		"\3\b\3\b\7\be\n\b\f\b\16\bh\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tr"+
		"\n\t\3\n\3\n\3\n\3\n\5\nx\n\n\3\13\3\13\3\13\3\13\3\13\7\13\177\n\13\f"+
		"\13\16\13\u0082\13\13\5\13\u0084\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u0090\n\13\f\13\16\13\u0093\13\13\3\13\3\13\5"+
		"\13\u0097\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a1\n\13"+
		"\f\13\16\13\u00a4\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ae"+
		"\n\13\f\13\16\13\u00b1\13\13\5\13\u00b3\n\13\3\13\5\13\u00b6\n\13\3\f"+
		"\3\f\3\f\3\f\7\f\u00bc\n\f\f\f\16\f\u00bf\13\f\5\f\u00c1\n\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ce\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\6\21"+
		"\u00e0\n\21\r\21\16\21\u00e1\3\21\3\21\3\21\3\21\7\21\u00e8\n\21\f\21"+
		"\16\21\u00eb\13\21\5\21\u00ed\n\21\3\21\3\21\3\22\3\22\3\22\5\22\u00f4"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u00fc\n\24\r\24\16\24\u00fd\3"+
		"\25\3\25\3\25\3\25\5\25\u0104\n\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0113\n\26\f\26\16\26\u0116\13\26"+
		"\5\26\u0118\n\26\3\26\3\26\3\26\5\26\u011d\n\26\3\26\3\26\3\26\3\27\3"+
		"\27\5\27\u0124\n\27\3\30\3\30\5\30\u0128\n\30\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0136\n\32\f\32\16\32\u0139\13"+
		"\32\5\32\u013b\n\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\2\5\3\2\6\13\3\2\f\r\3\2\16\17\2\u0155\2\64\3"+
		"\2\2\2\4\67\3\2\2\2\6<\3\2\2\2\bH\3\2\2\2\nT\3\2\2\2\fY\3\2\2\2\16a\3"+
		"\2\2\2\20q\3\2\2\2\22w\3\2\2\2\24y\3\2\2\2\26\u00b7\3\2\2\2\30\u00c4\3"+
		"\2\2\2\32\u00c7\3\2\2\2\34\u00cf\3\2\2\2\36\u00d4\3\2\2\2 \u00dd\3\2\2"+
		"\2\"\u00f3\3\2\2\2$\u00f5\3\2\2\2&\u00fb\3\2\2\2(\u00ff\3\2\2\2*\u0108"+
		"\3\2\2\2,\u0123\3\2\2\2.\u0127\3\2\2\2\60\u0129\3\2\2\2\62\u012d\3\2\2"+
		"\2\64\65\5\4\3\2\65\66\7\2\2\3\66\3\3\2\2\2\67:\5\6\4\289\7\3\2\29;\5"+
		"\6\4\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<F\5\b\5\2=>\7\4\2\2>C\5\b\5\2?@"+
		"\7\4\2\2@B\5\b\5\2A?\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2E"+
		"C\3\2\2\2F=\3\2\2\2FG\3\2\2\2G\7\3\2\2\2HR\5\n\6\2IJ\7\5\2\2JO\5\n\6\2"+
		"KL\7\5\2\2LN\5\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2"+
		"QO\3\2\2\2RI\3\2\2\2RS\3\2\2\2S\t\3\2\2\2TW\5\f\7\2UV\t\2\2\2VX\5\f\7"+
		"\2WU\3\2\2\2WX\3\2\2\2X\13\3\2\2\2Y^\5\16\b\2Z[\t\3\2\2[]\5\16\b\2\\Z"+
		"\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\r\3\2\2\2`^\3\2\2\2af\5\20\t"+
		"\2bc\t\4\2\2ce\5\20\t\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\17\3"+
		"\2\2\2hf\3\2\2\2ir\5\26\f\2jr\5\30\r\2kr\5\24\13\2lr\5\32\16\2mr\5\34"+
		"\17\2nr\5\36\20\2or\5 \21\2pr\5\22\n\2qi\3\2\2\2qj\3\2\2\2qk\3\2\2\2q"+
		"l\3\2\2\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\21\3\2\2\2sx\7-\2\2"+
		"tx\7.\2\2ux\7\20\2\2vx\7\21\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2"+
		"\2x\23\3\2\2\2y\u00b5\7,\2\2z\u0083\7\22\2\2{\u0080\5\4\3\2|}\7\23\2\2"+
		"}\177\5\4\3\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083{\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u00b6\7\24\2\2\u0086\u0087\7\25\2\2"+
		"\u0087\u0088\5\4\3\2\u0088\u0096\7\26\2\2\u0089\u008a\7\25\2\2\u008a\u008b"+
		"\5\4\3\2\u008b\u008c\7\26\2\2\u008c\u0090\3\2\2\2\u008d\u008e\7\27\2\2"+
		"\u008e\u0090\7,\2\2\u008f\u0089\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0093"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0097\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0095\7\30\2\2\u0095\u0097\5\4\3\2\u0096\u0091\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0097\u00b6\3\2\2\2\u0098\u0099\7\27\2\2\u0099"+
		"\u00a2\7,\2\2\u009a\u009b\7\25\2\2\u009b\u009c\5\4\3\2\u009c\u009d\7\26"+
		"\2\2\u009d\u00a1\3\2\2\2\u009e\u009f\7\27\2\2\u009f\u00a1\7,\2\2\u00a0"+
		"\u009a\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00b6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00b2\7\31\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00af\5\4"+
		"\3\2\u00a9\u00aa\7\23\2\2\u00aa\u00ab\7,\2\2\u00ab\u00ac\7\6\2\2\u00ac"+
		"\u00ae\5\4\3\2\u00ad\u00a9\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00a6\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\7\32"+
		"\2\2\u00b5z\3\2\2\2\u00b5\u0086\3\2\2\2\u00b5\u0098\3\2\2\2\u00b5\u00a5"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\25\3\2\2\2\u00b7\u00c0\7\22\2\2\u00b8"+
		"\u00bd\5\4\3\2\u00b9\u00ba\7\33\2\2\u00ba\u00bc\5\4\3\2\u00bb\u00b9\3"+
		"\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7\24\2\2\u00c3\27\3\2\2\2\u00c4\u00c5"+
		"\7\r\2\2\u00c5\u00c6\5\20\t\2\u00c6\31\3\2\2\2\u00c7\u00c8\7\34\2\2\u00c8"+
		"\u00c9\5\4\3\2\u00c9\u00ca\7\35\2\2\u00ca\u00cd\5\4\3\2\u00cb\u00cc\7"+
		"\36\2\2\u00cc\u00ce\5\4\3\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\33\3\2\2\2\u00cf\u00d0\7\37\2\2\u00d0\u00d1\5\4\3\2\u00d1\u00d2\7 \2"+
		"\2\u00d2\u00d3\5\4\3\2\u00d3\35\3\2\2\2\u00d4\u00d5\7!\2\2\u00d5\u00d6"+
		"\7,\2\2\u00d6\u00d7\7\3\2\2\u00d7\u00d8\5\4\3\2\u00d8\u00d9\7\"\2\2\u00d9"+
		"\u00da\5\4\3\2\u00da\u00db\7 \2\2\u00db\u00dc\5\4\3\2\u00dc\37\3\2\2\2"+
		"\u00dd\u00df\7#\2\2\u00de\u00e0\5\"\22\2\u00df\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00ec\7$\2\2\u00e4\u00e9\5\4\3\2\u00e5\u00e6\7\33\2\2\u00e6\u00e8\5\4"+
		"\3\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7%\2\2\u00ef"+
		"!\3\2\2\2\u00f0\u00f4\5&\24\2\u00f1\u00f4\5(\25\2\u00f2\u00f4\5*\26\2"+
		"\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4#\3"+
		"\2\2\2\u00f5\u00f6\7&\2\2\u00f6\u00f7\7,\2\2\u00f7\u00f8\7\6\2\2\u00f8"+
		"\u00f9\5,\27\2\u00f9%\3\2\2\2\u00fa\u00fc\5$\23\2\u00fb\u00fa\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\'\3"+
		"\2\2\2\u00ff\u0100\7\'\2\2\u0100\u0103\7,\2\2\u0101\u0102\7(\2\2\u0102"+
		"\u0104\7,\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0106\7\3\2\2\u0106\u0107\5\4\3\2\u0107)\3\2\2\2\u0108\u0109"+
		"\7)\2\2\u0109\u010a\7,\2\2\u010a\u0117\7\22\2\2\u010b\u010c\7,\2\2\u010c"+
		"\u010d\7(\2\2\u010d\u0114\7,\2\2\u010e\u010f\7\23\2\2\u010f\u0110\7,\2"+
		"\2\u0110\u0111\7(\2\2\u0111\u0113\7,\2\2\u0112\u010e\3\2\2\2\u0113\u0116"+
		"\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0117\u010b\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011c\7\24\2\2\u011a\u011b\7(\2\2\u011b\u011d\7,\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\6"+
		"\2\2\u011f\u0120\5\4\3\2\u0120+\3\2\2\2\u0121\u0124\7,\2\2\u0122\u0124"+
		"\5.\30\2\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124-\3\2\2\2\u0125"+
		"\u0128\5\60\31\2\u0126\u0128\5\62\32\2\u0127\u0125\3\2\2\2\u0127\u0126"+
		"\3\2\2\2\u0128/\3\2\2\2\u0129\u012a\7*\2\2\u012a\u012b\7\30\2\2\u012b"+
		"\u012c\7,\2\2\u012c\61\3\2\2\2\u012d\u013a\7\31\2\2\u012e\u012f\7,\2\2"+
		"\u012f\u0130\7(\2\2\u0130\u0137\7,\2\2\u0131\u0132\7\23\2\2\u0132\u0133"+
		"\7,\2\2\u0133\u0134\7(\2\2\u0134\u0136\7,\2\2\u0135\u0131\3\2\2\2\u0136"+
		"\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013b\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u013a\u012e\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\7\32\2\2\u013d\63\3\2\2\2&:CFORW^fqw\u0080"+
		"\u0083\u008f\u0091\u0096\u00a0\u00a2\u00af\u00b2\u00b5\u00bd\u00c0\u00cd"+
		"\u00e1\u00e9\u00ec\u00f3\u00fd\u0103\u0114\u0117\u011c\u0123\u0127\u0137"+
		"\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}