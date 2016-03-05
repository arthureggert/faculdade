package br.com.ahe.aed.tavares.pilha;

public class NodoPilha {

	private Object info;
	private NodoPilha ant;
	
	public NodoPilha(Object info){
		this.setInfo(info);
		this.setAnt(null);
	}

	public Object getInfo() {
		return this.info;
	}
	
	public NodoPilha getAnt() {
		return this.ant;
	}
	
	public void setInfo(Object info) {
		this.info = info;
	}
	
	public void setAnt(NodoPilha ant) {
		this.ant = ant;
	}

	@Override
	public String toString() {
		return "NoLista [Valor = " + this.info+" ]";
	}

}
