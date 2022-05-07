package AnalizadorSintactico_Manual;

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
		    	 		+ "en el siguiente formato: pruebas_tiny_0/filename.txt\n");
	 }
	 else { // Leer fichero de prueba
		 String filename = "prueba10_tiny0.txt";
		 input = new InputStreamReader(new FileInputStream("Fase2/pruebas_tiny_0/"+filename));
		 
		 //input = new InputStreamReader(new FileInputStream(args[0]));
		 AnalizadorSintacticoTiny0 asint = new AnalizadorSintacticoTiny0(input);
		 try {
    	    asint.Sp();
			System.out.println("OK");
		 } catch (Exception e) {
			System.out.println(e.getMessage());
		 }
	 }
   }
}   
   
