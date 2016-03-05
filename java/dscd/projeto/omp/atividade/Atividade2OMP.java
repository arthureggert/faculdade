package br.com.ahe.dscd.projeto.omp.atividade;

import java.util.ArrayList;
import java.util.List;

import jomp.runtime.OMP;
import utils.AListUtils;
import utils.AStringUtils;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;

public class Atividade2OMP {

	public static void main(String[] args) {

		List<Molecula> moleculas = new ArrayList<>();
		int b = 0;
		OMP.setNumThreads(moleculas.size());

		//omp parallel
		{
			//omp for
			for(b = 0; b <= moleculas.size() ; b++) {
				Molecula molecula = moleculas.get(b);
				String nomeAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos()).getNome();
				while(AStringUtils.isTerminaEmVogal(nomeAtomo)){
					nomeAtomo = AStringUtils.removeLastCharFomString(nomeAtomo);
				}
				molecula.setNome(String.format("Acido %sidrico", nomeAtomo));
			}
		}	


	}

}
