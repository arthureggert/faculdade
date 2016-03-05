package br.com.ahe.aed.tavares.pilha;


public class PilhaEncadeada {

	private NodoPilha topo;
	private NodoPilha base;
	
	public PilhaEncadeada() {
		this.setTopo(null);
		this.setBase(null);
	}

	public NodoPilha getTopo() {
		return this.topo;
	}

	public void setTopo(NodoPilha topo) {
		this.topo = topo;
	}

	public NodoPilha getBase() {
		return this.base;
	}

	public void setBase(NodoPilha base) {
		this.base = base;
	}

	public void empilha(Object info){
		
		NodoPilha tmp = new NodoPilha(info);
		if (isVazia()){
			this.setTopo(tmp);
			this.setBase(tmp);
		} else {
			tmp.setAnt(this.getTopo());
			this.setTopo(tmp);
		}
	}
	
	public boolean isVazia(){
		return (this.topo == null);
	}
	
	public Object desempilha(){
		NodoPilha tmp = this.getTopo();
		
		if (!isVazia()){
			this.setTopo(this.getTopo().getAnt());
			if (isVazia()){
				this.setBase(null);
			}
		}
		tmp.setAnt(null);
		return tmp.getInfo();
	}
	
    public void libera() {
        if (!isVazia()) {
            NodoPilha p = this.getTopo();
            while (p.getAnt() != null) {
                this.topo = this.topo.getAnt();
                p.setAnt(null);
                p = this.topo;
            }
            this.topo = null;
        }
    }
	
	
}
