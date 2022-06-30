package dscd.projeto.omp.atividade;

import java.util.ArrayList;
import java.util.List;

import core.utils.AListUtils;
import core.utils.AStringUtils;
import dscd.projeto.thread.quimica.molecula.Molecula;

public class AtividadeOMP {

	public static void main(String[] args) {
	
		 List<Molecula> moleculas = new ArrayList<>();
		 Molecula molecula = AListUtils.getRandomElementFromList(moleculas);
		 int b = 0;
		 
		//omp parallel private(molecula,i) reduction(+:b)
		{
			String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
			while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
				nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
			}
			molecula.setNome(String.format("Acido %sico", nomeAtomo));
		}	
		System.out.println(String.format("Qtd de moleculas nomeadas é de %d", b));
		
	}

}
