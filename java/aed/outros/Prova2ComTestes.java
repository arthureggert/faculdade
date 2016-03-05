package br.com.ahe.aed.outros;


public class Prova2ComTestes {
	
//	public void imprimeImpares() {
//		String strImpares = "";
//		int totalInpares = 0;
//		if(this.n > 0){
//			int p = this.ini;
//			int fim = (this.ini + this.n)%this.tam;			
//			do{
//				int numero = vet[p];
//				if (numero%2!=0) {
//					strImpares += numero+" ";
//					totalInpares += numero; 
//				}
//				p = (p+1)%this.tam;
//			}while( p != fim);
//		}		
//		System.out.println(strImpares + "" + totalInpares);
//	}
	
//	public int somaInfoFolhas() {
//		return somaInfoFolhas(this.raiz);
//	}
//
//	private int somaInfoFolhas(NoArvoreBinaria no) {
//		int totFls = 0;
//		if ((no!=null) ) {
//			if ( (no!=raiz) && (no.getEsq()==null && no.getDir()==null)) {
//				totFls += no.getInfo();				
//			}		
//			totFls += somaInfoFolhas(no.getEsq());
//			totFls += somaInfoFolhas(no.getDir());
//		}
//		return totFls;
//	}	
	
//	public int minV(){		
//		return minV(this.raiz);
//	}
//
//	private int minV(NoArvore no) {
//		int menor = no.getInfo(); 
//		NoArvore p = no.getPrim();
//		while (p != null) {
//			int m = minV(p);
//			if (m < menor) {
//				menor = m;
//			}
//			p = p.getProx();
//		}
//		return menor;
//	}
	
	public static void main(String[] args) throws Exception {
		FilaVetor fv = new FilaVetor(10);
		fv.insere(1);
		fv.insere(2);
		fv.insere(3);
		fv.insere(4);
		fv.insere(5);
		fv.insere(6);
		fv.insere(7);
		fv.insere(8);
		fv.insere(9);
		fv.insere(10);
		
		fv.imprimeImpares();
		System.out.println( (1+3+5+7+9) );
		
		ArvoreBinaria ab = new ArvoreBinaria();
		ab.insere(1);
//		ab.insere(1, 
//				ab.insere(2,
//						null,
//						ab.insere(4)),
//				ab.insere(3,
//						 ab.insere(5),
//						 ab.insere(6)
//						)
//				);
		System.out.println(ab.somaInfoFolhas());
		System.out.println(( 4+5+6 ));
		
		Arvore arv = new Arvore();
		NoArvore n1 = arv.criaNo(30);
		NoArvore n2 = arv.criaNo(20);
		NoArvore n3 = arv.criaNo(30);
		NoArvore n4 = arv.criaNo(40);
		NoArvore n5 = arv.criaNo(50);
		NoArvore n6 = arv.criaNo(60);
		NoArvore n7 = arv.criaNo(70);
		NoArvore n8 = arv.criaNo(80);
		NoArvore n9 = arv.criaNo(90);
		NoArvore n10 = arv.criaNo(100);
		arv.insereFilho(n3, n4);
		arv.insereFilho(n2, n5);
		arv.insereFilho(n2, n3);
		arv.insereFilho(n9, n10);
		arv.insereFilho(n7, n9);
		arv.insereFilho(n7, n8);
		arv.insereFilho(n1, n7);
		arv.insereFilho(n1, n6);
		arv.insereFilho(n1, n2);
		
		System.out.println("Menor: " + arv.minV());
		
	}
	
}
