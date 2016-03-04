with ada.text_io, Ada.Unchecked_Deallocation;
use ada.text_io;

GENERIC
   type ELEM is (<>);

package QqFila is
   type FILA is private;
   type pFILA is access FILA;

   function CriaFila (tam:integer) return pFila;
   function getTamanho return integer;
   function naoVazia (pQ: in pFILA) return BOOLEAN;
   function naoCheia (pQ: in pFILA) return BOOLEAN;
   procedure adiciona (X: in ELEM; pQ: in out pFILA);
   procedure remove (pQ: in out pFILA);
   function mostra (pQ: in pFILA) return ELEM;
   procedure liberaFila(pQ: in out pFila);

private
   tamanho: integer;
   type Tarray is array (1..tamanho) of ELEM;
   type FILA is
	record
		armazem	: Tarray;
		qtde	: integer range 0..tamanho:=0;
		inicio	: integer range 1..tamanho:=1;
		fim	: integer range 1..tamanho:=1;
      end record;
   procedure Free is
    new Ada.Unchecked_Deallocation(
        FILA, pFila);
end;
