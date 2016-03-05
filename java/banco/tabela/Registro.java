package br.com.ahe.banco.tabela;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"id"})
public class Registro {


	private String id;
	
	@Getter
	private String[] registro;
	
	public Registro(String registro) {
		this.registro = registro.split("\\|");
		this.id = this.registro[0];
	}

	public int size() {
		return registro.length;
	}

	public String get(int i) {
		return registro[i];
	}
	
	public void set(int i , String valor) {
		registro[i] = valor;
	}

	public String getChave() {
		return id;
	}

	public String getRegistroAsString() {
		StringBuilder builder = new StringBuilder();
		for (String string : registro) {
			builder.append(string);
		}
		return builder.toString();
		
	}	
}
