package alex;

import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AnalizadorLexicoTiny {

   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
    INICIO, RETPCIE, RETPAP, RETEOF, RETPTOCOMA, RETID, RETIDIS, RETDIS, RETIG, RETEQ,
    RETMAY, RETMAYEQ, RETMEN, RETMENEQ, RETMUL, RETDIV, RETIAMP, RETAMP, RETSUM, RETCERO,
    RETRES, RETENT, RETIDEC, RETDEC, RETIEXP, RETISIGN, RETEXP, RETDECAUX1, RETDECAUX2 
   }

   private Estado estado;

   public AnalizadorLexicoTiny(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }
   
   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INICIO;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INICIO: 
              if(hayLetra())  transita(Estado.RETID);
              else if (hayDigitoPos()) transita(Estado.RETENT);
              else if (hayCero()) transita(Estado.RETCERO);
              else if (haySuma()) transita(Estado.RETSUM);
              else if (hayResta()) transita(Estado.RETRES);
              else if (hayMul()) transita(Estado.RETMUL);
              else if (hayDiv()) transita(Estado.RETDIV);
              else if (hayPAp()) transita(Estado.RETPAP);
              else if (hayPCierre()) transita(Estado.RETPCIE);
              else if (hayIgual()) transita(Estado.RETIG);
              else if (haySep()) transitaIgnorando(Estado.INICIO);
              else if (hayEOF()) transita(Estado.RETEOF);
              else if (hayPtoComa()) transita(Estado.RETPTOCOMA);
              else if (hayExclamacion()) transita(Estado.RETIDIS);
              else if (hayMenor()) transita(Estado.RETMEN);
              else if (hayMayor()) transita(Estado.RETMAY);
              else if (hayAmpersand()) transita(Estado.RETIAMP);
              else error();
              break;
           case RETID: 
              if (hayLetra() || hayDigito()) transita(Estado.RETID);
              else return unidadId();               
              break;
           case RETENT:
               if (hayDigito()) transita(Estado.RETENT);
               else if (hayPunto()) transita(Estado.RETIDEC);
               else if (hayExp()) transita(Estado.RETIEXP);
               else return unidadEnt();
               break;
           case RETIDEC:
               if (hayDigitoPos()) transita(Estado.RETDEC);
               else if (hayCero()) transita(Estado.RETDECAUX1);
               else error();
               break;
           case RETDECAUX1:
               if (hayDigitoPos()) transita(Estado.RETDEC);
               else if (hayCero()) transita(Estado.RETDECAUX2);
               else return unidadReal();
               break;    
           case RETIEXP:
               if (hayDigitoPos()) transita(Estado.RETEXP);
               else if (haySuma() || hayResta()) transita(Estado.RETISIGN);
               else error();
               break;
           case RETDEC: 
               if (hayDigitoPos()) transita(Estado.RETDEC);
               else if (hayCero()) transita(Estado.RETDECAUX2);
               else if (hayExp()) transita(Estado.RETIEXP);
               else return unidadReal();
               break;
           case RETDECAUX2:
               if (hayDigitoPos()) transita(Estado.RETDEC);
               else if (hayCero()) transita(Estado.RETDECAUX2);
               else error();
               break;
           case RETEXP: 
               if (hayDigito()) transita(Estado.RETEXP);
               else return unidadReal();
               break;
           case RETISIGN:
               if (hayDigitoPos()) transita(Estado.RETEXP);
               else error();
               break;
           case RETCERO:
               if (hayPunto()) transita(Estado.RETIDEC);
               else return unidadEnt();
               break;
           case RETSUM:
               if (hayDigitoPos()) transita(Estado.RETENT);
               else if(hayCero()) transita(Estado.RETCERO);
               else return unidadMas();
               break;
           case RETRES: 
               if (hayDigitoPos()) transita(Estado.RETENT);
               else if(hayCero()) transita(Estado.RETCERO);
               else return unidadMenos();
               break;
           case RETIAMP:
               if (hayAmpersand()) transita(Estado.RETAMP);
               else error();
               break;
           case RETMEN: 
               if (hayIgual()) transita(Estado.RETMENEQ);
               else return unidadMenor();
               break;
           case RETMAY: 
               if (hayIgual()) transita(Estado.RETMAYEQ);
               else return unidadMayor();
               break;
           case RETIG: 
               if (hayIgual()) transita(Estado.RETEQ);
               else return unidadIgual();
               break;
           case RETIDIS: 
               if (hayIgual()) transita(Estado.RETDIS);
               else error();
               break;
           case RETDIS: return unidadDis();
           case RETEQ: return unidadComparacion();
           case RETMAYEQ: return unidadMayorIgual();
           case RETMENEQ: return unidadMenorIgual();
           case RETAMP: return unidadSeparador();
           case RETMUL: return unidadMul();
           case RETDIV: return unidadDiv();              
           case RETPAP: return unidadPAp();
           case RETPCIE: return unidadPCierre();
           case RETPTOCOMA: return unidadPtoComa();
           case RETEOF: return unidadEof();
           
           
         }
     }    
   }
   /**Esta funcion transita de estado y lee el siguiente caracter
    * de la entrada
    * 
    * @param Estado : siguiente estado al que se debe transitar
    * */
   private void transita(Estado sig) throws IOException {
     lex.append((char)sigCar);
     sigCar();         
     estado = sig;
   }
   /**Esta funcion transita de estado ignorando el caracter actua
    * 
    * @param Estado : siguiente estado al que se debe transitar
    * */
   private void transitaIgnorando(Estado sig) throws IOException {
     sigCar();         
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     estado = sig;
   }
   /**Esta funcion se encarga de leer la entrada caracter a caracter,
    * asi como obtener la fila y columna del caracter que se esta 
    * leyendo
    * */
   private void sigCar() throws IOException {
     sigCar = input.read();
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'z';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean haySuma() {return sigCar == '+';}
   private boolean hayResta() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   //TODO:RETORNO DE CARRO????? HAY QUE AÑADIR MÁS?
   private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
   private boolean hayExp() {return sigCar == 'e' || sigCar == 'E';}
   private boolean hayAmpersand() {return sigCar == '&';}
   private boolean hayPtoComa() {return sigCar == ';';}
   private boolean hayExclamacion() {return sigCar == '!';}
   private boolean hayMenor() {return sigCar == '<';}
   private boolean hayMayor() {return sigCar == '>';}
   
   //----------FUNCIONES QUE DEVUELVEN LA UNIDAD LEXICA----------------
   private UnidadLexica unidadId() {
     switch(lex.toString()) {
         case "int":  
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.INT);
         case "real":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.REAL);
         case "bool":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL);
         case "and":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
         case "or":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
         case "not":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
         case "true":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
         case "false":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ID,lex.toString());     
      }
   }  
   private UnidadLexica unidadEnt() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.NENT,lex.toString());     
   }    
   private UnidadLexica unidadReal() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.NREAL,lex.toString());     
   }    
   private UnidadLexica unidadMas() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
   }    
   private UnidadLexica unidadMenos() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
   }    
   private UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MUL);     
   }    
   private UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
   }    
   private UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
   }    
   private UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
   }    
   private UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);     
   }    
   private UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
   }
   private UnidadLexica unidadMenor() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
   }  
   private UnidadLexica unidadMenorIgual() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENORIGUAL);     
   } 
   private UnidadLexica unidadMayor() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
   }  
   private UnidadLexica unidadMayorIgual() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYORIGUAL);     
   }
   private UnidadLexica unidadDis() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DISTINTO);     
   }
   private UnidadLexica unidadPtoComa() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PTOCOMA);     
   }
   private UnidadLexica unidadComparacion() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.COMPARACION);     
   }
   private UnidadLexica unidadSeparador() {
	 return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SEP);     
   }
   
   /** Función que muestra mensaje de error en caso de recibir un caracter inesperado
    * */
   private void error() {
     System.err.println("("+filaActual+','+columnaActual+"):Caracter inexperado");  
     System.exit(1);
   }

   public static void main(String arg[]) throws IOException {
     Reader input = new InputStreamReader(new FileInputStream("prueba.txt"));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     do {
       unidad = al.sigToken();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    } 
}