package procesamiento;

import procesamiento.TinyASint.*;

public interface Procesamiento {

	void procesa(Programa_sinDecs prog);
	void procesa(Programa_conDecs prog);
	void procesa(Decs_una dec);
	void procesa(Decs_varias decs);
	void procesa(Dec_var d);
	void procesa(Dec_type d);
	void procesa(Dec_proc d);
	
	void procesa(Param_form p);
	void procesa(Param_form_vacio p);
	void procesa(List_param_form_uno p);
	void procesa(List_param_form_varios p);
	void procesa(Param_valor p);
	void procesa(Param_variable p);
	
	void procesa(Tipo_int t);
	void procesa(Tipo_real t);
	void procesa(Tipo_bool t);
	void procesa(Tipo_string t);
	void procesa(Tipo_array t);
	void procesa(Tipo_record t);
	void procesa(Tipo_pointer t);
	
	void procesa(Campos_uno c);
	void procesa(Campos_varios c);
	void procesa(Campo c);
	
	void procesa(Instrucciones_una ins);
	void procesa(Instrucciones_varias inss);
	
	void procesa(Inst_asig in);
	void procesa(Inst_ifThen in);
	void procesa(Inst_ifThenElse in);
	void procesa(Inst_while in);
	void procesa(Inst_op_varias in);
	void procesa(Inst_op_vacio in);
	void procesa(Inst_read in);
	void procesa(Inst_write in);
	void procesa(Inst_NewLine in);
	void procesa(Inst_new in);
	void procesa(Inst_delete in);
	void procesa(Inst_call in);
	void procesa(Inst_bloque in);
	
	void procesa(Bloque b);
	void procesa(Bloque_vacio b);
	
	//void procesa(ParReales_una parReales_una);
	void procesa(ParamReales_varios parReales_varias);
	void procesa(ParamReales_vacio parReales_ninguna);
	void procesa(ListaExpresiones_una lExpresiones_una);
	void procesa(ListaExpresiones_varias lExpresiones_varias);
	
	//void procesa (Inst ins);
	void procesa(Suma exp);
	void procesa(Resta exp);	
	void procesa(And an);
	void procesa(Or or);
	void procesa(Mayor may);
	void procesa(Menor men);
	void procesa(Mayor_igual mayI);
	void procesa(Menor_igual menI);
	void procesa(Comparacion eq);
	void procesa(Distinto dist);
	void procesa(Mul exp);
	void procesa(Div exp);
	void procesa(Not not);
	void procesa(Mod exp);
	void procesa(Neg neg);
	void procesa(Flecha fl);
	void procesa(Indexacion fl);
	void procesa(Punto fl);
	void procesa(Indice fl);
	
	
	void procesa(Id exp);
	void procesa(NumeroEntero exp);
	void procesa(NumeroReal exp);
	
	void procesa(True t);
	void procesa(False f);
	void procesa(Exp e);
	void procesa(Null e);	
	void procesa(LiteralCad lc);
	
}
