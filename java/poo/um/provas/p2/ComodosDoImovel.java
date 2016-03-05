package br.com.ahe.poo.um.provas.p2;

public class ComodosDoImovel {
	
	private String descricaoComodo;
	private float larguraComodo;
	private float comprimentoComodo;
	private int qtdPortas = 1;
	private int qtdJanelas;
	
	public ComodosDoImovel(String descricao, float largura, float comprimento, int qtdPortas, int qtdJanelas){
		this.setDescricaoComodo(descricao);
		this.setLarguraComodo(largura);
		this.setComprimentoComodo(comprimento);
		this.setQtdPortas(qtdPortas);
		this.setQtdJanelas(qtdJanelas);
	}
	
	public String getDescricaoComodo() {
		return this.descricaoComodo;
	}
	public void setDescricaoComodo(String descricaoComodo) {
		this.descricaoComodo = descricaoComodo;
	}
	public float getLarguraComodo() {
		return this.larguraComodo;
	}
	public void setLarguraComodo(float larguraComodo) {
		this.larguraComodo = larguraComodo;
	}
	public float getComprimentoComodo() {
		return this.comprimentoComodo;
	}
	public void setComprimentoComodo(float comprimentoComodo) {
		this.comprimentoComodo = comprimentoComodo;
	}
	public int getQtdPortas() {
		return this.qtdPortas;
	}
	public void setQtdPortas(int qtdPortas) {
		if ( qtdPortas < 1 ){
			throw new IllegalArgumentException("Pelo menos uma porta deve existir");
		} else {
		this.qtdPortas = qtdPortas;
		}
	}
	
	public int getQtdJanelas() {
		return this.qtdJanelas;
	}
	public void setQtdJanelas(int qtdJanelas) {
		this.qtdJanelas = qtdJanelas;
	}
	
	public float getAreaComodo(){
		float area = 0f;
		area = this.larguraComodo * this.comprimentoComodo;
		return area;
	}
	
	public float getIniceParaCalculoIndiceVentilacao(){
		float fator = 0f;
		if( this.qtdJanelas >= 1){
			fator = 0.08f;
		} else {
			fator = 1f;
		}
		return fator;
	}
	
	public float getIndiceVentilacaoComodo(){
		float indice = 0f;
		indice = (this.getAreaComodo()/this.getQtdJanelas()) * this.getIniceParaCalculoIndiceVentilacao();
		return indice;
	}
}
