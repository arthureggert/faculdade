program main;
{$mode objfpc}{$H+}

uses
    SysUtils, Classes, FilaCircular, Montadora, TypInfo;

type
    filaCid = specialize TList<string>;
    filaInt = specialize TList<Integer>;
    filaMont = specialize TList<TMontadora>;

procedure saidaDados(texto: String); forward;
procedure menu1; forward;
procedure menu2(tipoDaFila: Integer); forward;
procedure criarFila(tipoDaFila,tam: Integer); forward;
procedure removeFila(tipoDaFila: Integer); forward;
function leConsole:String; forward;
function getQtdFilas():Integer; forward;
function getNomeFilasExistentes():String; forward;
function getNomeFila(tipoDaFila: Integer):String; forward;
function getTotalElementosFila(tipoDaFila: Integer):String; forward;
function getTamanhoFila(tipoDaFila: Integer):String; forward;
function filaExiste(tipoDaFila: Integer):Boolean; forward;
function isFilaVazia(tipoDaFila: Integer):Boolean; forward;
function isFilaCheia(tipoDaFila: Integer):Boolean; forward;
function insereFila(tipoDaFila: Integer; tipoOpcao: String):Boolean;forward;
function mostrarFila(tipoDaFila: Integer):String; forward;
function deletarDaFila(tipoDaFila: Integer):String; forward;

//{$R *.res}

var
  filaC: ^filaCid;
  filaI: ^filaInt;
  filaM: ^filaMont;
