package br.com.ahe.aed.tavares.classificacao;

public class BubbleSort {
	
	public int[] bolha(int[] T, int n) { 
		boolean troca; 
		int i, temp; 
		do { 
			troca = false; 
			for (i=0; i < n-1; i++)	{ 
				if(T[i] > T[i+1]) { 
					temp = T[i]; 
					T[i] = T[i+1]; 
					T[i+1] = temp; 
					troca = true; 
				} 
			} 
		} while (troca == true);
		return T;
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] temp = new int[10];
		temp[0] = 9;
		temp[1] = 42;
		temp[2] = 3;
		temp[3] = 56;
		temp[4] = 89;
		temp[5] = 8;
		temp[6] = 1;
		temp[7] = 52;
		temp[8] = 13;
		temp[9] = 0;
		System.out.println("Antes do BubbleSort");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
		temp = bs.bolha(temp, temp.length);
		
		System.out.println("Depois do BubbleSort");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
	}
}
