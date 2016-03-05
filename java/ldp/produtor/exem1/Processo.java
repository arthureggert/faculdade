package br.com.ahe.ldp.produtor.exem1;
class Processo extends Thread {

	private int identificador;
	
	private String Nome;

	protected int contador = 0;

	protected boolean flagTerminar;

	protected String status = "Parado";

	protected int prod;

	protected int prodAtual;

	public Processo(int id) {
		this.identificador = id;
		this.contador = 0;
		this.flagTerminar = false;

	}

	public void terminar() {
		this.flagTerminar = true;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public boolean isFlagTerminar() {
		return this.flagTerminar;
	}

	public void setFlagTerminar(boolean flagTerminar) {
		this.flagTerminar = flagTerminar;
	}

	public int getContador() {
		return this.contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProd() {
		if (this.prod > 0)
			return this.prod;
		else
			return 0;

	}

	public void setProd(int prod) {
		this.prod = prod;
	}

	public int getProdAtual() {
		return this.prodAtual;
	}

	public void setProdAtual(int prodAtual) {
		this.prodAtual = prodAtual;
	}

	public String getNome() {
		return this.Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}
}
