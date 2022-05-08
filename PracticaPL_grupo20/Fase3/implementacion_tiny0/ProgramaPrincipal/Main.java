package ProgramaPrincipal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import AnalizadorSintactico_Manual.AnalizadorSintacticoTiny0;
import procesamiento.Impresion;
import procesamiento.Procesamiento;
import procesamiento.TinyASint;

public class Main {
	
   public static void main(String[] args) throws FileNotFoundException, IOException {
	 Reader input = null;
	 if(args.length == 0) { // Si no se proporciona ruta al fichero de prueba
		System.out.println("Proporcione un fichero como argumento de entrada\n"
		    	 		+ "en el siguiente formato: pruebas_tiny_0/filename.txt\n");
	 }
	 else { // Leer fichero de prueba
		 String filename = "prueba10_tiny0.txt";
		 String curDir = System.getProperty("user.dir");
		 input = new InputStreamReader(new FileInputStream(curDir+"/pruebas_tiny_0/"+filename));
		 
		 AnalizadorSintacticoTiny0 asint = new AnalizadorSintacticoTiny0(input);
		 try {
			 asint.Programa().procesa((Procesamiento) new Impresion());
			 System.out.println("OK");
		 } catch (Exception e) {
			System.out.println(e.getMessage());
		 }
			
		 /*asint.AnalizadorSintacticoTiny0 constructorast = new asint.AnalizadorSintacticoTiny0(input);
		 constructorast.Programa().procesa((Procesamiento) new Impresion());*/
	 }
   }
}   
   
