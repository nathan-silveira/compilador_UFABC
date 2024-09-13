// java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool UFABCGrammar.g4 -o src\io\compiler\core -package io.compiler.core

grammar UFABCGrammar;

@header {
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
}

@members {
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
}
 
programa	: 'programa' ID  { program.setName(_input.LT(-1).getText());
                               stack.push(new ArrayList<Command>()); 
                             }
               declaravar+
               'inicio'
               comando+
               'fim'
               'fimprog'
               
               {
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
			;
						
declaravar	: 'declare' { currentDecl.clear(); } 
               ID  {
						  // checagem se a variavel ja foi declarada 
						  String id = _input.LT(-1).getText();
						  if (symbolTable.get(id) != null) {
						  	throw new UFABCSemanticException("Variable: "+ id + " already declared.");
						  }
						  
               			  currentDecl.add(new Var(_input.LT(-1).getText()));
           			}
               ( VIRG ID                
              		{   
						  id = _input.LT(-1).getText();
						  if (symbolTable.get(id) != null) {
						  	throw new UFABCSemanticException("Variable: "+ id + " already declared.");
						  }
						   
              		 	  currentDecl.add(new Var(_input.LT(-1).getText()));}
               		)*	 
               DP 
               (
               'number' {currentType = Types.NUMBER;}
               |
               'text' {currentType = Types.TEXT;}
               ) 
               
               { updateType(); } 
               PV
			;
			
comando     :	cmdAttrib
			|	cmdLeitura
			|	cmdEscrita
			|	cmdIF
			|	cmdWHILE
			|	cmdDOWHILE
			;
			
cmdWHILE	: 'enquanto' 	{ 	
								// coloca novo comando na pilha
								stack.push(new ArrayList<Command>());
								
								// zera strExpr
                      			strExpr = "";
                      			
                      			// cria um novo comando WhileCommand
                      			currentWhileCommand = new WhileCommand();
                    	 	} 
			  AP 
			  expr 
			  OPREL { 
			  		// atribui valor da expressao do codigo isi para strExpr
			  		strExpr += _input.LT(-1).getText(); 
			  		}
			  expr
			  FP { 	
			  		// setExpression com strExpr como parametro
			  		currentWhileCommand.setExpression(strExpr); 
			  		}
			  'faca' 
			  comando+ 
			  {
			  		// setCommandList com os comandos dentro do faca
			  		currentWhileCommand.setCommandList(stack.pop());  
			  }
			  'fimenquanto'
			  {
			  		// adiciona o comando While trabalhado no stack de comandos
		  			stack.peek().add(currentWhileCommand);
			  }  	
			; 
			
cmdDOWHILE	: 'faca' 	{ 		stack.push(new ArrayList<Command>());
                      			currentDoWhileCommand = new DoWhileCommand();		
                	 	} 
              comando+ 
              {
              		currentDoWhileCommand.setCommandList(stack.pop()); 
              }
			  'enquanto'	{
                      			strExpr = "";	
			  				}
			  AP
			  expr 
			  OPREL { strExpr += _input.LT(-1).getText(); }
			  expr
			  FP 	{ 	
			  		currentDoWhileCommand.setExpression(strExpr);
		  			stack.peek().add(currentDoWhileCommand);
			  		}  	
			; 
			
			
cmdIF		: 'se'  { stack.push(new ArrayList<Command>());
                      strExpr = "";
                      currentIfCommand = new IfCommand();
                    } 
               AP 
               expr
               OPREL  { strExpr += _input.LT(-1).getText(); }
               expr 
               FP  { currentIfCommand.setExpression(strExpr); }
               'entao'  
               comando+                
               { 
                  currentIfCommand.setTrueList(stack.pop());                            
               }  
               ( 'senao'  
                  { stack.push(new ArrayList<Command>()); }
                 comando+
                 {
                   currentIfCommand.setFalseList(stack.pop());
                 }  
               )? 
               'fimse' 
               {
               	   stack.peek().add(currentIfCommand);
               }  			   
			;

cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                   }
                   
                   // inicializa o ID
                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   // pega o tipo do ID que recebe a expressao da direita
                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();  
                   
                   // atribui ID a strexpr
                   strExpr = _input.LT(-1).getText();
                   currentAttribCommand = new AttribCommand();
                 }
              OP_AT { 
              		// atribui expressao completa ao strExpr
              		strExpr += _input.LT(-1).getText(); 
              		}
              expr 
              PV 
              
              {         	
				 // checagem se os tipos sao validos para a atribuicao
                 if (leftType.getValue() < rightType.getValue()){
                    throw new UFABCSemanticException("Type Mismatchig on Assignment");
                 }
                 
                 currentAttribCommand.setExpression(strExpr); 
                 stack.peek().add(currentAttribCommand);
              }
			;			
			
cmdLeitura  : 'leia' AP 
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                    stack.peek().add(cmdRead);
                  } 
               FP 
               PV 
			;
			
cmdEscrita  : 'escreva' AP 
              ( termo  { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                         
                         stack.peek().add(cmdWrite);
                       } 

              ) 
              FP PV { rightType = null;}
			;			

			
expr		:  termo  { strExpr += _input.LT(-1).getText(); } exprl 			
			;
			
termo		: ID  { if (!isDeclared(_input.LT(-1).getText())) {
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
			| NUM    {  if (rightType == null) {
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
			| TEXTO  {  if (rightType == null) {
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
			;
			
exprl 		: ( OP { strExpr += _input.LT(-1).getText(); } 
                termo { strExpr += _input.LT(-1).getText(); } 
              ) *
			;	
			
			
OP			: '+' | '-' | '*' | '/' 
			;
			
OP_AT	    : '='
		    ;
		    
OPREL       : '>' | '<' | '>=' | '<= ' | '<>' | '=='
			;		    			
			
ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
			
NUM			: [0-9]+ ('.' [0-9]+ )?
			;			
			
VIRG		: ','
			;
						
PV			: ';'
            ;			
            
AP			: '('
			;            
						
FP			: ')'
			;
									
DP			: ':'
		    ;
		    
TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
			;		    
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;