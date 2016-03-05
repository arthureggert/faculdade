package br.com.ahe.poo.um.provas.p1;

public class MatrizDeDoubles {

	private double[][] Matriz;
	
	public MatrizDeDoubles(int valorColuna, int valorLinha){
		this.Matriz = new double[valorColuna][valorLinha];
	}
			
	public void setValor(int coluna, int linha, double valor){
		this.Matriz[coluna][linha] = valor;
	}
	
	public int somaColuna(int coluna){
		int valorColuna = 0;
		
		for(int i = 0; i != this.Matriz[coluna].length; i++){
			valorColuna = valorColuna + this.Matriz[coluna].length;
		}
		return valorColuna;
	}
	
	public int[] possicaoMenorValorPositivo(){
		int iM = 0;
		int zM = 0;
		int[] valor = new int[2];
		for (int i = 0, z = 0; i < this.Matriz.length; i++){
			if(this.Matriz[i][z] % 2 == 0){
				iM = i;
				zM = z;
			}
		}
		valor[0] = iM;
		valor[1] = zM;
		
		return valor;
	
	}
	
	public double[][] transposta(){
		double[][] transposta = this.Matriz.clone();
		double temp;
		for (int i = 0,j = this.Matriz.length; i < j ; i++,j--){
			temp = this.Matriz[i][j];
			transposta[i][j] = this.Matriz[j][i];
			transposta[j][i] = temp;
		}
		return transposta;
	}
}
