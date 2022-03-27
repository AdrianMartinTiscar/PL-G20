package AAscendente_Tiny1.analizadorSintactico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

import AAscendente_Tiny1.implementacion_jflex.ClaseLexica;
import AAscendente_Tiny1.implementacion_jflex.UnidadLexica;

public class Ascendente {
	private String fich;

	public Ascendente(String fich){
		this.fich = fich;
	}

	public void init() throws FileNotFoundException {
		Reader input = new InputStreamReader(new FileInputStream(fich));
		AnalizadorLexicoTiny1 al = new AnalizadorLexicoTiny1(input);
		UnidadLexica unidad;
		try {
			do {
				unidad = al.next_token();
			} while (unidad.clase() != ClaseLexica.EOF);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		input = new InputStreamReader(new FileInputStream(fich));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
		try {
			asint.parse();
			System.out.println("OK");
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
