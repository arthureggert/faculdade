package br.com.ahe.lf.ahe;

public class AutomatoFinito2 {
	
//	private char caracter;
//	private int estado;
	private Integer[][] matriz;
	
	public void iniciaTabelaDeTransicao(){
		this.matriz = new Integer[14][5];
		for (int i = 0; i < 15;i++){
			this.matriz[i][0] = i;
			this.matriz[i][4] = 14;
		}
		this.matriz[0][1] = 1;
		this.matriz[1][1] = 3;
	}

}
