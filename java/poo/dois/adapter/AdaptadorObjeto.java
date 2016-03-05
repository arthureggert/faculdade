package br.com.ahe.poo.dois.adapter;

public class AdaptadorObjeto extends Alvo {
	
	ClasseExistente existente = new ClasseExistente();
	
	public void operacao() {
		String texto = this.existente.metodoUtilDois("Opera��o Realizada.");
		this.existente.metodoUtilUm(texto);
	}
}