const
  ENDL = (#13+#10);

procedure menu2(tipoDaFila: Integer);
var
  opcao,tam: Integer;
  tipoOpcao: String;
begin
  repeat
   saidaDados('Menu 2' + ENDL +
			  'Tipo da Fila: ' + getNomeFila(tipoDaFila) +  ENDL +
			  'Total de Elementos: ' + getTotalElementosFila(tipoDaFila) + ENDL +
              'Tamanho da Fila: ' + getTamanhoFila(tipoDaFila) + ENDL +
              '1 - criar fila' + ENDL +
              '2 - destruir fila' + ENDL +
              '3 - inserir' + ENDL +
              '4 - mostrar' + ENDL +
              '5 - excluir' + ENDL +
              '9 - retornar ao menu 1');
   tipoOpcao := leConsole();
   try
      opcao := StrToInt(tipoOpcao);
      case (opcao) of
      1: 
        begin
             if (filaExiste(tipoDaFila)) then
                begin
                   saidaDados('Fila ja existe, nao pode ser criada novamente');
                end
             else
                 begin
                      saidaDados('Informe o tamanho da fila.');
                      tipoOpcao := leConsole();
                      tam := StrToInt(tipoOpcao);
                      if ( not (tam > 0) ) then
                      begin
                         saidaDados('Tamanho de fila invalido, deve ser maior que 0');
                      end
                      else
                      begin
                           criarFila(tipoDaFila,tam);
                      end;
                 end;
        end;
      2: 
         begin
            if (not filaExiste(tipoDaFila)) then
                begin
                   saidaDados('Fila nao existe.');
                end
             else
                 begin
                    if ( not isFilaVazia(tipoDaFila) ) then
                        begin
                             saidaDados('Existem elementos na fila.');
                        end
                    else
                        begin
                           removeFila(tipoDaFila);
                        end;
                 end;
         end;
      3: 
         begin
            if (not filaExiste(tipoDaFila)) then
                begin
                   saidaDados('Fila nao existe.');
                end
             else
                 begin
                    if ( isFilaCheia(tipoDaFila) ) then
                        begin
                             saidaDados('Fila está isCheia.');
                        end
                    else
                        begin
                           saidaDados('Valor a ser inserido');
                           tipoOpcao := leConsole();
                           insereFila(tipoDaFila, tipoOpcao);
                        end;
                 end;
         end;
      4: 
         begin
            if (not filaExiste(tipoDaFila)) then
                begin
                   saidaDados('Fila nao existe.');
                end
             else
                 begin
                    if ( isFilaVazia(tipoDaFila) ) then
                        begin
                             saidaDados('Fila esta isVazia.');
                        end
                    else
                        begin
                           saidaDados(mostrarFila(tipoDaFila));
                        end;
                 end;
         end;
      5: 
         begin
           if (not filaExiste(tipoDaFila)) then
                begin
                   saidaDados('Fila nao existe.');
                end
             else
                 begin
                    if ( isFilaVazia(tipoDaFila) ) then
                        begin
                             saidaDados('Fila esta isVazia.');
                        end
                    else
                        begin
                           saidaDados('Excluido: ' + deletarDaFila(tipoDaFila) );
                        end;
                 end;
         end;
      9:Exit;
      else
        begin
           saidaDados('Entrada invalida');
        end;
      end;
   except
     saidaDados('Entrada invalida');
   end;
  until(false);
end;

function deletarDaFila(tipoDaFila: Integer):String;
var
  valorRemover: Integer;
  valorRemoverMontadora: TMontadora;
begin
  case (tipoDaFila) of
  1:
     begin
        Result := filaC^.remover;
     end;
  2:
     begin
       valorRemover := filaI^.remover;
       Result := IntToStr(valorRemover);
     end;
  3:
    begin
       valorRemoverMontadora := filaM^.remover;
       Result := toStringMontadora(valorRemoverMontadora);
    end;
  end;
end;

function mostrarFila(tipoDaFila: Integer):String;
var
  valorMostrar: Integer;
  valorMostrarMontadora: TMontadora;
begin
  case (tipoDaFila) of
  1:
     begin
        Result := filaC^.mostrar;
     end;
  2:
     begin
       valorMostrar := filaI^.mostrar;
       Result := IntToStr(valorMostrar);
     end;
  3:
    begin
       valorMostrarMontadora := filaM^.mostrar;
       Result := toStringMontadora(valorMostrarMontadora);
    end;
  end;
end;

function isFilaCheia(tipoDaFila: Integer):Boolean;
begin
  Result := false;
  case (tipoDaFila) of
  1: Result := filaC^.isCheia;
  2: Result := filaI^.isCheia;
  3: Result := filaM^.isCheia;
  end;
end;

function insereFila(tipoDaFila: Integer; tipoOpcao: string):Boolean;
var
  valorInserirString : string;
  valorInserir: Integer;
  valorInserirMontadora: TMontadora;
begin
  Result := false;
  case (tipoDaFila) of
  1:
	begin
           valorInserirString := tipoOpcao;
	   filaC^.insere(valorInserirString);
           Result := true;
	end;
  2:
    begin
         try
           valorInserir := StrToInt(tipoOpcao);
           filaI^.insere(valorInserir);
           Result := true;
        except;
        end;
     end;
  3:
    begin
       try
           valorInserirMontadora := valueOfMontadora(tipoOpcao);
           filaM^.insere(valorInserirMontadora);
           Result := true;
       except;
       end;
    end;
  end;
end;

function isFilaVazia(tipoDaFila: Integer):Boolean;
begin
  Result := false;
  case (tipoDaFila) of
  1: Result := filaC^.isVazia;
  2: Result := filaI^.isVazia;
  3: Result := filaM^.isVazia;
  end;
end;

procedure removeFila(tipoDaFila: Integer);
begin
  case (tipoDaFila) of
  1:
    begin
         dispose(filaC);
         filaC:=nil;
    end;
  2:
    begin
         dispose(filaI);
         filaI:=nil;
    end;
  3:
    begin
         dispose(filaM);
         filaM:=nil;
    end;
  end;
end;

procedure criarFila(tipoDaFila,tam: Integer);
begin
  saidaDados(IntToStr(tam));
  case (tipoDaFila) of
  1:
    begin
         new(filaC);
         filaC^ := filaCid.create(tam);
    end;
  2:
    begin
         new(filaI);
         filaI^ := filaInt.create(tam);
    end;
  3:
    begin
         new(filaM);
         filaM^ := FilaMont.create(tam);
    end;
  end;
end;

function filaExiste(tipoDaFila: Integer):Boolean;
begin
  Result := false;
  case (tipoDaFila) of
  1: if (filaC <> nil) then
        Result := true;
  2: if (filaI <> nil) then
        Result := true;
  3: if (filaM <> nil) then
        Result := true;
  end;
end;

function getTamanhoFila(tipoDaFila: Integer):String;
var
  tamFila: Integer;
begin
   tamFila := 0;
  case (tipoDaFila) of
    1:
      begin
           if (filaC <> nil) then
              begin
                   tamFila := filaC^.getTamanho;
              end;
      end;
    2:
      begin
           if (filaI <> nil) then
              begin
                   tamFila := filaI^.getTamanho;
              end;
      end;
    3:
      begin
           if (filaM <> nil) then
              begin
                   tamFila := filaM^.getTamanho;
              end;
      end;
  end;
  if (tamFila = 0) then
     begin
          Result := 'Nao criada';
     end
  else
      begin
           Result := IntToStr(tamFila);
      end;
end;

function getTotalElementosFila(tipoDaFila: Integer):String;
var
  totElem: Integer;
begin
  Result := 'Nao criada';
  case (tipoDaFila) of
    1:
      begin
           if (filaC <> nil) then
              begin
                   totElem := filaC^.getQtd;
                   Result := IntToStr(totElem);
              end;
      end;
    2:
      begin
           if (filaI <> nil) then
              begin
                   totElem := filaI^.getQtd;
                   Result := IntToStr(totElem);
              end;
      end;
    3:
      begin
           if (filaM <> nil) then
              begin
                   totElem := filaM^.getQtd;
                   Result := IntToStr(totElem);
              end;
      end;
  end;
end;

function getNomeFila(tipoDaFila: Integer):String;
begin
  case (tipoDaFila) of
    1:Result := 'Cidades';
    2:Result := 'Inteiros';
    3:Result := 'Montadora';
  end;
end;



function getNomeFilasExistentes():String;
var 
	resultado: string;

begin
  resultado := '';
  if ( filaC <> nil ) then
     begin
          resultado := resultado + getNomeFila(1) + '';
     end;
  if ( filaI <> nil ) then
     begin
		resultado := resultado + getNomeFila(2);
     end;
  if ( filaM <> nil ) then
     begin
        resultado := resultado + getNomeFila(3);
     end;
  if ( getQtdFilas = 0 ) then
     begin
          resultado := 'Nenhum';
     end;
  Result := resultado;
end;

function getQtdFilas():Integer;
 var
   i: Integer;
 begin
   i := 0;
   if ( filaC <> nil ) then
   begin
      inc(i);
   end;
   if ( filaI <> nil ) then
   begin
      inc(i);
   end;
   if ( filaM <> nil ) then
   begin
      inc(i);
   end;
   Result := i;
 end;

procedure menu1();
var
  opcao: Integer;
  tipoOpcao: String;
begin
  repeat
    try
    opcao := 0;
	saidaDados('Menu 1' + ENDL +
               '1 - fila de nomes'+ ENDL+
	       '2 - fila de inteiros'+ ENDL+
	       '3 - fila de montadoras'+ ENDL+
	       '9 - finaliza programa'+ ENDL+
	       'Filas existentes: ' + IntToStr(getQtdFilas()) + ENDL +
	       'Tipos das filas existentes ' + getNomeFilasExistentes());
        tipoOpcao := leConsole();
        opcao := StrToInt(tipoOpcao);
	case (opcao) of
	1:menu2(1);
    2:menu2(2);
	3:menu2(3);
	9:
	  begin
	   if (getQtdFilas() > 0) then
 	   begin
	        saidaDados('Existem filas criadas');
	   end
	   else
	   begin
	        Exit;
	   end;
	  end;
        else
          begin
           saidaDados('Opcao invalida');
          end;
        end;
    except
      saidaDados('Entrada invalida');
    end;
  until (false) ;
end;

procedure saidaDados(texto: String);
begin
  WriteLn(texto);
end;

function leConsole:String;
var
  lido: String;
begin
  ReadLn(lido);
  Result := lido;
end;

begin
  saidaDados('L1211E05 - Arthur Henrique Eggert');
  menu1();
end.
