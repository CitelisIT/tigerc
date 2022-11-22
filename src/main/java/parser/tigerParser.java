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
		T__38=39, KEYWORD=40, ID=41, INT=42, STRING=43, COMMENT=44, WS=45;
	public static final int
		RULE_program = 0, RULE_exp = 1, RULE_orExp = 2, RULE_andExp = 3, RULE_eqExp = 4, 
		RULE_addExp = 5, RULE_multExp = 6, RULE_simpleExp = 7, RULE_litteralExp = 8, 
		RULE_idExp = 9, RULE_seqExp = 10, RULE_neg = 11, RULE_ifThen = 12, RULE_whileExp = 13, 
		RULE_forExp = 14, RULE_letExp = 15, RULE_fieldCreate = 16, RULE_dec = 17, 
		RULE_typeDec = 18, RULE_varDec = 19, RULE_varDecFact = 20, RULE_funDec = 21, 
		RULE_endDec = 22, RULE_type = 23, RULE_arrType = 24, RULE_recType = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "exp", "orExp", "andExp", "eqExp", "addExp", "multExp", "simpleExp", 
			"litteralExp", "idExp", "seqExp", "neg", "ifThen", "whileExp", "forExp", 
			"letExp", "fieldCreate", "dec", "typeDec", "varDec", "varDecFact", "funDec", 
			"endDec", "type", "arrType", "recType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'|'", "'&'", "'='", "'<>'", "'>'", "'<'", "'>='", "'+'", 
			"'-'", "'*'", "'/'", "'nil'", "'break'", "'('", "','", "')'", "'['", 
			"']'", "'.'", "'of'", "'{'", "'}'", "';'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "'for'", "'to'", "'let'", "'in'", "'end'", "'type'", 
			"'var'", "':'", "'function'", "'array of'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "KEYWORD", "ID", "INT", "STRING", "COMMENT", 
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
			setState(52);
			exp();
			setState(53);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			orExp();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(56);
				match(T__0);
				setState(57);
				orExp();
				}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			andExp();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(61);
				match(T__1);
				setState(62);
				andExp();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(63);
					match(T__1);
					setState(64);
					andExp();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			eqExp();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(73);
				match(T__2);
				setState(74);
				eqExp();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(75);
					match(T__2);
					setState(76);
					eqExp();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
			setState(84);
			addExp();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) {
				{
				setState(85);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(86);
				addExp();
				}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			multExp();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				{
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				multExp();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			simpleExp();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10 || _la==T__11) {
				{
				{
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				simpleExp();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				seqExp();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				neg();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				idExp();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				ifThen();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				whileExp();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				forExp();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 7);
				{
				setState(111);
				letExp();
				}
				break;
			case T__12:
			case T__13:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(112);
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
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntLitteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new StringLitteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(STRING);
				}
				break;
			case T__12:
				_localctx = new NilLitteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new BreakLitteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(T__13);
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
		public SimpleExpContext simpleExp() {
			return getRuleContext(SimpleExpContext.class,0);
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
			setState(121);
			match(ID);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(122);
				match(T__14);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
					{
					setState(123);
					exp();
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(124);
						match(T__15);
						setState(125);
						exp();
						}
						}
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(133);
				match(T__16);
				}
				break;
			case T__17:
				{
				setState(134);
				match(T__17);
				setState(135);
				exp();
				setState(136);
				match(T__18);
				setState(150);
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
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__22:
				case T__23:
				case T__25:
				case T__26:
				case T__28:
				case T__30:
				case T__32:
				case T__33:
				case T__34:
				case T__35:
				case T__37:
					{
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__17 || _la==T__19) {
						{
						setState(143);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__17:
							{
							setState(137);
							match(T__17);
							setState(138);
							exp();
							setState(139);
							match(T__18);
							}
							break;
						case T__19:
							{
							setState(141);
							match(T__19);
							setState(142);
							match(ID);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(147);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__20:
					{
					setState(148);
					match(T__20);
					setState(149);
					simpleExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__19:
				{
				setState(152);
				match(T__19);
				setState(153);
				match(ID);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17 || _la==T__19) {
					{
					setState(160);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__17:
						{
						setState(154);
						match(T__17);
						setState(155);
						exp();
						setState(156);
						match(T__18);
						}
						break;
					case T__19:
						{
						setState(158);
						match(T__19);
						setState(159);
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__21:
				{
				setState(165);
				match(T__21);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(166);
					match(ID);
					setState(167);
					match(T__3);
					setState(168);
					exp();
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(169);
						match(T__15);
						setState(170);
						match(ID);
						setState(171);
						match(T__3);
						setState(172);
						exp();
						}
						}
						setState(177);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(180);
				match(T__22);
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
			case T__15:
			case T__16:
			case T__18:
			case T__22:
			case T__23:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
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
			setState(183);
			match(T__14);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(184);
				exp();
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(185);
					match(T__23);
					setState(186);
					exp();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(194);
			match(T__16);
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
			setState(196);
			match(T__9);
			setState(197);
			simpleExp();
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<SimpleExpContext> simpleExp() {
			return getRuleContexts(SimpleExpContext.class);
		}
		public SimpleExpContext simpleExp(int i) {
			return getRuleContext(SimpleExpContext.class,i);
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
			setState(199);
			match(T__24);
			setState(200);
			exp();
			setState(201);
			match(T__25);
			setState(202);
			simpleExp();
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(203);
				match(T__26);
				setState(204);
				simpleExp();
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SimpleExpContext simpleExp() {
			return getRuleContext(SimpleExpContext.class,0);
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
			setState(207);
			match(T__27);
			setState(208);
			exp();
			setState(209);
			match(T__28);
			setState(210);
			simpleExp();
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
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SimpleExpContext simpleExp() {
			return getRuleContext(SimpleExpContext.class,0);
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
			setState(212);
			match(T__29);
			setState(213);
			match(ID);
			setState(214);
			match(T__0);
			setState(215);
			exp();
			setState(216);
			match(T__30);
			setState(217);
			exp();
			setState(218);
			match(T__28);
			setState(219);
			simpleExp();
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
			setState(221);
			match(T__31);
			setState(223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(222);
				dec();
				}
				}
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__37))) != 0) );
			setState(227);
			match(T__32);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(228);
				exp();
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(229);
					match(T__23);
					setState(230);
					exp();
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(238);
			match(T__33);
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

	public static class FieldCreateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FieldCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldCreate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitFieldCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldCreateContext fieldCreate() throws RecognitionException {
		FieldCreateContext _localctx = new FieldCreateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fieldCreate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ID);
			setState(241);
			match(T__3);
			setState(242);
			exp();
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
		public TypeDecContext typeDec() {
			return getRuleContext(TypeDecContext.class,0);
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
		enterRule(_localctx, 34, RULE_dec);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				typeDec();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				varDec();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
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
		enterRule(_localctx, 36, RULE_typeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__34);
			setState(250);
			match(ID);
			setState(251);
			match(T__3);
			setState(252);
			type();
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
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public VarDecFactContext varDecFact() {
			return getRuleContext(VarDecFactContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__35);
			setState(255);
			match(ID);
			setState(256);
			varDecFact();
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

	public static class VarDecFactContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public VarDecFactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecFact; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitVarDecFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecFactContext varDecFact() throws RecognitionException {
		VarDecFactContext _localctx = new VarDecFactContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varDecFact);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(T__0);
				setState(259);
				exp();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(T__36);
				setState(261);
				match(ID);
				setState(262);
				match(T__0);
				setState(263);
				exp();
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

	public static class FunDecContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(tigerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tigerParser.ID, i);
		}
		public EndDecContext endDec() {
			return getRuleContext(EndDecContext.class,0);
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
		enterRule(_localctx, 42, RULE_funDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__37);
			setState(267);
			match(ID);
			setState(268);
			match(T__14);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(269);
				match(ID);
				setState(270);
				match(T__36);
				setState(271);
				match(ID);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(272);
					match(T__15);
					setState(273);
					match(ID);
					setState(274);
					match(T__36);
					setState(275);
					match(ID);
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(283);
			match(T__16);
			setState(284);
			endDec();
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

	public static class EndDecContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public EndDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitEndDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndDecContext endDec() throws RecognitionException {
		EndDecContext _localctx = new EndDecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_endDec);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(T__3);
				setState(287);
				exp();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(T__36);
				setState(289);
				match(ID);
				setState(290);
				match(T__3);
				setState(291);
				exp();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tigerParser.ID, 0); }
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public RecTypeContext recType() {
			return getRuleContext(RecTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(ID);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				arrType();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
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
		enterRule(_localctx, 48, RULE_arrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(T__38);
			setState(300);
			match(ID);
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
		enterRule(_localctx, 50, RULE_recType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__21);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(303);
				match(ID);
				setState(304);
				match(T__36);
				setState(305);
				match(ID);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(306);
					match(T__15);
					setState(307);
					match(ID);
					setState(308);
					match(T__36);
					setState(309);
					match(ID);
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(317);
			match(T__22);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0142\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\7\4D\n\4\f\4\16\4G\13\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5"+
		"\16\5S\13\5\5\5U\n\5\3\6\3\6\3\6\5\6Z\n\6\3\7\3\7\3\7\7\7_\n\7\f\7\16"+
		"\7b\13\7\3\b\3\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\tt\n\t\3\n\3\n\3\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u0081\n\13\f\13\16\13\u0084\13\13\5\13\u0086\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0092\n\13\f\13\16\13\u0095\13\13"+
		"\3\13\3\13\5\13\u0099\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00a3\n\13\f\13\16\13\u00a6\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00b0\n\13\f\13\16\13\u00b3\13\13\5\13\u00b5\n\13\3\13\5\13"+
		"\u00b8\n\13\3\f\3\f\3\f\3\f\7\f\u00be\n\f\f\f\16\f\u00c1\13\f\5\f\u00c3"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d0\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\6\21\u00e2\n\21\r\21\16\21\u00e3\3\21\3\21\3\21\3\21\7\21\u00ea"+
		"\n\21\f\21\16\21\u00ed\13\21\5\21\u00ef\n\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\5\23\u00fa\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u010b\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0117\n\27\f\27\16\27\u011a\13"+
		"\27\5\27\u011c\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0127\n\30\3\31\3\31\3\31\5\31\u012c\n\31\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\7\33\u0139\n\33\f\33\16\33\u013c\13\33\5"+
		"\33\u013e\n\33\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\5\3\2\6\n\3\2\13\f\3\2\r\16\2\u0156\2\66\3"+
		"\2\2\2\49\3\2\2\2\6>\3\2\2\2\bJ\3\2\2\2\nV\3\2\2\2\f[\3\2\2\2\16c\3\2"+
		"\2\2\20s\3\2\2\2\22y\3\2\2\2\24{\3\2\2\2\26\u00b9\3\2\2\2\30\u00c6\3\2"+
		"\2\2\32\u00c9\3\2\2\2\34\u00d1\3\2\2\2\36\u00d6\3\2\2\2 \u00df\3\2\2\2"+
		"\"\u00f2\3\2\2\2$\u00f9\3\2\2\2&\u00fb\3\2\2\2(\u0100\3\2\2\2*\u010a\3"+
		"\2\2\2,\u010c\3\2\2\2.\u0126\3\2\2\2\60\u012b\3\2\2\2\62\u012d\3\2\2\2"+
		"\64\u0130\3\2\2\2\66\67\5\4\3\2\678\7\2\2\38\3\3\2\2\29<\5\6\4\2:;\7\3"+
		"\2\2;=\5\6\4\2<:\3\2\2\2<=\3\2\2\2=\5\3\2\2\2>H\5\b\5\2?@\7\4\2\2@E\5"+
		"\b\5\2AB\7\4\2\2BD\5\b\5\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3"+
		"\2\2\2GE\3\2\2\2H?\3\2\2\2HI\3\2\2\2I\7\3\2\2\2JT\5\n\6\2KL\7\5\2\2LQ"+
		"\5\n\6\2MN\7\5\2\2NP\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R"+
		"U\3\2\2\2SQ\3\2\2\2TK\3\2\2\2TU\3\2\2\2U\t\3\2\2\2VY\5\f\7\2WX\t\2\2\2"+
		"XZ\5\f\7\2YW\3\2\2\2YZ\3\2\2\2Z\13\3\2\2\2[`\5\16\b\2\\]\t\3\2\2]_\5\16"+
		"\b\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\r\3\2\2\2b`\3\2\2\2ch\5"+
		"\20\t\2de\t\4\2\2eg\5\20\t\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i"+
		"\17\3\2\2\2jh\3\2\2\2kt\5\26\f\2lt\5\30\r\2mt\5\24\13\2nt\5\32\16\2ot"+
		"\5\34\17\2pt\5\36\20\2qt\5 \21\2rt\5\22\n\2sk\3\2\2\2sl\3\2\2\2sm\3\2"+
		"\2\2sn\3\2\2\2so\3\2\2\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\21\3\2\2\2uz\7"+
		",\2\2vz\7-\2\2wz\7\17\2\2xz\7\20\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3"+
		"\2\2\2z\23\3\2\2\2{\u00b7\7+\2\2|\u0085\7\21\2\2}\u0082\5\4\3\2~\177\7"+
		"\22\2\2\177\u0081\5\4\3\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"}\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u00b8\7\23\2\2"+
		"\u0088\u0089\7\24\2\2\u0089\u008a\5\4\3\2\u008a\u0098\7\25\2\2\u008b\u008c"+
		"\7\24\2\2\u008c\u008d\5\4\3\2\u008d\u008e\7\25\2\2\u008e\u0092\3\2\2\2"+
		"\u008f\u0090\7\26\2\2\u0090\u0092\7+\2\2\u0091\u008b\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0099\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\27\2\2\u0097\u0099\5"+
		"\20\t\2\u0098\u0093\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u00b8\3\2\2\2\u009a"+
		"\u009b\7\26\2\2\u009b\u00a4\7+\2\2\u009c\u009d\7\24\2\2\u009d\u009e\5"+
		"\4\3\2\u009e\u009f\7\25\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a1\7\26\2\2\u00a1"+
		"\u00a3\7+\2\2\u00a2\u009c\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00b8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00b4\7\30\2\2\u00a8\u00a9\7+\2\2\u00a9\u00aa\7\6"+
		"\2\2\u00aa\u00b1\5\4\3\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7+\2\2\u00ad"+
		"\u00ae\7\6\2\2\u00ae\u00b0\5\4\3\2\u00af\u00ab\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00a8\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\7\31\2\2\u00b7|\3\2\2\2\u00b7\u0088\3\2\2\2\u00b7\u009a"+
		"\3\2\2\2\u00b7\u00a7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\25\3\2\2\2\u00b9"+
		"\u00c2\7\21\2\2\u00ba\u00bf\5\4\3\2\u00bb\u00bc\7\32\2\2\u00bc\u00be\5"+
		"\4\3\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00ba\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\23\2\2\u00c5"+
		"\27\3\2\2\2\u00c6\u00c7\7\f\2\2\u00c7\u00c8\5\20\t\2\u00c8\31\3\2\2\2"+
		"\u00c9\u00ca\7\33\2\2\u00ca\u00cb\5\4\3\2\u00cb\u00cc\7\34\2\2\u00cc\u00cf"+
		"\5\20\t\2\u00cd\u00ce\7\35\2\2\u00ce\u00d0\5\20\t\2\u00cf\u00cd\3\2\2"+
		"\2\u00cf\u00d0\3\2\2\2\u00d0\33\3\2\2\2\u00d1\u00d2\7\36\2\2\u00d2\u00d3"+
		"\5\4\3\2\u00d3\u00d4\7\37\2\2\u00d4\u00d5\5\20\t\2\u00d5\35\3\2\2\2\u00d6"+
		"\u00d7\7 \2\2\u00d7\u00d8\7+\2\2\u00d8\u00d9\7\3\2\2\u00d9\u00da\5\4\3"+
		"\2\u00da\u00db\7!\2\2\u00db\u00dc\5\4\3\2\u00dc\u00dd\7\37\2\2\u00dd\u00de"+
		"\5\20\t\2\u00de\37\3\2\2\2\u00df\u00e1\7\"\2\2\u00e0\u00e2\5$\23\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00ee\7#\2\2\u00e6\u00eb\5\4\3\2\u00e7"+
		"\u00e8\7\32\2\2\u00e8\u00ea\5\4\3\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3"+
		"\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00e6\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\7$\2\2\u00f1!\3\2\2\2\u00f2\u00f3\7+\2\2\u00f3\u00f4"+
		"\7\6\2\2\u00f4\u00f5\5\4\3\2\u00f5#\3\2\2\2\u00f6\u00fa\5&\24\2\u00f7"+
		"\u00fa\5(\25\2\u00f8\u00fa\5,\27\2\u00f9\u00f6\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00f8\3\2\2\2\u00fa%\3\2\2\2\u00fb\u00fc\7%\2\2\u00fc\u00fd"+
		"\7+\2\2\u00fd\u00fe\7\6\2\2\u00fe\u00ff\5\60\31\2\u00ff\'\3\2\2\2\u0100"+
		"\u0101\7&\2\2\u0101\u0102\7+\2\2\u0102\u0103\5*\26\2\u0103)\3\2\2\2\u0104"+
		"\u0105\7\3\2\2\u0105\u010b\5\4\3\2\u0106\u0107\7\'\2\2\u0107\u0108\7+"+
		"\2\2\u0108\u0109\7\3\2\2\u0109\u010b\5\4\3\2\u010a\u0104\3\2\2\2\u010a"+
		"\u0106\3\2\2\2\u010b+\3\2\2\2\u010c\u010d\7(\2\2\u010d\u010e\7+\2\2\u010e"+
		"\u011b\7\21\2\2\u010f\u0110\7+\2\2\u0110\u0111\7\'\2\2\u0111\u0118\7+"+
		"\2\2\u0112\u0113\7\22\2\2\u0113\u0114\7+\2\2\u0114\u0115\7\'\2\2\u0115"+
		"\u0117\7+\2\2\u0116\u0112\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u010f\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7\23"+
		"\2\2\u011e\u011f\5.\30\2\u011f-\3\2\2\2\u0120\u0121\7\6\2\2\u0121\u0127"+
		"\5\4\3\2\u0122\u0123\7\'\2\2\u0123\u0124\7+\2\2\u0124\u0125\7\6\2\2\u0125"+
		"\u0127\5\4\3\2\u0126\u0120\3\2\2\2\u0126\u0122\3\2\2\2\u0127/\3\2\2\2"+
		"\u0128\u012c\7+\2\2\u0129\u012c\5\62\32\2\u012a\u012c\5\64\33\2\u012b"+
		"\u0128\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\61\3\2\2"+
		"\2\u012d\u012e\7)\2\2\u012e\u012f\7+\2\2\u012f\63\3\2\2\2\u0130\u013d"+
		"\7\30\2\2\u0131\u0132\7+\2\2\u0132\u0133\7\'\2\2\u0133\u013a\7+\2\2\u0134"+
		"\u0135\7\22\2\2\u0135\u0136\7+\2\2\u0136\u0137\7\'\2\2\u0137\u0139\7+"+
		"\2\2\u0138\u0134\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u0131\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7\31\2\2\u0140"+
		"\65\3\2\2\2$<EHQTY`hsy\u0082\u0085\u0091\u0093\u0098\u00a2\u00a4\u00b1"+
		"\u00b4\u00b7\u00bf\u00c2\u00cf\u00e3\u00eb\u00ee\u00f9\u010a\u0118\u011b"+
		"\u0126\u012b\u013a\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}