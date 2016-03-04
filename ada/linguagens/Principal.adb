with ada.text_io, Ada.Integer_Text_IO, QqFila;
use ada.text_io, Ada.Integer_Text_IO;

procedure Principal is
   package INT_FILA is new QqFila (INTEGER);
   -- package REAL_FILA is new QqFila (FLOAT,50);

   pQA: INT_FILA.pFila;

   x: string(1..3);
   n: natural;

begin

   pQA:= INT_FILA.CriaFila (3);
   Put_Line("Saiu do CriaFila");

   Put ("Tamanho da Fila=");
   Put(INT_FILA.getTamanho);

   New_Line;
   if INT_FILA.naoVazia(pQA) then
      Put_Line("Fila nao vazia");
   else
      Put_Line("Fila vazia");
   end if;

   if INT_FILA.naoCheia(pQ => pQA)
   then
      INT_FILA.adiciona(40,pQA);
   else
      Put ("fila cheia - nao inserido ");
      Put (40);
      New_Line;
   end if;

   if INT_FILA.naoCheia(pQ => pQA)
   then
      INT_FILA.adiciona(41,pQA);
   else
      Put ("fila cheia - nao inserido ");
      Put (41);
      New_Line;
   end if;

   if INT_FILA.naoCheia(pQ => pQA)
   then
      INT_FILA.adiciona(42,pQA);
   else
      Put ("fila cheia - nao inserido ");
      Put (42);
      New_Line;
   end if;

   if INT_FILA.naoCheia(pQ => pQA)
   then
      INT_FILA.adiciona(43,pQA);
   else
      Put ("fila cheia - nao inserido ");
      Put (43);
      New_Line;
   end if;

   if INT_FILA.naoVazia(pQA) then
      Put_Line("Fila nao vazia");
   else
      Put_Line("Fila vazia");
   end if;

   Put ("Primeiro da Fila=");
   Put(INT_FILA.mostra(pQA));
   New_Line;

   INT_FILA.liberaFila (pQA);

   New_Line;

   pQA:= INT_FILA.CriaFila (2);
   Put ("Tamanho da Fila=");
   Put(INT_FILA.getTamanho);
   New_Line;

   if INT_FILA.naoVazia(pQA) then
      Put_Line("Fila nao vazia");
   else
      Put_Line("Fila vazia");
   end if;
   Put_Line("Digite algo para finalizar");
   get_line(X,n);
   Put_Line("Programa vai finalizar");
end Principal;
