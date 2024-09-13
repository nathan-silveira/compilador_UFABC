# Autor
Nathan Silveira Alves 11201920933
Video-explicação: https://youtu.be/aqLhE1Q-cB4

# Gramática
A descrição a seguir ilustra a gramática, sendo os termos em negrito palavras reservadas:
- programa -> **programa** ID (declaraVar)+ **inicio** (comando)+ **fim** **fimprog**
- declaraVar -> **declare** ID (VIRG, ID)* DP PV
- comando -> cmdAttrib | CmdLeitura | CmdEscrita | CmdIF | cmdWHILE | cmdDOWHILE
- cmdAttrib -> ID OP_AT expr PV
- cmdDOWHILE -> **faca** (comando)+ **enquanto** AP expr OPREL expr FP
- cmdIF -> **se** AP expr OPREL expr FP **entao** (comando)+ (**senao** (comando)+)? **fimse**
- cmdLeitura -> **leia** AP ID FP PV
- cmdEscrita -> **escreva** AP termo FP PV
- cmdWHILE -> **enquanto** AP expr OPREL expr FP **faca* (comando)+ **fimenquanto**
- expr -> termo exprl
- termo -> ID | NUM | TEXTO
- exprl -> (OP termo)*
- OP -> '+' | '-' | '*' | '/'
- OP_AT -> '-'
- OPREL -> '>' | '<' | '>=' | '<=' | '<>' | '=='
- ID -> [a-z] ( [a-z] | [A-Z] | [0-9] )*
- NUM -> [0-9]+ ('.' [0-9]+ )?
- VIRG -> ','
- PV -> ';'
- AP -> '('
- FP -> ')'
- DP -> ':'
- TEXTO -> '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
- WS -> (' ' | '\n' | '\r' | '\t' ) -> skip

## Como usar

- você precisa baixa o Antlr no site oficial (https://www.antlr.org/download/antlr-4.13.2-complete.jar)
- você deve referenciar este JAR como biblioteca do seu projeto
- para gerar os arquivos JAVA a partir do arquivo G4, o comando é este:
``` java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool [nome do arquivo da gramatica com extensão .g4] -o [pasta onde voce quer gerar os arquivos] -package [nome do pacote java que ira no cabecalho]```
