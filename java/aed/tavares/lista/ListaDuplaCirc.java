package br.com.ahe.aed.tavares.lista;

import br.com.ahe.aed.rodacki.listas.NoListaDupla;

/**
 * @author Arthur Henrique Eggert
 **/

public class ListaDuplaCirc {
	
	private NoListaDupla prim;
	
	public void insere(int v){
  		NoListaDupla novo = new NoListaDupla();
		novo.setInfo(v);
		if(this.prim == null){
			novo.setProx(novo);
			novo.setAnt(novo);
		} else {
			novo.setAnt(this.prim.getAnt());
			novo.setProx(this.prim);			
			this.prim.getAnt().setProx(novo);
			this.prim.setAnt(novo);
		}
	 	this.prim = novo;
	}

	public int lastIndexOf(int v){
		int indiceNo = 0;
		if(this.prim != null){
			for(NoListaDupla p = this.prim ; p.getProx() != this.prim; p = p.getProx()){
				if(p.getInfo() == v){
					return indiceNo;
				} else {
					indiceNo++;
				}
			}
		} 
		return -1;
	}
	
	public ListaDuplaCirc subList(int fromIndex, int toIndex){
		ListaDuplaCirc l2 = new ListaDuplaCirc();
		int auxIndice = 0;
		for(NoListaDupla p = this.prim ; p.getProx() != this.prim; p = p.getProx()){
			if(auxIndice == fromIndex){
				if(fromIndex <= toIndex){
					l2.insere(p.getInfo());
				}
				fromIndex++;
				auxIndice++;
			}
		}
		return l2;		
	}
	
	public void imprimeInvertido(){
		NoListaDupla p = this.prim.getAnt();
		String str = "";
		if(this.prim != null){
			do{
				str += p.getInfo() + " ";
				p = p.getAnt();
			} while(p != this.prim.getAnt());
			System.out.println(str);
		}		
	}
	
    public NoListaDupla pesquisaListaDupla(Integer info)
    {
        NoListaDupla p = this.prim;
        
        while (p != null){
            if(((Integer) p.getInfo()).intValue() == info.intValue()){
                return p;
            } else {
                p = p.getProx();
            }
        }
        return null;
    }
}
