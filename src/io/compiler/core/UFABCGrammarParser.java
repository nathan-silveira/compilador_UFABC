// Generated from UFABCGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UFABCGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP=17, 
		OP_AT=18, OPREL=19, ID=20, NUM=21, VIRG=22, PV=23, AP=24, FP=25, DP=26, 
		TEXTO=27, WS=28;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_comando = 2, RULE_cmdWHILE = 3, 
		RULE_cmdDOWHILE = 4, RULE_cmdIF = 5, RULE_cmdAttrib = 6, RULE_cmdLeitura = 7, 
		RULE_cmdEscrita = 8, RULE_expr = 9, RULE_termo = 10, RULE_exprl = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "comando", "cmdWHILE", "cmdDOWHILE", "cmdIF", 
			"cmdAttrib", "cmdLeitura", "cmdEscrita", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'enquanto'", "'faca'", "'fimenquanto'", "'se'", "'entao'", 
			"'senao'", "'fimse'", "'leia'", "'escreva'", null, "'='", null, null, 
			null, "','", "';'", "'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", "NUM", "VIRG", 
			"PV", "AP", "FP", "DP", "TEXTO", "WS"
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
	public String getGrammarFileName() { return "UFABCGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    private Program program = new Program();
	    private String strExpr = "";
	    
	    // instanciacao de alguns comandos
	    private IfCommand currentIfCommand;
	    private WhileCommand currentWhileCommand;
	    private DoWhileCommand currentDoWhileCommand;    
	    private AttribCommand currentAttribCommand;
	    
	    
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    
	    
	    public void updateType(){
	    	for(Var v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    public void exibirVar(){
	        for (String id: symbolTable.keySet()){
	        	System.out.println(symbolTable.get(id));
	        }
	    }
	    
	    public Program getProgram(){
	    	return this.program;
	    	}
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }

	public UFABCGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                             
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declaravar();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(32);
			match(T__1);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149696L) != 0) );
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);

			                  program.setSymbolTable(symbolTable);
			                  program.setCommandList(stack.pop());
							  
							  // checagem se existe alguma variavel que foi declarada porem nao inicializada
							  for (String varId: symbolTable.keySet()) {
									Var var = symbolTable.get(varId);
									if (!var.isInitialized()){
										throw new UFABCSemanticException("Variable: "+ var.getId()+ " declared but not assigned. For memory reasons, please assign a value.");
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(UFABCGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UFABCGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(UFABCGrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(UFABCGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(UFABCGrammarParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__4);
			 currentDecl.clear(); 
			setState(44);
			match(ID);

									  // checagem se a variavel ja foi declarada 
									  String id = _input.LT(-1).getText();
									  if (symbolTable.get(id) != null) {
									  	throw new UFABCSemanticException("Variable: "+ id + " already declared.");
									  }
									  
			               			  currentDecl.add(new Var(_input.LT(-1).getText()));
			           			
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(46);
				match(VIRG);
				setState(47);
				match(ID);
				   
										  id = _input.LT(-1).getText();
										  if (symbolTable.get(id) != null) {
										  	throw new UFABCSemanticException("Variable: "+ id + " already declared.");
										  }
										   
				              		 	  currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(DP);
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(55);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(57);
				match(T__6);
				currentType = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(62);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIFContext cmdIF() {
			return getRuleContext(CmdIFContext.class,0);
		}
		public CmdWHILEContext cmdWHILE() {
			return getRuleContext(CmdWHILEContext.class,0);
		}
		public CmdDOWHILEContext cmdDOWHILE() {
			return getRuleContext(CmdDOWHILEContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdAttrib();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				cmdLeitura();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdEscrita();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdIF();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				cmdWHILE();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				cmdDOWHILE();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWHILEContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(UFABCGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWHILEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWHILE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdWHILE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdWHILE(this);
		}
	}

	public final CmdWHILEContext cmdWHILE() throws RecognitionException {
		CmdWHILEContext _localctx = new CmdWHILEContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdWHILE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__7);
			 	
											// coloca novo comando na pilha
											stack.push(new ArrayList<Command>());
											
											// zera strExpr
			                      			strExpr = "";
			                      			
			                      			// cria um novo comando WhileCommand
			                      			currentWhileCommand = new WhileCommand();
			                    	 	
			setState(74);
			match(AP);
			setState(75);
			expr();
			setState(76);
			match(OPREL);
			 
						  		// atribui valor da expressao do codigo isi para strExpr
						  		strExpr += _input.LT(-1).getText(); 
						  		
			setState(78);
			expr();
			setState(79);
			match(FP);
			 	
						  		// setExpression com strExpr como parametro
						  		currentWhileCommand.setExpression(strExpr); 
						  		
			setState(81);
			match(T__8);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				comando();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149696L) != 0) );

						  		// setCommandList com os comandos dentro do faca
						  		currentWhileCommand.setCommandList(stack.pop());  
						  
			setState(88);
			match(T__9);

						  		// adiciona o comando While trabalhado no stack de comandos
					  			stack.peek().add(currentWhileCommand);
						  
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDOWHILEContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(UFABCGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdDOWHILEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDOWHILE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdDOWHILE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdDOWHILE(this);
		}
	}

	public final CmdDOWHILEContext cmdDOWHILE() throws RecognitionException {
		CmdDOWHILEContext _localctx = new CmdDOWHILEContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdDOWHILE);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__8);
			 		stack.push(new ArrayList<Command>());
			                      			currentDoWhileCommand = new DoWhileCommand();		
			                	 	
			setState(94); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(93);
					comando();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

			              		currentDoWhileCommand.setCommandList(stack.pop()); 
			              
			setState(99);
			match(T__7);

			                      			strExpr = "";	
						  				
			setState(101);
			match(AP);
			setState(102);
			expr();
			setState(103);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(105);
			expr();
			setState(106);
			match(FP);
			 	
						  		currentDoWhileCommand.setExpression(strExpr);
					  			stack.peek().add(currentDoWhileCommand);
						  		
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIFContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(UFABCGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdIF(this);
		}
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__10);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(111);
			match(AP);
			setState(112);
			expr();
			setState(113);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(115);
			expr();
			setState(116);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(118);
			match(T__11);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				comando();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149696L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(125);
				match(T__12);
				 stack.push(new ArrayList<Command>()); 
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(127);
					comando();
					}
					}
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149696L) != 0) );

				                   currentIfCommand.setFalseList(stack.pop());
				                 
				}
			}

			setState(136);
			match(T__13);

			               	   stack.peek().add(currentIfCommand);
			               
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(UFABCGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   
			                   // inicializa o ID
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   // pega o tipo do ID que recebe a expressao da direita
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();  
			                   
			                   // atribui ID a strexpr
			                   strExpr = _input.LT(-1).getText();
			                   currentAttribCommand = new AttribCommand();
			                 
			setState(141);
			match(OP_AT);
			 
			              		// atribui expressao completa ao strExpr
			              		strExpr += _input.LT(-1).getText(); 
			              		
			setState(143);
			expr();
			setState(144);
			match(PV);
			         	
							 // checagem se os tipos sao validos para a atribuicao
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new UFABCSemanticException("Type Mismatchig on Assignment");
			                 }
			                 
			                 currentAttribCommand.setExpression(strExpr); 
			                 stack.peek().add(currentAttribCommand);
			              
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__14);
			setState(148);
			match(AP);
			setState(149);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(151);
			match(FP);
			setState(152);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__15);
			setState(155);
			match(AP);
			{
			setState(156);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(159);
			match(FP);
			setState(160);
			match(PV);
			 rightType = null;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(165);
			exprl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(UFABCGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(UFABCGrammarParser.TEXTO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termo);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                       throw new UFABCSemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
				                    }
				                    if (rightType == null){
				                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
				                    }   
				                    else{
				                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
				                          
				                       }
				                    }
				                  
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(NUM);
				  if (rightType == null) {
							 				rightType = Types.NUMBER;
							 				//System.out.println("Encontrei um numero pela 1a vez "+rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
							                	rightType = Types.NUMBER;
							                	//System.out.println("Mudei o tipo para Number = "+rightType);
							                }
							            }
							         
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(TEXTO);
				  if (rightType == null) {
							 				rightType = Types.TEXT;
							 				//System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.TEXT.getValue()){			                    
							                	rightType = Types.TEXT;
							                	//System.out.println("Mudei o tipo para TEXT = "+rightType);
							                	
							                }
							            }
							         
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(UFABCGrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(UFABCGrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(175);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(177);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(184);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000"+
		"\u000b\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000"+
		"\u000b\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003T\b\u0003"+
		"\u000b\u0003\f\u0003U\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004_\b\u0004\u000b\u0004"+
		"\f\u0004`\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"y\b\u0005\u000b\u0005\f\u0005z\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005\u0081\b\u0005\u000b\u0005\f\u0005\u0082\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0087\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ae\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b5\b\u000b"+
		"\n\u000b\f\u000b\u00b8\t\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u00be\u0000\u0018"+
		"\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004F\u0001\u0000"+
		"\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000"+
		"\nm\u0001\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000\u0000\u000e\u0093"+
		"\u0001\u0000\u0000\u0000\u0010\u009a\u0001\u0000\u0000\u0000\u0012\u00a3"+
		"\u0001\u0000\u0000\u0000\u0014\u00ad\u0001\u0000\u0000\u0000\u0016\u00b6"+
		"\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019\u001a"+
		"\u0005\u0014\u0000\u0000\u001a\u001c\u0006\u0000\uffff\uffff\u0000\u001b"+
		"\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0005"+
		"\u0002\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005\u0004"+
		"\u0000\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0005\u0000\u0000+,\u0006\u0001\uffff\uffff\u0000,-\u0005"+
		"\u0014\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0016\u0000"+
		"\u0000/0\u0005\u0014\u0000\u000002\u0006\u0001\uffff\uffff\u00001.\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u00006;\u0005\u001a\u0000\u000078\u0005\u0006\u0000\u00008<\u0006\u0001"+
		"\uffff\uffff\u00009:\u0005\u0007\u0000\u0000:<\u0006\u0001\uffff\uffff"+
		"\u0000;7\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=>\u0006\u0001\uffff\uffff\u0000>?\u0005\u0017\u0000\u0000"+
		"?\u0003\u0001\u0000\u0000\u0000@G\u0003\f\u0006\u0000AG\u0003\u000e\u0007"+
		"\u0000BG\u0003\u0010\b\u0000CG\u0003\n\u0005\u0000DG\u0003\u0006\u0003"+
		"\u0000EG\u0003\b\u0004\u0000F@\u0001\u0000\u0000\u0000FA\u0001\u0000\u0000"+
		"\u0000FB\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000\u0000"+
		"HI\u0005\b\u0000\u0000IJ\u0006\u0003\uffff\uffff\u0000JK\u0005\u0018\u0000"+
		"\u0000KL\u0003\u0012\t\u0000LM\u0005\u0013\u0000\u0000MN\u0006\u0003\uffff"+
		"\uffff\u0000NO\u0003\u0012\t\u0000OP\u0005\u0019\u0000\u0000PQ\u0006\u0003"+
		"\uffff\uffff\u0000QS\u0005\t\u0000\u0000RT\u0003\u0004\u0002\u0000SR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0006\u0003\uffff"+
		"\uffff\u0000XY\u0005\n\u0000\u0000YZ\u0006\u0003\uffff\uffff\u0000Z\u0007"+
		"\u0001\u0000\u0000\u0000[\\\u0005\t\u0000\u0000\\^\u0006\u0004\uffff\uffff"+
		"\u0000]_\u0003\u0004\u0002\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bc\u0006\u0004\uffff\uffff\u0000cd\u0005\b\u0000\u0000"+
		"de\u0006\u0004\uffff\uffff\u0000ef\u0005\u0018\u0000\u0000fg\u0003\u0012"+
		"\t\u0000gh\u0005\u0013\u0000\u0000hi\u0006\u0004\uffff\uffff\u0000ij\u0003"+
		"\u0012\t\u0000jk\u0005\u0019\u0000\u0000kl\u0006\u0004\uffff\uffff\u0000"+
		"l\t\u0001\u0000\u0000\u0000mn\u0005\u000b\u0000\u0000no\u0006\u0005\uffff"+
		"\uffff\u0000op\u0005\u0018\u0000\u0000pq\u0003\u0012\t\u0000qr\u0005\u0013"+
		"\u0000\u0000rs\u0006\u0005\uffff\uffff\u0000st\u0003\u0012\t\u0000tu\u0005"+
		"\u0019\u0000\u0000uv\u0006\u0005\uffff\uffff\u0000vx\u0005\f\u0000\u0000"+
		"wy\u0003\u0004\u0002\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|\u0086\u0006\u0005\uffff\uffff\u0000}~\u0005\r\u0000\u0000"+
		"~\u0080\u0006\u0005\uffff\uffff\u0000\u007f\u0081\u0003\u0004\u0002\u0000"+
		"\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0006\u0005\uffff\uffff"+
		"\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086}\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u000e\u0000\u0000\u0089\u008a\u0006\u0005\uffff\uffff"+
		"\u0000\u008a\u000b\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0014\u0000"+
		"\u0000\u008c\u008d\u0006\u0006\uffff\uffff\u0000\u008d\u008e\u0005\u0012"+
		"\u0000\u0000\u008e\u008f\u0006\u0006\uffff\uffff\u0000\u008f\u0090\u0003"+
		"\u0012\t\u0000\u0090\u0091\u0005\u0017\u0000\u0000\u0091\u0092\u0006\u0006"+
		"\uffff\uffff\u0000\u0092\r\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u000f"+
		"\u0000\u0000\u0094\u0095\u0005\u0018\u0000\u0000\u0095\u0096\u0005\u0014"+
		"\u0000\u0000\u0096\u0097\u0006\u0007\uffff\uffff\u0000\u0097\u0098\u0005"+
		"\u0019\u0000\u0000\u0098\u0099\u0005\u0017\u0000\u0000\u0099\u000f\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005\u0010\u0000\u0000\u009b\u009c\u0005"+
		"\u0018\u0000\u0000\u009c\u009d\u0003\u0014\n\u0000\u009d\u009e\u0006\b"+
		"\uffff\uffff\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"\u0019\u0000\u0000\u00a0\u00a1\u0005\u0017\u0000\u0000\u00a1\u00a2\u0006"+
		"\b\uffff\uffff\u0000\u00a2\u0011\u0001\u0000\u0000\u0000\u00a3\u00a4\u0003"+
		"\u0014\n\u0000\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5\u00a6\u0003"+
		"\u0016\u000b\u0000\u00a6\u0013\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\u0014\u0000\u0000\u00a8\u00ae\u0006\n\uffff\uffff\u0000\u00a9\u00aa\u0005"+
		"\u0015\u0000\u0000\u00aa\u00ae\u0006\n\uffff\uffff\u0000\u00ab\u00ac\u0005"+
		"\u001b\u0000\u0000\u00ac\u00ae\u0006\n\uffff\uffff\u0000\u00ad\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ad\u00a9\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ae\u0015\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\u0011\u0000\u0000\u00b0\u00b1\u0006\u000b\uffff\uffff\u0000\u00b1\u00b2"+
		"\u0003\u0014\n\u0000\u00b2\u00b3\u0006\u000b\uffff\uffff\u0000\u00b3\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b4\u00af\u0001\u0000\u0000\u0000\u00b5\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b7\u0017\u0001\u0000\u0000\u0000\u00b8\u00b6"+
		"\u0001\u0000\u0000\u0000\f\u001e$3;FU`z\u0082\u0086\u00ad\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}