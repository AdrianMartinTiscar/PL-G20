package implementacion_jflex;

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
  public UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
  } 
  public UnidadLexica unidadLLaveAbierta() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLAVEABIERTA); 
  } 
  public UnidadLexica unidadLlaveCerrada() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLAVECERRADA); 
  } 
  public UnidadLexica unidadCorAbierto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORABIERTO); 
  } 
  public UnidadLexica unidadCorCerrado() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCERRADO); 
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
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadPntComa() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PTOCOMA); 
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
  public UnidadLexica unidadLiteralCad() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LITERALCAD); 
  } 
  public UnidadLexica unidadSep() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEP); 
  }
  public UnidadLexica unidadDistinto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DISTINTO); 
  }
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
