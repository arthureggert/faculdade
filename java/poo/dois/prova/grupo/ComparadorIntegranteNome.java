package br.com.ahe.poo.dois.prova.grupo;

import java.util.Comparator;

public class ComparadorIntegranteNome implements Comparator<Integrante> {

	@Override
	public int compare(Integrante o1, Integrante o2) {
		return o1.getNome().compareTo(o2.getNome()); 
	}

}
