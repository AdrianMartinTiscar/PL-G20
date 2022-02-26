package implementacion_jflex;

%%
%line
%column
%class AnalizadorLexicoTiny1
%type  UnidadLexica
%unicode

%{
  private Operations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new Operations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = ({digito}* {digitoPositivo}| 0)
parteExp = (e|E) {numeroEntero}
identificador = {letra}({letra}|{digito}|\_)*
numeroEntero = [\+,\-]?{parteEntera}
numeroReal = [\+,\-]?{parteEntera}\.({parteDecimal}|{parteExp}|{parteDecimal} {parteExp})
suma = \+
resta = \-
mul = \*
div = \/
parentesisAbierto = \(
parentesisCerrado = \)
igual = \=
coma  = \,
separadores = &&
PntComa = \;
int = int
real = real
bool = bool
literalCad = \â€� [^  \b, \n, \r, \â€�]* \â€�
true = true
false = false
and = and
or = or
not = not
menor = <
menorIgual = <\=
mayor = >
mayorIgual = >=
comparacion = \=\=
distinto = !\=
mod = \%
corcheteAbierto = \[
corcheteCerrado = \]
llaveAbierta =\{
llaveCerrada = \}
punto = \.
flecha = ->
amp = &
string = string
null = null
proc = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
array = array
of = of
pointer = pointer
new = new
delete = delete
read = read
write = write
nl = nl
var = var
type = type
Com = #[^\n]* \n
ignor = [ â€œ â€œ\t\r\b\n]

%%
{ignor}                    {}
{Com}                     {}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadNEnt();}
{numeroReal}              {return ops.unidadNReal();}
{suma}            {return ops.unidadSuma();}
{resta}           {return ops.unidadResta();}
{mul}             {return ops.unidadMul();}
{div}                   {return ops.unidadDiv();}
{parentesisAbierto}      {return ops.unidadPAp();}
{parentesisCerrado}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{separadores}                    {return ops.unidadSep();}
{PntComa}                    {return ops.unidadPntComa();}
{int}                    {return ops.unidadInt();}
{real}                    {return ops.unidadReal();}
{bool}                    {return ops.unidadBool();}
{literalCad}                    {return ops.unidadLiteralCad();}
{true}                    {return ops.unidadTrue();}
{false}                    {return ops.unidadFalse();}
{and}                    {return ops.unidadAnd();}
{or}                    {return ops.unidadOr();}
{not}                    {return ops.unidadNot();}
{menor}                    {return ops.unidadMenor();}
{menorIgual}                    {return ops.unidadMenorIgual();}
{mayor}                    {return ops.unidadMayorIgual();}
{mayorIgual}                    {return ops.unidadMayorIgual();}
{comparacion}                    {return ops.unidadComparacion();}
{distinto}                    {return ops.unidadDistinto();}
{mod}                    {return ops.unidadMod();}
{corcheteAbierto}                    {return ops.unidadCorcheteAbierto();}
{corcheteCerrado}                    {return ops.unidadCorcheteCerrado();}
{llaveAbierta}                    {return ops.unidadLlaveAbierta();}
{llaveCerrada}                    {return ops.unidadLlaveCerrada();}
{punto}                    {return ops.unidadPunto();}
{flecha}                    {return ops.unidadFlecha();}
{amp}                    {return ops.unidadAmp();}
{string}                    {return ops.unidadString();}
{null}                    {return ops.unidadNull();}
{proc}                    {return ops.unidadProc();}
{if}                    {return ops.unidadIf();}
{then}                    {return ops.unidadThen();}
{else}                    {return ops.unidadElse();}
{endif}                    {return ops.unidadEndIf();}
{while}                    {return ops.unidadWhile();}
{do}                    {return ops.unidadDo();}
{endwhile}                    {return ops.unidadEndWhile();}
{call}                    {return ops.unidadCall();}
{record}                    {return ops.unidadRecord();}
{array}                    {return ops.unidadArray();}
{of}                    {return ops.unidadOf();}
{pointer}                    {return ops.unidadPointer();}
{new}                    {return ops.unidadNew();}
{delete}                    {return ops.unidadDelete();}
{read}                    {return ops.unidadRead();}
{write}                    {return ops.unidadWrite();}
{nl}                    {return ops.unidadNl();}
{var}                    {return ops.unidadVar();}
{type}                    {return ops.unidadType();}
[^]                       {ops.error();}  

