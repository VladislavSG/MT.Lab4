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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Local = 5, Name = 6, NTerminal = 7, Literal = 8,
            Action = 9, Args = 10, WS = 11, COMMENT = 12;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16~\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3" +
                    "\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\7\7\62\n\7\f\7\16\7\65\13\7\3\b" +
                    "\3\b\7\b9\n\b\f\b\16\b<\13\b\3\t\3\t\3\t\3\t\6\tB\n\t\r\t\16\tC\3\t\3" +
                    "\t\3\n\3\n\6\nJ\n\n\r\n\16\nK\3\n\3\n\3\n\3\n\6\nR\n\n\r\n\16\nS\3\n\3" +
                    "\n\3\13\3\13\6\13Z\n\13\r\13\16\13[\3\13\3\13\3\13\3\13\5\13b\n\13\6\13" +
                    "d\n\13\r\13\16\13e\3\13\3\13\3\f\6\fk\n\f\r\f\16\fl\3\f\3\f\3\r\3\r\7" +
                    "\rs\n\r\f\r\16\rv\13\r\3\r\5\ry\n\r\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7\5" +
                    "\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\n\3\2C\\\4\2\62;c|\3" +
                    "\2c|\3\2))\4\2}}\177\177\4\2]]__\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u008a" +
                    "\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2" +
                    "\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2" +
                    "\2\31\3\2\2\2\3\33\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2" +
                    "\2\r/\3\2\2\2\17\66\3\2\2\2\21=\3\2\2\2\23G\3\2\2\2\25W\3\2\2\2\27j\3" +
                    "\2\2\2\31p\3\2\2\2\33\34\7i\2\2\34\35\7t\2\2\35\36\7c\2\2\36\37\7o\2\2" +
                    "\37 \7o\2\2 !\7c\2\2!\"\7t\2\2\"\4\3\2\2\2#$\7=\2\2$\6\3\2\2\2%&\7<\2" +
                    "\2&\b\3\2\2\2\'(\7~\2\2(\n\3\2\2\2)*\7n\2\2*+\7q\2\2+,\7e\2\2,-\7c\2\2" +
                    "-.\7n\2\2.\f\3\2\2\2/\63\t\2\2\2\60\62\t\3\2\2\61\60\3\2\2\2\62\65\3\2" +
                    "\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\16\3\2\2\2\65\63\3\2\2\2\66:\t\4\2" +
                    "\2\679\t\3\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\20\3\2\2\2<" +
                    ":\3\2\2\2=A\7)\2\2>?\7^\2\2?B\7)\2\2@B\n\5\2\2A>\3\2\2\2A@\3\2\2\2BC\3" +
                    "\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7)\2\2F\22\3\2\2\2GQ\7}\2\2HJ\n" +
                    "\6\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LR\3\2\2\2MN\7}\2\2NO\5" +
                    "\23\n\2OP\7\177\2\2PR\3\2\2\2QI\3\2\2\2QM\3\2\2\2RS\3\2\2\2SQ\3\2\2\2" +
                    "ST\3\2\2\2TU\3\2\2\2UV\7\177\2\2V\24\3\2\2\2Wc\7]\2\2XZ\n\7\2\2YX\3\2" +
                    "\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\a\3\2\2\2]^\7]\2\2^_\5\25\13\2_`" +
                    "\7_\2\2`b\3\2\2\2a]\3\2\2\2ab\3\2\2\2bd\3\2\2\2cY\3\2\2\2de\3\2\2\2ec" +
                    "\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7_\2\2h\26\3\2\2\2ik\t\b\2\2ji\3\2\2\2" +
                    "kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\f\2\2o\30\3\2\2\2pt\7%\2" +
                    "\2qs\n\t\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2" +
                    "\2wy\7\17\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\r" +
                    "\2\2}\32\3\2\2\2\20\2\63:ACKQS[aeltx\3\b\2\2";
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
                "T__0", "T__1", "T__2", "T__3", "Local", "Name", "NTerminal", "Literal",
                "Action", "Args", "WS", "COMMENT"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'grammar'", "';'", "':'", "'|'", "'local'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, "Local", "Name", "NTerminal", "Literal",
                "Action", "Args", "WS", "COMMENT"
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