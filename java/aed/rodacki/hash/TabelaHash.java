package br.com.ahe.aed.rodacki.hash;

public class TabelaHash {
	
	private Aluno[] tabela;

	public TabelaHash(int N) {
		this.tabela = new Aluno[N];
	}
	
    private int hash(int k) {
        return k % this.tabela.length;
    }
    
    private int hash2(int k){
    	return (this.tabela.length-2-k)%(this.tabela.length-2);
    }

    /** Metodo getAluno modelo 1  
  	public Aluno getAluno(int mat){
    	int h = hash(mat);
    	while(tabela[h] != null){
    		if(tabela[h].getMatricula() == mat){
    			return tabela[h];
    		}
    		h = (h+1) % tabela.length;
    	}
    	return null;
    } 
 	**/
    
    public Aluno getAluno(int mat){
    	int h = hash(mat);
    	int h2 = hash2(mat);
    	while(this.tabela[h] != null){
    		if(this.tabela[h].getMatricula() == mat){
    			return this.tabela[h];
    		}
    		h = (h+h2) % this.tabela.length;
    	}
    	return null;
    }
    
    	/** Metodo de Insercao Modelo 1
    	public Aluno setAluno(int mat, String nome, float media){
    	int h = hash(mat);
    	while(tabela[h] != null){
    		if(tabela[h].getMatricula() == mat){
    			break;
    		}
    		h = (h+1) % tabela.length;
    	}
    	
    		
    	if(tabela[h] == null){
    		tabela[h] = new Aluno();
    		tabela[h].setMatricula(mat);
    	}
    	tabela[h].setNome(nome);
    	tabela[h].setMediageral(media);
    	return tabela[h];	
    } 
    **/
    
    public Aluno setAluno(int mat, String nome, float media){
    	int h = hash(mat);
    	Aluno a = this.tabela[h];
    	while(a != null){
    		if(this.tabela[h].getMatricula() == mat){
    			
    		}
    		a = a.getProx();
    	}
    	if(a == null){
    		a = new Aluno();
    		a.setMatricula(mat);
    		a.setProx(this.tabela[h]);
    		this.tabela[h] = a;
    	}
    	this.tabela[h].setNome(nome);
    	this.tabela[h].setMediageral(media);
    	return this.tabela[h];	
    }
    
    public void remove(int mat){
    	int xAux = 0;
    	int h = hash(mat);
    	while(this.tabela[h] != null){
    		if(this.tabela[h].getMatricula() == mat){
    			Aluno a = this.tabela[h]; 
    			if(a.getProx() == null){
    				xAux = this.tabela[h].getMatricula();
    			} else {
    				while(a.getProx() != null){
        				this.tabela[h] = a.getProx();
        				a.setProx(a.getProx().getProx());
        			}
    			}
    			
    		}
    		h = (h+1) % this.tabela.length;
    		this.tabela[xAux] = null;
    	}
    	
    }

	@Override
	public String toString() {
    	String s = "";
    	for(int i = 1 ; i < this.tabela.length; i++){
    		Aluno a = this.tabela[i];
    		while(a != null){
   					s+= a+"\n";
   					a = a.getProx();
    			}
    		}
		return s;
	}

	public void ordena() {		
	}
    
    
    
    
	
}
