package br.com.ahe.aed.tavares.pilha;

public class PilhaEncadeadaComMarca {
	
		private NodoPilhaComMarca topo;
		private NodoPilhaComMarca base;
		
		public NodoPilhaComMarca getTopo() {
			return this.topo;
		}

		public NodoPilhaComMarca getBase() {
			return this.base;
		}

		public void setTopo(NodoPilhaComMarca topo) {
			this.topo = topo;
		}

		public void setBase(NodoPilhaComMarca base) {
			this.base = base;
		}

		public PilhaEncadeadaComMarca() {
			this.topo = null;
			this.base = null;
		}

		public void empilha(Object elemento, boolean marca) {
			NodoPilhaComMarca nodo = new NodoPilhaComMarca(elemento, marca);
			if (this.topo == null) /* pilha vazia */
				this.base = nodo;
			nodo.setAnterior(this.topo);
			this.topo = nodo;
		}
		
		public Object desempilha() {

			if (this.topo != null) {
				NodoPilhaComMarca nodo = this.topo;
				this.topo = nodo.getAnterior();
				return nodo;
			} else
				return null;
		}

		public boolean vazia() {
			if (this.topo == null)
				return true;
			else
				return false;
		}
}
