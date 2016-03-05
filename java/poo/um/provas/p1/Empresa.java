package br.com.ahe.poo.um.provas.p1;

public class Empresa {
	
	private String nomeEmpresa;
	private int anoFundacao;
	private float[] faturamentoAnual = new float[10];
	private char ramoAtuacao;
	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public int getAnoFundacao() {
		return this.anoFundacao;
	}
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
	public float[] getFaturamentoAnual() {
		return this.faturamentoAnual;
	}
	public void setFaturamentoAnual(int ano, float valor) {
		this.faturamentoAnual[ano] = valor;
	}
	public char getRamoAtuacao() {
		return this.ramoAtuacao;
	}
	public void setRamoAtuacao(char ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
	}
	
	

	
	public float faturamentoCincoAnos(){
		float media = 0f;
		for (int i = 0; i < this.faturamentoAnual.length-5;i++){
			media = media+this.faturamentoAnual[i];		
		}
		return media;
	}
	
	public float prevFat(){
		float fatAno = 0f;
		float percentual = 0.01f; 
		for(int i = 0; i < this.faturamentoAnual.length;i++){
			fatAno += this.faturamentoAnual[i]*percentual;
			percentual++;
		}
		return fatAno;
	}
	
	public boolean compara(Empresa outraEmpresa){
		if(this.anoFundacao == outraEmpresa.anoFundacao){
			return true;
		} else {
			return false;
		}
	}
}
	
