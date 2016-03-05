package br.com.ahe.aed.rodacki.provas;


public class Prova2 {
/**	
	
	// Exercicio 1	
    public String imprimePares() throws Exception {
        String st = "";
        int ult = calculaFimLista();
        int soma=0;
        if (!vazia()) {
            int i = inicioFila;
            if (vetorFila[i] % 2 == 0) {
                st += vetorFila[i] + " ";
                soma+=vetorFila[i];
            }
            
            i++;
            while (i != ult) {
                if (vetorFila[i] % 2 == 0) {
                    st += vetorFila[i] + " ";
                    soma+=vetorFila[i];
                }
                i++;
                if (i == tamanhoVetorFila) {
                    i = 0;
                }
            }
        } else {
            throw new Exception("ERRO: Fila esta vazia");
        }
        return st + " " + soma;
    }
    
//    Exercicio Dois
    public int maxV(){
    	return maxV(this.raiz);
    }
    
    private int maxV(NoArvoreBinaria raiz){
    	int maior = raiz.getInfo();
    	NoArvoreBinaria dir = raiz.getDir();
    	NoArvoreBinaria esq = raiz.getEsq();
    	
    	if(raiz.getDir() == null && raiz.getEsq() == null){
    		return maior;
    	}
    	
    	if(raiz.getDir() != null && raiz.getEsq() != null){
    		
    		int maxDir = maxV(dir);
        	int maxEsq = maxV(esq);
        	
        	if(maxDir > maior){
        		maior = maxDir;
        	}
        	if(maxEsq > maior){
        		maior = maxEsq;
        	}
    	} 
    	
    	if (raiz.getDir() == null){
        	int maxEsq = maxV(esq);
        	
        	if(maxEsq > maior){
        		maior = maxEsq;
        	}
    	}
    	
    	if (raiz.getEsq() == null){
        	int maxDir = maxV(dir);
        	
        	if(maxDir > maior){
        		maior = maxDir;
        	}
    	}
    	
    	return maior;
    }
    
//    Exercicio 3
    public int somaInfoInternos() {
        return somaInfoInternos(raiz);
    }

    private int somaInfoInternos(NoArvore no) {
        int v = 0;
        if(no.getProx() !=null){
            v += no.getInfo();
        }
        NoArvore p = no.getPrim();
        while (p != null) {
           v+=somaInfoInternos(p);
            p = p.getProx();
        }
        return v;
    }
    */
}
