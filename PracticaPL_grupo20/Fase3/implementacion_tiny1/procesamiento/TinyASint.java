package procesamiento;

public class TinyASint {
	public static abstract class Exp {
		public Exp() {
		}

		public abstract int prioridad();

		public abstract void procesa(Procesamiento procesamiento);
	}

	public static class StringLocalizado {
		private String s;
		private int fila;
		private int col;

		public StringLocalizado(String s, int fila, int col) {
			this.s = s;
			this.fila = fila;
			this.col = col;
		}

		public int fila() {
			return fila;
		}

		public int col() {
			return col;
		}

		public String toString() {
			return s;
		}

		public boolean equals(Object o) {
			return (o == this) || ((o instanceof StringLocalizado) && (((StringLocalizado) o).s.equals(s)));
		}

		public int hashCode() {
			return s.hashCode();
		}
	}

	private static abstract class ExpBin extends Exp {
		private Exp arg0;
		private Exp arg1;

		public Exp arg0() {
			return arg0;
		}

		public Exp arg1() {
			return arg1;
		}

		public ExpBin(Exp arg0, Exp arg1) {
			super();
			this.arg0 = arg0;
			this.arg1 = arg1;
		}
	}

	private static abstract class ExpAditiva extends ExpBin {
		public ExpAditiva(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 0;
		}
	}

