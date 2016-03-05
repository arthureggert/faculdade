package br.com.ahe.aed.outros;



public class TabelaHashPostada {

	private Aluno[] tabela;
	
	public float menorMediaGeral(){
		float menorMedia = 9999;
		for (Aluno aluno : this.tabela) {
			if (aluno!=null) {
				if (aluno.getMediageral() < menorMedia) {
					menorMedia = aluno.getMediageral(); 
				}
				Aluno p = aluno.getProx();
				while (p!=null) {
					if (p.getMediageral() < menorMedia) {
						menorMedia = p.getMediageral(); 
					}
					p = aluno.getProx();
				}
			}
		}
		if (menorMedia==9999) {
			menorMedia = 0f;
		}
		return menorMedia;
	}
	
	public void reAloca(int tamanho) {
		
		Aluno[] novaTabela = new Aluno[tamanho];
		
		for (Aluno aluno : this.tabela) {
			if (aluno!=null) {
				int hAloca = hashAloca(aluno.getMatricula(), novaTabela.length); 
				setAloca(aluno, hAloca, novaTabela);
				Aluno prox = aluno.getProx();
				while (prox!=null) {
					hAloca = hashAloca(prox.getMatricula(), novaTabela.length); 
					setAloca(prox, hAloca, novaTabela);
					prox = prox.getProx();
				}
			}
		}
		
		this.tabela = novaTabela;
	}
	
	private int hashAloca(int k, int tamanho) {
		return k%tamanho;
	}
	
	private void setAloca(Aluno aluno, int hash, Aluno[] novaTabela) {
		int h = hash;
		Aluno a = novaTabela[h];
		while (a!=null) {
			if (novaTabela[h].getMatricula()==aluno.getMatricula()) {
				break;
			}
			a = a.getProx();
		}
		if (a==null) {
			a = new Aluno();
			a.setMatricula(aluno.getMatricula());
			a.setProx(novaTabela[h]);
			novaTabela[h] = a;
		}
		novaTabela[h].setNome(aluno.getNome());
		novaTabela[h].setMediageral(aluno.getMediageral());
	}
	
	public Aluno[] ordena(){
		int tam = 0;
		for (Aluno aluno : this.tabela) {
			if (aluno!=null) {
				tam++;
				Aluno prox = aluno.getProx();
				while (prox!=null) {
					tam++;
					prox = prox.getProx();
				}
			}
		}
		Aluno[] v = new Aluno[tam];
		int pos = 0;
		for (Aluno aluno : this.tabela) {
			if (aluno!=null) {
				v[pos++] = aluno;
				Aluno prox = aluno.getProx();
				while (prox!=null) {
					v[pos++] = prox;
					prox = prox.getProx();
				}
			}
		}
		
		bubbleSortOtimizado(v);
		return v;
	}
	
	private void bubbleSortOtimizado(Aluno[] v) {
		int n = v.length;
		for (int i = n - 1; i > 1; i--) {
			boolean troca = false;
			for (int j = 0; j < i; j++) {
				if (v[j].getMediageral() > v[j+1].getMediageral()) {
					Aluno temp = v[j];
					v[j] = v[j+1];
					v[j+1] = temp;
					troca = true;
				}
			}
			if (!troca) {
				return;
			}
		}
	}
}
