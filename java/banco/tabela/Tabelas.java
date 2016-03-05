package br.com.ahe.banco.tabela;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import br.com.ahe.banco.exception.TabelaNaoEncontradaException;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@NoArgsConstructor
public enum Tabelas {

	TABELAS;
	
	private List<Tabela> tabelas = new ArrayList<Tabela>();
	
	public List<Tabela> get() {
		return tabelas;
	}
	
	public void carregaTabelas() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("/home/aheggert/tabelas.json"));
		String json = new String(encoded, Charset.defaultCharset());
		tabelas = new GsonBuilder().setPrettyPrinting().create().fromJson(json, new TypeToken<List<Tabela>>(){}.getType());
	}
	
	public void salvaTabelas() throws IOException {
		Files.deleteIfExists(Paths.get("/home/aheggert/tabelas.json"));
		String fileContent = new GsonBuilder().setPrettyPrinting().create().toJson(tabelas);
		Files.write(Paths.get("/home/aheggert/tabelas.json"), fileContent.getBytes(), StandardOpenOption.CREATE_NEW);
	}
	
	public Tabela carregaTabela(String nome) throws TabelaNaoEncontradaException {
		for (Tabela tabela : tabelas) {
			if(tabela.getNome().equals(nome)) {
				return tabela;
			}
		}
		throw new TabelaNaoEncontradaException(nome);
	}
	
	public void addTabela(Tabela tabela) {
		if(!tabelas.contains(tabela)) {
			tabelas.add(tabela);
		} else {
			tabelas.remove(tabela);
			tabelas.add(tabela);
		}
	}
	
}
