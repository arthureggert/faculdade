package br.com.ahe.cop.copilador.gals3.acao;
public class Simbolo {
	private String identificador;
	private String tipo;

	public Simbolo(String identificador, String tipo) {
		this.identificador = identificador;
		this.tipo = tipo;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}