package implementacion_jflex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = null;
	 if(args.length == 0) { // Si no se proporciona ruta al fichero de prueba
    	 System.out.println("Proporcione un fichero como argumento de entrada\n"
    	 		+ "en el siguiente formato: pruebas_tiny_1/filename.txt\n");
     }
     else { // Leer fichero de prueba
    	 /*String filename = "prueba1_tiny1.txt";
    	 input = new InputStreamReader(new FileInputStream("pruebas_tiny_1/"+filename));*/
    	 
    	 input = new InputStreamReader(new FileInputStream(args[0]));
    	 
    	 AnalizadorLexicoTiny1 al = new AnalizadorLexicoTiny1(input);
    	 UnidadLexica unidad;
    	 do {
    		 unidad = al.yylex();
    		 System.out.println(unidad);
    	 }
    	 while (unidad.clase() != ClaseLexica.EOF);
     }
     
    }        
} 
