package br.com.ahe.aed.tavares.classificacao;

public class MetodoInsercao {
		
	public int[] insercao(int[] T, int n)	{ 
		int i, j, temp; 
		boolean posicao; 
		for (i = 1; i < n; i++) { 
			j = i; 
			temp = T[j]; 
			posicao = false; 
			do { 
				if( temp < T[j-1] ){ 
					T[j] = T[j-1]; 
					j = j-1; 
					if ( j== 0 )
						posicao = true;  
				} else { 
					posicao = true;
				} 
			} while (posicao == true); 
			T[j] = temp; 
		}
		return T;
	} 
	
	public static void main(String[] args) {
		MetodoInsercao mi = new MetodoInsercao();
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
		
		temp = mi.insercao(temp, temp.length);
		
		System.out.println("Depois do BubbleSort");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}

}
