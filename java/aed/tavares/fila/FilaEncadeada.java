package br.com.ahe.aed.tavares.fila;

public class FilaEncadeada {
	
	private NodoFila inicio;
	private NodoFila fim;
	
	public FilaEncadeada() {
		this.setInicio(null);
		this.setFim(null);
	}

	public NodoFila getInicio() {
		return this.inicio;
	}

	public void setInicio(NodoFila inicio) {
		this.inicio = inicio;
	}

	public NodoFila getFim() {
		return this.fim;
	}


	public void setFim(NodoFila fim) {
		this.fim = fim;
	}
	
	public void insereFila(Object info){
		
		NodoFila tmp = new NodoFila(info);
		
		if (isVazia()){
			this.setInicio(tmp);
		} else {
			this.getFim().setProximo(tmp);
		}
		this.setFim(tmp);
	}
	
	public Object removeFila(){
		if (!isVazia()){
			NodoFila tmp = this.getInicio();
			this.setInicio(this.getInicio().getProximo());
			tmp.setProximo(null);
			if (isVazia()){
				this.setFim(null);
			}
			return tmp;
		} else {
			return null;
		}
	}

	public boolean isVazia(){
		if (this.getInicio() == null){
			return true;
		} else {
			return false;
		}
	}
	public Object consultaFila() throws Exception{
		if (!isVazia()){
			Object ret = this.getInicio();
			return ret;
		} else {
			throw new Exception("ERRO: Fila esta vazia!");
		}
	}
}
