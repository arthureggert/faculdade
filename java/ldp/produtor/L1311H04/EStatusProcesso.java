package br.com.ahe.ldp.produtor.L1311H04;

public enum EStatusProcesso {
	
	CONSUMINDO("Consumindo"),
	PRODUZINDO("Produzindo"),
	PARADO("Parado"),
	FINALIZADO("Finalizado");

	private String descricao;
	
	private EStatusProcesso(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
