package br.com.ahe.aed.rodacki.ordenacao;

import java.util.ArrayList;
import java.util.Collections;

public class Ordenacao {

	public void imprimeComparacao(String tipoComparacao, long t1, long t2) {
			System.out.println(tipoComparacao+": " + (t2-t1) + " milisegundos");
	}

	
	public int[] criaVetorEmbaralhado(int n){
		ArrayList<Integer> array = new ArrayList<Integer>();
		int[] vetor = new int[n];
		int xAux = 0;
		
		for(int i = 0; i < vetor.length; i++){
			array.add(i);
		}
		Collections.shuffle(array);
		
		for(Integer i : array){
			vetor[xAux] = i;
			xAux++;
		}
		
		return vetor;
	}
	
	public void imprimeVetor(int[] v){
		String n = "";
		for(int i = 0; i < v.length; i++){
			n+= v[i]+" ";
		}
		System.out.println(n);
	}
	
	
	/**  BubbleSort  **/
	
	public int[] bubbleSortV1(int[] v){
		int i, j ;
		int n = v.length;
		for(i = n-1; i > 1; i--){
			for(j = 0; j < i; j++ ){
				if(v[j] > v[j+1]){
					int temp = v[j];
					v[j] = v[j+1];
					v[j+1] = temp;
				}	
			}
		}
		return v;
	}
	
	public int[] bubbleSortV2 (int[] v){
		boolean troca = true;
	    while (troca == true) {
	    	troca = false;
	        for (int i = 0; i < (v.length)-1; i++){
	            if (v[i] > v[i+1]){
	                int temp = v[i+1];
	                v[i+1] = v[i];
	                v[i] = temp;
	                troca = true;
	            }
			}
	    }
		return v;         
	}
	
	public int[] bubbleSortRecursivo(int n, int[] v){
		int j;
		boolean troca = false;
		for(j = 0; j <= n-1; j++){
			if(v[j] > v[j+1]){
				int temp = v[j];
				v[j] = v[j+1];
				v[j+1] = temp;
				troca = true;
			}
		}
		if(troca){
			bubbleSortRecursivo(n-1, v);
		}
		return v;
	}

 /**  QuickSort  **/
	
	private void troca(int[] v, int a, int b){
		int temp = v[a];
		v[a] = v[b];
		v[b] = temp;
	}
	
	public int[] quickSort(int[] v, int a, int b){
		if(a >= b){
			return null;
		}
		int indicePivo = particiona(v,a,b);
		quickSort(v, a, indicePivo);
		quickSort(v, indicePivo + 1, b);
		return v;
	}

	private int particiona(int[] v, int a, int b) {
		int x = v[a];
		while(a < b){
			while(v[a] < x){
				a++;
			}
			while(v[b] > x){
				b--;
			}
			troca(v,a,b);
		}
		return a;
	}
	
	/** MergeSort **/

	public void mergeSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
	}
 
	private void merge(int[] vetor, int inicio, int meio, int fim) {
		int tamanho = fim - inicio + 1;
        int[] temp = new int[tamanho];
        System.arraycopy(vetor, inicio, temp, 0, tamanho);
        int i = 0;
        int j = meio - inicio + 1;
        for (int posicao = 0; posicao < tamanho; posicao++) {
        	if (j <= tamanho - 1) {
        		if (i <= meio - inicio) {
        			if (temp[i] < temp[j]) {
        				vetor[inicio + posicao] = temp[i++];
        			} else {
        				vetor[inicio + posicao] = temp[j++];
        			}
        		} else {
        			vetor[inicio + posicao] = temp[j++];
        		}
        	} else {
        		vetor[inicio + posicao] = temp[i++];
        	}
        }
	}
}
