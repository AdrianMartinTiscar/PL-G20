/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico_Manual;

import errors.GestionErroresTiny0;
import procesamiento.SemOps;
import procesamiento.TinyASint.*;

import java.io.IOException;
import java.io.Reader;
import AnalizadorLexico_Manual.AnalizadorLexicoTiny0;
import AnalizadorLexico_Manual.ClaseLexica;
import AnalizadorLexico_Manual.UnidadLexica;

public class AnalizadorSintacticoTiny0 {
	// Token siguiente para tomar decisiones
	private UnidadLexica anticipo;
	// AnalizadorLexito al que pedir los tokes
	private AnalizadorLexicoTiny0 alex;
	// Modulo de gestion de errores
	private GestionErroresTiny0 errores;
	private SemOps sem;

	// Constructor
	public AnalizadorSintacticoTiny0(Reader input) throws IOException {
		errores = new GestionErroresTiny0();
		alex = new AnalizadorLexicoTiny0(input);
		// Pasar al analizador lexico el modulo de gestion de errores
		alex.fijaGestionErrores(errores);
		sigToken();
		sem = new SemOps();
	}

	/*
	 * Llama a S para reconocer todo el programa y luego empareja fin de fichero
	 * public void Sp() { Programa(); empareja(ClaseLexica.EOF); }
	 */

	// ------------GRAMATICA ACONDICIONADA-----------------

	/**
	 * Programa -> Decs '&&' Instrucciones
	 */
	private Programa Programa() {
		Decs decs = Decs();
		empareja(ClaseLexica.SEP);
		Insts inss = Instrs();
		empareja(ClaseLexica.EOF);
		return sem.programa(decs, inss);
	}

	/*
	 * Decs -> Dec RDecs
	 * 
	 * private Decs Decs() { Decs_varias decs = Dec(); RDecs(); return decs; }
	 */

