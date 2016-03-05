package br.com.ahe.banco.tabela;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import br.com.ahe.banco.exception.ChavePKDuplicada;
import br.com.ahe.banco.exception.TamanhoDoRegistroException;
import br.com.ahe.banco.utils.ConsoleStringTable;

import com.google.common.base.Strings;

@EqualsAndHashCode(of = {"nome"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Tabela {

	@Getter
	@NonNull
	private String nome;

	private List<Coluna> colunas= new ArrayList<Coluna>();

	private List<Registro> registros = new ArrayList<Registro>();

	public void addColuna(Coluna coluna) {
		colunas.add(coluna);
	}

	public void addRegistro(Registro registro) throws TamanhoDoRegistroException, ChavePKDuplicada {
		if(colunas.size() == registro.size()) {
			if(!registros.contains(registro)) {
				for (int i = 0; i < colunas.size(); i++) {
					Coluna coluna = colunas.get(i);
					if(registro.get(i).length() > coluna.getTamanhoMaximo()) {
						registro.set(i, registro.get(i).substring(0, coluna.getTamanhoMaximo()));
					}
				}
				registros.add(registro);			
			} else {
				throw new ChavePKDuplicada(registro.getChave() , nome);
			}
		} else {
			throw new TamanhoDoRegistroException(nome , colunas.size() , registro.size());
		}
	}

	public Registro getRegistro(int index) {
		if(index > registros.size()) {
			throw new IllegalArgumentException("Indixe inválido");
		}
		return registros.get(index);
		
	}

	public int getQtdColunas() {
		return colunas.size();
	}
	
	@Override
	public String toString() {
		ConsoleStringTable cst = new ConsoleStringTable();
		for (int i = 0; i < colunas.size(); i++) {
			cst.addString(0, i, colunas.get(i).getNome());
			cst.addString(1, i, Strings.repeat("-", colunas.get(i).getNome().length()));
		}
		int i = 2; 
		for (Registro registro : registros) {
			for (int j = 0; j < registro.size(); j++) {
				cst.addString(i, j, registro.get(j));
			}
			i++;
		}
		
		return cst.getTableAsString();
	}


	public static class TabelaBuilder {

		private Tabela tabela;

		public TabelaBuilder(String nomeTabela) {
			tabela = new Tabela(nomeTabela);
		}


		public TabelaBuilder add(Coluna coluna) {
			tabela.addColuna(coluna);
			return this;
		}

		public Tabela build() {
			return tabela;
		}

	}



}



