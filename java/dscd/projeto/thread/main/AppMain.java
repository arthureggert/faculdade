package br.com.ahe.dscd.projeto.thread.main;

import java.util.ArrayList;
import java.util.List;

import br.com.ahe.dscd.projeto.thread.geradados.GeraDadosEntrada;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoFactory;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.GeraNomeMolecula;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.MoleculaFactory;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.GeraReacaoAcidoBase;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;
import br.com.ahe.dscd.projeto.thread.threads.TExecutaReacao;
import br.com.ahe.dscd.projeto.thread.threads.TGeraAcidos;
import br.com.ahe.dscd.projeto.thread.threads.TGeraBases;
import br.com.ahe.dscd.projeto.thread.threads.TNomeiaAcido;
import br.com.ahe.dscd.projeto.thread.threads.TNomeiaBases;
import br.com.ahe.dscd.projeto.thread.utils.Armazem;

/**
 * @author arthur
 *
 */
public class AppMain {

	public static void main(String[] args) throws InterruptedException {
		List<Atomo> lista = AtomoFactory.getInstance().getAtomos();
		MoleculaFactory fabrica = new MoleculaFactory(lista);
		
		Armazem dados = new Armazem();
		
		TGeraAcidos tAcidos = new TGeraAcidos(fabrica, dados);
		TGeraBases tBases = new TGeraBases(fabrica, dados);
		
		tAcidos.start();
		tBases.start();
		
		Thread.sleep(1000);
		
		GeraNomeMolecula geradorNomesMoleculas = new GeraNomeMolecula(dados);
		
		TNomeiaAcido tNomeiaAcido = new TNomeiaAcido(geradorNomesMoleculas);
		TNomeiaBases tNomeiaBases = new TNomeiaBases(geradorNomesMoleculas);
		
		tNomeiaAcido.start();
		tNomeiaBases.start();
		
		Thread.sleep(1000);
		GeraReacaoAcidoBase reacao = new GeraReacaoAcidoBase(dados);
		
		TExecutaReacao tExecutaReacao = new TExecutaReacao(reacao);
		TExecutaReacao tExecutaReacao1 = new TExecutaReacao(reacao);
		
		tExecutaReacao.start();
		tExecutaReacao1.start();

	}

	public static void geracaoTeste() {
		List<Atomo> lista = AtomoFactory.getInstance().getAtomos();
		MoleculaFactory factory = new MoleculaFactory(lista);
		List<Molecula> moleculas = new ArrayList<Molecula>();
		for (int i = 0; i < 1000; i++) {
			factory.criaBase();
		}
		System.out.println(moleculas.size());
		for (Molecula molecula : moleculas) {
			System.out.println(molecula.toString());
			System.out.println("----------------------------------------------");
		}
	}

	public static void geraDados() {
		List<String> dados = TabelaPeriodicaFactory.getInstance().getTabelaPeriodica().getSilgaElementosAsLIst();
		GeraDadosEntrada gdados = new GeraDadosEntrada();
		gdados.geraDados(dados, 1000);
	}

}
