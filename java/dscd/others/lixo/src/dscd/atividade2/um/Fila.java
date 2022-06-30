package dscd.atividade2.um;

import java.util.LinkedList;


public class Fila {

	private LinkedList<String> vetor;
	private boolean inserindo;

	public Fila() {
		this.inserindo = true;
		this.vetor = new LinkedList<String>();
	}

	public synchronized void put(String dado) throws InterruptedException {
		while (!podeInserir()) {
			wait();
		}			
		vetor.add(dado);
		notifyAll();
		imprimeN("Insere", dado);			
		verificaInsercao();
	}

	private void verificaInsercao() {
		if(vetor.size() < 10){
			inserindo = true;
		}
		if (vetor.size() == 20){
			inserindo = false;
		}
		
	}

	private boolean podeInserir() {
		if(inserindo && vetor.size() < 20){
			return true;
		}
		if(!inserindo && vetor.size() < 10){
			return true;
		}
		return false;
	}

	private void imprimeN(String metodo, String dado) {
		System.out.println(metodo + ": " + dado + " " + vetor.size());
	}

	public synchronized void get() throws InterruptedException {
		while (vazia()) {
			wait();
		}
		imprimeN("Retira", vetor.remove());
		notifyAll();
	}

	public boolean vazia() {
		return vetor.size() == 0;
	}

}
