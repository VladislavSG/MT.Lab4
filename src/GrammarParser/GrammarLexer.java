// Generated from D:/prog/ITMO/5-term/MT/Lab4\Grammar.g4 by ANTLR 4.9.2
package GrammarParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	public static final int
			T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Range = 5, Local = 6, Name = 7, NTerminal = 8,
			Literal = 9, Action = 10, Args = 11, WS = 12, COMMENT = 13;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u008c\b\1\4\2" +
					"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
					"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3" +
					"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6\62\n\6\r\6\16\6\63\3" +
					"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b@\n\b\f\b\16\bC\13\b\3\t\3\t" +
					"\7\tG\n\t\f\t\16\tJ\13\t\3\n\3\n\3\n\3\n\6\nP\n\n\r\n\16\nQ\3\n\3\n\3" +
					"\13\3\13\6\13X\n\13\r\13\16\13Y\3\13\3\13\3\13\3\13\6\13`\n\13\r\13\16" +
					"\13a\3\13\3\13\3\f\3\f\6\fh\n\f\r\f\16\fi\3\f\3\f\3\f\3\f\5\fp\n\f\6\f" +
					"r\n\f\r\f\16\fs\3\f\3\f\3\r\6\ry\n\r\r\r\16\rz\3\r\3\r\3\16\3\16\7\16" +
					"\u0081\n\16\f\16\16\16\u0084\13\16\3\16\5\16\u0087\n\16\3\16\3\16\3\16" +
					"\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16" +
					"\33\17\3\2\n\3\2))\3\2C\\\4\2\62;c|\3\2c|\4\2}}\177\177\4\2]]__\5\2\13" +
					"\f\17\17\"\"\4\2\f\f\17\17\2\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2" +
					"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3" +
					"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2" +
					"\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r\67\3\2\2\2\17=\3\2" +
					"\2\2\21D\3\2\2\2\23K\3\2\2\2\25U\3\2\2\2\27e\3\2\2\2\31x\3\2\2\2\33~\3" +
					"\2\2\2\35\36\7i\2\2\36\37\7t\2\2\37 \7c\2\2 !\7o\2\2!\"\7o\2\2\"#\7c\2" +
					"\2#$\7t\2\2$\4\3\2\2\2%&\7=\2\2&\6\3\2\2\2\'(\7<\2\2(\b\3\2\2\2)*\7~\2" +
					"\2*\n\3\2\2\2+,\7#\2\2,-\7)\2\2-\61\3\2\2\2.\62\n\2\2\2/\60\7^\2\2\60" +
					"\62\7)\2\2\61.\3\2\2\2\61/\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3" +
					"\2\2\2\64\65\3\2\2\2\65\66\7)\2\2\66\f\3\2\2\2\678\7n\2\289\7q\2\29:\7" +
					"e\2\2:;\7c\2\2;<\7n\2\2<\16\3\2\2\2=A\t\3\2\2>@\t\4\2\2?>\3\2\2\2@C\3" +
					"\2\2\2A?\3\2\2\2AB\3\2\2\2B\20\3\2\2\2CA\3\2\2\2DH\t\5\2\2EG\t\4\2\2F" +
					"E\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\22\3\2\2\2JH\3\2\2\2KO\7)\2\2" +
					"LM\7^\2\2MP\7)\2\2NP\n\2\2\2OL\3\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2Q" +
					"R\3\2\2\2RS\3\2\2\2ST\7)\2\2T\24\3\2\2\2U_\7}\2\2VX\n\6\2\2WV\3\2\2\2" +
					"XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z`\3\2\2\2[\\\7}\2\2\\]\5\25\13\2]^\7\177" +
					"\2\2^`\3\2\2\2_W\3\2\2\2_[\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2" +
					"\2\2cd\7\177\2\2d\26\3\2\2\2eq\7]\2\2fh\n\7\2\2gf\3\2\2\2hi\3\2\2\2ig" +
					"\3\2\2\2ij\3\2\2\2jo\3\2\2\2kl\7]\2\2lm\5\27\f\2mn\7_\2\2np\3\2\2\2ok" +
					"\3\2\2\2op\3\2\2\2pr\3\2\2\2qg\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t" +
					"u\3\2\2\2uv\7_\2\2v\30\3\2\2\2wy\t\b\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2" +
					"z{\3\2\2\2{|\3\2\2\2|}\b\r\2\2}\32\3\2\2\2~\u0082\7%\2\2\177\u0081\n\t" +
					"\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083" +
					"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7\17\2\2" +
					"\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089" +
					"\7\f\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\16\2\2\u008b\34\3\2\2\2\22" +
					"\2\61\63AHOQY_aiosz\u0082\u0086\3\b\2\2";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	public static String[] channelNames = {
			"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};
	public static String[] modeNames = {
			"DEFAULT_MODE"
	};

	static {
		RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
	}

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

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}

	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{
				"T__0", "T__1", "T__2", "T__3", "Range", "Local", "Name", "NTerminal",
				"Literal", "Action", "Args", "WS", "COMMENT"
		};
	}

	private static String[] makeLiteralNames() {
		return new String[]{
				null, "'grammar'", "';'", "':'", "'|'", null, "'local'"
		};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{
				null, null, null, null, null, "Range", "Local", "Name", "NTerminal",
				"Literal", "Action", "Args", "WS", "COMMENT"
		};
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
	public String getGrammarFileName() {
		return "Grammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}
}