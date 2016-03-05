package br.com.ahe.lf.ahe;

public class AutomatoFinito {
	private String palavra;
	private int indexPalavra = 0;
	private String transicoes = "";
	
	public String getTransicoes() {
		return this.transicoes;
	}

	public String iniciaAnalise(String palavra) throws Exception{
		this.palavra = palavra;
		return estadoQ0(proximoSimbolo());
	}
	
	private String estadoQ0(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q0 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ1(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ2(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoQ7(proximoSimbolo());
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;		
	}

	private String estadoQ1(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q1 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ3(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ4(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ2(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q2 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ5(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ4(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ3(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q3 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ13(proximoSimbolo());	
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ6(proximoSimbolo());
			}
			break;
		case 'c':
			if (isfinalDePalavra()){
				tmp = estadoFinal(2);
			} else {
				tmp = estadoQ7(proximoSimbolo());	
			}
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ4(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q4 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ5(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ2(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoQ7(proximoSimbolo());
			break;
			
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ5(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q5 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ9(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ10(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoFinal(0);
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ6(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q6 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ9(proximoSimbolo());	
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ11(proximoSimbolo());
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ7(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q7 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoFinal(1);
			break;
		case 'b':
			tmp = estadoFinal(1);
			break;
		case 'c':
			if (isfinalDePalavra()){
				tmp = estadoFinal(2);
			} else {
				tmp = estadoQ7(proximoSimbolo());
			}
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ8(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q8 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ9(proximoSimbolo());				
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ11(proximoSimbolo());
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}	
		return tmp;
	}
	
	private String estadoQ9(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q9 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ9(proximoSimbolo());
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ12(proximoSimbolo());
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}		
		return tmp;
	}
	
	private String estadoQ10(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q10 ";
		switch (simbolo) {
		case 'a':
			tmp = estadoQ5(proximoSimbolo());
			break;
		case 'b':
			tmp = estadoQ10(proximoSimbolo());
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ11(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q11 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ9(proximoSimbolo());
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ8(proximoSimbolo());
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private String estadoQ12(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q12 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ9(proximoSimbolo());
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ12(proximoSimbolo());
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}

	private String estadoQ13(char simbolo) throws Exception{
		String tmp = "";
		this.transicoes += "Q13 ";
		switch (simbolo) {
		case 'a':
			if(isfinalDePalavra()){
				 tmp = estadoFinal(2);
			} else {
				tmp = estadoQ3(proximoSimbolo());
			}
			break;
		case 'b':
			if(isfinalDePalavra()){
				tmp = estadoFinal(2);	
			} else {
				tmp = estadoQ11(proximoSimbolo());	
			}
			break;
		case 'c':
			tmp = estadoFinal(0);
			break;
		default:
			tmp = estadoFinal(1);
			break;
		}
		return tmp;
	}
	
	private char proximoSimbolo(){
		int tam = this.palavra.length();
		char temp = 0;
		if(this.indexPalavra < tam){
			temp = this.palavra.charAt(this.indexPalavra);
			this.indexPalavra++;
		}
		return temp;
	}
	
	private boolean isfinalDePalavra(){
		if (proximoSimbolo() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	private String estadoFinal(int estado) throws Exception{
		String strRetorno = "";
		switch (estado) {
		case 0:
			this.transicoes += "Qerro";
			strRetorno = "Erro de Palavra Invalida";
			break;
		case 1:
			this.transicoes += "Qerro";
			strRetorno  ="Erro de Caracter Invalido";
			break;
		case 2:
			strRetorno = "Palavra Aceita";
			break;
		default:
			throw new Exception("Estado Final n�o esperado");
		}
		return strRetorno;
	}
}
