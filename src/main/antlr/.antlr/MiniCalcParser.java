// Generated from /Users/tedneward/Projects/MiniCalc.git/src/main/antlr/MiniCalcParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, INPUT=3, VAR=4, PRINT=5, AS=6, INT=7, DECIMAL=8, STRING=9, 
		INTLIT=10, DECLIT=11, PLUS=12, MINUS=13, ASTERISK=14, DIVISION=15, ASSIGN=16, 
		LPAREN=17, RPAREN=18, ID=19, STRING_OPEN=20, UNMATCHED=21, ESCAPE_STRING_DELIMITER=22, 
		ESCAPE_SLASH=23, ESCAPE_NEWLINE=24, ESCAPE_SHARP=25, STRING_CLOSE=26, 
		INTERPOLATION_OPEN=27, STRING_CONTENT=28, INTERPOLATION_CLOSE=29, INTERP_WS=30;
	public static final int
		RULE_miniCalcFile = 0, RULE_line = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_expr = 4, RULE_stringLiteralContent = 5, RULE_type = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"miniCalcFile", "line", "statement", "assignment", "expr", "stringLiteralContent", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'input'", "'var'", "'print'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'\\\"'", "'\\\\'", "'\\n'", "'\\#'", null, "'#{'", null, "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "INPUT", "VAR", "PRINT", "AS", "INT", "DECIMAL", 
			"STRING", "INTLIT", "DECLIT", "PLUS", "MINUS", "ASTERISK", "DIVISION", 
			"ASSIGN", "LPAREN", "RPAREN", "ID", "STRING_OPEN", "UNMATCHED", "ESCAPE_STRING_DELIMITER", 
			"ESCAPE_SLASH", "ESCAPE_NEWLINE", "ESCAPE_SHARP", "STRING_CLOSE", "INTERPOLATION_OPEN", 
			"STRING_CONTENT", "INTERPOLATION_CLOSE", "INTERP_WS"
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
	public String getGrammarFileName() { return "MiniCalcParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MiniCalcFileContext extends ParserRuleContext {
		public LineContext lines;
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public MiniCalcFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_miniCalcFile; }
	}

	public final MiniCalcFileContext miniCalcFile() throws RecognitionException {
		MiniCalcFileContext _localctx = new MiniCalcFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_miniCalcFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				((MiniCalcFileContext)_localctx).lines = line();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INPUT) | (1L << VAR) | (1L << PRINT) | (1L << ID))) != 0) );
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

	public static class LineContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MiniCalcParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(MiniCalcParser.EOF, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			statement();
			setState(20);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintStmtContext extends StatementContext {
		public TerminalNode PRINT() { return getToken(MiniCalcParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCalcParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCalcParser.RPAREN, 0); }
		public PrintStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStmtContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class VarStmtContext extends StatementContext {
		public TerminalNode VAR() { return getToken(MiniCalcParser.VAR, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VarStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class InputStmtContext extends StatementContext {
		public Token name;
		public TerminalNode INPUT() { return getToken(MiniCalcParser.INPUT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniCalcParser.ID, 0); }
		public InputStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT:
				_localctx = new InputStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(INPUT);
				setState(23);
				type();
				setState(24);
				((InputStmtContext)_localctx).name = match(ID);
				}
				break;
			case VAR:
				_localctx = new VarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(VAR);
				setState(27);
				assignment();
				}
				break;
			case ID:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				assignment();
				}
				break;
			case PRINT:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				match(PRINT);
				setState(30);
				match(LPAREN);
				setState(31);
				expr(0);
				setState(32);
				match(RPAREN);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniCalcParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCalcParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ID);
			setState(37);
			match(ASSIGN);
			setState(38);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryMinusExpressionContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(MiniCalcParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExpressionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class DecimalLiteralContext extends ExprContext {
		public TerminalNode DECLIT() { return getToken(MiniCalcParser.DECLIT, 0); }
		public DecimalLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryOperatonContext extends ExprContext {
		public ExprContext left;
		public Token operator;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(MiniCalcParser.DIVISION, 0); }
		public TerminalNode ASTERISK() { return getToken(MiniCalcParser.ASTERISK, 0); }
		public BinaryOperatonContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class StringLiteralContext extends ExprContext {
		public StringLiteralContentContext stringLiteralContent;
		public List<StringLiteralContentContext> parts = new ArrayList<StringLiteralContentContext>();
		public TerminalNode STRING_OPEN() { return getToken(MiniCalcParser.STRING_OPEN, 0); }
		public TerminalNode STRING_CLOSE() { return getToken(MiniCalcParser.STRING_CLOSE, 0); }
		public List<StringLiteralContentContext> stringLiteralContent() {
			return getRuleContexts(StringLiteralContentContext.class);
		}
		public StringLiteralContentContext stringLiteralContent(int i) {
			return getRuleContext(StringLiteralContentContext.class,i);
		}
		public StringLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IntLiteralContext extends ExprContext {
		public TerminalNode INTLIT() { return getToken(MiniCalcParser.INTLIT, 0); }
		public IntLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpressionContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(MiniCalcParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCalcParser.RPAREN, 0); }
		public ParenExpressionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryOperationContext extends ExprContext {
		public ExprContext left;
		public Token operator;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MiniCalcParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniCalcParser.MINUS, 0); }
		public BinaryOperationContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class TypeConversionContext extends ExprContext {
		public ExprContext left;
		public TypeContext targetType;
		public TerminalNode AS() { return getToken(MiniCalcParser.AS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeConversionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class VarReferenceContext extends ExprContext {
		public TerminalNode ID() { return getToken(MiniCalcParser.ID, 0); }
		public VarReferenceContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(41);
				match(LPAREN);
				setState(42);
				expr(0);
				setState(43);
				match(RPAREN);
				}
				break;
			case ID:
				{
				_localctx = new VarReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(ID);
				}
				break;
			case MINUS:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(MINUS);
				setState(47);
				expr(4);
				}
				break;
			case STRING_OPEN:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(STRING_OPEN);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INTERPOLATION_OPEN || _la==STRING_CONTENT) {
					{
					{
					setState(49);
					((StringLiteralContext)_localctx).stringLiteralContent = stringLiteralContent();
					((StringLiteralContext)_localctx).parts.add(((StringLiteralContext)_localctx).stringLiteralContent);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(STRING_CLOSE);
				}
				break;
			case INTLIT:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(INTLIT);
				}
				break;
			case DECLIT:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(DECLIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(69);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperatonContext(new ExprContext(_parentctx, _parentState));
						((BinaryOperatonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(61);
						((BinaryOperatonContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==DIVISION) ) {
							((BinaryOperatonContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(62);
						((BinaryOperatonContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOperationContext(new ExprContext(_parentctx, _parentState));
						((BinaryOperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(64);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						((BinaryOperationContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new TypeConversionContext(new ExprContext(_parentctx, _parentState));
						((TypeConversionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(67);
						match(AS);
						setState(68);
						((TypeConversionContext)_localctx).targetType = type();
						}
						break;
					}
					} 
				}
				setState(73);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringLiteralContentContext extends ParserRuleContext {
		public StringLiteralContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteralContent; }
	 
		public StringLiteralContentContext() { }
		public void copyFrom(StringLiteralContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InteropolatedValueContext extends StringLiteralContentContext {
		public TerminalNode INTERPOLATION_OPEN() { return getToken(MiniCalcParser.INTERPOLATION_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INTERPOLATION_CLOSE() { return getToken(MiniCalcParser.INTERPOLATION_CLOSE, 0); }
		public InteropolatedValueContext(StringLiteralContentContext ctx) { copyFrom(ctx); }
	}
	public static class ConstantStringContext extends StringLiteralContentContext {
		public TerminalNode STRING_CONTENT() { return getToken(MiniCalcParser.STRING_CONTENT, 0); }
		public ConstantStringContext(StringLiteralContentContext ctx) { copyFrom(ctx); }
	}

	public final StringLiteralContentContext stringLiteralContent() throws RecognitionException {
		StringLiteralContentContext _localctx = new StringLiteralContentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stringLiteralContent);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_CONTENT:
				_localctx = new ConstantStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(STRING_CONTENT);
				}
				break;
			case INTERPOLATION_OPEN:
				_localctx = new InteropolatedValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(INTERPOLATION_OPEN);
				setState(76);
				expr(0);
				setState(77);
				match(INTERPOLATION_CLOSE);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringContext extends TypeContext {
		public TerminalNode STRING() { return getToken(MiniCalcParser.STRING, 0); }
		public StringContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntegerContext extends TypeContext {
		public TerminalNode INT() { return getToken(MiniCalcParser.INT, 0); }
		public IntegerContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class DecimalContext extends TypeContext {
		public TerminalNode DECIMAL() { return getToken(MiniCalcParser.DECIMAL, 0); }
		public DecimalContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(INT);
				}
				break;
			case DECIMAL:
				_localctx = new DecimalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(DECIMAL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 Y\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4%\n\4\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\65\n\6\f\6"+
		"\16\68\13\6\3\6\3\6\3\6\5\6=\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\3\7\3\7\5\7R\n\7\3\b\3\b\3\b\5\bW\n"+
		"\b\3\b\2\3\n\t\2\4\6\b\n\f\16\2\5\3\3\3\3\3\2\20\21\3\2\16\17\2a\2\21"+
		"\3\2\2\2\4\25\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n<\3\2\2\2\fQ\3\2\2\2\16V"+
		"\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24"+
		"\3\2\2\2\24\3\3\2\2\2\25\26\5\6\4\2\26\27\t\2\2\2\27\5\3\2\2\2\30\31\7"+
		"\5\2\2\31\32\5\16\b\2\32\33\7\25\2\2\33%\3\2\2\2\34\35\7\6\2\2\35%\5\b"+
		"\5\2\36%\5\b\5\2\37 \7\7\2\2 !\7\23\2\2!\"\5\n\6\2\"#\7\24\2\2#%\3\2\2"+
		"\2$\30\3\2\2\2$\34\3\2\2\2$\36\3\2\2\2$\37\3\2\2\2%\7\3\2\2\2&\'\7\25"+
		"\2\2\'(\7\22\2\2()\5\n\6\2)\t\3\2\2\2*+\b\6\1\2+,\7\23\2\2,-\5\n\6\2-"+
		".\7\24\2\2.=\3\2\2\2/=\7\25\2\2\60\61\7\17\2\2\61=\5\n\6\6\62\66\7\26"+
		"\2\2\63\65\5\f\7\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2"+
		"\2\679\3\2\2\28\66\3\2\2\29=\7\34\2\2:=\7\f\2\2;=\7\r\2\2<*\3\2\2\2</"+
		"\3\2\2\2<\60\3\2\2\2<\62\3\2\2\2<:\3\2\2\2<;\3\2\2\2=I\3\2\2\2>?\f\13"+
		"\2\2?@\t\3\2\2@H\5\n\6\fAB\f\n\2\2BC\t\4\2\2CH\5\n\6\13DE\f\t\2\2EF\7"+
		"\b\2\2FH\5\16\b\2G>\3\2\2\2GA\3\2\2\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2J\13\3\2\2\2KI\3\2\2\2LR\7\36\2\2MN\7\35\2\2NO\5\n\6\2OP\7\37"+
		"\2\2PR\3\2\2\2QL\3\2\2\2QM\3\2\2\2R\r\3\2\2\2SW\7\t\2\2TW\7\n\2\2UW\7"+
		"\13\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\17\3\2\2\2\n\23$\66<GIQV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}