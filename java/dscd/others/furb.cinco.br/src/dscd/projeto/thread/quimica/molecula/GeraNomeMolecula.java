package dscd.projeto.thread.quimica.molecula;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import core.utils.AListUtils;
import core.utils.AStringUtils;
import dscd.projeto.thread.utils.AQuimicaUtils;
import dscd.projeto.thread.utils.Armazem;
import dscd.projeto.thread.utils.ETipoAcido;


public class GeraNomeMolecula {
	
	private Armazem dados;	

	private static Logger log;
	
	public GeraNomeMolecula(Armazem dados){
		this.dados =  dados;
		GeraNomeMolecula.log = Logger.getLogger(GeraNomeMolecula.class.getSimpleName());
		BasicConfigurator.configure();
	}
	
	public synchronized void nomeiaAcidos(){
		try {
			while(!AQuimicaUtils.hasAcidoAtList(dados.getMoleculas())) {
				wait();
			}
			Molecula molecula = AListUtils.getFirstObjectFromList(dados.getMoleculas());
			if(!AQuimicaUtils.isMoleculaAcido(molecula)) {
				throw new MoleculaInvalidaException("Molecula Encontrada não é um acido");
			} else {
				if(AQuimicaUtils.getTipoAcido(molecula) == ETipoAcido.HIDRACIDO){
					geraNomeHidracido(molecula);
				} else {
					geraNomeOxiacido(molecula);
				}
			}
			dados.removeMolecula(molecula);
			dados.addMoleculaAcido(molecula);
		} catch (InterruptedException interruptedException) {	
			log.debug(interruptedException.getMessage());
		} catch (MoleculaInvalidaException moleculaInvalidaException) {
			log.debug(moleculaInvalidaException.getMessage());
		} 
		notifyAll();			
		
	}

	private void geraNomeOxiacido(Molecula molecula) {
		String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
		while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
			nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
		}
		molecula.setNome(String.format("Acido %sico", nomeAtomo));
	}

	private void geraNomeHidracido(Molecula molecula) {
		String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
		while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
			nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
		}
		molecula.setNome(String.format("Acido %sidrico", nomeAtomo));
	}

	public synchronized void nomeiaBases() {
		try {
			while(!AQuimicaUtils.hasBaseAtList(dados.getMoleculas())) {
				wait();
			}
			Molecula molecula = AListUtils.getFirstObjectFromList(dados.getMoleculas());
			if(!AQuimicaUtils.isMoleculaBase(molecula)) {
				throw new MoleculaInvalidaException("Molecula Encontrada não é uma base");
			} else {
				geraNomeBase(molecula);
			}
			dados.removeMolecula(molecula);
			dados.addMoleculaBase(molecula);
		} catch (InterruptedException interruptedException) {	
			log.debug(interruptedException.getMessage());
		} catch (MoleculaInvalidaException moleculaInvalidaException) {
			log.debug(moleculaInvalidaException.getMessage());
		} 
		notifyAll();			
	}

	private void geraNomeBase(Molecula molecula) {
		String nomeAtomo = AListUtils.getFirstObjectFromList(molecula.getAtomos()).getNome();
		molecula.setNome(String.format("Hidroxido de %s", nomeAtomo));
	}
	
}
