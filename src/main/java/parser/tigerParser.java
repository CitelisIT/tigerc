// Generated from tiger.g4 by ANTLR 4.9.2

	package main.java.parser;

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
		RULE_addExp = 5, RULE_multExp = 6, RULE_simpleExp = 7, RULE_idExp = 8, 
		RULE_seqexp = 9, RULE_neg = 10, RULE_ifThen = 11, RULE_elseRule = 12, 
		RULE_whileExp = 13, RULE_forExp = 14, RULE_letExp = 15, RULE_fieldCreate = 16, 
		RULE_dec = 17, RULE_typeDec = 18, RULE_varDec = 19, RULE_varDecFact = 20, 
		RULE_funDec = 21, RULE_type = 22, RULE_arrType = 23, RULE_recType = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "exp", "orExp", "andExp", "eqExp", "addExp", "multExp", "simpleExp", 
			"idExp", "seqexp", "neg", "ifThen", "elseRule", "whileExp", "forExp", 
			"letExp", "fieldCreate", "dec", "typeDec", "varDec", "varDecFact", "funDec", 
			"type", "arrType", "recType"
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
			orExp();
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(54);
				match(T__0);
				setState(55);
				orExp();
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
		public AndExpContext andExp() {
			return getRuleContext(AndExpContext.class,0);
		}
		public List<OrExpContext> orExp() {
			return getRuleContexts(OrExpContext.class);
		}
		public OrExpContext orExp(int i) {
			return getRuleContext(OrExpContext.class,i);
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
			andExp();
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					match(T__1);
					setState(60);
					orExp();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public List<AndExpContext> andExp() {
			return getRuleContexts(AndExpContext.class);
		}
		public AndExpContext andExp(int i) {
			return getRuleContext(AndExpContext.class,i);
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
			setState(66);
			eqExp();
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					match(T__2);
					setState(68);
					andExp();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			addExp();
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(75);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(76);
					addExp();
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			multExp();
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					_la = _input.LA(1);
					if ( !(_la==T__8 || _la==T__9) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(84);
					multExp();
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			simpleExp();
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__11) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(92);
					simpleExp();
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public SeqexpContext seqexp() {
			return getRuleContext(SeqexpContext.class,0);
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
		public TerminalNode INT() { return getToken(tigerParser.INT, 0); }
		public TerminalNode STRING() { return getToken(tigerParser.STRING, 0); }
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
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				seqexp();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				neg();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				idExp();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				ifThen();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				whileExp();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				forExp();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				letExp();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				match(STRING);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 10);
				{
				setState(107);
				match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 11);
				{
				setState(108);
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
		enterRule(_localctx, 16, RULE_idExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(112);
				match(T__14);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
					{
					setState(113);
					exp();
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(114);
						match(T__15);
						setState(115);
						exp();
						}
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(123);
				match(T__16);
				}
				break;
			case T__17:
				{
				setState(124);
				match(T__17);
				setState(125);
				exp();
				setState(126);
				match(T__18);
				setState(140);
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
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__17 || _la==T__19) {
						{
						setState(133);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__17:
							{
							setState(127);
							match(T__17);
							setState(128);
							exp();
							setState(129);
							match(T__18);
							}
							break;
						case T__19:
							{
							setState(131);
							match(T__19);
							setState(132);
							match(ID);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__20:
					{
					setState(138);
					match(T__20);
					setState(139);
					exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__19:
				{
				setState(142);
				match(T__19);
				setState(143);
				match(ID);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17 || _la==T__19) {
					{
					setState(150);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__17:
						{
						setState(144);
						match(T__17);
						setState(145);
						exp();
						setState(146);
						match(T__18);
						}
						break;
					case T__19:
						{
						setState(148);
						match(T__19);
						setState(149);
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__21:
				{
				setState(155);
				match(T__21);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(156);
					match(ID);
					setState(157);
					match(T__3);
					setState(158);
					exp();
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(159);
						match(T__15);
						setState(160);
						match(ID);
						setState(161);
						match(T__3);
						setState(162);
						exp();
						}
						}
						setState(167);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(170);
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

	public static class SeqexpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitSeqexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqexpContext seqexp() throws RecognitionException {
		SeqexpContext _localctx = new SeqexpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_seqexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__14);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(174);
				exp();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(175);
					match(T__23);
					setState(176);
					exp();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(184);
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
		enterRule(_localctx, 20, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__9);
			setState(187);
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

	public static class IfThenContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ElseRuleContext elseRule() {
			return getRuleContext(ElseRuleContext.class,0);
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
		enterRule(_localctx, 22, RULE_ifThen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__24);
			setState(190);
			exp();
			setState(191);
			match(T__25);
			setState(192);
			exp();
			setState(193);
			elseRule();
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

	public static class ElseRuleContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ElseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tigerVisitor ) return ((tigerVisitor<? extends T>)visitor).visitElseRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseRuleContext elseRule() throws RecognitionException {
		ElseRuleContext _localctx = new ElseRuleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_elseRule);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(T__26);
				setState(196);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
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
			setState(200);
			match(T__27);
			setState(201);
			exp();
			setState(202);
			match(T__28);
			setState(203);
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

	public static class ForExpContext extends ParserRuleContext {
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
			setState(205);
			match(T__29);
			setState(206);
			match(ID);
			setState(207);
			match(T__0);
			setState(208);
			exp();
			setState(209);
			match(T__30);
			setState(210);
			exp();
			setState(211);
			match(T__28);
			setState(212);
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
			setState(214);
			match(T__31);
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(215);
				dec();
				}
				}
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__37))) != 0) );
			setState(220);
			match(T__32);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(221);
				exp();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(222);
					match(T__23);
					setState(223);
					exp();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(231);
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
			setState(233);
			match(ID);
			setState(234);
			match(T__3);
			setState(235);
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
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				typeDec();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				varDec();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
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
			setState(242);
			match(T__34);
			setState(243);
			match(ID);
			setState(244);
			match(T__3);
			setState(245);
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
			setState(247);
			match(T__35);
			setState(248);
			match(ID);
			setState(249);
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
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(T__0);
				setState(252);
				exp();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(T__36);
				setState(254);
				match(ID);
				setState(255);
				match(T__0);
				setState(256);
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
		enterRule(_localctx, 42, RULE_funDec);
		int _la;
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(T__37);
				setState(260);
				match(ID);
				setState(261);
				match(T__14);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(262);
					match(ID);
					setState(263);
					match(T__36);
					setState(264);
					match(ID);
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(265);
						match(T__15);
						setState(266);
						match(ID);
						setState(267);
						match(T__36);
						setState(268);
						match(ID);
						}
						}
						setState(273);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(276);
				match(T__16);
				setState(277);
				match(T__3);
				setState(278);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(T__37);
				setState(280);
				match(ID);
				setState(281);
				match(T__14);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(282);
					match(ID);
					setState(283);
					match(T__36);
					setState(284);
					match(ID);
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(285);
						match(T__15);
						setState(286);
						match(ID);
						setState(287);
						match(T__36);
						setState(288);
						match(ID);
						}
						}
						setState(293);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(296);
				match(T__16);
				setState(297);
				match(T__36);
				setState(298);
				match(ID);
				setState(299);
				match(T__3);
				setState(300);
				exp();
				}
				break;
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
		enterRule(_localctx, 44, RULE_type);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(ID);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				arrType();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
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
		enterRule(_localctx, 46, RULE_arrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__38);
			setState(309);
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
		enterRule(_localctx, 48, RULE_recType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(T__21);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(312);
				match(ID);
				setState(313);
				match(T__36);
				setState(314);
				match(ID);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(315);
					match(T__15);
					setState(316);
					match(ID);
					setState(317);
					match(T__36);
					setState(318);
					match(ID);
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(326);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u014b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\7\4@\n\4\f\4\16"+
		"\4C\13\4\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\3\6\7\6P\n\6\f\6"+
		"\16\6S\13\6\3\7\3\7\3\7\7\7X\n\7\f\7\16\7[\13\7\3\b\3\b\3\b\7\b`\n\b\f"+
		"\b\16\bc\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\7\nw\n\n\f\n\16\nz\13\n\5\n|\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\n\u0088\n\n\f\n\16\n\u008b\13\n\3\n\3\n\5\n\u008f"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0099\n\n\f\n\16\n\u009c\13\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a6\n\n\f\n\16\n\u00a9\13\n\5\n"+
		"\u00ab\n\n\3\n\5\n\u00ae\n\n\3\13\3\13\3\13\3\13\7\13\u00b4\n\13\f\13"+
		"\16\13\u00b7\13\13\5\13\u00b9\n\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\5\16\u00c9\n\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\6\21\u00db\n\21\r\21"+
		"\16\21\u00dc\3\21\3\21\3\21\3\21\7\21\u00e3\n\21\f\21\16\21\u00e6\13\21"+
		"\5\21\u00e8\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00f3"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0104\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0110\n\27\f\27\16\27\u0113\13\27\5\27\u0115\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0124\n\27"+
		"\f\27\16\27\u0127\13\27\5\27\u0129\n\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0130\n\27\3\30\3\30\3\30\5\30\u0135\n\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\7\32\u0142\n\32\f\32\16\32\u0145\13\32\5"+
		"\32\u0147\n\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\5\3\2\6\n\3\2\13\f\3\2\r\16\2\u0160\2\64\3\2\2"+
		"\2\4\67\3\2\2\2\6<\3\2\2\2\bD\3\2\2\2\nL\3\2\2\2\fT\3\2\2\2\16\\\3\2\2"+
		"\2\20o\3\2\2\2\22q\3\2\2\2\24\u00af\3\2\2\2\26\u00bc\3\2\2\2\30\u00bf"+
		"\3\2\2\2\32\u00c8\3\2\2\2\34\u00ca\3\2\2\2\36\u00cf\3\2\2\2 \u00d8\3\2"+
		"\2\2\"\u00eb\3\2\2\2$\u00f2\3\2\2\2&\u00f4\3\2\2\2(\u00f9\3\2\2\2*\u0103"+
		"\3\2\2\2,\u012f\3\2\2\2.\u0134\3\2\2\2\60\u0136\3\2\2\2\62\u0139\3\2\2"+
		"\2\64\65\5\4\3\2\65\66\7\2\2\3\66\3\3\2\2\2\67:\5\6\4\289\7\3\2\29;\5"+
		"\6\4\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<A\5\b\5\2=>\7\4\2\2>@\5\6\4\2?="+
		"\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2CA\3\2\2\2DI\5\n\6\2"+
		"EF\7\5\2\2FH\5\b\5\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\t\3\2\2"+
		"\2KI\3\2\2\2LQ\5\f\7\2MN\t\2\2\2NP\5\f\7\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2"+
		"\2QR\3\2\2\2R\13\3\2\2\2SQ\3\2\2\2TY\5\16\b\2UV\t\3\2\2VX\5\16\b\2WU\3"+
		"\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\r\3\2\2\2[Y\3\2\2\2\\a\5\20\t\2"+
		"]^\t\4\2\2^`\5\20\t\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\17\3\2"+
		"\2\2ca\3\2\2\2dp\5\24\13\2ep\5\26\f\2fp\5\22\n\2gp\5\30\r\2hp\5\34\17"+
		"\2ip\5\36\20\2jp\5 \21\2kp\7,\2\2lp\7-\2\2mp\7\17\2\2np\7\20\2\2od\3\2"+
		"\2\2oe\3\2\2\2of\3\2\2\2og\3\2\2\2oh\3\2\2\2oi\3\2\2\2oj\3\2\2\2ok\3\2"+
		"\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\21\3\2\2\2q\u00ad\7+\2\2r{\7\21\2"+
		"\2sx\5\4\3\2tu\7\22\2\2uw\5\4\3\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2"+
		"\2\2y|\3\2\2\2zx\3\2\2\2{s\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u00ae\7\23\2\2"+
		"~\177\7\24\2\2\177\u0080\5\4\3\2\u0080\u008e\7\25\2\2\u0081\u0082\7\24"+
		"\2\2\u0082\u0083\5\4\3\2\u0083\u0084\7\25\2\2\u0084\u0088\3\2\2\2\u0085"+
		"\u0086\7\26\2\2\u0086\u0088\7+\2\2\u0087\u0081\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008f\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\27\2\2\u008d\u008f\5"+
		"\4\3\2\u008e\u0089\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u00ae\3\2\2\2\u0090"+
		"\u0091\7\26\2\2\u0091\u009a\7+\2\2\u0092\u0093\7\24\2\2\u0093\u0094\5"+
		"\4\3\2\u0094\u0095\7\25\2\2\u0095\u0099\3\2\2\2\u0096\u0097\7\26\2\2\u0097"+
		"\u0099\7+\2\2\u0098\u0092\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00ae\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u00aa\7\30\2\2\u009e\u009f\7+\2\2\u009f\u00a0\7\6"+
		"\2\2\u00a0\u00a7\5\4\3\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3\7+\2\2\u00a3"+
		"\u00a4\7\6\2\2\u00a4\u00a6\5\4\3\2\u00a5\u00a1\3\2\2\2\u00a6\u00a9\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u009e\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\7\31\2\2\u00adr\3\2\2\2\u00ad~\3\2\2\2\u00ad\u0090\3"+
		"\2\2\2\u00ad\u009d\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\23\3\2\2\2\u00af"+
		"\u00b8\7\21\2\2\u00b0\u00b5\5\4\3\2\u00b1\u00b2\7\32\2\2\u00b2\u00b4\5"+
		"\4\3\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b0\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\23\2\2\u00bb"+
		"\25\3\2\2\2\u00bc\u00bd\7\f\2\2\u00bd\u00be\5\4\3\2\u00be\27\3\2\2\2\u00bf"+
		"\u00c0\7\33\2\2\u00c0\u00c1\5\4\3\2\u00c1\u00c2\7\34\2\2\u00c2\u00c3\5"+
		"\4\3\2\u00c3\u00c4\5\32\16\2\u00c4\31\3\2\2\2\u00c5\u00c6\7\35\2\2\u00c6"+
		"\u00c9\5\4\3\2\u00c7\u00c9\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c7\3\2"+
		"\2\2\u00c9\33\3\2\2\2\u00ca\u00cb\7\36\2\2\u00cb\u00cc\5\4\3\2\u00cc\u00cd"+
		"\7\37\2\2\u00cd\u00ce\5\4\3\2\u00ce\35\3\2\2\2\u00cf\u00d0\7 \2\2\u00d0"+
		"\u00d1\7+\2\2\u00d1\u00d2\7\3\2\2\u00d2\u00d3\5\4\3\2\u00d3\u00d4\7!\2"+
		"\2\u00d4\u00d5\5\4\3\2\u00d5\u00d6\7\37\2\2\u00d6\u00d7\5\4\3\2\u00d7"+
		"\37\3\2\2\2\u00d8\u00da\7\"\2\2\u00d9\u00db\5$\23\2\u00da\u00d9\3\2\2"+
		"\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00e7\7#\2\2\u00df\u00e4\5\4\3\2\u00e0\u00e1\7\32\2\2\u00e1"+
		"\u00e3\5\4\3\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00df\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7$"+
		"\2\2\u00ea!\3\2\2\2\u00eb\u00ec\7+\2\2\u00ec\u00ed\7\6\2\2\u00ed\u00ee"+
		"\5\4\3\2\u00ee#\3\2\2\2\u00ef\u00f3\5&\24\2\u00f0\u00f3\5(\25\2\u00f1"+
		"\u00f3\5,\27\2\u00f2\u00ef\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2"+
		"\2\2\u00f3%\3\2\2\2\u00f4\u00f5\7%\2\2\u00f5\u00f6\7+\2\2\u00f6\u00f7"+
		"\7\6\2\2\u00f7\u00f8\5.\30\2\u00f8\'\3\2\2\2\u00f9\u00fa\7&\2\2\u00fa"+
		"\u00fb\7+\2\2\u00fb\u00fc\5*\26\2\u00fc)\3\2\2\2\u00fd\u00fe\7\3\2\2\u00fe"+
		"\u0104\5\4\3\2\u00ff\u0100\7\'\2\2\u0100\u0101\7+\2\2\u0101\u0102\7\3"+
		"\2\2\u0102\u0104\5\4\3\2\u0103\u00fd\3\2\2\2\u0103\u00ff\3\2\2\2\u0104"+
		"+\3\2\2\2\u0105\u0106\7(\2\2\u0106\u0107\7+\2\2\u0107\u0114\7\21\2\2\u0108"+
		"\u0109\7+\2\2\u0109\u010a\7\'\2\2\u010a\u0111\7+\2\2\u010b\u010c\7\22"+
		"\2\2\u010c\u010d\7+\2\2\u010d\u010e\7\'\2\2\u010e\u0110\7+\2\2\u010f\u010b"+
		"\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0108\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\23\2\2\u0117\u0118\7\6\2\2\u0118"+
		"\u0130\5\4\3\2\u0119\u011a\7(\2\2\u011a\u011b\7+\2\2\u011b\u0128\7\21"+
		"\2\2\u011c\u011d\7+\2\2\u011d\u011e\7\'\2\2\u011e\u0125\7+\2\2\u011f\u0120"+
		"\7\22\2\2\u0120\u0121\7+\2\2\u0121\u0122\7\'\2\2\u0122\u0124\7+\2\2\u0123"+
		"\u011f\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u011c\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\23\2\2\u012b\u012c\7"+
		"\'\2\2\u012c\u012d\7+\2\2\u012d\u012e\7\6\2\2\u012e\u0130\5\4\3\2\u012f"+
		"\u0105\3\2\2\2\u012f\u0119\3\2\2\2\u0130-\3\2\2\2\u0131\u0135\7+\2\2\u0132"+
		"\u0135\5\60\31\2\u0133\u0135\5\62\32\2\u0134\u0131\3\2\2\2\u0134\u0132"+
		"\3\2\2\2\u0134\u0133\3\2\2\2\u0135/\3\2\2\2\u0136\u0137\7)\2\2\u0137\u0138"+
		"\7+\2\2\u0138\61\3\2\2\2\u0139\u0146\7\30\2\2\u013a\u013b\7+\2\2\u013b"+
		"\u013c\7\'\2\2\u013c\u0143\7+\2\2\u013d\u013e\7\22\2\2\u013e\u013f\7+"+
		"\2\2\u013f\u0140\7\'\2\2\u0140\u0142\7+\2\2\u0141\u013d\3\2\2\2\u0142"+
		"\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0146\u013a\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\7\31\2\2\u0149\63\3\2\2\2#:AIQYaox{\u0087\u0089"+
		"\u008e\u0098\u009a\u00a7\u00aa\u00ad\u00b5\u00b8\u00c8\u00dc\u00e4\u00e7"+
		"\u00f2\u0103\u0111\u0114\u0125\u0128\u012f\u0134\u0143\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}