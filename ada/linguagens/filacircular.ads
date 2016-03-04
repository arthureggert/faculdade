with ada.text_io, Ada.Unchecked_Deallocation;
use ada.text_io;

generic
   type T is private;
package FilaCircular is

   type Fila is private;
   type pFila is access Fila;

  function criaFila (tam:integer) return pFila;
  function vazia (F: in pFila) return Boolean;
  function cheia (F: in pFila) return Boolean;
  procedure insere (E: in T; F: in out pFila);
  procedure remover (F: in out pFila);
  function mostrar (F: in pFila) return T;
  function getTamanho return integer;
  function getQtd(F: in pFila) return integer;
  procedure liberaFila(F: in out pFila);
  function exists(F: in pFila) return Boolean;

private
  tamanho : integer;
  subtype DeZeroTamanho is Integer range 0..tamanho;
  subtype DeUmTamanho is Integer range 1..tamanho;
  type vetor is array (1 .. tamanho) of T;
  type Fila is record
    armazena : vetor;
    qtd	   : DeZeroTamanho := 0;
    inicio : DeUmTamanho := 1;
    fim    : DeUmTamanho := 1;
  end record;

 procedure Free is
     new Ada.Unchecked_Deallocation(Fila, pFila);
end;
