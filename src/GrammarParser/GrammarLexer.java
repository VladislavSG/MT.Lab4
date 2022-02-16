// Generated from C:/prog/ITMO/5-term/MT/Lab4\Grammar.g4 by ANTLR 4.9.2
package GrammarParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Name=5, RuleName=6, Literal=7, Action=8, 
		Args=9, WS=10, COMMENT=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "Name", "RuleName", "Literal", "Action", 
			"Args", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "':'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "Name", "RuleName", "Literal", "Action", 
			"Args", "WS", "COMMENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\ru\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\7\6*\n\6\f\6\16\6-\13\6\3\7\3\7\7\7\61\n\7\f\7\16\7\64\13\7\3\b"+
		"\3\b\3\b\3\b\7\b:\n\b\f\b\16\b=\13\b\3\b\3\b\3\t\3\t\6\tC\n\t\r\t\16\t"+
		"D\3\t\3\t\3\t\3\t\6\tK\n\t\r\t\16\tL\3\t\3\t\3\n\3\n\6\nS\n\n\r\n\16\n"+
		"T\3\n\3\n\3\n\3\n\6\n[\n\n\r\n\16\n\\\3\n\3\n\3\13\6\13b\n\13\r\13\16"+
		"\13c\3\13\3\13\3\f\3\f\7\fj\n\f\f\f\16\fm\13\f\3\f\5\fp\n\f\3\f\3\f\3"+
		"\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\n"+
		"\3\2C\\\4\2\62;c|\3\2c|\3\2))\4\2}}\177\177\4\2]]__\5\2\13\f\17\17\"\""+
		"\4\2\f\f\17\17\2\u0081\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13"+
		"\'\3\2\2\2\r.\3\2\2\2\17\65\3\2\2\2\21@\3\2\2\2\23P\3\2\2\2\25a\3\2\2"+
		"\2\27g\3\2\2\2\31\32\7i\2\2\32\33\7t\2\2\33\34\7c\2\2\34\35\7o\2\2\35"+
		"\36\7o\2\2\36\37\7c\2\2\37 \7t\2\2 \4\3\2\2\2!\"\7=\2\2\"\6\3\2\2\2#$"+
		"\7<\2\2$\b\3\2\2\2%&\7~\2\2&\n\3\2\2\2\'+\t\2\2\2(*\t\3\2\2)(\3\2\2\2"+
		"*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\f\3\2\2\2-+\3\2\2\2.\62\t\4\2\2/\61\t"+
		"\3\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\16\3\2"+
		"\2\2\64\62\3\2\2\2\65;\7)\2\2\66\67\7^\2\2\67:\7)\2\28:\n\5\2\29\66\3"+
		"\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7"+
		")\2\2?\20\3\2\2\2@J\7}\2\2AC\n\6\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3"+
		"\2\2\2EK\3\2\2\2FG\7}\2\2GH\5\21\t\2HI\7\177\2\2IK\3\2\2\2JB\3\2\2\2J"+
		"F\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\177\2\2O\22\3\2"+
		"\2\2PZ\7]\2\2QS\n\7\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U[\3\2"+
		"\2\2VW\7]\2\2WX\5\23\n\2XY\7_\2\2Y[\3\2\2\2ZR\3\2\2\2ZV\3\2\2\2[\\\3\2"+
		"\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7_\2\2_\24\3\2\2\2`b\t\b\2\2a`"+
		"\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\b\13\2\2f\26\3\2\2"+
		"\2gk\7%\2\2hj\n\t\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2"+
		"\2mk\3\2\2\2np\7\17\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\f\2\2rs\3\2"+
		"\2\2st\b\f\2\2t\30\3\2\2\2\20\2+\629;DJLTZ\\cko\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}