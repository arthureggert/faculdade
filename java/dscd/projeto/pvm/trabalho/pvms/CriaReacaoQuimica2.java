package br.com.ahe.dscd.projeto.pvm.trabalho.pvms;

import java.util.ArrayList;
import java.util.List;

import br.com.ahe.dscd.deamon.jpvmBuffer;
import br.com.ahe.dscd.deamon.jpvmEnvironment;
import br.com.ahe.dscd.deamon.jpvmException;
import br.com.ahe.dscd.deamon.jpvmMessage;
import br.com.ahe.dscd.deamon.jpvmTaskId;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaElemento;
import br.com.ahe.dscd.projeto.thread.quimica.tabela.TabelaPeriodicaFactory;

public class CriaReacaoQuimica2 {

	public static void main(String[] args) {

		try {
			jpvmEnvironment jpvm = new jpvmEnvironment();
			jpvmTaskId parent = jpvm.pvm_parent();
			jpvmMessage message = jpvm.pvm_recv();
			String reacao = criaReacaoCompleta(message);
			jpvmBuffer buf = new jpvmBuffer();
			buf.pack(reacao.toString());
			int tag = 0;
			if(reacao.compareTo("erro") == 0){
				tag = 1;
			}
			jpvm.pvm_send(buf, parent, tag );
			jpvm.pvm_exit();
		} 
		catch (jpvmException jpe) {
			System.out.println("Error - jpvm exception");
		}
	}

	private static String criaReacaoCompleta(jpvmMessage message) throws jpvmException {
		try {
			String[] reacao = message.buffer.upkstr().split("#");
			String nomeAcido = reacao[0].replaceAll("\\r", "");
			String moleculaAcido = reacao[1].replaceAll("\\r", "");
			String nomeBase = reacao[2].replaceAll("\\r", "");
			String moleculaBase = reacao[3].replaceAll("\\r", "");
			String resultados =  reacao[4].replaceAll("\\r", "");

			ReacaoQuimica2 reacao2 = new ReacaoQuimica2();
			reacao2.setAcido(criaMolecula(nomeAcido, moleculaAcido));
			reacao2.setBase(criaMolecula(nomeBase, moleculaBase));
			reacao2.setAgua(criaMolecula("Agua", resultados.substring(0, 2)));
			reacao2.setSal(criaMolecula("", resultados.substring(3, resultados.length()-1)));

			return reacao2.toString();
		} catch (Exception e) {
			return "erro";
		}
	}

	private static Molecula criaMolecula(String nome, String molecula) {
		Molecula mol = new Molecula();
		mol.setNome(nome);
		mol.addAtomos(criaAtomos(molecula));
		return mol;
	}

	private static List<Atomo> criaAtomos(String molecula) {
		List<Atomo> atomosMolecula = new ArrayList<Atomo>();
		String[] moleculaSplit = molecula.split("(?=\\p{Lu})");

		for (String siglaAtomo : moleculaSplit) {
			if(!siglaAtomo.trim().isEmpty()){
				TabelaPeriodicaElemento elemento = TabelaPeriodicaFactory.getInstance().getElementBySigla(siglaAtomo.trim());
				atomosMolecula.add(new Atomo(elemento));					
			}
		}
		return atomosMolecula;
	}

}
