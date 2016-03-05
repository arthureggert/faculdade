package br.com.ahe.poo.dois.adapter;



public class AdaptadorClasse extends ClasseExistente implements InterfaceAlvo {

	@Override
	public void operacao() {
		String texto = metodoUtilDois("Opera��o Realizada");
		metodoUtilUm(texto);
	}
}
