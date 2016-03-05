package br.com.ahe.lf.endy;

import java.util.HashMap;

import javax.management.InvalidAttributeValueException;


public class AutomatoFinito {

	private String sequencia = "";

	public boolean leituraSimbolos(String simbolo)
			throws InvalidAttributeValueException {
		HashMap<Integer, HashMap<String, Integer[]>> tabela = geraTabela();
		Integer estado = 0;
		Integer isFinal = 0;
		for (int i = 0; i < simbolo.length(); i++) {
			HashMap<String, Integer[]> aux = tabela.get(estado);
			if (aux.get(String.valueOf(simbolo.charAt(i))) == null) {
				this.sequencia += " e(erro)";
				throw new InvalidAttributeValueException(simbolo);
			}
			this.sequencia += " e" + estado;
			estado = aux.get(String.valueOf(simbolo.charAt(i)))[0];
			isFinal = aux.get(String.valueOf(simbolo.charAt(i)))[1];
		}

		if (isFinal == 1) {
			this.sequencia += " e" + estado;
			return true;
		}
		this.sequencia += " e(erro)";
		return false;
	}

	private HashMap<Integer, HashMap<String, Integer[]>> geraTabela() {
		HashMap<String, Integer[]> aux1 = new HashMap<>();
		HashMap<Integer, HashMap<String, Integer[]>> aux2 = new HashMap<>();
		// estado E0
		aux1.put("A", new Integer[] { 1, 0 });
		aux1.put("B", new Integer[] { 2, 0 });
		aux1.put("C", new Integer[] { 7, 0 });
		aux2.put(0, aux1);
		aux1 = new HashMap<>();

		// estado E1
		aux1.put("A", new Integer[] { 3, 0 });
		aux1.put("B", new Integer[] { 4, 0 });
		aux1.put("C", new Integer[] { 14, 0 });
		aux2.put(1, aux1);
		aux1 = new HashMap<>();

		// estado E2
		aux1.put("A", new Integer[] { 5, 0 });
		aux1.put("B", new Integer[] { 4, 0 });
		aux1.put("C", new Integer[] { 14, 0 });
		aux2.put(2, aux1);
		aux1 = new HashMap<>();

		// estado E3
		aux1.put("A", new Integer[] { 13, 1 });
		aux1.put("B", new Integer[] { 6, 1 });
		aux1.put("C", new Integer[] { 7, 1 });
		aux2.put(3, aux1);
		aux1 = new HashMap<>();

		// estado E4
		aux1.put("A", new Integer[] { 5, 0 });
		aux1.put("B", new Integer[] { 2, 0 });
		aux1.put("C", new Integer[] { 7, 0 });
		aux2.put(4, aux1);
		aux1 = new HashMap<>();

		// estado E5
		aux1.put("A", new Integer[] { 9, 0 });
		aux1.put("B", new Integer[] { 10, 0 });
		aux1.put("C", new Integer[] { 14, 0 });
		aux2.put(5, aux1);
		aux1 = new HashMap<>();

		// estado E6
		aux1.put("A", new Integer[] { 9, 1 });
		aux1.put("B", new Integer[] { 11, 1 });
		aux1.put("C", new Integer[] { 14, 1 });
		aux2.put(6, aux1);
		aux1 = new HashMap<>();

		// estado E7
		aux1.put("A", new Integer[] { 14, 0 });
		aux1.put("B", new Integer[] { 14, 0 });
		aux1.put("C", new Integer[] { 7, 1 });
		aux2.put(7, aux1);
		aux1 = new HashMap<>();

		// estado E8
		aux1.put("A", new Integer[] { 9, 1 });
		aux1.put("B", new Integer[] { 11, 1 });
		aux1.put("C", new Integer[] { 14, 1 });
		aux2.put(8, aux1);
		aux1 = new HashMap<>();

		// estado E9
		aux1.put("A", new Integer[] { 9, 1 });
		aux1.put("B", new Integer[] { 12, 1 });
		aux1.put("C", new Integer[] { 14, 1 });
		aux2.put(9, aux1);
		aux1 = new HashMap<>();

		// estado E10
		aux1.put("A", new Integer[] { 5, 0 });
		aux1.put("B", new Integer[] { 10, 0 });
		aux1.put("C", new Integer[] { 14, 0 });
		aux2.put(10, aux1);
		aux1 = new HashMap<>();

		// estado E11
		aux1.put("A", new Integer[] { 9, 1 });
		aux1.put("B", new Integer[] { 8, 1 });
		aux1.put("C", new Integer[] { 7, 1 });
		aux2.put(11, aux1);
		aux1 = new HashMap<>();

		// estado E12
		aux1.put("A", new Integer[] { 9, 1 });
		aux1.put("B", new Integer[] { 12, 1 });
		aux1.put("C", new Integer[] { 14, 1 });
		aux2.put(12, aux1);
		aux1 = new HashMap<>();

		// estado E13
		aux1.put("A", new Integer[] { 3, 1 });
		aux1.put("B", new Integer[] { 11, 1 });
		aux1.put("C", new Integer[] { 14, 1 });
		aux2.put(13, aux1);
		aux1 = new HashMap<>();

		// estado E14
		aux1.put("A", new Integer[] { 14, 0 });
		aux1.put("B", new Integer[] { 14, 0 });
		aux1.put("C", new Integer[] { 14, 0 });
		aux2.put(14, aux1);

		return aux2;
	}

	public String getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}
}
