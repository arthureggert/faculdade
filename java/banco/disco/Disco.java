package br.com.ahe.banco.disco;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import lombok.NoArgsConstructor;
import br.com.ahe.banco.exception.PaginaNaoEncontradaException;
import br.com.ahe.banco.pagina.Pagina;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@NoArgsConstructor
public enum Disco {

	DISCO;
	
	private List<Pagina> paginas;
	
	public void carregaPaginas() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("/home/aheggert/banco.json"));
		String json = new String(encoded, Charset.defaultCharset());
		paginas = new GsonBuilder().setPrettyPrinting().create().fromJson(json, new TypeToken<List<Pagina>>(){}.getType());
	}
	
	public Pagina carregaPagina(int id) throws PaginaNaoEncontradaException {
		for (Pagina pagina : paginas) {
			if(pagina.getId() == id) {
				return pagina;
			}
		}
		throw new PaginaNaoEncontradaException();
	}
	
	public void salvaPagina(Pagina pagina) {
		paginas.remove(pagina);
		paginas.add(pagina);
	}
	
	public void salvaPaginas() throws IOException {
		String fileContent = new GsonBuilder().setPrettyPrinting().create().toJson(paginas);
		Files.write(Paths.get("/home/aheggert/banco.json"), fileContent.getBytes(), StandardOpenOption.CREATE_NEW);
	}
	
	
	
	
	
}
