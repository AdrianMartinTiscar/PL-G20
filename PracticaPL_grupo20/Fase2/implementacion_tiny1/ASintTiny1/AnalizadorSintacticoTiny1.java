/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny1.java */
package ASintTiny1;

public class AnalizadorSintacticoTiny1 implements AnalizadorSintacticoTiny1Constants {

  final public void Sp() throws ParseException {
    Programa();
    jj_consume_token(0);
  }

  final public void Programa() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case proc:
    case var:
    case type:
      Decs();
      jj_consume_token(Separacion);
      Instrucciones();
      break;
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case pif:
    case pwhile:
    case call:
    case pnew:
    case delete:
    case read:
    case write:
    case nl:
    case menos:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 52:
    case 54:
    case 58:
      Instrucciones();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Decs() throws ParseException {
    Dec();
    RDecs();
  }

  final public void RDecs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      Dec();
      RDecs();
      break;
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void Dec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case var:
      jj_consume_token(var);
      tipo();
      jj_consume_token(id);
      break;
    case type:
      jj_consume_token(type);
      tipo();
      jj_consume_token(id);
      break;
    case proc:
      jj_consume_token(proc);
      jj_consume_token(id);
      ParamForm();
      bloque();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pint:
      jj_consume_token(pint);
      break;
    case bool:
      jj_consume_token(bool);
      break;
    case real:
      jj_consume_token(real);
      break;
    case string:
      jj_consume_token(string);
      break;
    case id:
      jj_consume_token(id);
      break;
    case array:
      jj_consume_token(array);
      jj_consume_token(50);
      jj_consume_token(numeroEntero);
      jj_consume_token(51);
      jj_consume_token(of);
      tipo();
      break;
    case record:
      jj_consume_token(record);
      jj_consume_token(52);
      campos();
      jj_consume_token(53);
      break;
    case pointer:
      jj_consume_token(pointer);
      tipo();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ParamForm() throws ParseException {
    jj_consume_token(54);
    restoParamForm();
    jj_consume_token(55);
  }

