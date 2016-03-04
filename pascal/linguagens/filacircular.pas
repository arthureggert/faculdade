unit FilaCircular;

{$mode objfpc}{$H+}

interface

uses
    Classes, SysUtils, Montadora;

type
	{ TFilaCircular }
        generic TList<T> = class(TObject)
	private
		tamanho: integer;
		ini: integer;
		fim:integer;
		qtdElemento:integer;
		armazem:array of T;
	public

              constructor create(tam: Integer);
              destructor destroy; Override;
              procedure insere(elem: T);
              function remover:T;
              function mostrar:T;
              function isVazia:boolean;
              function isCheia:boolean;
              function getTamanho:Integer;
              function getQtd:Integer;

	end;

implementation
              { TFilaCircular }
              constructor TList.create(tam: Integer);
              begin
                   SetLength(armazem, tam);
                   tamanho := tam;
                   qtdElemento := 0;
                   ini := 0;
                   fim := 0;
              end;

              destructor TList.destroy;
              begin
                inherited;
              end;

              procedure TList.insere(elem: T);
              begin
                armazem[fim] := elem;
                fim := (fim+1) mod tamanho;
                inc(qtdElemento);
              end;

              function TList.remover: T;
              var
                elem: T;
                begin
                    elem := mostrar;
                    ini := (ini+1) mod tamanho;
                    dec(qtdElemento);
                    Result := elem;
                end;

                function TList.mostrar: T;
                begin
                     Result := armazem[ini];
                end;

                function TList.isVazia: boolean;
                begin
                  Result := qtdElemento = 0;
                end;

                function TList.isCheia: boolean;
                begin
                  Result := qtdElemento >= tamanho;
                end;

                function TList.getTamanho: Integer;
                begin
                  Result := tamanho;
                end;

                function TList.getQtd: Integer;
                begin
                  Result := qtdElemento;
                end;
end.
