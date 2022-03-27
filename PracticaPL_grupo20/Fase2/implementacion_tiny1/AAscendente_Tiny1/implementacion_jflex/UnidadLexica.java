package AAscendente_Tiny1.implementacion_jflex;

import AAscendente_Tiny1.analizadorSintactico.ClaseLexica;
import java_cup.runtime.Symbol;

/*Una unidad lexica se define con una clase, una fila y una columna.*/

public abstract class UnidadLexica {
   private ClaseLexica clase; //Representa la clase del token
   private int fila;		    	
   private int columna;
   public UnidadLexica(int fila, int columna, ClaseLexica clase) {
     this.fila = fila;
     this.columna = columna;
     this.clase = clase;
   }
   public ClaseLexica clase () {return clase;}
   public abstract String lexema(); /*Si el token es univaluado no soporta esta operacion y se lanza una excepcion*/
   public int fila() {return fila;}
   public int columna() {return columna;}
}
