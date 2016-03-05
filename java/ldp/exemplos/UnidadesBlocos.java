package br.com.ahe.ldp.exemplos;

public class UnidadesBlocos {

	private String testeUm;
	
	public void teste(){
		String testeUm = null;
		this.setTesteUm(testeUm);
		{
			int testeDois = 0;
			System.out.println(testeDois);;
		}
	
	}

	public String getTesteUm() {
		return this.testeUm;
	}

	public void setTesteUm(String testeUm) {
		this.testeUm = testeUm;
	}
}
