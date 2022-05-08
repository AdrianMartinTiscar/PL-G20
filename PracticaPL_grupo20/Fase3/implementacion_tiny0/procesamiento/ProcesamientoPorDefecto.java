package procesamiento;

import procesamiento.TinyASint.*;

public class ProcesamientoPorDefecto implements Procesamiento{
	public void procesa(Programa prog) {}
	public void procesa(Decs_una dec){}
	public void procesa(Decs_varias decs){}
	public void procesa(Dec_int di){}
	public void procesa(Dec_bool db){}
	public void procesa(Dec_real dr){}
	public void procesa(Inst_una ins){}
	public void procesa(Inst_varias inss){}
	public void procesa(Inst ins) {}
	public void procesa(Suma exp){}
	public void procesa(Resta exp){}
	public void procesa(Mul exp){}
	public void procesa(And an){}
	public void procesa(Or or){}
	public void procesa(Mayor may){}
	public void procesa(Menor men){}
	public void procesa(Mayor_igual mayI){}
	public void procesa(Menor_igual menI){}
	public void procesa(Equivalente eq){}
	public void procesa(Distinto dist){}
	public void procesa(Not not){}
	public void procesa(Div exp){}
	public void procesa(Id exp){}
	//public void procesa(Num exp){}
	public void procesa(NumEntero ne){}
	public void procesa(NumReal nr){}
	public void procesa(Negacion neg){}
	public void procesa(True t){}
	public void procesa(False f){}
	public void procesa(Exp e) {}
}
