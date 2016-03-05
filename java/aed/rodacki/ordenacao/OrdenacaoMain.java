package br.com.ahe.aed.rodacki.ordenacao;

public class OrdenacaoMain {

	public static void main(String[] args) {
		
		

		
		Ordenacao ordena = new Ordenacao();
		
//		int[] v1 = ordena.criaVetorEmbaralhado(100);
		int[] v2 = ordena.criaVetorEmbaralhado(1000);
//		int[] v3 = ordena.criaVetorEmbaralhado(10000);
//		int[] v4 = ordena.criaVetorEmbaralhado(100000);
//		int[] v5 = ordena.criaVetorEmbaralhado(1000000);
		
		bubbleSortV1(ordena, v2);
		bubbleSortV2(ordena, v2);
		bubbleSortRecursivo(ordena, v2, v2.length-1);
		quickSort(ordena, v2, 0, v2.length-1);
		mergeSort(ordena, v2, 0, v2.length-1);
	}

	private static void bubbleSortV1(Ordenacao ordena, int[] v) {
		long t1 = System.currentTimeMillis();
		ordena.bubbleSortV1(v);
		long t2 = System.currentTimeMillis();
		ordena.imprimeComparacao("BubbleSortV1", t1, t2);
	}
	
	private static void bubbleSortV2(Ordenacao ordena, int[] v) {
		long t1 = System.currentTimeMillis();
		ordena.bubbleSortV1(v);
		long t2 = System.currentTimeMillis();
		ordena.imprimeComparacao("BubbleSortV2", t1, t2);
	}
	
	private static void bubbleSortRecursivo(Ordenacao ordena, int[] v, int n) {
		long t1 = System.currentTimeMillis();
		ordena.bubbleSortRecursivo(n, v);
		long t2 = System.currentTimeMillis();
		ordena.imprimeComparacao("BubbleSortRecursivo", t1, t2);
	}
	
	private static void quickSort(Ordenacao ordena, int[] v, int a, int b) {
		long t1 = System.currentTimeMillis();
		ordena.quickSort(v, a, b);
		long t2 = System.currentTimeMillis();
		ordena.imprimeComparacao("QuickSort", t1, t2);
	}
	
	private static void mergeSort(Ordenacao ordena, int[] v, int a, int b) {
		long t1 = System.currentTimeMillis();
		ordena.mergeSort(v, a, b);
		long t2 = System.currentTimeMillis();
		ordena.imprimeComparacao("MergeSort", t1, t2);
	}
	
	
}
