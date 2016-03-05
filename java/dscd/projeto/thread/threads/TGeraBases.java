package br.com.ahe.dscd.projeto.thread.threads;

import org.apache.logging.log4j.core.Logger;

import br.com.ahe.dscd.projeto.thread.quimica.molecula.MoleculaFactory;
import br.com.ahe.dscd.projeto.thread.utils.Armazem;

public class TGeraBases extends Thread {

	private MoleculaFactory factory;

	private Armazem dados;
	
	private static Logger log;

	public TGeraBases(MoleculaFactory fabrica, Armazem armazem) {
		this.dados = armazem;
		this.factory = fabrica;
		//log = Logger.getLogger(TGeraBases.class.getSimpleName()); 
		//BasicConfigurator.configure();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			log.debug("Thread de Geração de BASES INI");
			this.dados.addMolecula(this.factory.criaBase());
			log.debug("Thread de Geração de BASES FIM");
		}	
	}
}
