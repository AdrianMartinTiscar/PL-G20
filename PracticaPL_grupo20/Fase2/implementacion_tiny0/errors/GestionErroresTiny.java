package errors;

import AnalizadorLexico_Manual.ClaseLexica;

/*Esta clase es el gestor de errores*/
public class GestionErroresTiny {

   public void errorLexico(int fila, int col, String lexema) {
     System.out.println("ERROR fila "+fila+","+col+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  

   /*... es un array de clases lexicas esperadas, Java toma '...' como un numero variable
de parametros que mete en un array*/
   public void errorSintactico(int fila, int col, ClaseLexica encontrada, 
                               ClaseLexica ... esperadas) {
     System.out.print("ERROR fila "+fila+","+col+": Encontrado "+encontrada+" Se esperada: ");
     for(ClaseLexica esperada: esperadas)
         System.out.print(esperada+" ");
     System.out.println();
     System.exit(1);
   }

   public void errorFatal(Exception e) {
     System.out.println(e);
     e.printStackTrace();
     System.exit(1);
   }
}
