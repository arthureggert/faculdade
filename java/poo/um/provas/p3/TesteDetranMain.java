package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

public class TesteDetranMain {

    public static void main(String[] args) throws AtributoException {
        Detran detran = new Detran("Santa Catarina");

        Automovel automovel1 = new Automovel();
        automovel1.setDescricao("Hummer");
        automovel1.setAno(2008);
        automovel1.setValor(500000);
        automovel1.setImportado(true);

        Automovel automovel2 = new Automovel();
        automovel2.setDescricao("Vectra");
        automovel2.setAno(2009);
        automovel2.setValor(50000);
        automovel2.setImportado(false);

        Automovel automovel3 = new Automovel();
        automovel3.setDescricao("Fiat Uno");
        automovel3.setAno(1985);
        automovel3.setValor(10000);
        automovel3.setImportado(false);

        Motocicleta moto1 = new Motocicleta();
        moto1.setDescricao("Honda Falcon NX4");
        moto1.setAno(2008);
        moto1.setValor(12000);
        moto1.setCilindradas(400);

        Motocicleta moto2 = new Motocicleta();
        moto2.setDescricao("Yamaha DT 180");
        moto2.setAno(1984);
        moto2.setValor(1000);
        moto2.setCilindradas(180);

        detran.addVeiculo(automovel1);
        detran.addVeiculo(automovel2);
        detran.addVeiculo(automovel3);
        detran.addVeiculo(moto1);
        detran.addVeiculo(moto2);
        
        System.out.println(detran.listaVeiculos());
        System.out.println(detran.quaisVeiculosFaixa(240, 1000).size());
    }
}
