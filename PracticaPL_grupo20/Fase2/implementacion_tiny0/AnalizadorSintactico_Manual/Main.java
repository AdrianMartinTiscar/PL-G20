package AnalizadorSintactico_Manual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorSintacticoTiny0 asint = new AnalizadorSintacticoTiny0(input);
     try {
    	    asint.Sp();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
 }
}   
   
