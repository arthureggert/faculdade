package br.com.ahe.aed.rodacki.arvores;

public class Busca {

	public int buscaLinear(int vet[], int elem){
		int n = vet.length;
		for(int i = 0; i <= n-1; i++){
			if(elem == vet[i]){
				return i;
			}
		}
		return -1;
	}
	
	public int buscaLinearOrdenada(int vet[], int elem){
		int n = vet.length;
		for(int i = 0; i <= n-1; i++){
			if(elem == vet[i]){
				return i;
			} else {
				if(elem < vet[i]){
					return -1;
				}
			}
		}
		return -1;
	}
	
	
	public int buscaBinaria(int vet[], int elem){
		int n = vet.length;
		int ini = 0;
		int fim = n-1;
		int meio;
		while(ini <= fim){
			meio = (ini+fim)/2;
			if(elem < vet[meio]){
				fim = meio-1;
			} else {
				if(elem > vet[meio]){
					fim = meio + 1;
				} else {
					return meio;
				}
			}
		}
		return -1;
	}
	
	public int buscaBinariaRecursiva(int vet[], int ini, int fim, int elem){
		if(ini < fim){
			int meio = ini+(fim-ini)/2;
			if (elem < vet[meio]){
				return buscaBinariaRecursiva(vet,ini,meio,elem);
			} else {
				if(elem > vet[meio]){
					return buscaBinariaRecursiva(vet,meio+1,fim,elem);
				} else {
					return meio;
				}
			}
		}
		return -1;
	}
}
