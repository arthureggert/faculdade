package br.com.ahe.aed.outros;


@Deprecated
public class TabelaHash {

	private Aluno[] tabela;
	
	public TabelaHash(int n) {
		this.tabela = new Aluno[n];
	}
	
	private int hash(int k) {
		return k%this.tabela.length;
	}
	
	public Aluno get(int mat) {
		int h = hash(mat);
		Aluno a = this.tabela[h];
		while (a!=null) {
			if (a.getMatricula()==mat) {
				return a;
			}
			a = a.getProx();
		}		
		return null;
	}
	
	public void set(String nome, int matricula, float mediageral) {
		int h = hash(matricula);
		Aluno a = this.tabela[h];
		while (a!=null) {
			if (this.tabela[h].getMatricula()==matricula) {
				break;
			}
			a = a.getProx();
		}
		if (a==null) {
			a = new Aluno();
			a.setMatricula(matricula);
			a.setProx(this.tabela[h]);
			this.tabela[h] = a;
		}
		this.tabela[h].setNome(nome);
		this.tabela[h].setMediageral(mediageral);
	}
	
	public void remove(int mat) {
		int h = hash(mat);
		Aluno aluno = this.tabela[h];
		if (aluno.getMatricula()==mat) {
			this.tabela[h] = null;
		} else {
			Aluno anterior = aluno;
			aluno = aluno.getProx();
			while (aluno!=null) {
				if (aluno.getMatricula()==mat) {
					anterior.setProx(aluno.getProx());
					return;
				} else {
					anterior = aluno;
					aluno = aluno.getProx();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Aluno aluno : this.tabela) {
			if (aluno!=null) {
				str += "\n" + aluno;
				Aluno p = aluno.getProx();
				while (p!=null) {
					str += "\n" + p;
					p = aluno.getProx();
				}
			}
		}
		return str;
				
	}
	
}
