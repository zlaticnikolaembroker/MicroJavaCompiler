
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());     }
"print" 	{ return new_symbol(sym.PRINT, yytext());    }
"return" 	{ return new_symbol(sym.RETURN, yytext());   }
"void" 		{ return new_symbol(sym.VOID, yytext());     }
"const"		{ return new_symbol(sym.CONST, yytext());    }
"class" 	{ return new_symbol(sym.CLASS, yytext());    }
"read" 		{ return new_symbol(sym.READ, yytext());     }
"if" 		{ return new_symbol(sym.IF, yytext());       }
"else" 		{ return new_symbol(sym.ELSE, yytext());     }
"do" 		{ return new_symbol(sym.DO, yytext());       }
"while" 	{ return new_symbol(sym.WHILE, yytext());    }
"switch" 	{ return new_symbol(sym.SWITCH, yytext());   }
"break" 	{ return new_symbol(sym.BREAK, yytext());    }
"continue" 	{ return new_symbol(sym.CONTINUE, yytext()); }
"new" 		{ return new_symbol(sym.NEW, yytext());      }
"case" 		{ return new_symbol(sym.CASE, yytext());     }

"++" 		{ return new_symbol(sym.PLUSPLUS, yytext());   	 }
"+" 		{ return new_symbol(sym.PLUS, yytext());   	 	 }
"--" 		{ return new_symbol(sym.MINUSMINUS, yytext());   }
"-" 		{ return new_symbol(sym.MINUS, yytext());   	 }
"==" 		{ return new_symbol(sym.IDENTICAL, yytext());  	 }
"=" 		{ return new_symbol(sym.EQUAL, yytext());  		 }
";" 		{ return new_symbol(sym.SEMI, yytext());   		 }
"," 		{ return new_symbol(sym.COMMA, yytext());  		 }
"||" 		{ return new_symbol(sym.OR, yytext());  		 }
"&&" 		{ return new_symbol(sym.AND, yytext());  		 }
"?" 		{ return new_symbol(sym.QUESTIONMARK, yytext()); }
"!=" 		{ return new_symbol(sym.NOTEQUAL, yytext());     }
">=" 		{ return new_symbol(sym.GREATEREQUAL, yytext()); }
">" 		{ return new_symbol(sym.GREATER, yytext());      }
"<=" 		{ return new_symbol(sym.LESSEQUAL, yytext());    }
"<" 		{ return new_symbol(sym.LESS, yytext());  		 }
"*" 		{ return new_symbol(sym.MUL, yytext());  		 }
"/" 		{ return new_symbol(sym.DIV, yytext());  		 }		
"%" 		{ return new_symbol(sym.MOD, yytext());  		 }
":" 		{ return new_symbol(sym.COLON, yytext());  		 }
"." 		{ return new_symbol(sym.DOT, yytext());  		 }

"(" 		{ return new_symbol(sym.LPAREN, yytext());  }
")" 		{ return new_symbol(sym.RPAREN, yytext());  }
"{" 		{ return new_symbol(sym.LBRACE, yytext());  }
"}"			{ return new_symbol(sym.RBRACE, yytext());  }
"[" 		{ return new_symbol(sym.LSQUARE, yytext()); }
"]"			{ return new_symbol(sym.RSQUARE, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" {yybegin(YYINITIAL);}

[0-9]+  						{return new_symbol(sym.NUMBER, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext());               }
"'"."'" 						{ return new_symbol(sym.CONSTCHAR, new Character (yytext().charAt(1))); }
"true"|"false" 					{ return new_symbol(sym.CONSTBOOL, new Boolean (yytext())); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }
 