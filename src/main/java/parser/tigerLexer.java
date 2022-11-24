// Generated from tiger.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tigerLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "KEYWORD", "ID", 
			"INT", "TEXT", "STRING", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'|'", "'&'", "'='", "'<>'", "'>'", "'<'", "'>='", "'+'", 
			"'-'", "'*'", "'/'", "'nil'", "'break'", "'('", "','", "')'", "'['", 
			"']'", "'of'", "'.'", "'{'", "'}'", "';'", "'if'", "'then'", "'else'", 
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


	public tigerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "tiger.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0149\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u011b\n)\3*\3*\7*\u011f"+
		"\n*\f*\16*\u0122\13*\3+\6+\u0125\n+\r+\16+\u0126\3,\7,\u012a\n,\f,\16"+
		",\u012d\13,\3-\3-\3-\3-\7-\u0133\n-\f-\16-\u0136\13-\3-\3-\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3/\6/\u0144\n/\r/\16/\u0145\3/\3/\2\2\60\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W\2Y-[.]/\3\2\t\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\7\2\""+
		"#%+.]_ac\177\b\2$$))^^ppttvv\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\2\u015d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5b\3\2\2\2\7d\3"+
		"\2\2\2\tf\3\2\2\2\13h\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23r\3"+
		"\2\2\2\25t\3\2\2\2\27v\3\2\2\2\31x\3\2\2\2\33z\3\2\2\2\35~\3\2\2\2\37"+
		"\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008c\3"+
		"\2\2\2)\u008e\3\2\2\2+\u0091\3\2\2\2-\u0093\3\2\2\2/\u0095\3\2\2\2\61"+
		"\u0097\3\2\2\2\63\u0099\3\2\2\2\65\u009c\3\2\2\2\67\u00a1\3\2\2\29\u00a6"+
		"\3\2\2\2;\u00ac\3\2\2\2=\u00af\3\2\2\2?\u00b3\3\2\2\2A\u00b6\3\2\2\2C"+
		"\u00ba\3\2\2\2E\u00bd\3\2\2\2G\u00c1\3\2\2\2I\u00c6\3\2\2\2K\u00ca\3\2"+
		"\2\2M\u00cc\3\2\2\2O\u00d5\3\2\2\2Q\u011a\3\2\2\2S\u011c\3\2\2\2U\u0124"+
		"\3\2\2\2W\u012b\3\2\2\2Y\u012e\3\2\2\2[\u0139\3\2\2\2]\u0143\3\2\2\2_"+
		"`\7<\2\2`a\7?\2\2a\4\3\2\2\2bc\7~\2\2c\6\3\2\2\2de\7(\2\2e\b\3\2\2\2f"+
		"g\7?\2\2g\n\3\2\2\2hi\7>\2\2ij\7@\2\2j\f\3\2\2\2kl\7@\2\2l\16\3\2\2\2"+
		"mn\7>\2\2n\20\3\2\2\2op\7@\2\2pq\7?\2\2q\22\3\2\2\2rs\7-\2\2s\24\3\2\2"+
		"\2tu\7/\2\2u\26\3\2\2\2vw\7,\2\2w\30\3\2\2\2xy\7\61\2\2y\32\3\2\2\2z{"+
		"\7p\2\2{|\7k\2\2|}\7n\2\2}\34\3\2\2\2~\177\7d\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7g\2\2\u0081\u0082\7c\2\2\u0082\u0083\7m\2\2\u0083\36\3\2\2\2\u0084"+
		"\u0085\7*\2\2\u0085 \3\2\2\2\u0086\u0087\7.\2\2\u0087\"\3\2\2\2\u0088"+
		"\u0089\7+\2\2\u0089$\3\2\2\2\u008a\u008b\7]\2\2\u008b&\3\2\2\2\u008c\u008d"+
		"\7_\2\2\u008d(\3\2\2\2\u008e\u008f\7q\2\2\u008f\u0090\7h\2\2\u0090*\3"+
		"\2\2\2\u0091\u0092\7\60\2\2\u0092,\3\2\2\2\u0093\u0094\7}\2\2\u0094.\3"+
		"\2\2\2\u0095\u0096\7\177\2\2\u0096\60\3\2\2\2\u0097\u0098\7=\2\2\u0098"+
		"\62\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\64\3\2\2\2\u009c"+
		"\u009d\7v\2\2\u009d\u009e\7j\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7p\2\2"+
		"\u00a0\66\3\2\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7"+
		"u\2\2\u00a4\u00a5\7g\2\2\u00a58\3\2\2\2\u00a6\u00a7\7y\2\2\u00a7\u00a8"+
		"\7j\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		":\3\2\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7q\2\2\u00ae<\3\2\2\2\u00af\u00b0"+
		"\7h\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7t\2\2\u00b2>\3\2\2\2\u00b3\u00b4"+
		"\7v\2\2\u00b4\u00b5\7q\2\2\u00b5@\3\2\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8\u00b9\7v\2\2\u00b9B\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc"+
		"\7p\2\2\u00bcD\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0"+
		"\7f\2\2\u00c0F\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7{\2\2\u00c3\u00c4"+
		"\7r\2\2\u00c4\u00c5\7g\2\2\u00c5H\3\2\2\2\u00c6\u00c7\7x\2\2\u00c7\u00c8"+
		"\7c\2\2\u00c8\u00c9\7t\2\2\u00c9J\3\2\2\2\u00ca\u00cb\7<\2\2\u00cbL\3"+
		"\2\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7w\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"\u00d0\7e\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7q\2\2"+
		"\u00d3\u00d4\7p\2\2\u00d4N\3\2\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7t\2"+
		"\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7{\2\2\u00da\u00db"+
		"\7\"\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7h\2\2\u00ddP\3\2\2\2\u00de\u00df"+
		"\7c\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7c\2\2\u00e2"+
		"\u011b\7{\2\2\u00e3\u00e4\7d\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7g\2\2"+
		"\u00e6\u00e7\7c\2\2\u00e7\u011b\7m\2\2\u00e8\u00e9\7f\2\2\u00e9\u011b"+
		"\7q\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7u\2\2\u00ed"+
		"\u011b\7g\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7p\2\2\u00f0\u011b\7f\2\2"+
		"\u00f1\u00f2\7h\2\2\u00f2\u00f3\7q\2\2\u00f3\u011b\7t\2\2\u00f4\u00f5"+
		"\7h\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7e\2\2\u00f8"+
		"\u00f9\7v\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7q\2\2\u00fb\u011b\7p\2\2"+
		"\u00fc\u00fd\7k\2\2\u00fd\u011b\7h\2\2\u00fe\u00ff\7k\2\2\u00ff\u011b"+
		"\7p\2\2\u0100\u0101\7n\2\2\u0101\u0102\7g\2\2\u0102\u011b\7v\2\2\u0103"+
		"\u0104\7p\2\2\u0104\u0105\7k\2\2\u0105\u011b\7n\2\2\u0106\u0107\7q\2\2"+
		"\u0107\u011b\7h\2\2\u0108\u0109\7v\2\2\u0109\u010a\7j\2\2\u010a\u010b"+
		"\7g\2\2\u010b\u011b\7p\2\2\u010c\u010d\7v\2\2\u010d\u011b\7q\2\2\u010e"+
		"\u010f\7v\2\2\u010f\u0110\7{\2\2\u0110\u0111\7r\2\2\u0111\u011b\7g\2\2"+
		"\u0112\u0113\7x\2\2\u0113\u0114\7c\2\2\u0114\u011b\7t\2\2\u0115\u0116"+
		"\7y\2\2\u0116\u0117\7j\2\2\u0117\u0118\7k\2\2\u0118\u0119\7n\2\2\u0119"+
		"\u011b\7g\2\2\u011a\u00de\3\2\2\2\u011a\u00e3\3\2\2\2\u011a\u00e8\3\2"+
		"\2\2\u011a\u00ea\3\2\2\2\u011a\u00ee\3\2\2\2\u011a\u00f1\3\2\2\2\u011a"+
		"\u00f4\3\2\2\2\u011a\u00fc\3\2\2\2\u011a\u00fe\3\2\2\2\u011a\u0100\3\2"+
		"\2\2\u011a\u0103\3\2\2\2\u011a\u0106\3\2\2\2\u011a\u0108\3\2\2\2\u011a"+
		"\u010c\3\2\2\2\u011a\u010e\3\2\2\2\u011a\u0112\3\2\2\2\u011a\u0115\3\2"+
		"\2\2\u011bR\3\2\2\2\u011c\u0120\t\2\2\2\u011d\u011f\t\3\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"T\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\t\4\2\2\u0124\u0123\3\2\2\2"+
		"\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127V\3"+
		"\2\2\2\u0128\u012a\t\5\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012cX\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012e\u0134\7$\2\2\u012f\u0130\7^\2\2\u0130\u0133\t\6\2\2\u0131\u0133"+
		"\n\7\2\2\u0132\u012f\3\2\2\2\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2"+
		"\2\2\u0137\u0138\7$\2\2\u0138Z\3\2\2\2\u0139\u013a\7\61\2\2\u013a\u013b"+
		"\7,\2\2\u013b\u013c\3\2\2\2\u013c\u013d\5W,\2\u013d\u013e\7,\2\2\u013e"+
		"\u013f\7\61\2\2\u013f\u0140\3\2\2\2\u0140\u0141\b.\2\2\u0141\\\3\2\2\2"+
		"\u0142\u0144\t\b\2\2\u0143\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b/\2\2\u0148"+
		"^\3\2\2\2\n\2\u011a\u0120\u0126\u012b\u0132\u0134\u0145\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}