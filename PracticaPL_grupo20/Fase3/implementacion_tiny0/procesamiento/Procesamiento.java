package procesamiento;

import procesamiento.TinyASint.*;
public interface Procesamiento {

	void procesa (Programa prog);
	void procesa (Decs_una dec);
	void procesa (Decs_varias decs);
	void procesa (Dec_int di);
	void procesa (Dec_real dr);
	void procesa (Dec_bool db);
	void procesa (Inst_una ins);
	void procesa (Inst_varias inss);
	void procesa (Inst ins);
	void procesa(Suma exp);
	void procesa(Resta exp);
	void procesa(Mul exp);
	void procesa(Div exp);
	void procesa(And an);
	void procesa(Or or);
	void procesa(Mayor may);
	void procesa(Menor men);
	void procesa(Mayor_igual mayI);
	void procesa(Menor_igual menI);
	void procesa(Equivalente eq);
	void procesa(Distinto dist);
	void procesa(Not not);	
	void procesa(Id exp);
	//void procesa(Num exp);
	void procesa (NumEntero ne);
	void procesa (NumReal nr);
	void procesa(Neg neg);
	void procesa(Cierto t);
	void procesa(Falso f);
	void procesa(Exp e);//TODO:revisar
	
}
