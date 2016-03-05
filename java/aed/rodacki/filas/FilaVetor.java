package br.com.ahe.aed.rodacki.filas;


/**
 * @author Arthur Henrique Eggert
 **/

public class FilaVetor implements Fila {
    
    // Quantidade de valores armazenados
    private int qtdValoresArmazenados; 
       
    // Posi��o do prox elemento a ser retirado, ou seja o inicio da fila
    private int inicioFila;
    
    // Tamanho do vetor
    private int tamanhoVetorFila;
    
    // Vetor que armazena elementos
    private int vetorFila[];

    public FilaVetor(int tamanhoFila) {
        this.tamanhoVetorFila = tamanhoFila;
        this.vetorFila = new int[this.tamanhoVetorFila];
        this.inicioFila  = 0;
        this.qtdValoresArmazenados = 0; 
    }
    
    private int calculaFimLista() {
    	return (this.inicioFila+this.qtdValoresArmazenados)%this.tamanhoVetorFila;
    }
    
    public void insere(int valorInserir) throws Exception {
    	int fimFila = 0;
	
    	if(cheia()){
    		throw new Exception("ERRO: Tamanho da fila foi ultrapassado");	    
    	} else {
    		fimFila = calculaFimLista();
    		this.vetorFila[fimFila] = valorInserir;
    		this.qtdValoresArmazenados++;
    	}
    }
    
    private void insereIndice(int valorInserir, int possicao) throws Exception {

    	if(cheia()){
    		throw new Exception("ERRO: Tamanho da fila foi ultrapassado");	    
    	} else {
    		this.vetorFila[possicao] = valorInserir;
    		this.qtdValoresArmazenados++;
    	}
    }

    public int retira() throws Exception {
        int ret = 0;
        if(vazia()){
            throw new Exception("ERRO: Fila esta vazia");
        } else {
            ret = this.vetorFila[this.inicioFila];
            this.vetorFila[this.inicioFila] = 0;
            this.inicioFila++;
            this.qtdValoresArmazenados--;
        }
        return ret;
    }
    
    public boolean cheia() {
        if (this.qtdValoresArmazenados == this.tamanhoVetorFila) {
            return true;
        }
        return false;
    }

    public boolean vazia() throws Exception {
        if (this.vetorFila[this.inicioFila] == 0) {
            return true;
        }
        return false;
    }

    public void libera() {
        this.vetorFila = new int[this.tamanhoVetorFila];
    }

    @Override
    public String toString(){    
        String str = "";                    
        if(this.qtdValoresArmazenados > 0){
            int p = this.inicioFila;
            int fim = (this.inicioFila + this.qtdValoresArmazenados)%this.tamanhoVetorFila;            
            do{
                str += this.vetorFila[p]+" ";            
                p = (p+1)%this.tamanhoVetorFila;
            }while( p != fim);
        }        
        return str;
    }

    
    public int getTam() {
        return this.tamanhoVetorFila;
    }
    
    public FilaVetor concatena(FilaVetor f2) throws Exception{
        FilaVetor f3 = new FilaVetor(this.getTam() + f2.getTam());

        for (int possicaoVetor : this.vetorFila) {
        		if(possicaoVetor != 0){
        			f3.insere(possicaoVetor);
        		} else {
        			break;
        		}
        }		

        for (int possicaoVetor : f2.vetorFila) {
        		if(possicaoVetor != 0){
        			f3.insere(possicaoVetor);
        		} else {
        			break;
        		}
        }	
        return f3;
    }
    
    public FilaVetor merge(FilaVetor f2) throws Exception{
    	FilaVetor f3 = new FilaVetor(f2.getTam() + getTam());
    	int mergeAux = 0;
        
    	for (int possicaoVetor : this.vetorFila) {
    		if(possicaoVetor != 0){
    			f3.insereIndice(possicaoVetor,mergeAux);
    			mergeAux += 2;
    		} else {
    			break;
    		}
    	}	
        
    	mergeAux = 1;
    	for (int possicaoVetor : f2.vetorFila) {
    		if(possicaoVetor != 0){
    			f3.insereIndice(possicaoVetor,mergeAux);
    			mergeAux += 2;
    		} else {
    			break;
    		}
    	}	
    	       
        return f3;
    }
    
    public String imprimePares() throws Exception {
        String st = "Pares da fila em ordem de retirada>>>";
        int ult = calculaFimLista();
        int soma=0;
        if (!vazia()) {
            int i = this.inicioFila;
            if (this.vetorFila[i] % 2 == 0) {
                st += this.vetorFila[i] + " ";
                soma+=this.vetorFila[i];
            }
            
            i++;
            while (i != ult) {
                if (this.vetorFila[i] % 2 == 0) {
                    st += this.vetorFila[i] + " ";
                    soma+=this.vetorFila[i];
                }
                i++;
                if (i == this.tamanhoVetorFila) {
                    i = 0;
                }
            }
        } else {
            throw new Exception("ERRO: Fila esta vazia");
        }
        return st+"\n Soma dos numeros pares: "+soma;
    }
}
