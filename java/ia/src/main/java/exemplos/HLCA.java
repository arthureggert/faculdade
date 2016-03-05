package exemplos;

import java.util.LinkedList;
import java.util.List;

import busca.Estado;

/**
 * Homem, Lobo Carneiro e Alface
 * 
 * @author aheggert
 *
 */
public class HLCA implements Estado {

	final char homem, lobo, carneiro, alface;

	final String operacao;
	
	public HLCA(char homem, char lobo, char carneiro, char alface, String operacao) {
		this.homem = homem;
		this.lobo = lobo;
		this.carneiro = carneiro;
		this.alface = alface;
		this.operacao = operacao;
	}

	@Override
	public int custo() {
		return 1;
	}

	@Override
	public boolean ehMeta() {
		return homem == 'd' && lobo == 'd' && alface == 'd' && carneiro == 'd';
	}

	@Override
	public List<Estado> sucessores() {
		List<Estado> estadosSucessores = new LinkedList<Estado>();
		
		levarNada(estadosSucessores);
		levarLobo(estadosSucessores);
		levarCarneiro(estadosSucessores);
		levarAlface(estadosSucessores);
		
		return estadosSucessores;
	}
	
	private boolean ehValido() {
		// lobo e carneiro na mesma margem sem o homem
		if (lobo == carneiro && lobo != homem) {
			return false;
		} 
		// carneiro e alfase na mesma margem sem o homem
		if (carneiro == alface && carneiro != homem) {
			return false;
		}
		return true;
	}

	private void levarNada(List<Estado> suc) {
		char novaMargem = ladoOposto(homem);
		HLCA novo = new HLCA(novaMargem, lobo, carneiro, alface, "levarNada-" + homem + novaMargem);

		if (novo.ehValido()) {
			suc.add(novo);
		}

	}

	private void levarAlface(List<Estado> suc) {
		if (alface == homem) {
			char novaMargem = ladoOposto(homem);
			HLCA novo = new HLCA(novaMargem, lobo, carneiro, novaMargem, "levarAlface-" + alface + novaMargem);

			if (novo.ehValido()) {
				suc.add(novo);
			}
		}		
	}

	private void levarLobo(List<Estado> suc) {
		if (lobo == homem) {
			char novaMargem = ladoOposto(homem);
			HLCA novo = new HLCA(novaMargem, novaMargem, carneiro, alface, "levarLobo-" + lobo + novaMargem);

			if (novo.ehValido()) {
				suc.add(novo);
			}
		}
	}

	private void levarCarneiro(List<Estado> suc) {
		if (carneiro == homem) {
			char novaMargem = ladoOposto(homem);
			HLCA novo = new HLCA(novaMargem, lobo, novaMargem, alface, "levar Carneiro-" + carneiro + novaMargem);

			if (novo.ehValido()) {
				suc.add(novo);
			}
		}
	}

	private char ladoOposto(char l) {
		if (l == 'e') {
			return 'd';
		} else {
			return 'e';
		}
	}

	public boolean equals(Object o) {
		if (o instanceof HLCA) {
			HLCA e = (HLCA) o;
			return e.homem == this.homem && e.lobo == this.lobo && e.carneiro == this.carneiro && e.alface == this.alface;
		}
		return false;
	}

	/** 
	 * retorna o hashCode desse estado
	 * (usado para poda, conjunto de fechados)
	 */
	public int hashCode() {
		return (""+homem + lobo + carneiro + alface).hashCode();
	}

	public String toString() {
		String dir = ""; // quem esta na dir
		String esq = ""; // quem esta na esq
		if (homem == 'd') {
			dir += 'h';
		} else {
			esq += 'h';
		}
		if (lobo == 'd') {
			dir += 'l';
		} else {
			esq += 'l';
		}
		if (carneiro == 'd') {
			dir += 'c';
		} else {
			esq += 'c';
		}
		if (alface == 'd') {
			dir += 'a';
		} else {
			esq += 'a';
		}
		return esq +"--" + dir + " (" + operacao + ")\n";
	}
}
	
	

