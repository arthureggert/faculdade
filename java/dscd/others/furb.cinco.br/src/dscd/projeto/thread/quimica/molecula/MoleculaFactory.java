package dscd.projeto.thread.quimica.molecula;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import dscd.projeto.thread.quimica.atomo.Atomo;
import dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import dscd.projeto.thread.utils.AQuimicaUtils;

public class MoleculaFactory {

	private static Logger log;

	private List<Atomo> atomos;
	
	private Lock lock;

	private Condition inUse;

	private boolean criandoMolecula;

	public MoleculaFactory(List<Atomo> atomosList) {
		atomos = atomosList;
		lock = new ReentrantLock();
		inUse = lock.newCondition();
		criandoMolecula = false;
		log = Logger.getLogger(MoleculaFactory.class.getSimpleName()); 
		BasicConfigurator.configure();
	}


	public Molecula criaAcido(){
		lock.lock();
		Molecula molecula = null;
		try {			
			molecula = new Molecula(AQuimicaUtils.getFirstAtomoFromList(atomos, "H"));
			while (criandoMolecula) {
				inUse.await(5, TimeUnit.MILLISECONDS);
			}
			criandoMolecula = true;
			for(int i = 0 ; i <= 5 ; i++){
				Atomo atomo = AQuimicaUtils.getProximoAtomoFromList(atomos);
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
			atomos.removeAll(molecula.getAtomos());
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
			inUse.signalAll();
			lock.unlock();
			criandoMolecula = false;
		}
		return molecula;
		
	}
	
	public Molecula criaBase(){
		lock.lock();
		Molecula molecula = null;
		try {			
			molecula = new Molecula(AQuimicaUtils.getFirstAtomoFromList(atomos, "OH"));
			while (criandoMolecula) {
				inUse.await(100, TimeUnit.MILLISECONDS);
			}
			criandoMolecula = true;
			for(int i = 0 ; i <= 5 ; i++){
				Atomo atomo = AQuimicaUtils.getProximoAtomoFromList(atomos);
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
			atomos.removeAll(molecula.getAtomos());
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
			inUse.signalAll();
			lock.unlock();
			criandoMolecula = false;
		}
		return molecula;
	}
}
