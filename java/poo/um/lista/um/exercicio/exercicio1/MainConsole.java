package br.com.ahe.poo.um.lista.um.exercicio.exercicio1;

import java.math.BigDecimal;

public class MainConsole {

	public static void main(String[] args) {
		Pessoa pess = null;
		try {
			pess = new Pessoa("Arthur", "00000000000", new BigDecimal(5000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ImpostoRenda ir = new ImpostoRenda();
		
		System.out.println(ir.calculaImposto(pess));
	}
}
