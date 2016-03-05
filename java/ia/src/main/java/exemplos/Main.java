package exemplos;

import java.util.Objects;

import busca.BuscaLargura;
import busca.Nodo;

public class Main {

	public static void main(String[] args) {
		
		HLCA problema = new HLCA('e', 'e', 'e', 'e', "inicial");
		
		
		BuscaLargura buscaEmLargura = new BuscaLargura();
		
		Nodo nodo = buscaEmLargura.busca(problema);
		
		if(Objects.isNull(nodo)) {
			System.out.println("Prolema sem Solução");
		} else {
			System.out.println("Solução\n:" + nodo.montaCaminho());
		}
	}
	
}
