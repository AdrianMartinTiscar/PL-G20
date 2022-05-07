/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico_Manual;


import errors.GestionErroresTiny0;
import procesamiento.SemOps;
import procesamiento.TinyASint.Dec;
import procesamiento.TinyASint.Dec_int;
import procesamiento.TinyASint.Decs;
import procesamiento.TinyASint.Decs_varias;
import procesamiento.TinyASint.Inst_varias;
import procesamiento.TinyASint.Insts;

import java.io.IOException;
import java.io.Reader;
import AnalizadorLexico_Manual.AnalizadorLexicoTiny0;
import AnalizadorLexico_Manual.ClaseLexica;
import AnalizadorLexico_Manual.UnidadLexica;

public class AnalizadorSintacticoTiny0 {
   //Token siguiente para tomar decisiones
   private UnidadLexica anticipo;
   //AnalizadorLexito al que pedir los tokes
   private AnalizadorLexicoTiny0 alex;
   //Modulo de gestion de errores
   private GestionErroresTiny0 errores;
   private SemOps sem;

   //Constructor
   public AnalizadorSintacticoTiny0(Reader input) throws IOException {
      errores = new GestionErroresTiny0();
      alex = new AnalizadorLexicoTiny0(input);
	//Pasar al analizador lexico el modulo de gestion de errores
      alex.fijaGestionErrores(errores);
      sigToken();
      sem = new SemOps();
   }

   /*Llama a S para reconocer todo el programa y luego empareja fin de fichero
   public void Sp() {
      Programa();
      empareja(ClaseLexica.EOF);
   }*/

   //------------GRAMATICA ACONDICIONADA-----------------

   /** Programa -> Decs '&&' Instrucciones
    * */
   private Programa Programa() {
	 Decs decs = Decs();
     empareja(ClaseLexica.SEP);
     Insts inss = Insts();
     empareja(ClaseLexica.EOF);
     return sem.programa(decs, inss);
   }

   /*Decs -> Dec RDecs
    * 
   private Decs Decs() {
	  Decs_varias decs = Dec();
	  RDecs();
	  return decs;
   }*/
   
