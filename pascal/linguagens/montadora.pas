unit Montadora;
{$mode objfpc}{$H+}
interface
uses
  Classes, SysUtils;
type  TMontadora = ( CHEVROLET,
                     CITROEN,
                     FIAT,
                     FORD,
                     HONDA,
                     HYUNDAI,
                     KIA,
                     MITSUBISHI,
                     NISSAN,
                     PEUGEOT,
                     RENAULT,
                     TOYOTA,
                     VOLKSWAGEN
                   );
  TMont = record
    tipo:TMontadora;
    nomeMont:string;
  end;
const
  CMontadora: array[1..13] of TMont = ((tipo:CHEVROLET;nomeMont:'CHEVROLET'),
                                       (tipo:CITROEN;nomeMont:'CITROEN'),
                                       (tipo:FIAT;nomeMont:'FIAT'),
                                       (tipo:FORD;nomeMont:'FORD'),
                                       (tipo:HONDA;nomeMont:'HONDA'),
                                       (tipo:HYUNDAI;nomeMont:'HYUNDAI'),
                                       (tipo:KIA;nomeMont:'KIA'),
                                       (tipo:MITSUBISHI;nomeMont:'MITSUBISHI'),
                                       (tipo:NISSAN;nomeMont:'NISSAN'),
                                       (tipo:PEUGEOT;nomeMont:'PEUGEOT'),
                                       (tipo:RENAULT;nomeMont:'RENAULT'),
                                       (tipo:TOYOTA;nomeMont:'TOYOTA'),
                                       (tipo:VOLKSWAGEN;nomeMont:'VOLKSWAGEN'));

  function valueOfMontadora(nomeMont: String):TMontadora;

  function toStringMontadora(mont: TMontadora):String;

implementation
function valueOfMontadora(nomeMont: String):TMontadora;
var
  i: Integer;
  uperNomeMont: String;
begin
  uperNomeMont := UpperCase( nomeMont );
  for i := 1 to Length(CMontadora) do
  begin
    if CMontadora[i].nomeMont = uperNomeMont then
    begin
      Result := CMontadora[i].tipo;
      Exit;
    end;
  end;
  raise Exception.Create('');
end;

function toStringMontadora(mont: TMontadora):String;
var
  i: Integer;
begin
  for i := 1 to Length(CMontadora) do
  begin
    if CMontadora[i].tipo = mont then
    begin
      Result := CMontadora[i].nomeMont;
      Exit;
    end;
  end;
  raise Exception.Create('');
end;
end.

