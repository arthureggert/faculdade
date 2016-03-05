package br.com.ahe.dscd.projeto.thread.quimica.molecula;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.core.Logger;

import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import br.com.ahe.dscd.projeto.thread.utils.AQuimicaUtils;

public class MoleculaFactory {

	private static Logger log;

	private List<Atomo> atomos;
	
	private Lock lock;

	private Condition inUse;

	private boolean criandoMolecula;

	public MoleculaFactory(List<Atomo> atomosList) {
		this.atomos = atomosList;
		this.lock = new ReentrantLock();
		this.inUse = this.lock.newCondition();
		this.criandoMolecula = false;
//		log = Logger.getLogger(MoleculaFactory.class.getSimpleName()); 
//		BasicConfigurator.configure();
	}


	public Molecula criaAcido(){
		this.lock.lock();
		Molecula molecula = null;
		try {			
			molecula = new Molecula(AQuimicaUtils.getFirstAtomoFromList(this.atomos, "H"));
			while (this.criandoMolecula) {
				this.inUse.await(5, TimeUnit.MILLISECONDS);
			}
			this.criandoMolecula = true;
			for(int i = 0 ; i <= 5 ; i++){
				Atomo atomo = AQuimicaUtils.getProximoAtomoFromList(this.atomos);
				if(atomo.getNox() + molecula.getNox() == 0){
					molecula.addAtomoLast(atomo);
					break;
				} else {
					if(AQuimicaUtils.isAtomoFromTipe(atomo, "O")){
						if(!AQuimicaUtils.hasOxigenio(molecula)){
							molecula.addAtomoLast(atomo);							
						}
					} 
					continue;
				}
			}
			AQuimicaUtils.validaMolecula(molecula);
			this.atomos.removeAll(molecula.getAtomos());
		} catch (AtomoNaoEncontradoException atomoNaoEncontradoException) {
			log.debug(atomoNaoEncontradoException.getMessage());
			molecula = null;
		} catch (MoleculaInvalidaException moleculaInvalidaException) {
			log.debug(moleculaInvalidaException.getMessage());
			molecula = null;
		} catch (InterruptedException interruptedException) {
			log.debug(interruptedException.getMessage());
			molecula = null;
		} finally {
			this.inUse.signalAll();
			this.lock.unlock();
			this.criandoMolecula = false;
		}
		return molecula;
		
	}
	
	public Molecula criaBase(){
		this.lock.lock();
		Molecula molecula = null;
		try {			
			molecula = new Molecula(AQuimicaUtils.getFirstAtomoFromList(this.atomos, "OH"));
			while (this.criandoMolecula) {
				this.inUse.await(100, TimeUnit.MILLISECONDS);
			}
			this.criandoMolecula = true;
			for(int i = 0 ; i <= 5 ; i++){
				Atomo atomo = AQuimicaUtils.getProximoAtomoFromList(this.atomos);
				if(atomo.getNox() + molecula.getNox() == 0){
					molecula.addAtomoFirst(atomo);
					break;
				} else {
					if(AQuimicaUtils.isAtomoFromTipe(atomo, "O")){
						if(!AQuimicaUtils.hasOxigenio(molecula)){
							molecula.addAtomoLast(atomo);							
						}
					} 
					continue;
				}
			}
			AQuimicaUtils.validaMolecula(molecula);
			this.atomos.removeAll(molecula.getAtomos());
		} catch (AtomoNaoEncontradoException atomoNaoEncontradoException) {
			log.debug(atomoNaoEncontradoException.getMessage());
			molecula = null;
		} catch (MoleculaInvalidaException moleculaInvalidaException) {
			log.debug(moleculaInvalidaException.getMessage());
			molecula = null;
		} catch (InterruptedException interruptedException) {
			log.debug(interruptedException.getMessage());
			molecula = null;
		} finally {
			this.inUse.signalAll();
			this.lock.unlock();
			this.criandoMolecula = false;
		}
		return molecula;
	}
}
