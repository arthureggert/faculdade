package dscd.projeto.thread.threads;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import dscd.projeto.thread.quimica.molecula.MoleculaFactory;
import dscd.projeto.thread.utils.Armazem;

public class TGeraAcidos extends Thread {

	private MoleculaFactory factory;

	private Armazem dados;
	
	private static Logger log;

	public TGeraAcidos(MoleculaFactory fabrica, Armazem armazem) {
		dados = armazem;
		factory = fabrica;
		log = Logger.getLogger(TGeraAcidos.class.getSimpleName()); 
		BasicConfigurator.configure();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			log.debug("Thread de Geração de Acidos INI");
			dados.addMolecula(factory.criaAcido());
			log.debug("Thread de Geração de Acidos FIM");
		}	
	}
	
	
}
