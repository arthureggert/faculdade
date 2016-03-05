package br.com.ahe.poo.um.provas.p2;

import java.util.ArrayList;

public class Imovel {
	
	private char tipoImovel;
	private char usoImovel;
	private String enderecoImovel;
	private String proprietarioDoImovel;
	private char finalidadeImovel;
	private int valorDoImovel;
	private ArrayList<ComodosDoImovel> comodosImovel = new ArrayList<ComodosDoImovel>();
	
	public Imovel(char tipo, char uso, String endereco, String proprietario, char finalidade, int valor){
		this.setTipoImovel(tipo);
		this.setUsoImovel(uso);
		this.setEnderecoImovel(endereco);
		this.setProprietarioDoImovel(proprietario);
		this.setFinalidadeImovel(finalidade);
		this.setValorDoImovel(valor);
	}
	
	public char getTipoImovel() {
		return this.tipoImovel;
	}		
	public void setTipoImovel(char tipoImovel) {
		if( tipoImovel != 'C' || tipoImovel != 'A' || tipoImovel != 'G' || tipoImovel != 'T' ||	tipoImovel != 'O'){
			throw new IllegalArgumentException("Tipo do Imovel Difere dos possiveis: C(Casa), A(Apartamento), G(Galp�o), T(Telheiro), O(Outros)");
		} else {
			this.tipoImovel = tipoImovel;
		}	
	}
	
	public char getUsoImovel() {
		return this.usoImovel;
	}
	public void setUsoImovel(char usoImovel) {
		if( usoImovel != 'R' || usoImovel != 'C' || usoImovel != 'I' || usoImovel != 'S' || usoImovel != 'O'){
			throw new IllegalArgumentException("Uso do Imvel Difere dos possiveis: R(Residencial, C(Comercial), I(Industrial), S(Servi�os), O(Outros)");
		} else {
			this.usoImovel = usoImovel;	
		}		
	}
	
	public String getEnderecoImovel() {
		return this.enderecoImovel;
	}
	public void setEnderecoImovel(String enderecoImovel) {
		if ( enderecoImovel == null || enderecoImovel.isEmpty()){
			throw new IllegalArgumentException("Endere�o n�o pode ser nulo");
		} else {
			this.enderecoImovel = enderecoImovel;	
		}
	}
	
	public String getProprietarioDoImovel() {
		return this.proprietarioDoImovel;
	}
	public void setProprietarioDoImovel(String proprietarioDoImovel) {
		if ( proprietarioDoImovel == null || proprietarioDoImovel.isEmpty()){
			throw new IllegalArgumentException("Prppietario n�o pode ser nulo");
		} else {
			this.proprietarioDoImovel = proprietarioDoImovel;	
		}	
	}
	
	public char getFinalidadeImovel() {
		return this.finalidadeImovel;
	}
	public void setFinalidadeImovel(char finalidadeImovel) {
		if ( finalidadeImovel != 'V' || finalidadeImovel != 'L' ){
			throw new IllegalArgumentException("Finalidade do imovel difere dos possiveis: V(Venda), L(Loca��o)");
		} else {
			this.finalidadeImovel = finalidadeImovel;	
		}
	}
	public int getValorDoImovel() {
		return this.valorDoImovel;
	}
	public void setValorDoImovel(int valorDoImovel) {
		this.valorDoImovel = valorDoImovel;
	}

	public void addComodoImovel(ComodosDoImovel comodo){
		if (comodo == null){
			throw new IllegalArgumentException("Comodo Inexistente");
		} else {
			this.comodosImovel.add(comodo);
		}
	}
	
	public float getIndiceVentilacao(){
		float somaIndices = 0f;
		float totalIndice = 0f;
		for ( ComodosDoImovel c: this.comodosImovel ){
			somaIndices = somaIndices+c.getIndiceVentilacaoComodo();
		}
		totalIndice = somaIndices/this.comodosImovel.size();
		return totalIndice;
	}
	
	public float getAreaTotal(){
		float areaTotal = 0f;
		for ( ComodosDoImovel c: this.comodosImovel ){
			areaTotal = areaTotal+c.getAreaComodo();
		}
		return areaTotal;
	}
	
	public int compareTo(Imovel outroImovel){
		int comparador = 0;
		if ( this.tipoImovel != outroImovel.tipoImovel || this.getUsoImovel() != outroImovel.getUsoImovel() ){
			comparador = 5;
		} else if (this.getFinalidadeImovel() != outroImovel.getFinalidadeImovel()){
			comparador = -5;
		} else if (this.getValorDoImovel() > outroImovel.getValorDoImovel()){
			comparador = 1;
		} else if (this.getValorDoImovel() == outroImovel.getValorDoImovel()){
			comparador = 0;
		} else if (this.getValorDoImovel() < outroImovel.getValorDoImovel()){
			comparador = -1;
		}
		return comparador;
	}
	
	public int getQtdComodos(){
		int qtdComodos = 0;
		qtdComodos = this.comodosImovel.size();
		return qtdComodos;
	}
	
	public float getIndiceRetabilidadeLocacao(){
		float indice = 0f;
		if (this.finalidadeImovel == 'L'){
			indice = (this.getValorDoImovel()/this.getAreaTotal())/this.getQtdComodos();
		} else {
			indice = 1f;
		}
		return indice;
	}
}
