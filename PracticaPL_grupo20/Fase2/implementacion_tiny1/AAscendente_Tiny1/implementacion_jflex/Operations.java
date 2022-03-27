package AAscendente_Tiny1.implementacion_jflex;

public class Operations {
  private AnalizadorLexicoTiny1 alex;
  public Operations(AnalizadorLexicoTiny1 alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.ID,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadNEnt() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NENT,alex.lexema()); 
  } 
  public UnidadLexica unidadNReal() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NREAL,alex.lexema()); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGUAL); 
  }
  public UnidadLexica unidadTrue() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TRUE); 
  }
  public UnidadLexica unidadFalse() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FALSE); 
  }
  public UnidadLexica unidadAnd() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AND); 
  }
  public UnidadLexica unidadOr() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OR); 
  }
  public UnidadLexica unidadNot() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOT); 
  }
  public UnidadLexica unidadMenor() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOR); 
  }
  public UnidadLexica unidadMenorIgual() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENORIGUAL); 
  }
  public UnidadLexica unidadMayor() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYOR); 
  }
  public UnidadLexica unidadMayorIgual() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYORIGUAL); 
  }
  public UnidadLexica unidadComparacion() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMPARACION); 
  }
  public UnidadLexica unidadDistinto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DISTINTO); 
  }
  public UnidadLexica unidadSuma() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MUL); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DIV); 
  } 
  public UnidadLexica unidadSep() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEP); 
  }
  public UnidadLexica unidadPntComa() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PTOCOMA); 
  }
  public UnidadLexica unidadInt() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.INT); 
  }
  public UnidadLexica unidadReal() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL); 
  }
  public UnidadLexica unidadBool() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BOOL); 
  }
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
  }
  public UnidadLexica unidadLiteralCad() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LITERALCAD); 
  } 
  public UnidadLexica unidadMod() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MODULO); 
  }
  public UnidadLexica unidadCorcheteAbierto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORABIERTO); 
  } 
  public UnidadLexica unidadCorcheteCerrado() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCERRADO); 
  }
  public UnidadLexica unidadLlaveAbierta() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLAVEABIERTA); 
  } 
  public UnidadLexica unidadLlaveCerrada() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLAVECERRADA); 
  } 
  public UnidadLexica unidadPunto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO); 
  }
  public UnidadLexica unidadFlecha() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FLECHA); 
  }
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadAmp() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AMP); 
  }
  public UnidadLexica unidadString() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.STRING); 
  }
  public UnidadLexica unidadNull() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NULL); 
  }
  public UnidadLexica unidadProc() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PROC); 
  }
  public UnidadLexica unidadIf() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IF); 
  }
  public UnidadLexica unidadThen() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.THEN); 
  }
  public UnidadLexica unidadElse() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ELSE); 
  }
  public UnidadLexica unidadEndIf() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDIF); 
  }
  public UnidadLexica unidadWhile() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WHILE); 
  }
  public UnidadLexica unidadDo() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DO); 
  }
  public UnidadLexica unidadEndWhile() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE); 
  }
  public UnidadLexica unidadCall() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CALL); 
  }
  public UnidadLexica unidadRecord() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.RECORD); 
  }
  public UnidadLexica unidadArray() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ARRAY); 
  }
  public UnidadLexica unidadOf() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OF); 
  }
  public UnidadLexica unidadPointer() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POINTER); 
  }
  public UnidadLexica unidadNew() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEW); 
  }
  public UnidadLexica unidadDelete() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DELETE); 
  }
  public UnidadLexica unidadRead() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.READ); 
  }
  public UnidadLexica unidadWrite() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WRITE); 
  }
  public UnidadLexica unidadNl() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NL); 
  }
  public UnidadLexica unidadVar() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.VAR); 
  }
  public UnidadLexica unidadType() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TYPE); 
  }  
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
