with ada.strings.unbounded; use ada.strings.unbounded;
with ada.strings.unbounded.text_io; use ada.strings.unbounded.text_io;
with ada.text_io; use ada.text_io;
with ada.integer_text_io; use ada.integer_text_io;
with FilaCircular;
with Ada.Characters.Latin_1; use Ada.Characters.Latin_1;

procedure main  is

   -- A implementação está preparada, para trabalhar com enumerados, porém como
   -- ainda não foi localizado uma especificação de fila genérica que suporte
   -- os tipos Integer, Unbounded_String e Enumerados ao mesmo tempo a opção foi
   -- removida, logo é possível apenas tratalhar no momento com s tipos Integer
   -- e Unbounded_String

   type Montadoras is ( CHEVROLET,CITROEN,FIAT,FORD,HONDA,HYUNDAI,KIA,MITSUBICHI,NISSAN,PEUGOUT,RENAULT,TOYOTA,VOLKSWAGEN );

   package FI is new FilaCircular(Integer);
   package FS is new FilaCircular(Unbounded_String);
   package FM is new FilaCircular(Montadoras);
   FILA_INT:FI.pFILA := null;
   FILA_STR:FS.pFILA := null;
   FILA_MON:FM.pFila := null;

   procedure saidaConsole(texto: String) is
   begin
      Put_Line(texto);
   end saidaConsole;

   function pedeConsole Return Unbounded_String is
   begin
      return Get_Line;
   end pedeConsole;

   function getNroFilasExist Return Integer is
      qtd : Integer := 0;
   begin
     if (FS.exists(FILA_STR)) then
        qtd := qtd+1;
     end if;
     if (FI.exists(FILA_INT)) then
        qtd := qtd+1;
     end if;
     if (FM.exists(FILA_MON)) then
        qtd := qtd+1;
     end if;
     return qtd;
   end getNroFilasExist;

   function getNomeFila(tpFila: Integer) Return String is
      nome : Unbounded_String := To_Unbounded_String("");
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
   begin
      switch := tpFila;
      case switch is
         when 1 => nome := To_Unbounded_String("Cidades");
         when 2 => nome := To_Unbounded_String("Inteiros");
         when 3 => nome := To_Unbounded_String("Montadoras");
      end case;
      return To_String(nome);
   end getNomeFila;

   function getTamFila(tpFila: Integer) Return String is
      tam : Unbounded_String := To_Unbounded_String("Nao Criada");
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
   begin
      switch := tpFila;
      case switch is
         when 1 =>
            begin
               if (FS.exists(FILA_STR)) then
                  tam := To_Unbounded_String(Integer'Image(FS.getTamanho));
               end if;
            end;
         when 2 =>
            begin
               if (FI.exists(FILA_INT)) then
                  tam := To_Unbounded_String(Integer'Image(FI.getTamanho));
               end if;
            end;
         when 3 =>
            begin
               if (FM.exists(FILA_MON)) then
                  tam := To_Unbounded_String(Integer'Image(FM.getTamanho));
               end if;
            end;
      end case;
      return To_String(tam);
   end;

   function getTotElem(tpFila: Integer) Return String is
      qtd : Unbounded_String := To_Unbounded_String("Nao Criada");
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
   begin
      switch := tpFila;
      case switch is
         when 1 =>
            begin
               if (FS.exists(FILA_STR)) then
                  qtd := To_Unbounded_String(Integer'Image(FS.getQtd(FILA_STR)));
               end if;
            end;
         when 2 =>
            begin
               if (FI.exists(FILA_INT)) then
                  qtd := To_Unbounded_String(Integer'Image(FI.getQtd(FILA_INT)));
               end if;
            end;
         when 3 =>
            begin
               if (FM.exists(FILA_MON)) then
                  qtd := To_Unbounded_String(Integer'Image(FM.getQtd(FILA_MON)));
               end if;
            end;
      end case;
      return To_String(qtd);
   end;

   function getNomeFilasExistentes Return String is
      ret : Unbounded_String := To_Unbounded_String("");
   begin
      if (FS.exists(FILA_STR)) then
        if (Length(ret) /= 0) then
          ret := ret & ";";
        end if;
        ret := ret & "Cidades";
     end if;
     if (FI.exists(FILA_INT)) then
        if (Length(ret) /= 0) then
           ret := ret & ";";
        end if;
        ret := ret & getNomeFila(2);--"Inteiros";
     end if;
     if (FM.exists(FILA_MON)) then
        if (Length(ret) /= 0) then
           ret := ret & ";";
        end if;
        ret := ret & "Montadoras";
     end if;
     if (Length(ret) = 0) then
        ret := To_Unbounded_String("Nenhum");
     end if;
      return To_String(ret);
   end getNomeFilasExistentes;

   function filaExiste(tpFila : Integer) Return boolean is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      exist : Boolean := false;
   begin
      switch := tpFila;
      case switch is
         when 1 => exist := FS.exists(FILA_STR);
         when 2 => exist := FI.exists(FILA_INT);
         when 3 => exist := FM.exists(FILA_MON);
      end case;
      return exist;
   end;

   procedure newFilaCircular(tpFila: Integer; tamanho: Integer) is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
   begin
      switch := tpFila;
      case switch is
         when 1 =>
            begin
               FILA_STR := FS.criaFila(tamanho);
            end;
         when 2 =>
            begin
               FILA_INT := FI.criaFila(tamanho);
            end;
         when 3 =>
            begin
               FILA_MON := FM.criaFila(tamanho);
            end;
      end case;
   end;

   function filaVazia(tpFila: Integer) Return Boolean is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      vazia : boolean := false;
   begin
      switch := tpFila;
      case switch is
         when 1 => vazia := FS.vazia(FILA_STR);
         when 2 => vazia := FI.vazia(FILA_INT);
         when 3 => vazia := FM.vazia(FILA_MON);
      end case;
      return vazia;
   end;

   procedure deleteFilaCircular(tpFila: Integer) is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
   begin
      switch := tpFila;
      case switch is
         when 1 => FS.liberaFila(FILA_STR);
         when 2 => FI.liberaFila(FILA_INT);
         when 3 => FM.liberaFila(FILA_MON);
      end case;
   end;

   function mostrarFilaCircular(tpFila: Integer) Return String is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      ret : Unbounded_String := To_Unbounded_String("");
   begin
      switch := tpFila;
      case switch is
         when 1 => ret := FS.mostrar(FILA_STR);
         when 2 => ret := To_Unbounded_String(Integer'Image(FI.mostrar(FILA_INT)));
         when 3 => ret := To_Unbounded_String(Montadoras'Image(FM.mostrar(FILA_MON)));
      end case;
      return To_String(ret);
   end;

   function excluirDaFilaCircular(tpFila: Integer) Return String is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      ret : Unbounded_String := To_Unbounded_String("");
   begin
      ret := To_Unbounded_String(mostrarFilaCircular(tpFila));
      switch := tpFila;
      case switch is
         when 1 => FS.remover(FILA_STR);
         when 2 => FI.remover(FILA_INT);
         when 3 => FM.remover(FILA_MON);
      end case;
      return To_String(ret);
   end;

   procedure insereFilaCircular(tpFila: Integer) is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      ret : Unbounded_String := To_Unbounded_String("");
      numero : Integer;
      mont : Montadoras;
   begin
      begin
         saidaConsole("Informe o valor a ser inserido");
      	 ret := pedeConsole;
      	 switch := tpFila;
      	case switch is
            when 1 =>
               begin
                  if Length(ret) > 0 then
                     FS.insere(ret,FILA_STR);
                  else
                     saidaConsole("Entrada inválida.");
                  end if;
               end;
            when 2 =>
               begin
                  numero := Integer'Value(To_String(ret));
                  FI.insere(numero,FILA_INT);
               end;
            when 3 =>
               begin
                  mont := Montadoras'Value(To_String(ret));
                  FM.insere(mont,FILA_MON);
               end;
         end case;
      exception

            when Constraint_Error => saidaConsole("Entrada inválida");
      end;
   end;

   function filaCheia(tpFila: Integer) Return Boolean is
      subtype Small_Int is Integer range 1..3;
      switch : Small_Int;
      cheia: boolean := false;
   begin
      switch := tpFila;
      case switch is
         when 1 => cheia := FS.cheia(FILA_STR);
         when 2 => cheia := FI.cheia(FILA_INT);
         when 3 => cheia := FM.cheia(FILA_MON);
      end case;
      return cheia;
   end;

   procedure menu2(tpFila : Integer) is
      sOpc : Unbounded_String := To_Unbounded_String("");
      opc : Integer;
      subtype Small_Int is Integer range 1..9;
      switch : Small_Int;
   begin
      loop
         saidaConsole("Menu 2" & LF &
                      "Tipo da Fila: [" & getNomeFila(tpFila) & "]" & LF &
         	      "Total de Elementos: [" & getTotElem(tpFila) & "]" & LF &
         	      "Tamanho da fila: [" & getTamFila(tpFila) & "]" & LF &
         	      "1 - criar fila" & LF &
         	      "2 - destruir fila" & LF &
         	      "3 - inserir" & LF &
         	      "4 - mostrar" & LF &
         	      "5 - excluir" & LF &
         	      "9 - retornar ao menu 1");
         sOpc := pedeConsole;
         if (Length(sOpc) > 0) then
            begin
               opc := Integer'Value(To_String(sOpc));
               switch := opc;
               case switch is
                  when 1 => -- criar
                     begin
                        if filaExiste(tpFila) then
                           saidaConsole("Fila ja existe, nao pode ser criada novamente");
                        else
                           saidaConsole("Informe o tamanho da fila.");
                           sOpc := pedeConsole;
                           opc := Integer'Value(To_String(sOpc));
                           if opc < 1 then
                              saidaConsole("Tamanho de fila invalido, deve ser maior que 0");
                           else
                              newFilaCircular(tpFila,opc);
                           end if;
                        end if;
                     end;
                  when 2 => --destruir
                     begin
                        if not filaExiste(tpFila) then
                           saidaConsole("Fila não existe.");
                        else
                           if not filaVazia(tpFila) then
                              saidaConsole("Existem elementos na fila.");
                           else
                              deleteFilaCircular(tpFila);
                           end if;
                        end if;
                     end;
                  when 3 => -- inserir
                     begin
                        if not filaExiste(tpFila) then
                           saidaConsole("Fila nao existe.");
                        else
                           if filaCheia(tpFila) then
                             saidaConsole("Fila esta cheia.");
                           else
                              insereFilaCircular(tpFila);
                           end if;
                        end if;
                     end;
                  when 4 => -- mostrar
                     begin
                        if not filaExiste(tpFila) then
                           saidaConsole("Fila nao existe.");
                        else
                           if filaVazia(tpFila) then
                              saidaConsole("Fila esta vazia.");
                           else
                              saidaConsole(mostrarFilaCircular(tpFila));
                           end if;
                        end if;
                     end;
                  when 5 => -- excluir
                     begin
                        if not filaExiste(tpFila) then
                           saidaConsole("Fila nao existe.");
                        else
                           if filaVazia(tpFila) then
                              saidaConsole("Fila esta vazia.");
                           else
                              saidaConsole("Excluido: " & excluirDaFilaCircular(tpFila));
                           end if;
                        end if;
                     end;
                  when 6 .. 8 => Raise Constraint_Error;
                  when 9 => exit;
               end case;
            exception
                  when Constraint_Error => saidaConsole("Entrada inválida");
            end;
         else
            saidaConsole("Entrada inválida!");
         end if;
      end loop;
   end menu2;

   procedure menu1 is
      msg : Unbounded_String := To_Unbounded_String("");
      opc : Integer;
      sOpc : Unbounded_String := To_Unbounded_String("");
      subtype Small_Int is Integer range 1..9;
      switch : Small_Int;
   begin
   loop

      saidaConsole("Menu 1" & LF &
      		   "1 - fila de nomes" & LF &
                   "2 - fila de inteiros" & LF &
                   --"3 - fila de montadoras" & LF &
		   "9 - finaliza programa" & LF &
		   "Filas existentes: " & Integer'Image(getNroFilasExist) & LF &
		   "Tipos das filas existentes [" & getNomeFilasExistentes & "]");
      sOpc := pedeConsole;
      if (Length(sOpc) > 0) then
         begin
            opc := Integer'Value(To_String(sOpc));
            switch := opc;
            case switch is
               when 1 => menu2(1);
               when 2 => menu2(2);
               --when 3 => menu2(3);
               when 3..8 => Raise Constraint_Error;
               when 9 =>
                  begin
                    if (getNroFilasExist > 0) then
                        saidaConsole("Existem filas criadas, exclua as mesmas antes de finalizar a aplicacao");
                    else
                    	exit;
                    end if;
                  end;
            end case;
         exception
               when Constraint_Error => saidaConsole("Entrada Inválida");
         end;
      else
         saidaConsole("Entrada inválida!");
      end if;

   end loop;
   end menu1;

begin
   saidaConsole("");
   menu1;
end main;
