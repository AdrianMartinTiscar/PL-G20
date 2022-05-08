package procesamiento;

import procesamiento.TinyASint.*;

public class ProcesamientoPorDefecto implements Procesamiento{
	public void procesa(Programa_sinDecs prog) {}
	public void procesa(Programa_conDecs prog) {}
	public void procesa(Decs_una dec) {}
	public void procesa(Decs_varias decs) {}
	public void procesa(Dec_var d) {}
	public void procesa(Dec_type d) {}
	public void procesa(Dec_proc d) {}
	
	public void procesa(Param_form p) {}
	public void procesa(Param_form_vacio p) {}
	public void procesa(List_param_form_uno p) {}
	public void procesa(List_param_form_varios p) {}
	public void procesa(Param_valor p) {}
	public void procesa(Param_variable p) {}
	
	public void procesa(Tipo_int t) {}
	public void procesa(Tipo_real t) {}
	public void procesa(Tipo_bool t) {}
	public void procesa(Tipo_string t) {}
	public void procesa(Tipo_array t) {}
	public void procesa(Tipo_record t) {}
	public void procesa(Tipo_pointer t) {}
	
	public void procesa(Campos_uno c) {}
	public void procesa(Campos_varios c) {}
	public void procesa(Campo c) {}
	
	public void procesa(Instrucciones_una ins) {}
	public void procesa(Instrucciones_varias inss) {}
	
	public void procesa(Inst_asig in) {}
	public void procesa(Inst_ifThen in) {}
	public void procesa(Inst_ifThenElse in) {}
	public void procesa(Inst_while in) {}
	public void procesa(Inst_op_varias in) {}
	public void procesa(Inst_op_vacio in) {}
	public void procesa(Inst_read in) {}
	public void procesa(Inst_write in) {}
	public void procesa(Inst_NewLine in) {}
	public void procesa(Inst_new in) {}
	public void procesa(Inst_delete in) {}
	public void procesa(Inst_call in) {}
	public void procesa(Instruccion_bloque in) {}
	
	public void procesa(Bloque b) {}
	public void procesa(Bloque_vacio b) {}
	
	//public void procesa(ParReales_una parReales_una) {}
	public void procesa(ParamReales_varios parReales_varias) {}
	public void procesa(ParamReales_vacio parReales_ninguna) {}
	public void procesa(ListaExpresiones_una lExpresiones_una) {}
	public void procesa(ListaExpresiones_varias lExpresiones_varias) {}
	
	//public void procesa (Inst ins) {}
	public void procesa(Suma exp) {}
	public void procesa(Resta exp) {}
	public void procesa(And an) {}
	public void procesa(Or or) {}
	public void procesa(Mayor may) {}
	public void procesa(Menor men) {}
	public void procesa(Mayor_igual mayI) {}
	public void procesa(Menor_igual menI) {}
	public void procesa(Comparacion eq) {}
	public void procesa(Distinto dist) {}
	public void procesa(Mul exp) {}
	public void procesa(Div exp) {}
	public void procesa(Not not) {}
	public void procesa(Mod exp) {}
	public void procesa(Neg neg) {}
	public void procesa(Flecha fl) {}
	public void procesa(Indexacion fl) {}
	public void procesa(Punto fl) {}
	public void procesa(Indice fl) {}
	
	
	public void procesa(Id exp) {}
	public void procesa(NumeroEntero exp) {}
	public void procesa(NumeroReal exp) {}
	
	public void procesa(True t) {}
	public void procesa(False f) {}
	public void procesa(Exp e) {}
	public void procesa(Null e) {}	
	public void procesa(LiteralCad lc) {}
	
}
