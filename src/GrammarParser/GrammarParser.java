// Generated from D:/prog/ITMO/5-term/MT/Lab4\Grammar.g4 by ANTLR 4.9.2
package GrammarParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	public static final int
			T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Range = 5, Local = 6, Name = 7, NTerminal = 8,
			Literal = 9, Action = 10, Args = 11, WS = 12, COMMENT = 13;
	public static final int
			RULE_s = 0, RULE_body = 1, RULE_name = 2, RULE_lexem = 3, RULE_line = 4,
			RULE_pravilo = 5, RULE_left = 6, RULE_right = 7, RULE_term = 8;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17K\4\2\t\2\4\3\t" +
					"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2" +
					"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3" +
					"\5\3\6\3\6\5\6*\n\6\3\6\3\6\3\7\3\7\3\7\5\7\61\n\7\3\7\3\7\3\7\3\b\3\b" +
					"\5\b8\n\b\3\t\3\t\3\t\7\t=\n\t\f\t\16\t@\13\t\3\n\3\n\3\n\3\n\7\nF\n\n" +
					"\f\n\16\nI\13\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\4\2\7\7\13\13\2J\2" +
					"\24\3\2\2\2\4\32\3\2\2\2\6\37\3\2\2\2\b#\3\2\2\2\n)\3\2\2\2\f-\3\2\2\2" +
					"\16\65\3\2\2\2\209\3\2\2\2\22G\3\2\2\2\24\25\5\6\4\2\25\26\5\4\3\2\26" +
					"\3\3\2\2\2\27\31\5\n\6\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32" +
					"\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36\7\2\2\3\36\5\3\2\2\2\37" +
					" \7\3\2\2 !\7\t\2\2!\"\7\4\2\2\"\7\3\2\2\2#$\7\t\2\2$%\7\5\2\2%&\t\2\2" +
					"\2&\t\3\2\2\2\'*\5\f\7\2(*\5\b\5\2)\'\3\2\2\2)(\3\2\2\2*+\3\2\2\2+,\7" +
					"\4\2\2,\13\3\2\2\2-\60\5\16\b\2./\7\b\2\2/\61\7\r\2\2\60.\3\2\2\2\60\61" +
					"\3\2\2\2\61\62\3\2\2\2\62\63\7\5\2\2\63\64\5\20\t\2\64\r\3\2\2\2\65\67" +
					"\7\n\2\2\668\7\r\2\2\67\66\3\2\2\2\678\3\2\2\28\17\3\2\2\29>\5\22\n\2" +
					":;\7\6\2\2;=\5\22\n\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\21\3\2" +
					"\2\2@>\3\2\2\2AF\5\16\b\2BF\7\13\2\2CF\7\f\2\2DF\7\t\2\2EA\3\2\2\2EB\3" +
					"\2\2\2EC\3\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\23\3\2\2\2I" +
					"G\3\2\2\2\t\32)\60\67>EG";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

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

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{
				"s", "body", "name", "lexem", "line", "pravilo", "left", "right", "term"
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
	public ATN getATN() {
		return _ATN;
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(18);
				name();
				setState(19);
				body();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Name || _la == NTerminal) {
					{
						{
							setState(21);
							line();
						}
					}
					setState(26);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(27);
				match(EOF);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(29);
				match(T__0);
				setState(30);
				match(Name);
				setState(31);
				match(T__1);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final LexemContext lexem() throws RecognitionException {
		LexemContext _localctx = new LexemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lexem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(33);
				match(Name);
				setState(34);
				match(T__2);
				setState(35);
				_la = _input.LA(1);
				if (!(_la == Range || _la == Literal)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(39);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case NTerminal: {
						setState(37);
						pravilo();
					}
					break;
					case Name: {
						setState(38);
						lexem();
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				setState(41);
				match(T__1);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final PraviloContext pravilo() throws RecognitionException {
		PraviloContext _localctx = new PraviloContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pravilo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(43);
				left();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == Local) {
					{
						setState(44);
						match(Local);
						setState(45);
						match(Args);
					}
				}

				setState(48);
				match(T__2);
				setState(49);
				right();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final LeftContext left() throws RecognitionException {
		LeftContext _localctx = new LeftContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_left);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(51);
				match(NTerminal);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == Args) {
					{
						setState(52);
						match(Args);
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final RightContext right() throws RecognitionException {
		RightContext _localctx = new RightContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_right);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(55);
				term();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__3) {
					{
						{
							setState(56);
							match(T__3);
							setState(57);
							term();
						}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Name) | (1L << NTerminal) | (1L << Literal) | (1L << Action))) != 0)) {
					{
						setState(67);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case NTerminal: {
								setState(63);
								left();
							}
							break;
							case Literal: {
								setState(64);
								match(Literal);
							}
							break;
							case Action: {
								setState(65);
								match(Action);
							}
							break;
							case Name: {
								setState(66);
								match(Name);
							}
							break;
							default:
								throw new NoViableAltException(this);
						}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SContext extends ParserRuleContext {
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public NameContext name() {
			return getRuleContext(NameContext.class, 0);
		}

		public BodyContext body() {
			return getRuleContext(BodyContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_s;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode EOF() {
			return getToken(GrammarParser.EOF, 0);
		}

		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_body;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class NameContext extends ParserRuleContext {
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode Name() {
			return getToken(GrammarParser.Name, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_name;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LexemContext extends ParserRuleContext {
		public LexemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode Name() {
			return getToken(GrammarParser.Name, 0);
		}

		public TerminalNode Literal() {
			return getToken(GrammarParser.Literal, 0);
		}

		public TerminalNode Range() {
			return getToken(GrammarParser.Range, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lexem;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitLexem(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public PraviloContext pravilo() {
			return getRuleContext(PraviloContext.class, 0);
		}

		public LexemContext lexem() {
			return getRuleContext(LexemContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_line;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class PraviloContext extends ParserRuleContext {
		public PraviloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public LeftContext left() {
			return getRuleContext(LeftContext.class, 0);
		}

		public RightContext right() {
			return getRuleContext(RightContext.class, 0);
		}

		public TerminalNode Local() {
			return getToken(GrammarParser.Local, 0);
		}

		public TerminalNode Args() {
			return getToken(GrammarParser.Args, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_pravilo;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitPravilo(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class LeftContext extends ParserRuleContext {
		public LeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode NTerminal() {
			return getToken(GrammarParser.NTerminal, 0);
		}

		public TerminalNode Args() {
			return getToken(GrammarParser.Args, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_left;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class RightContext extends ParserRuleContext {
		public RightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}

		public TermContext term(int i) {
			return getRuleContext(TermContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_right;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<LeftContext> left() {
			return getRuleContexts(LeftContext.class);
		}

		public LeftContext left(int i) {
			return getRuleContext(LeftContext.class, i);
		}

		public List<TerminalNode> Literal() {
			return getTokens(GrammarParser.Literal);
		}

		public TerminalNode Literal(int i) {
			return getToken(GrammarParser.Literal, i);
		}

		public List<TerminalNode> Action() {
			return getTokens(GrammarParser.Action);
		}

		public TerminalNode Action(int i) {
			return getToken(GrammarParser.Action, i);
		}

		public List<TerminalNode> Name() {
			return getTokens(GrammarParser.Name);
		}

		public TerminalNode Name(int i) {
			return getToken(GrammarParser.Name, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_term;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>) visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}
}