  final public void restoParamForm() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pint:
    case real:
    case bool:
    case string:
    case record:
    case array:
    case pointer:
    case id:
      ListParamForm();
      break;
    default:
      jj_la1[4] = jj_gen;

    }
  }

  final public void ListParamForm() throws ParseException {
    Parametro();
    RListParamForm();
  }

  final public void RListParamForm() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      Parametro();
      RListParamForm();
      break;
    default:
      jj_la1[5] = jj_gen;

    }
  }

  final public void Parametro() throws ParseException {
    tipo();
    restoParametro();
  }

  final public void restoParametro() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
      jj_consume_token(56);
      jj_consume_token(id);
      break;
    case id:
      jj_consume_token(id);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void bloque() throws ParseException {
    jj_consume_token(52);
    Programa();
    jj_consume_token(53);
  }

  final public void campos() throws ParseException {
    campo();
    RCampos();
  }

  final public void RCampos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      campo();
      RCampos();
      break;
    default:
      jj_la1[7] = jj_gen;

    }
  }

  final public void campo() throws ParseException {
    tipo();
    jj_consume_token(id);
  }

  final public void Instrucciones() throws ParseException {
    Inst();
    RInstrucciones();
  }

  final public void RInstrucciones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      Inst();
      RInstrucciones();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  final public void Inst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case menos:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 54:
    case 58:
      Expresion();
      jj_consume_token(igual);
      Expresion();
      break;
    case pif:
      jj_consume_token(pif);
      Expresion();
      jj_consume_token(then);
      InstOp();
      RIf();
      break;
    case pwhile:
      jj_consume_token(pwhile);
      Expresion();
      jj_consume_token(pdo);
      InstOp();
      jj_consume_token(endwhile);
      break;
    case read:
      jj_consume_token(read);
      Expresion();
      break;
    case write:
      jj_consume_token(write);
      Expresion();
      break;
    case nl:
      jj_consume_token(nl);
      break;
    case pnew:
      jj_consume_token(pnew);
      Expresion();
      break;
    case delete:
      jj_consume_token(delete);
      Expresion();
      break;
    case call:
      jj_consume_token(call);
      jj_consume_token(id);
      paramReales();
      break;
    case 52:
      bloque();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void RIf() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case endif:
      jj_consume_token(endif);
      break;
    case pelse:
      jj_consume_token(pelse);
      InstOp();
      jj_consume_token(endif);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void InstOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case pif:
    case pwhile:
    case call:
    case pnew:
    case delete:
    case read:
    case write:
    case nl:
    case menos:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 52:
    case 54:
    case 58:
      Instrucciones();
      break;
    default:
      jj_la1[11] = jj_gen;

    }
  }

  final public void paramReales() throws ParseException {
    jj_consume_token(54);
    RparamReales();
    jj_consume_token(55);
  }

  final public void RparamReales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case menos:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 54:
    case 58:
      ListaExpresiones();
      break;
    default:
      jj_la1[12] = jj_gen;

    }
  }

  final public void ListaExpresiones() throws ParseException {
    Expresion();
    RListaExpresiones();
  }

  final public void RListaExpresiones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 57:
      jj_consume_token(57);
      Expresion();
      RListaExpresiones();
      break;
    default:
      jj_la1[13] = jj_gen;

    }
  }

  final public void Expresion() throws ParseException {
    E0();
  }

  final public void E0() throws ParseException {
    E1();
    RE0();
  }

  final public void RE0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case mas:
      jj_consume_token(mas);
      E0();
      break;
    case menos:
      jj_consume_token(menos);
      E1();
      break;
    default:
      jj_la1[14] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    RE1();
  }

  final public void RE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
    case or:
      OP1();
      E2();
      RE1();
      break;
    default:
      jj_la1[15] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    E3();
    RE2();
  }

  final public void RE2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case equiv:
    case distinto:
    case 59:
    case 60:
      OP2();
      E3();
      RE2();
      break;
    default:
      jj_la1[16] = jj_gen;

    }
  }

  final public void E3() throws ParseException {
    E4();
    RE3();
  }

  final public void RE3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 58:
    case 61:
    case 62:
      OP3();
      E4();
      break;
    default:
      jj_la1[17] = jj_gen;

    }
  }

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case menos:
      jj_consume_token(menos);
      E5();
      break;
    case not:
      jj_consume_token(not);
      E4();
      break;
    case ptrue:
    case pfalse:
    case pnull:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 54:
    case 58:
      E5();
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E5() throws ParseException {
    E6();
    RE5();
  }

  final public void RE5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
    case 63:
    case 64:
      OP5();
      RE5();
      break;
    default:
      jj_la1[19] = jj_gen;

    }
  }

  final public void E6() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 58:
      jj_consume_token(58);
      E6();
      break;
    case ptrue:
    case pfalse:
    case pnull:
    case id:
    case numeroEntero:
    case numeroReal:
    case literalCad:
    case 54:
      E7();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E7() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
      jj_consume_token(numeroEntero);
      break;
    case numeroReal:
      jj_consume_token(numeroReal);
      break;
    case id:
      jj_consume_token(id);
      break;
    case ptrue:
      jj_consume_token(ptrue);
      break;
    case pfalse:
      jj_consume_token(pfalse);
      break;
    case literalCad:
      jj_consume_token(literalCad);
      break;
    case pnull:
      jj_consume_token(pnull);
      break;
    case 54:
      jj_consume_token(54);
      E0();
      jj_consume_token(55);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
      jj_consume_token(and);
      break;
    case or:
      jj_consume_token(or);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 59:
      jj_consume_token(59);
      ROP2();
      break;
    case 60:
      jj_consume_token(60);
      ROP2();
      break;
    case equiv:
      jj_consume_token(equiv);
      break;
    case distinto:
      jj_consume_token(distinto);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ROP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case igual:
      jj_consume_token(igual);
      break;
    default:
      jj_la1[24] = jj_gen;

    }
  }

  final public void OP3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 58:
      jj_consume_token(58);
      break;
    case 61:
      jj_consume_token(61);
      break;
    case 62:
      jj_consume_token(62);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
      jj_consume_token(50);
      Expresion();
      jj_consume_token(51);
      break;
    case 63:
      jj_consume_token(63);
      jj_consume_token(id);
      break;
    case 64:
      jj_consume_token(64);
      jj_consume_token(id);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  public AnalizadorSintacticoTiny1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x91e3000,0x0,0x80000,0xb0004e00,0xb0004e00,0x0,0x0,0x0,0x0,0x9163000,0xc00000,0x9163000,0x63000,0x0,0x0,0x18000,0x0,0x0,0x63000,0x0,0x43000,0x43000,0x18000,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x453e07f,0x100,0x60,0x4000,0x4000,0x100,0x1004000,0x100,0x100,0x453e01f,0x0,0x453e01f,0x443e000,0x2000000,0x3000,0x0,0x18000c00,0x64000000,0x443e000,0x80040000,0x443c000,0x43c000,0x0,0x18000c00,0x200,0x64000000,0x80040000,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x1,};
   }

  public AnalizadorSintacticoTiny1(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTiny1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny1(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTiny1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny1(AnalizadorSintacticoTiny1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(AnalizadorSintacticoTiny1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[65];
    for (int i = 0; i < 65; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 65; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

                                        }