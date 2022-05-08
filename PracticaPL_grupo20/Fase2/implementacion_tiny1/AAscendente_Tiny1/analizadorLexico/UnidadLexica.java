package AAscendente_Tiny1.implementacion_jflex;

import AAscendente_Tiny1.analizadorSintactico.ClaseLexica;
import java_cup.runtime.Symbol;

/*Una unidad lexica se define con una clase, una fila y una columna.*/

public class UnidadLexica extends Symbol {
   private ClaseLexica clase; //Representa la clase del token
   private int fila;		    	
   private int columna;
   public UnidadLexica(int fila, int columna, int clase, String lex) {
     super(clase, lex);
	 this.fila = fila;
     this.columna = columna;
   }
   public int clase () {return sym;}
   public String lexema(){return (String) value;};
   public int fila() {return fila;}
   public int columna() {return columna;}
}
