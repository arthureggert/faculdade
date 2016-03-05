package br.com.ahe.aed.rodacki.provas;

public class TabelaHash {
	/**
	private Aluno[] tabela;

	public TabelaHash(int N) {
		tabela = new Aluno[N];
	}
	

    public float mediaGeral() {
        float soma = 0;
        int qua = 0;
        for (int i = 0; i < tabela.length; i++) {
            Aluno temp = tabela[i];
            if (temp != null) {
                qua++;
                soma += temp.getMediageral();
            }
            temp = null;
        }
        return (soma / qua);
    }
    
    public void reAloca(int tam){
        Aluno alunos[] = new Aluno[tam];
        for(int i=0; i<tabela.length; i++){
            Aluno temp = tabela[i];
            if(temp != null){
                alunos[hash(temp.getMatricula())+1]=temp;
            }
        }
        tabela=alunos;
    }
    
	public Aluno[] ordena(){
		return bubbleSortRecursivo(tabela.length, tabela);
	}
	
	private Aluno[] bubbleSortRecursivo(int n, Aluno[] aluno){
		int j,j2 = 0;
		boolean troca = false;
		
		for(j = 0; j <= n-1; j++){
			if(aluno[j] != null){
				j2 = j+1;
				while(getAluno(j2) == null && j2 < n-1){
					j2++;
				}
				if(aluno[j2] != null){
					if(aluno[j].getMediageral() > aluno[j2].getMediageral()){
						Aluno temp = aluno[j];
						aluno[j] = aluno[j2];
						aluno[j2] = temp;
						troca = true;
					}	
				}
			}
	
		}
			

		if(troca){
			bubbleSortRecursivo(n-1, aluno);
		}
		return aluno;
	}
	*/
}
