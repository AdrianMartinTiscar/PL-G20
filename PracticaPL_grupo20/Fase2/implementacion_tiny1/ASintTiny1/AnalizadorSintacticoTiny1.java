/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny1.java */
package ASintTiny1;

public class AnalizadorSintacticoTiny1 implements AnalizadorSintacticoTiny1Constants {

  final public void Sp() throws ParseException {
    Programa();
    jj_consume_token(0);
  }

  final public void Programa() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
    case 16:
      Decs();
      jj_consume_token(13);
      Instrucciones();
      break;
    case 26:
    case 33:
    case 37:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 48:
    case 49:
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
    case 14:
      jj_consume_token(14);
      Dec();
      RDecs();
      break;
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void Dec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      jj_consume_token(15);
      tipo();
      jj_consume_token(id);
      break;
      jj_consume_token(15);
      tipo();
      jj_consume_token(id);
      break;
    case 16:
      jj_consume_token(16);
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
    case 17:
      jj_consume_token(17);
      break;
    case 18:
      jj_consume_token(18);
      break;
    case 19:
      jj_consume_token(19);
      break;
    case 20:
      jj_consume_token(20);
      break;
    case id:
      jj_consume_token(id);
      break;
    case 21:
      jj_consume_token(21);
      jj_consume_token(22);
      jj_consume_token(numeroEntero);
      jj_consume_token(23);
      jj_consume_token(24);
      tipo();
      break;
    case 25:
      jj_consume_token(25);
      jj_consume_token(26);
      campos();
      jj_consume_token(27);
      break;
    case 28:
      jj_consume_token(28);
      tipo();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ParamForm() throws ParseException {
    jj_consume_token(29);
    restoParamForm();
    jj_consume_token(30);
  }

  final public void restoParamForm() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      jj_consume_token(id);
      break;
    case id:
      jj_consume_token(id);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void bloque() throws ParseException {
    jj_consume_token(26);
    Programa();
    jj_consume_token(27);
  }

  final public void campos() throws ParseException {
    campo();
    RCampos();
  }

  final public void RCampos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 14:
      jj_consume_token(14);
      campo();
      RCampos();
      break;
    default:
      jj_la1[5] = jj_gen;

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
    case 14:
      jj_consume_token(14);
      Inst();
      RInstrucciones();
      break;
    default:
      jj_la1[6] = jj_gen;

    }
  }

  final public void Inst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 48:
    case 49:
      Expresion();
      jj_consume_token(32);
      Expresion();
      break;
    case 33:
      jj_consume_token(33);
      Expresion();
      jj_consume_token(34);
      InstOp();
      jj_consume_token(35);
      break;
      jj_consume_token(33);
      Expresion();
      jj_consume_token(34);
      InstOp();
      jj_consume_token(36);
      InstOp();
      jj_consume_token(35);
      break;
    case 37:
      jj_consume_token(37);
      Expresion();
      jj_consume_token(38);
      InstOp();
      jj_consume_token(39);
      break;
    case 40:
      jj_consume_token(40);
      Expresion();
      break;
    case 41:
      jj_consume_token(41);
      Expresion();
      break;
    case 42:
      jj_consume_token(42);
      Expresion();
      break;
    case 43:
      jj_consume_token(43);
      Expresion();
      break;
    case 44:
      jj_consume_token(44);
      Expresion();
      break;
    case 45:
      jj_consume_token(45);
      jj_consume_token(id);
      paramReales();
      break;
    case 26:
      bloque();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void InstOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 26:
    case 33:
    case 37:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 48:
    case 49:
      Instrucciones();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  final public void paramReales() throws ParseException {
    jj_consume_token(29);
    RparamReales();
    jj_consume_token(30);
  }

  final public void RparamReales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 48:
    case 49:
      ListaExpresiones();
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  final public void ListaExpresiones() throws ParseException {
    Expresion();
    RListaExpresiones();
  }

  final public void RListaExpresiones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 46:
      jj_consume_token(46);
      Expresion();
      RListaExpresiones();
      break;
    default:
      jj_la1[10] = jj_gen;

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
    case 47:
      jj_consume_token(47);
      E0();
      break;
    case 48:
      jj_consume_token(48);
      E1();
      break;
    default:
      jj_la1[11] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    RE1();
  }

  final public void RE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 54:
    case 55:
      OP1();
      E2();
      RE1();
      break;
    default:
      jj_la1[12] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    E3();
    RE2();
  }

  final public void RE2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
    case 57:
    case 58:
    case 59:
      OP2();
      E3();
      RE2();
      break;
    default:
      jj_la1[13] = jj_gen;

    }
  }

  final public void E3() throws ParseException {
    E4();
    RE3();
  }

  final public void RE3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
    case 60:
    case 61:
      OP3();
      E4();
      break;
    default:
      jj_la1[14] = jj_gen;

    }
  }

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 48:
      jj_consume_token(48);
      E5();
      break;
    case 49:
      jj_consume_token(49);
      E4();
      break;
    default:
      jj_la1[15] = jj_gen;
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
    case 22:
    case 62:
    case 63:
      OP5();
      RE5();
      break;
    default:
      jj_la1[16] = jj_gen;

    }
  }

  final public void E6() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
      jj_consume_token(50);
      E6();
      break;
    case literalCad:
    case id:
    case numeroEntero:
    case numeroReal:
    case 29:
    case 51:
    case 52:
    case 53:
      E7();
      break;
    default:
      jj_la1[17] = jj_gen;
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
    case 51:
      jj_consume_token(51);
      break;
    case 52:
      jj_consume_token(52);
      break;
    case literalCad:
      jj_consume_token(literalCad);
      break;
    case 53:
      jj_consume_token(53);
      break;
    case 29:
      jj_consume_token(29);
      E0();
      jj_consume_token(30);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 54:
      jj_consume_token(54);
      break;
    case 55:
      jj_consume_token(55);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
      jj_consume_token(56);
      ROP2();
      break;
    case 57:
      jj_consume_token(57);
      ROP2();
      break;
    case 58:
      jj_consume_token(58);
      break;
    case 59:
      jj_consume_token(59);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ROP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[21] = jj_gen;

    }
  }

  final public void OP3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
      jj_consume_token(50);
      break;
    case 60:
      jj_consume_token(60);
      break;
    case 61:
      jj_consume_token(61);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 22:
      jj_consume_token(22);
      Expresion();
      jj_consume_token(23);
      break;
    case 62:
      jj_consume_token(62);
      jj_consume_token(id);
      break;
    case 63:
      jj_consume_token(63);
      jj_consume_token(id);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  public AnalizadorSintacticoTiny1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[24];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x4018000,0x4000,0x18000,0x123e0400,0x80000400,0x4000,0x4000,0x4000000,0x4000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x400000,0x20001e00,0x20001e00,0x0,0x0,0x0,0x0,0x400000,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x33f22,0x0,0x0,0x0,0x0,0x0,0x0,0x33f22,0x33f22,0x30000,0x4000,0x18000,0xc00000,0xf000000,0x30040000,0x30000,0xc0000000,0x3c0000,0x380000,0xc00000,0xf000000,0x1,0x30040000,0xc0000000,};
   }

  public AnalizadorSintacticoTiny1(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTiny1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny1(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTiny1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny1(AnalizadorSintacticoTiny1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  public void ReInit(AnalizadorSintacticoTiny1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[64];
    for (int i = 0; i < 64; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 24; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 64; i++) {
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
