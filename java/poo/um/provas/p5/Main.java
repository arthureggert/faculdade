package br.com.ahe.poo.um.provas.p5;

public class Main {

    public static void main(String args[]) throws AtributoObrigatorioException {
        Transatlantico transatlantico = new Transatlantico();
        transatlantico.setRegistroCapitania("FTR 1267");
        transatlantico.setQtdePessoas(2365);
        transatlantico.setNome("Titanic");
        transatlantico.setDataInauguracao(StringUtil.dataBr("14/05/1989"));
        //
        BoteSalvaVidas bote1 = new BoteSalvaVidas();
        bote1.setRegistroCapitania("BSV 001");
        bote1.setQtdePessoas(28);
        bote1.setInflavel(true);
        bote1.setQtdeRemos(5);
        bote1.setQtdeColetes(28);
        //
        BoteSalvaVidas bote2 = new BoteSalvaVidas();
        bote2.setRegistroCapitania("BSV 1966");
        bote2.setQtdePessoas(142);
        bote2.setInflavel(false);
        bote2.setQtdeRemos(12);
        bote2.setQtdeColetes(145);
        //
        BoteSalvaVidas bote3 = new BoteSalvaVidas();
        bote3.setRegistroCapitania("BSV 244");
        bote3.setQtdePessoas(122);
        bote3.setInflavel(false);
        bote3.setQtdeRemos(12);
        bote3.setQtdeColetes(120);
        //
        transatlantico.addBote(bote1);
        transatlantico.addBote(bote2);
        transatlantico.addBote(bote3);
        //
        System.out.println(bote1.verificaSeguranca());
        System.out.println(bote2.verificaSeguranca());
        System.out.println(bote3.verificaSeguranca());
        System.out.println(transatlantico.verificaSeguranca());
    }
}