	/**
	 * Dec -> int id Dec -> bool id Dec -> real id Símbolos de diagnostico: bool,
	 * int, real
	 */
	private Decs Decs() {
		switch (anticipo.clase()) {
		case INT:
		case BOOL:
		case REAL:
			Dec dec = Dec();
			return RDecs(sem.decs_una(dec));
		case SEP:
			return null;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.BOOL,
					ClaseLexica.INT, ClaseLexica.REAL);
			return null;
		}
	}

	/**
	 * RDecs -> ';' Dec RDecs RDecs -> cadena vacia Símbolos de diagnostico: ';',
	 * '&'
	 */
	private Decs RDecs(Decs decsh) {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Dec dec = Dec();
			return RDecs(sem.decs_varias(decsh, dec));
		case SEP:
			return decsh;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.SEP);
			return null;
		}
	}

	private Dec Dec() {
		UnidadLexica id;
		switch (anticipo.clase()) {
		case INT:
			empareja(ClaseLexica.INT);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_int(sem.str(id.lexema(), id.fila(), id.columna()));
		case BOOL:
			empareja(ClaseLexica.BOOL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_bool(sem.str(id.lexema(), id.fila(), id.columna()));
		case REAL:
			empareja(ClaseLexica.REAL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_real(sem.str(id.lexema(), id.fila(), id.columna()));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.BOOL, ClaseLexica.REAL);
			return null;
		}

	}

	/*
	 * Instrucciones -> Inst RInstrucciones
	 * 
	 * private void Instrucciones() { Inst(); RInstrucciones(); }
	 */

	private Insts Instrs() {
		switch (anticipo.clase()) {
		case ID:
			Inst ins = Instr();
			return RInstrucciones(sem.inst_una(ins));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.ID/*, ClaseLexica.EXP*/);
			return null;

		}
	}
	/**Inst -> Id '=' Expresion
    * Símbolos de diagnostico: id
    * */
   private Inst Instr() {
	      switch(anticipo.clase()) {
	       case ID:  
	    	   UnidadLexica id = anticipo;
	           empareja(ClaseLexica.ID);
	           empareja(ClaseLexica.IGUAL);
	           UnidadLexica e = anticipo;
	           Exp exp = E0();
	           return sem.inst(sem.str(id.lexema(), id.fila(), id.columna()),
						exp);
	       default: 
	    	   errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                         ClaseLexica.ID);
	    	   return null;
	   }
   }

	/**
	 * RInstrucciones -> ';' Inst RInstrucciones RInstrucciones -> cadena vacia
	 * Símbolos de diagnostico: ';', 'EOF'
	 */
	private Insts RInstrucciones(Insts insh) {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Inst ins = Instr();
			return RInstrucciones(sem.inst_varias(insh, ins));
		case EOF:
			return insh;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.EOF);
			return null;
		}
	}

	/*
	 * Expresion -> EO
	 * 
	 * private void Expresion() { E0(); }
	 */

	/**
	 * EO -> E1 RE0
	 */
	private Exp E0() {
		switch (anticipo.clase()) {
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
		case MAS:
		case MENOS:
			Exp exp = E1();
			return RE0(exp);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS,
					ClaseLexica.NOT, ClaseLexica.PAP);
			return null;
		}
	}

	/**
	 * RE0 -> '+' E0 RE0 -> '-' E0 RE0 -> cadena vacia Símbolos de diagnostico: '+',
	 * '-'
	 */
	private Exp RE0(Exp exph) {
		switch (anticipo.clase()) {
		case MAS:
			empareja(ClaseLexica.MAS);
			Exp e0 = E0();
			return sem.suma(exph, RE0(e0));
		case MENOS:
			empareja(ClaseLexica.MENOS);
			Exp e1 = E1();
			return sem.resta(exph, RE0(e1));
		case PCIERRE:
		case EOF:
		case PTOCOMA:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAS,
					ClaseLexica.MENOS);
			return null;
		}
	}

	/** E1 -> E2 RE1 */
	private Exp E1() {
		switch (anticipo.clase()) {
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
		case MAS:
		case MENOS:
			Exp e2 = E2();
			return RE1(e2);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS,
					ClaseLexica.NOT, ClaseLexica.PAP);
			return null;
		}
	}

	/**
	 * RE1 -> OP1 E2 RE1 RE1 -> cadena vacia Símbolos de diagnostico: and, or
	 */
	private Exp RE1(Exp exph) {
		switch (anticipo.clase()) {
		case AND:
		case OR:
			String op = OP1();
			Exp e2 = E2();
			Exp eRes = RE1(e2);
			return sem.exp(op, exph, eRes);
		//case EXPRES:
		case NENT:
		case NREAL:
		case ID:
		case EOF:
		case PTOCOMA:
		case PCIERRE:
		case MAS:
		case MENOS:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR);
			return null;
		}
	}

	/** E2 -> E3 RE2 */
	private Exp E2() {
		switch (anticipo.clase()) {
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
		case MAS:
		case MENOS:
			Exp e3 = E3();
			return RE2(e3);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.MENOS, ClaseLexica.NOT);
			return null;
		}
	}

	/**
	 * RE2 -> OP2 E3 RE2 RE2 -> cadena vacia Símbolos de diagnostico: '>', '<', '=',
	 * and, or
	 */
	private Exp RE2(Exp exph) {
		switch (anticipo.clase()) {
		case MAYOR:
		case MENOR:
		case COMPARACION:
		case DISTINTO:
		case MAYORIGUAL:
		case MENORIGUAL:
			String op = OP2();
			Exp e3 = E3();
			Exp eRes = RE2(e3);
			return sem.exp(op, exph, eRes);
		//case EXPRES:
		case NENT:
		case NREAL:
		case ID:
		case EOF:
		case PTOCOMA:
		case PCIERRE:
		case MAS:
		case MENOS:
		case AND:
		case OR:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAYOR,
					ClaseLexica.MENOR, ClaseLexica.DISTINTO, ClaseLexica.IGUAL, ClaseLexica.AND, ClaseLexica.OR);
			return null;
		}
	}

	/** E3 -> E4 RE3 */
	private Exp E3() {
		switch (anticipo.clase()) {
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
		case MAS:
		case MENOS:
			Exp e4 = E4();
			return RE3(e4);

		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NOT, ClaseLexica.MENOS);
			return null;

		}
	}

	/**
	 * RE3 -> OP3 E4 RE3 -> cadena vacia Símbolos de diagnostico: '*', '/', '!',
	 * '<', '>', '=', and, or
	 */
	private Exp RE3(Exp exph) {
		switch (anticipo.clase()) {
		case MUL:
		case DIV:
			String op = OP3();
			Exp e4 = E4();
			return sem.exp(op, exph, e4);
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
		case EOF:
		case PCIERRE:
		case MAS:
		case MENOS:
		case PTOCOMA:
		case AND:
		case OR:
		case MAYOR:
		case MENOR:
		case COMPARACION:
		case DISTINTO:
		case MENORIGUAL:
		case MAYORIGUAL:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV, ClaseLexica.MAYOR, ClaseLexica.MENOR, ClaseLexica.DISTINTO, ClaseLexica.IGUAL,
					ClaseLexica.AND, ClaseLexica.OR);
			return null;
		}
	}

	/**
	 * E4 -> '-' E5 E4 -> not E4 E4 -> E5 Simbolos de diagnostico: '(', '-', false,
	 * true, id, not, numeroEntero, numeroReal
	 */
	private Exp E4() {
		switch (anticipo.clase()) {
		case MENOS:
			empareja(ClaseLexica.MENOS);
			return sem.negacion(E5()); // TODO: revisar
		case NOT:
			empareja(ClaseLexica.NOT);
			return sem.not(E4());
		//case EXPRES:
		case PAP:
		case NENT:
		case NREAL:
		case ID:
			return E5();
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.MENOS, ClaseLexica.FALSE, ClaseLexica.TRUE, ClaseLexica.ID, ClaseLexica.NOT,
					ClaseLexica.NENT, ClaseLexica.NREAL);
			return null;
		}
	}

	/**
	 * E5 -> numeroEntero E5 -> numeroReal E5 -> id E5 -> true E5 -> false E5 ->
	 * (E0) Símbolos de diagnostico: '(', false, true, id, numeroEntero, numeroReal
	 */
	private Exp E5() {
		switch (anticipo.clase()) {
		case NENT:
			UnidadLexica entero = anticipo;
			empareja(ClaseLexica.NENT);
			return sem.numEntero(sem.str(entero.lexema(), entero.fila(), entero.columna()));
		case NREAL:
			UnidadLexica real = anticipo;
			empareja(ClaseLexica.NREAL);
			return sem.numReal(sem.str(real.lexema(), real.fila(), real.columna()));
		case ID:
			empareja(ClaseLexica.ID);
			UnidadLexica id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.id(sem.str(id.lexema(), id.fila(), id.columna()));
		case TRUE:
			empareja(ClaseLexica.TRUE);
			return sem.cierto();
		case FALSE:
			empareja(ClaseLexica.FALSE);
			return sem.falso();
		case PAP:
			empareja(ClaseLexica.PAP);
			Exp e = E0();
			empareja(ClaseLexica.PCIERRE);
			return e;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.FALSE, ClaseLexica.TRUE, ClaseLexica.ID, ClaseLexica.NENT, ClaseLexica.NREAL);
			return null;
		}
	}

	/**
	 * OP1 -> and OP1 -> or Simbolos de diagnostico: and, or
	 */
	private String OP1() {
		switch (anticipo.clase()) {
		case AND:
			empareja(ClaseLexica.AND);
			return "and";
		case OR:
			empareja(ClaseLexica.OR);
			return "or";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR);
			return null;
		}
	}

	/**
	 * OP2 -> '<' ROP2 OP2 -> '>' ROP2 OP2 -> '==' OP2 -> '!=' Simbolos de
	 * diagnostico: '>', '<', '!', '='
	 */
	private String OP2() {
		switch (anticipo.clase()) {
		case MAYOR:
			empareja(ClaseLexica.MAYOR);
			return ">";
			//ROP2(); // TODO:REVISAR
		case MAYORIGUAL:
			empareja(ClaseLexica.MAYORIGUAL);
			return ">=";
		case MENOR:
			empareja(ClaseLexica.MENOR);
			return "<";
			//ROP2();
			//break;
		case MENORIGUAL:
			empareja(ClaseLexica.MENORIGUAL);
			return "<=";
		case COMPARACION:
			empareja(ClaseLexica.COMPARACION);
			return "==";
		case DISTINTO:
			empareja(ClaseLexica.DISTINTO);
			return "!=";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAYOR,
					ClaseLexica.MENOR, ClaseLexica.DISTINTO, ClaseLexica.IGUAL);
			return null;
		}
	}

	/**
	 * ROP2 -> '=' ROP2 -> cadena vacia Simbolos de diagnostico: '=',(', '-', false,
	 * true, id, not, numeroEntero, numeroReal
	 */
	/*private String ROP2() { // TODO: REVISAR ESTA FUNCION SI ES NECESARIA
		switch (anticipo.clase()) {
		case IGUAL:
			empareja(ClaseLexica.IGUAL);
			return "=";
		case PAP:
		case MENOS:
		case TRUE:
		case FALSE:
		case ID:
		case NOT:
		case NENT:
		case NREAL:
			break;
			return;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IGUAL,
					ClaseLexica.PAP, ClaseLexica.MENOS, ClaseLexica.FALSE, ClaseLexica.TRUE, ClaseLexica.ID,
					ClaseLexica.NOT, ClaseLexica.NENT, ClaseLexica.NREAL);
			return null;
		}
	}*/

	/**
	 * OP3 -> '*' OP3 -> '/' Simbolos de diagnostico: '*', '/'
	 */
	private String OP3() {
		switch (anticipo.clase()) {
		case MUL:
			empareja(ClaseLexica.MUL);
			return "*";
		case DIV:
			empareja(ClaseLexica.DIV);
			return "/";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV);
			return null;
		}
	}

	// ------------FIN GRAMATICA ACONDICIONADA-----------------

	/**
	 * Empareja la clase lexica esperada con la del anticipo. Si coincide lee el
	 * siguiente token, en caso contrario lanza error sinctactico.
	 */
	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), claseEsperada);
	}

	/** Lee el siguiente token */
	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}

}
