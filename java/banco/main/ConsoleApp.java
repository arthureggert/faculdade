package br.com.ahe.banco.main;

import static br.com.ahe.banco.tabela.Tabelas.TABELAS;

import java.io.IOException;

import br.com.ahe.banco.exception.ChavePKDuplicada;
import br.com.ahe.banco.exception.TabelaNaoEncontradaException;
import br.com.ahe.banco.exception.TamanhoDoRegistroException;
import br.com.ahe.banco.slot.Slot;
import br.com.ahe.banco.tabela.Tabela;

public class ConsoleApp {

	public static void main(String[] args) throws IOException, TamanhoDoRegistroException, ChavePKDuplicada, TabelaNaoEncontradaException {
//		Tabela estado = new Tabela.TabelaBuilder("Estado")
//						.add(new Coluna("codEstado", VARCHAR, 2, true))
//						.add(new Coluna("nomeEstado", VARCHAR, 50, false))
//						.add(new Coluna("nomePais", VARCHAR, 40, false))
//						.build();
//		
//		estado.addRegistro(new Registro("SC|SANTA CATARINA|BRASIL"));
//		estado.addRegistro(new Registro("PR|PARANA|BRASIL"));
//		estado.addRegistro(new Registro("NY|NEW YORK|EUA"));
		
//		
//		TABELAS.addTabela(estado);
//		TABELAS.salvaTabelas();
		
		TABELAS.carregaTabelas();
		Tabela estado = TABELAS.carregaTabela("Estado");
		Slot slot = Slot.criaSlot(10, null, estado, estado.getRegistro(0), 1);
		slot.getInformacoes();
	}
	
}
