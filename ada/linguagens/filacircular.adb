package body FilaCircular is
   function criaFila (tam:integer) return pFila is
      pX: pFila;
   begin
      tamanho:= tam;
      pX:= new Fila;
      return pX;
   end criaFila;

   function vazia (F: in pFila) return Boolean is
   begin
      return F.qtd = 0;
   end vazia;

   function cheia (F: in pFila) return Boolean is
   begin
      return F.qtd >= tamanho;
   end cheia;

   procedure insere (E: in T; F: in out pFila) is
   begin
      F.armazena(F.fim) := E;
      F.fim := F.fim mod tamanho+1;
      F.qtd := F.qtd+1;
   end insere;

   procedure remover (F: in out pFila) is
   begin
      F.inicio := F.inicio mod tamanho+1;
      F.qtd := F.qtd-1;
   end remover;

   function mostrar (F: in pFila) return T is
   begin
      return F.armazena(F.inicio);
   end mostrar;

   function getTamanho return integer is
   begin
      return tamanho;
   end getTamanho;

   function getQtd (F: in pFila) return integer is
   begin
      return F.qtd;
   end getQtd;

   procedure liberaFila(F: in out pFila)is
   begin
      Free(F);
   end liberaFila;

   function exists (F: in pFila) return Boolean is
   begin
      return F/=null;
   end exists;

end FilaCircular;