	public static class Suma extends ExpAditiva {
		public Suma(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Resta extends ExpAditiva {
		public Resta(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpAndOr extends ExpBin {
		public ExpAndOr(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 1;
		}
	}

	public static class And extends ExpAndOr {
		public And(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Or extends ExpAndOr {
		public Or(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpRelacionales extends ExpBin {
		public ExpRelacionales(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 2;
		}
	}

	public static class Menor extends ExpRelacionales {
		public Menor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mayor extends ExpRelacionales {
		public Mayor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Menor_igual extends ExpRelacionales {
		public Menor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mayor_igual extends ExpRelacionales {
		public Mayor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Comparacion extends ExpRelacionales {
		public Comparacion(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Distinto extends ExpRelacionales {
		public Distinto(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpMultiplicativa extends ExpBin {
		public ExpMultiplicativa(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 3;
		}
	}

	public static class Mul extends ExpMultiplicativa {
		public Mul(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Div extends ExpMultiplicativa {
		public Div(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mod extends ExpMultiplicativa {
		public Mod(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpDir extends Exp {
		private Exp ar0;
		public ExpDir(Exp arg0) {
			super();
			this.ar0 = arg0;
		}
		public Exp arg0() {
			return ar0;
		}
		public final int prioridad() {
			return 4;
		}
	}

	public static class Indexacion extends ExpDir {
		private Exp ar1;
		public Indexacion(Exp arg0, Exp arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public Exp arg1() {
			return ar1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Punto extends ExpDir {
		private StringLocalizado ar1;
		public Punto(Exp arg0, StringLocalizado arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public StringLocalizado arg1() {
			return ar1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Flecha extends ExpDir {
		private StringLocalizado ar1;
		public Flecha(Exp arg0, StringLocalizado arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public StringLocalizado arg1() {
			return ar1;
		}
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Indice extends ExpDir {
		public Indice(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpUn extends Exp {
		private Exp arg;

		public Exp arg0() {
			return arg;
		}

		public ExpUn(Exp arg0) {
			super();
			this.arg = arg0;
		}

		public final int prioridad() {
			return 4;
		}
	}

	public static class Neg extends ExpUn {
		public Neg(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Not extends ExpUn {
		public Not(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Num extends Exp {
		private StringLocalizado num;

		public Num(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class NumeroEntero extends Exp {
		private StringLocalizado num;

		public NumeroEntero(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class NumeroReal extends Exp {
		private StringLocalizado num;

		public NumeroReal(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Id extends Exp {
		private StringLocalizado id;

		public Id(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class True extends Exp {
		private String cierto;

		public True() {
			super();
			this.cierto = "True";
		}

		public String num() {
			return cierto;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class False extends Exp {
		private String fals;

		public False() {
			super();
			this.fals = "False";
		}

		public String num() {
			return fals;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Null extends Exp {
		private String nul;

		public Null() {
			super();
			this.nul = "null";
		}

		public String num() {
			return nul;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;// PRIORIDAD 5????? O CUAL?
		}
	}

	public static abstract class Dec {
		public Dec() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Dec_var extends Dec {
		private Tipo tipo;
		private StringLocalizado id;

		public Dec_var(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}
	
	public static class Dec_type extends Dec {
		private Tipo tipo;
		private Tipo id;

		public Dec_type(Tipo tipo, Tipo id) {
			this.id = id;
			this.tipo = tipo;
		}

		public Tipo id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Dec_bloque extends Dec {
		private Tipo tipo;
		private StringLocalizado id;

		public Dec_bloque(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Dec_proc extends Dec {
		private StringLocalizado id;
		private ParamForm pf;
		private Bloque_vacio block;

		public Dec_proc(StringLocalizado id, ParamForm pf, Bloque_vacio block) {
			this.id = id;
			this.pf = pf;
			this.block = block;
		}

		public StringLocalizado id() {
			return id;
		}

		public ParamForm parF() {
			return pf;
		}

		public Bloque_vacio block() {
			return block;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class ParamForm {
		public ParamForm() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Param_form extends ParamForm {
		private ParamD par;
		private LParamForm pars;

		public Param_form(ParamD par, LParamForm pars) {
			this.par = par;
			this.pars = pars;
		}

		public ParamD par() {
			return par;
		}

		public LParamForm lpar() {
			return pars;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param_form_vacio extends ParamForm {
		public Param_form_vacio() {
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	//TODO: necesario???
	public static class Param_form_uno extends ParamForm {
		private ParamD par;

		public Param_form_uno(ParamD par) {
			this.par = par;
		}

		public ParamD par() {
			return par;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParamD {
		private Tipo t;
		private StringLocalizado i;

		public ParamD(Tipo t, StringLocalizado i) {
			this.t = t;
			this.i = i;
		}

		public StringLocalizado id() {
			return i;
		}

		public Tipo tipo() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}
	public static class ParamDAmp extends ParamD{
		public ParamDAmp(Tipo t, StringLocalizado i) {
			super(t, i);
		}
		public void procesa(Procesamiento p) {
			p.procesa(this);		}
	}

	public static abstract class LParamForm {
		public LParamForm() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class List_param_form_varios extends LParamForm {
		private ParamD par;
		private LParamForm pars;

		public List_param_form_varios(ParamD par, LParamForm pars) {
			this.par = par;
			this.pars = pars;
		}

		public ParamD par() {
			return par;
		}

		public LParamForm lpar() {
			return pars;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class List_param_form_uno extends LParamForm {
		private ParamD par;

		public List_param_form_uno(ParamD par) {
			this.par = par;
		}

		public ParamD par() {
			return par;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bloque extends Bloque_vacio{
		private Programa p;

		public Bloque(Programa p) {
			this.p = p;
		}

		public Programa cont() {
			return p;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}
	public static class Bloque_vacio {
		public Bloque_vacio() {
		}


		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}


	public static class Tipo_array extends Tipo {
		private NumeroEntero n;
		private Tipo t;

		public Tipo_array(StringLocalizado n, Tipo t) {
			super("tArray");
			this.n = new NumeroEntero(n);
			this.t = t;
		}

		public NumeroEntero tam() {
			return n;
		}

		public Tipo of() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class TRecord extends Tipo {
		public TRecord() {
			super("tRecord");
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class TRecord_varias extends TRecord {
		private Campo c;
		private Campos cs;

		public TRecord_varias(Campo c, Campos cs) {
			super();
			this.c = c;
			this.cs = cs;
		}

		public Campo campo() {
			return c;
		}

		public Campos campos() {
			return cs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TRecord_una extends TRecord {
		private Campo c;

		public TRecord_una(Campo c) {
			super();
			this.c = c;
		}

		public Campo campo() {
			return c;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Campos {
		public Campos() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Campos_varios extends Campos {
		private Campo c;
		private Campos cs;

		public Campos_varios(Campo c, Campos cs) {
			super();
			this.c = c;
			this.cs = cs;
		}

		public Campo campo() {
			return c;
		}

		public Campos campos() {
			return cs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Campos_uno extends Campos {
		private Campo c;

		public Campos_uno(Campo c) {
			super();
			this.c = c;
		}

		public Campo campo() {
			return c;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Campo {
		private Tipo t;
		private StringLocalizado id;

		public Campo(Tipo t, StringLocalizado id) {
			super();
			this.t = t;
			this.id = id;
		}

		public Tipo tipo() {
			return t;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_pointer extends Tipo {
		private Tipo t;

		public Tipo_pointer(Tipo t) {
			super("tPointer");
			this.t = t;
		}

		public Tipo tipo() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Decs {
		public Decs() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Decs_una extends Decs {
		private Dec dec;

		public Decs_una(Dec dec) {
			super();
			this.dec = dec;
		}

		public Dec dec() {
			return dec;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Decs_varias extends Decs {
		private Dec dec;
		private Decs decs;

		public Decs_varias(Dec dec, Decs decs) {
			super();
			this.dec = dec;
			this.decs = decs;
		}

		public Dec dec() {
			return dec;
		}

		public Decs decs() {
			return decs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Inst {
		public Inst() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Inst_asig extends Inst {
		private Exp id;
		private Exp val;

		public Inst_asig(Exp id, Exp val) {
			this.id = id;
			this.val = val;
		}

		public Exp id() {
			return id;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_ifThen extends Inst {
		private Exp val;
		private InstrOp op;

		public Inst_ifThen(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_if_nada extends Inst {
		private Exp val;

		public Instruccion_if_nada(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_ifThenElse extends Inst {
		private Exp val;
		private InstrOp op1;
		private InstrOp op2;

		public Inst_ifThenElse(Exp val, InstrOp op1, InstrOp op2) {
			this.val = val;
			this.op1 = op1;
			this.op2 = op2;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op1() {
			return op1;
		}

		public InstrOp op2() {
			return op2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_nada extends Inst {
		private Exp val;

		public Instruccion_ifelse_nada(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_no1 extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_ifelse_no1(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_no2 extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_ifelse_no2(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_bloque extends Inst {
		private Bloque_vacio blo;

		public Instruccion_bloque(Bloque_vacio blo) {
			this.blo = blo;
		}

		public Bloque_vacio blo() {
			return blo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_while extends Inst {
		private Exp val;
		private InstrOp op;

		public Inst_while(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_read extends Inst {
		private Exp val;

		public Inst_read(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_write extends Inst {
		private Exp val;

		public Inst_write(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_NewLine extends Inst {

		public Inst_NewLine() {
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_new extends Inst {
		private Exp val;

		public Inst_new(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_delete extends Inst {
		private Exp val;

		public Inst_delete(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_call extends Inst {
		private StringLocalizado str;// QUIZAS ES STRING A SECAS????
		private ParReales pReal;

		public Inst_call(StringLocalizado str, ParReales pReal) {
			this.str = str;
			this.pReal = pReal;
		}

		public StringLocalizado str() {
			return this.str;
		}

		public ParReales parReales() {
			return this.pReal;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class ParReales {
		public ParReales() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class ParReales_una extends ParReales {
		private Exp exp;

		public ParReales_una(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return this.exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParamReales_varios extends ParReales {
		private Exp exp;
		private LExpresiones lexps;

		public ParamReales_varios(Exp exp, LExpresiones lexps) {
			super();
			this.exp = exp;
			this.lexps = lexps;
		}

		public Exp exp() {
			return this.exp;
		}

		public LExpresiones lexps() {
			return this.lexps;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParamReales_vacio extends ParReales {

		public ParamReales_vacio() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LExpresiones {
		public LExpresiones() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class ListaExpresiones_una extends LExpresiones {
		private Exp exp;

		public ListaExpresiones_una(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return this.exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ListaExpresiones_varias extends LExpresiones {
		private Exp exp;
		private LExpresiones lexp;

		public ListaExpresiones_varias(Exp exp, LExpresiones lexp) {
			super();
			this.exp = exp;
			this.lexp = lexp;
		}

		public Exp exp() {
			return this.exp;
		}

		public LExpresiones lExpresiones() {
			return this.lexp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class InstrOp {
		public InstrOp() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class InstrOp_una extends InstrOp {
		private Inst instr;

		public InstrOp_una(Inst ins) {
			super();
			this.instr = ins;
		}

		public Inst instrOp() {
			return this.instr;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class InstrOp_varias extends InstrOp {
		private Insts instrs;

		public InstrOp_varias(Insts insts) {
			super();
			this.instrs = insts;
		}


		public Insts instrOps() {
			return this.instrs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}


	public static abstract class Insts {
		public Insts() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Instrucciones_una extends Insts {
		private Inst ins;

		public Instrucciones_una(Inst ins) {
			super();
			this.ins = ins;
		}

		public Inst ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instrucciones_varias extends Insts {
		private Inst ins;
		private Insts inss;

		public Instrucciones_varias(Insts inss, Inst ins) {
			super();
			this.ins = ins;
			this.inss = inss;
		}

		public Inst ins() {
			return ins;
		}

		public Insts inss() {
			return inss;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Programa {
		public Programa() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Programa_conDecs extends Programa {
		private Decs decs;
		private Insts ins;

		public Programa_conDecs(Decs decs, Insts ins) {
			super();
			this.decs = decs;
			this.ins = ins;
		}

		public Decs decs() {
			return decs;
		}

		public Insts ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Programa_sinDecs extends Programa {
		private Insts ins;

		public Programa_sinDecs(Insts ins) {
			super();
			this.ins = ins;
		}

		public Insts ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Tipo {
		private String tipo;

		public Tipo(String tipo) {
			this.tipo = tipo;
		}

		public String getTipo() {
			return this.tipo;
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Tipo_int extends Tipo {
		public Tipo_int() {
			super("Int");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_real extends Tipo {
		public Tipo_real() {
			super("Real");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_bool extends Tipo {
		public Tipo_bool() {
			super("Bool");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_string extends Tipo {
		public Tipo_string() {
			super("String");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TipoIn extends Tipo {
		public TipoIn(String t) {
			super(t);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LiteralCad extends Exp{
		private StringLocalizado cadena;

		public LiteralCad(StringLocalizado cadena) {
			this.cadena = cadena;
		}

		public StringLocalizado cad() {
			return cadena;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public int prioridad() {
			// TODO Auto-generated method stub
			return 5;
		}
	}

	// Constructoras
	public Programa programa_conDecs(Decs decs, Insts inss) {
		return new Programa_conDecs(decs, inss);
	}

	public Programa programa_sinDecs(Insts inss) {
		return new Programa_sinDecs(inss);
	}

	public Exp suma(Exp arg0, Exp arg1) {
		return new Suma(arg0, arg1);
	}

	public Exp resta(Exp arg0, Exp arg1) {
		return new Resta(arg0, arg1);
	}

	public Exp and(Exp arg0, Exp arg1) {
		return new And(arg0, arg1);
	}

	public Exp or(Exp arg0, Exp arg1) {
		return new Or(arg0, arg1);
	}

	public Exp not(Exp arg0) {
		return new Not(arg0);
	}

	public Exp menor(Exp arg0, Exp arg1) {
		return new Menor(arg0, arg1);
	}

	public Exp mayor(Exp arg0, Exp arg1) {
		return new Mayor(arg0, arg1);
	}

	public Exp menor_igual(Exp arg0, Exp arg1) {
		return new Menor_igual(arg0, arg1);
	}

	public Exp mayor_igual(Exp arg0, Exp arg1) {
		return new Mayor_igual(arg0, arg1);
	}

	public Exp comparacion(Exp arg0, Exp arg1) {
		return new Comparacion(arg0, arg1);
	}

	public Exp distinto(Exp arg0, Exp arg1) {
		return new Distinto(arg0, arg1);
	}

	public Exp neg(Exp arg0) {
		return new Neg(arg0);
	}

	public Exp mul(Exp arg0, Exp arg1) {
		return new Mul(arg0, arg1);
	}

	public Exp div(Exp arg0, Exp arg1) {
		return new Div(arg0, arg1);
	}

	public Exp mod(Exp arg0, Exp arg1) {
		return new Mod(arg0, arg1);
	}

	
	public Exp flecha(Exp arg0, Exp arg1) { 
		return new Flecha(arg0, arg1); 
	}
	 

	public Exp num(StringLocalizado num) {
		return new Num(num);
	}

	public Exp numeroEntero(StringLocalizado num) {
		return new NumeroEntero(num);
	}

	public Exp numeroReal(StringLocalizado num) {
		return new NumeroReal(num);
	}

	public Exp id(StringLocalizado num) {
		return new Id(num);
	}

	public Exp falso() {
		return new False();
	}

	public Exp cierto() {
		return new True();
	}

	public Exp nulo() {
		return new Null();
	}

	public Dec dec_var(Tipo tipo, StringLocalizado id) {
		return new Dec_var(tipo, id);
	}

	public Dec dec_proc(StringLocalizado id, ParamForm pf, Bloque_vacio block) {
		return new Dec_proc(id, pf, block);
	}

	public Dec dec_bloque(Tipo tipo, StringLocalizado id) {
		return new Dec_bloque(tipo, id);
	}

	public Decs decs_una(Dec dec) {
		return new Decs_una(dec);
	}

	public Decs decs_varias(Dec dec, Decs decs) {
		return new Decs_varias(dec, decs);
	}

	public Insts instrucciones_varias(Inst ins, Insts inss) {
		return new Instrucciones_varias(inss, ins);
	}

	public Insts instrucciones_una(Inst ins) {
		return new Instrucciones_una(ins);
	}

	public Inst inst_asig(Exp id, Exp val) {
		return new Inst_asig(id, val);
	}

	public Inst inst_ifThen(Exp id, InstrOp val) {
		return new Inst_ifThen(id, val);
	}

	public Inst instruccion_if_nada(Exp e) {
		return new Instruccion_if_nada(e);
	}

	public Inst inst_ifThenElse(Exp val, InstrOp in1, InstrOp in2) {
		return new Inst_ifThenElse(val, in1, in2);
	}

	public Inst instruccion_ifelse_nada(Exp val) {
		return new Instruccion_ifelse_nada(val);
	}

	public Inst instruccion_ifelse_no1(Exp val, InstrOp in1) {
		return new Instruccion_ifelse_no1(val, in1);
	}

	public Inst instruccion_ifelse_no2(Exp val, InstrOp in1) {
		return new Instruccion_ifelse_no2(val, in1);
	}

	public InstrOp instrOp_una(Inst ins) {
		return new InstrOp_una(ins);
	}

	public InstrOp instrOp_varias(Insts inss) {
		return new InstrOp_varias(inss);
	}

	public Inst instruccion_bloque(Bloque_vacio bloque) {
		return new Instruccion_bloque(bloque);
	}

	public Inst inst_while(Exp val, InstrOp op) {
		return new Inst_while(val, op);
	}

	public Inst inst_read(Exp val) {
		return new Inst_read(val);
	}

	public Inst inst_write(Exp val) {
		return new Inst_write(val);
	}

	public Inst inst_NewLine() {
		return new Inst_NewLine();
	}

	public Inst inst_new(Exp val) {
		return new Inst_new(val);
	}

	public Inst inst_delete(Exp val) {
		return new Inst_delete(val);
	}

	public Inst inst_call(StringLocalizado str, ParReales pReal) {
		return new Inst_call(str, pReal);
	}

	public ParReales paramReales_vacio() {
		return new ParamReales_vacio();
	}

	public ParReales parReales_una(Exp exp) {
		return new ParReales_una(exp);
	}

	public ParReales paramReales_varios(Exp exp, LExpresiones lexps) {
		return new ParamReales_varios(exp, lexps);
	}

	public LExpresiones listaExpresiones_varias(Exp exp, LExpresiones lexps) {
		return new ListaExpresiones_varias(exp, lexps);
	}

	public LExpresiones listaExpresiones_una(Exp exp) {
		return new ListaExpresiones_una(exp);
	}

	public StringLocalizado str(String s, int fila, int col) {
		return new StringLocalizado(s, fila, col);
	}

	public Tipo tipo_int() {
		return new Tipo_int();
	}

	public Tipo Tipo_string() {
		return new Tipo_string();
	}

	public Tipo tipo_bool() {
		return new Tipo_bool();
	}

	public Tipo Tipo_real() {
		return new Tipo_real();
	}

	public Tipo tipoin(StringLocalizado in) {
		return new TipoIn(in.s);
	}

	public Flecha flecha(Exp a0, StringLocalizado a1) {
		return new Flecha(a0, a1);
	}

	public Indexacion indexacion(Exp a0, Exp a1) {
		return new Indexacion(a0, a1);
	}

	public Indice indice(Exp a0) {
		return new Indice(a0);
	}

	public Punto punto(Exp a0, StringLocalizado a1) {
		return new Punto(a0, a1);
	}

	public Tipo tipo_pointer(Tipo t) {
		return new Tipo_pointer(t);
	}

	public Campo campo(Tipo t, StringLocalizado id) {
		return new Campo(t, id);
	}

	public Campos campos_varios(Campo c, Campos cs) {
		return new Campos_varios(c, cs);
	}

	public Campos campos_uno(Campo c) {
		return new Campos_uno(c);
	}

	//TODO: revisar
	public TRecord tRecord_varias(Campo c, Campos cs) {
		return new TRecord_varias(c, cs);
	}

	//TODO: revisar
	public TRecord tRecord_una(Campo c) {
		return new TRecord_una(c);
	}

	public Tipo_array tipo_array(StringLocalizado n, Tipo t) {
		return new Tipo_array(n, t);
	}

	public Bloque bloque(Programa p) {
		return new Bloque(p);
	}
	public Bloque_vacio bloque_vacio() {
		return new Bloque_vacio();
	}

	public List_param_form_varios list_param_form_varios(ParamD par, LParamForm pars) {
		return new List_param_form_varios(par, pars);
	}

	public List_param_form_uno list_param_form_uno(ParamD par) {
		return new List_param_form_uno(par);
	}

	//TODO: revisar param valor y param variable
	public ParamD paramD(Tipo t, StringLocalizado i) {
		return new ParamD(t, i);
	}

	public ParamForm param_form(ParamD par, LParamForm pars) {
		return new Param_form(par, pars);
	}

	//TODO: necesario??
	public ParamForm param_form_uno(ParamD par) {
		return new Param_form_uno(par);
	}

	public ParamForm Param_form_vacio() {
		return new Param_form_vacio();
	}
	
	public Exp literalCad(StringLocalizado s) {
		return new LiteralCad(s);
	}
	
	public Dec dec_type(Tipo a, Tipo b) {
		return new Dec_type(a, b);
	}
	
	public ParamD paramDAmp(Tipo t, StringLocalizado i) {
		return new ParamDAmp(t, i);
	}
}
