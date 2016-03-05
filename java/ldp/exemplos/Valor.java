package br.com.ahe.ldp.exemplos;

public class Valor {  
	int val = 0;
	
	public Valor() {
	}
	void add(int qdt) {   
		for (int i=0; i<qdt; i++) {    
			int temp = this.val;    
			//System.out.println(temp);    
			this.val = temp + 1;   
		}  
	} 

	int get(){ 
		return this.val; 
	} 
}  
