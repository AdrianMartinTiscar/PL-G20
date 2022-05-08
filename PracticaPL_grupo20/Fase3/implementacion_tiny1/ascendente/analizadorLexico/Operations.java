package ascendente.analizadorLexico;


public class Operations {
  private AnalizadorLexicoTiny1 alex;
  
  public Operations(AnalizadorLexicoTiny1 alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ID,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadNEnt() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NENT,alex.lexema()); 
  } 
  public UnidadLexica unidadNReal() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NREAL,alex.lexema()); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PAP, "("); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PCIERRE, ")"); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IGUAL, "="); 
  }
  public UnidadLexica unidadTrue() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.TRUE, "true"); 
  }
  public UnidadLexica unidadFalse() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.FALSE, "false"); 
  }
  public UnidadLexica unidadAnd() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.AND, "and"); 
  }
  public UnidadLexica unidadOr() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.OR, "or"); 
  }
  public UnidadLexica unidadNot() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NOT, "not"); 
  }
  public UnidadLexica unidadMenor() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOR, "<"); 
  }
  public UnidadLexica unidadMenorIgual() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENORIGUAL, "<="); 
  }
  public UnidadLexica unidadMayor() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAYOR, ">"); 
  }
  public UnidadLexica unidadMayorIgual() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAYORIGUAL, ">="); 
  }
  public UnidadLexica unidadComparacion() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.COMPARACION, "=="); 
  }
  public UnidadLexica unidadDistinto() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DISTINTO, "!="); 
  }
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAS, "+"); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOS, "-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MUL, "*"); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DIV, "/"); 
  } 
  public UnidadLexica unidadSep() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.SEP, "&&"); 
  }
  public UnidadLexica unidadPntComa() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PTOCOMA, ";"); 
  }
  public UnidadLexica unidadInt() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.INT, "int"); 
  }
  public UnidadLexica unidadReal() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.REAL, "real"); 
  }
  public UnidadLexica unidadBool() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BOOL, "bool"); 
  }
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.EOF, "<EOF>"); 
  }
  public UnidadLexica unidadLiteralCad() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LITERALCAD, alex.lexema()); 
  } 
  public UnidadLexica unidadMod() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MODULO, "%"); 
  }
  public UnidadLexica unidadCorcheteAbierto() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORABIERTO, "["); 
  } 
  public UnidadLexica unidadCorcheteCerrado() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORCERRADO, "]"); 
  }
  public UnidadLexica unidadLlaveAbierta() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LLAVEABIERTA, "{"); 
  } 
  public UnidadLexica unidadLlaveCerrada() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LLAVECERRADA, "}"); 
  } 
  public UnidadLexica unidadPunto() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PUNTO, "."); 
  }
  public UnidadLexica unidadFlecha() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.FLECHA, "->"); 
  }
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.COMA, ","); 
  } 
  public UnidadLexica unidadAmp() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.AMP, "&"); 
  }
  public UnidadLexica unidadString() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.STRING, "string"); 
  }
  public UnidadLexica unidadNull() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NULL, "null"); 
  }
  public UnidadLexica unidadProc() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PROC, "proc"); 
  }
  public UnidadLexica unidadIf() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IF, "if"); 
  }
  public UnidadLexica unidadThen() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.THEN, "then"); 
  }
  public UnidadLexica unidadElse() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ELSE, "else"); 
  }
  public UnidadLexica unidadEndIf() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ENDIF, "endif"); 
  }
  public UnidadLexica unidadWhile() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.WHILE, "while"); 
  }
  public UnidadLexica unidadDo() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DO, "do"); 
  }
  public UnidadLexica unidadEndWhile() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE, "endwhile"); 
  }
  public UnidadLexica unidadCall() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CALL, "call"); 
  }
  public UnidadLexica unidadRecord() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.RECORD, "record"); 
  }
  public UnidadLexica unidadArray() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ARRAY, "array"); 
  }
  public UnidadLexica unidadOf() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.OF, "of"); 
  }
  public UnidadLexica unidadPointer() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.POINTER, "pointer"); 
  }
  public UnidadLexica unidadNew() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NEW, "new"); 
  }
  public UnidadLexica unidadDelete() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DELETE, "delete"); 
  }
  public UnidadLexica unidadRead() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.READ, "read"); 
  }
  public UnidadLexica unidadWrite() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.WRITE, "write"); 
  }
  public UnidadLexica unidadNl() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NL, "nl"); 
  }
  public UnidadLexica unidadVar() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.VAR, "var"); 
  }
  public UnidadLexica unidadType() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.TYPE, "type"); 
  }  
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
