package br.com.ahe.aed.provas.prova2;


public class PilhaComMarca {
		private NodoPilhaComMarca topo;
		private NodoPilhaComMarca base;

		public PilhaComMarca() {
			this.topo = null;
			setBase(null);
		}

		public void empilha(Object elemento, boolean marca) {
			NodoPilhaComMarca nodo = new NodoPilhaComMarca(elemento, marca);
			if (this.topo == null) /* pilha vazia */
				setBase(nodo);
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

		public NodoPilhaComMarca getBase() {
			return this.base;
		}

		public void setBase(NodoPilhaComMarca base) {
			this.base = base;
		}
}
