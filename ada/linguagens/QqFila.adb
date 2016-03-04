with Ada.Unchecked_Deallocation;
package body QqFila is

   function CriaFila (tam:integer) return pFila is
      pX: pFila;
   begin
      tamanho:= tam;
      pX:= new FILA;
      return pX;
   end CriaFila;

   function getTamanho return integer is
   begin
      return tamanho;
   end getTamanho;


   function naoVazia (pQ: in pFILA) return BOOLEAN is
   begin
      return pQ.qtde > 0;
   end naoVazia;

   function naoCheia (pQ: in pFILA) return BOOLEAN is
   begin
      return pQ.qtde < tamanho;

   end naoCheia;

   procedure adiciona (X: in ELEM; pQ: in out pFILA) is
   begin
      pQ.armazem(pQ.fim):= X;
      pQ.fim:= pQ.fim mod tamanho + 1;
      pQ.qtde:= pQ.qtde + 1;
   end adiciona;

   procedure remove (pQ: in out pFILA) is
   begin
      pQ.inicio:= pQ.inicio mod tamanho + 1;
      pQ.qtde:= pQ.qtde - 1;
   end remove;

   function mostra (pQ: in pFILA) return ELEM is
   begin
	return pQ.armazem(pQ.inicio);
   end mostra;

   procedure liberaFila(pQ: in out pFila)is
   begin
      Free(pQ);
   end liberaFila;


end QqFila;
