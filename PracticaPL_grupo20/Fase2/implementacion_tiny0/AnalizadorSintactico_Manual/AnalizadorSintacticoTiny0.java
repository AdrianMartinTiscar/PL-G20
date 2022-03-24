/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico_Manual;


import errors.GestionErroresTiny0;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

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

   //Constructor
   public AnalizadorSintacticoTiny0(Reader input) throws IOException {
      errores = new GestionErroresTiny0();
      alex = new AnalizadorLexicoTiny0(input);
	//Pasar al analizador lexico el modulo de gestion de errores
      alex.fijaGestionErrores(errores);
      sigToken();
   }

   //Llama a S para reconocer todo el programa y luego empareja fin de fichero
   public void Sp() {
      Programa();
      empareja(ClaseLexica.EOF);
   }

   //------------IMPLEMENTACION DEL ANALIZADOR SINTACTICO-----------------

   /** Programa -> Decs '&&' Instrucciones
    * * */
   private void Programa() {
	 Decs();
     empareja(ClaseLexica.SEP);
     RDecs();
     /*
     switch(anticipo.clase()) {
         case DECS:          
              
              break;
         default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.DECS);                                            
   }*/
   }

   /**Decs -> Dec RDecs
    * */
   private void Decs() {
	  Dec();
	  RDecs();
   }
   
   /**Dec -> int id 
    * Dec -> bool id
    * Dec -> real id
    * */
   private void Dec()  {
	   switch(anticipo.clase()) {
       case INT:
           empareja(ClaseLexica.INT);
           empareja(ClaseLexica.ID);
           RDecs();
           break;
       case BOOL:
           empareja(ClaseLexica.BOOL);
           empareja(ClaseLexica.ID);
           RDecs();
           break;
       case REAL:
           empareja(ClaseLexica.REAL);
           empareja(ClaseLexica.ID);
           RDecs();
           break;
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.DONDE,ClaseLexica.EOF);                                       
   }
   }

   /**RDecs -> ';' Dec RDecs
    * RDecs -> cadena vacia
    * */
   private void RDecs() {
	      switch(anticipo.clase()) {
	          case PTOCOMA:
	              empareja(ClaseLexica.PTOCOMA);
	              Dec();
	              RDecs();
	              break;
	          case EOF:  break;
	          default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                          ClaseLexica.DONDE,ClaseLexica.EOF);                                       
	      } 
   }
   
   /**Instrucciones -> Inst RInstrucciones*/
   private void Instrucciones() {
	   Inst();
	   RInstrucciones();
   }
   
   private void Inst() {
	      switch(anticipo.clase()) {
	       case ID:    
	           empareja(ClaseLexica.ID);
	           empareja(ClaseLexica.IGUAL);
	           Expresion();
	           break;
	       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
	                                         ClaseLexica.IDEN);                                       
	   }
   } 
   
   private void LDs() {
      switch(anticipo.clase()) {
       case IDEN:    
           D();
           RLDs();
           break;
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                                       
   }
   }   
 
   private void RLDs() {
      switch(anticipo.clase()) {
       case COMA:    
           empareja(ClaseLexica.COMA);
           D();
           RLDs();
           break;
       case EOF: break;    
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.COMA, ClaseLexica.EOF);                                       
      }          
   }   

   private void D() {
     switch(anticipo.clase()) {       
       case IDEN:   
        empareja(ClaseLexica.IDEN);
        empareja(ClaseLexica.IGUAL);
        E0();
        break;
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                                       
     }
   }

   private void E0() {
     switch(anticipo.clase()) {
         case IDEN: case ENT: case REAL: case PAP:
             E1();
             RE0();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.ENT,
                                           ClaseLexica.REAL, ClaseLexica.PAP);                                    
     }  
   }

   private void RE0() {
      switch(anticipo.clase()) {
          case MAS: case MENOS: 
             Op0();
             E1();
             RE0();
             break;
          case DONDE: case PCIERRE: case EOF: case COMA: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);                                              
      } 
   }

   private void E1() {
     switch(anticipo.clase()) {
         case IDEN: case ENT: case REAL: case PAP:
             E2();
             RE1();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.ENT,
                                           ClaseLexica.REAL, ClaseLexica.PAP);                                    
     }  
   }

   private void RE1() {
      switch(anticipo.clase()) {
          case POR: case DIV: 
             Op1();
             E2();
             RE1();
             break;
          case DONDE: case PCIERRE: case EOF: case MAS: case MENOS: case COMA: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV,
                                      ClaseLexica.MAS, ClaseLexica.MENOS);                                              
      } 
   }

   private void E2() {
      switch(anticipo.clase()) {
          case ENT: empareja(ClaseLexica.ENT); break;
          case REAL: empareja(ClaseLexica.REAL); break; 
          case IDEN: empareja(ClaseLexica.IDEN); break;
          case PAP: 
               empareja(ClaseLexica.PAP); 
               E0(); 
               empareja(ClaseLexica.PCIERRE); 
               break;
          default:     
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.ENT,ClaseLexica.REAL,
                                      ClaseLexica.PAP);
   }   
   }

   private void Op0() {
     switch(anticipo.clase()) {
         case MAS: empareja(ClaseLexica.MAS); break;  
         case MENOS: empareja(ClaseLexica.MENOS); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);
     }  
   }

   private void Op1() {
     switch(anticipo.clase()) {
         case POR: empareja(ClaseLexica.POR); break;  
         case DIV: empareja(ClaseLexica.DIV); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV);
     }  
   }
   
   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
   }

   /**/
   private void sigToken() {
      try {
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
}