   /**Dec -> int id 
    * Dec -> bool id
    * Dec -> real id
    * Símbolos de diagnostico: bool, int, real
    * */
   private Decs Decs()  {
	   switch(anticipo.clase()) {
       case INT:
       case BOOL:
       case REAL:
    	   Dec dec = Dec();
    	   return RestoDec(sem.Decs_una(dec));
           break;
       case SEP:
    	   return null;
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.BOOL,ClaseLexica.INT,ClaseLexica.REAL);                                       
	   }
   }
   
   private Dec Dec() {
		UnidadLexica id;
		switch (anticipo.clase()) {
		case INT:
			empareja(ClaseLexica.INT);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_int(sem.str(id.lexema(),id.fila(),id.columna()));
		case BOOL:
			empareja(ClaseLexica.BOOL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_bool(sem.str(id.lexema(),id.fila(),id.columna()));
		case REAL:
			empareja(ClaseLexica.REAL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec_real(sem.str(id.lexema(),id.fila(),id.columna()));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.BOOL, ClaseLexica.REAL);
			return null;
		}

	}

   /**RDecs -> ';' Dec RDecs
    * RDecs -> cadena vacia
    * Símbolos de diagnostico: ';', '&'
    * */
   private Decs RDecs(Decs decsh) {
	      switch(anticipo.clase()) {
	          case PTOCOMA:
	              empareja(ClaseLexica.PTOCOMA);
	              Dec dec = Dec();
	              return RDecs(sem.Decs_varias(decsh,dec));
	              break;
	          case SEP:  
	        	  return decsh;
	        	  break;
	          default: 
	        	  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                          ClaseLexica.PTOCOMA,ClaseLexica.SEP); 
	          	  return null;
	      } 
   }
   
   /**Instrucciones -> Inst RInstrucciones
    * */
   private void Instrucciones() {
	   Inst();
	   RInstrucciones();
   }
   
   /**Inst -> Id '=' Expresion
    * Símbolos de diagnostico: id
    * */
   private void Inst() {
	      switch(anticipo.clase()) {
	       case ID:    
	           empareja(ClaseLexica.ID);
	           empareja(ClaseLexica.IGUAL);
	           Expresion();
	           break;
	       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                         ClaseLexica.ID);                                       
	   }
   } 
   
   /**RInstrucciones -> ';' Inst RInstrucciones
    * RInstrucciones -> cadena vacia
    * Símbolos de diagnostico: ';', 'EOF'
    * */
   private void RInstrucciones() {
	      switch(anticipo.clase()) {
	       case PTOCOMA:    
	           empareja(ClaseLexica.PTOCOMA);
	           Inst();
	           RInstrucciones();
	           break;
	       case EOF:  break;
	       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                         ClaseLexica.PTOCOMA, ClaseLexica.EOF);                                       
	   }
   } 

   /**Expresion -> EO
    * */
   private void Expresion() {
	   E0();
   }
   
   /**EO -> E1 RE0
    * */
   private void E0() {
	 E1();
	 RE0();
   }

   /**RE0 -> '+' E0
    * RE0 -> '-' E0
    * RE0 -> cadena vacia
    * Símbolos de diagnostico: '+', '-'
    * */
   private void RE0() {
      switch(anticipo.clase()) {
          case MAS: 
             empareja(ClaseLexica.MAS);
             E0();
             break;
          case MENOS: 
              empareja(ClaseLexica.MENOS);
              E1();
              break;
          case PCIERRE: case EOF: case PTOCOMA: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);                                              
      } 
   }

   /**E1 -> E2 RE1*/
   private void E1() {
	   E2();
	   RE1();
   }

   /**RE1 -> OP1 E2 RE1
    * RE1 -> cadena vacia
    * Símbolos de diagnostico: and, or
    * */
   private void RE1() {
      switch(anticipo.clase()) {
          case AND: case OR: 
             OP1();
             E2();
             RE1();
             break;
          case MAS: case MENOS: case PCIERRE:
          case PTOCOMA: case EOF: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.AND,ClaseLexica.OR);                                              
      } 
   }

   /**E2 -> E3 RE2*/
   private void E2() {
	  E3();
	  RE2();
   }
   
   /**RE2 -> OP2 E3 RE2
    * RE2 -> cadena vacia
    * Símbolos de diagnostico: '>', '<', '=', and, or
    * */
   private void RE2() {
      switch(anticipo.clase()) {
          case MAYOR: case MENOR: case COMPARACION: case DISTINTO:
          case MAYORIGUAL: case MENORIGUAL:
             OP2();
             E3();
             RE2();
             break;
          case AND: case OR: case MAS: case MENOS:
          case PTOCOMA: case PCIERRE: case EOF: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAYOR,ClaseLexica.MENOR,ClaseLexica.DISTINTO,
                                      ClaseLexica.IGUAL,ClaseLexica.AND,ClaseLexica.OR);                                              
      } 
   }
   
   /**E3 -> E4 RE3*/
   private void E3() {
	  E4();
	  RE3();
   }
   
   /**RE3 -> OP3 E4 
    * RE3 -> cadena vacia
    * Símbolos de diagnostico: '*', '/', '!', '<', '>', '=', and, or
    * */
   private void RE3() {
      switch(anticipo.clase()) {
          case MUL: case DIV: 
             OP3();
             E4();
             break;
          case MAYOR: case MENOR: case COMPARACION: case DISTINTO: 
          case AND: case OR: case MAS: case MENOS: case PCIERRE:
          case PTOCOMA: case EOF: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
            		  				  ClaseLexica.MUL, ClaseLexica.DIV,ClaseLexica.MAYOR,
            		  				  ClaseLexica.MENOR,ClaseLexica.DISTINTO,ClaseLexica.IGUAL,
            		  				  ClaseLexica.AND,ClaseLexica.OR);                                              
      } 
   }
   
   /**E4 -> '-' E5
    * E4 -> not E4
    * E4 -> E5
    * Simbolos de diagnostico: '(', '-', false, true, id, not, numeroEntero,
    * numeroReal
    * */
   private void E4() {
	   switch(anticipo.clase()) {
	       case MENOS:  
	          empareja(ClaseLexica.MENOS);
	          E5();
	          break;
	       case NOT:  
		      empareja(ClaseLexica.NOT);
		      E4();
		      break; 
	       case NENT: case NREAL: case ID: 
	       case TRUE: case FALSE: case PAP:
	    	  E5();
	    	  break;
	       default:    
	           errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                   ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.FALSE,
	                                   ClaseLexica.TRUE,ClaseLexica.ID,ClaseLexica.NOT,
	                                   ClaseLexica.NENT,ClaseLexica.NREAL);                                              
	   } 
   }

   /**E5 -> numeroEntero
    * E5 -> numeroReal
    * E5 -> id
    * E5 -> true
    * E5 -> false
    * E5 -> (E0)
    * Símbolos de diagnostico: '(', false, true, id, numeroEntero,
    * numeroReal
    * */
   private void E5() {
	   switch(anticipo.clase()) {
	       case NENT: empareja(ClaseLexica.NENT); break;
	       case NREAL: empareja(ClaseLexica.NREAL); break; 
	       case ID: empareja(ClaseLexica.ID); break;
	       case TRUE: empareja(ClaseLexica.TRUE); break;
	       case FALSE: empareja(ClaseLexica.FALSE); break;
	       case PAP: 
	    	   empareja(ClaseLexica.PAP); 
	    	   E0(); 
	    	   empareja(ClaseLexica.PCIERRE); 
	    	   break;
	       default:    
	           errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	        		   				   ClaseLexica.PAP,ClaseLexica.FALSE,ClaseLexica.TRUE,
	        		   				   ClaseLexica.ID,ClaseLexica.NENT,ClaseLexica.NREAL);                                              
	   } 
   }
   
   /**OP1 -> and
    * OP1 -> or
    * Simbolos de diagnostico: and, or
    * */
   private void OP1() {
     switch(anticipo.clase()) {
         case AND: empareja(ClaseLexica.AND); break;  
         case OR: empareja(ClaseLexica.OR); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.AND,ClaseLexica.OR);
     }  
   }

   /**OP2 -> '<' ROP2
    * OP2 -> '>' ROP2
    * OP2 -> '=='
    * OP2 -> '!='
    * Simbolos de diagnostico: '>', '<', '!', '='
    * */
   private void OP2() {
     switch(anticipo.clase()) {
         case MAYOR:  empareja(ClaseLexica.MAYOR); ROP2(); break;
         case MAYORIGUAL: empareja(ClaseLexica.MAYORIGUAL); break;
         case MENOR:  empareja(ClaseLexica.MENOR); ROP2(); break;
         case MENORIGUAL: empareja(ClaseLexica.MENORIGUAL); break;
         case COMPARACION: empareja(ClaseLexica.COMPARACION); break;
         case DISTINTO: empareja(ClaseLexica.DISTINTO); break;
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAYOR,ClaseLexica.MENOR,ClaseLexica.DISTINTO,
                                      ClaseLexica.IGUAL);
     }  
   }
   
   /**ROP2 -> '='
    * ROP2 -> cadena vacia
    * Simbolos de diagnostico: '=',(', '-', false, true, id, not, numeroEntero,
    * numeroReal
    * */
   private void ROP2() {
     switch(anticipo.clase()) {
         case IGUAL: empareja(ClaseLexica.IGUAL); break;  
         case PAP: case MENOS: case TRUE: case FALSE:
         case ID: case NOT: case NENT: case NREAL: break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
            		  				  ClaseLexica.IGUAL,ClaseLexica.PAP,ClaseLexica.MENOS,
            		  				  ClaseLexica.FALSE,ClaseLexica.TRUE,ClaseLexica.ID,
            		  				  ClaseLexica.NOT,ClaseLexica.NENT,ClaseLexica.NREAL);
     }  
   }
   
   /**OP3 -> '*'
    * OP3 -> '/'
    * Simbolos de diagnostico: '*', '/'
    * */
   private void OP3() {
     switch(anticipo.clase()) {
         case MUL: empareja(ClaseLexica.MUL); break;  
         case DIV: empareja(ClaseLexica.DIV); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MUL,ClaseLexica.DIV);
     }  
   }
   
   //------------FIN GRAMATICA ACONDICIONADA-----------------

   
   /**Empareja la clase lexica esperada con la del anticipo.
    * Si coincide lee el siguiente token, en caso contrario
    * lanza error sinctactico.
    * */
   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
   }

   /**Lee el siguiente token*/
   private void sigToken() {
      try {
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
}
