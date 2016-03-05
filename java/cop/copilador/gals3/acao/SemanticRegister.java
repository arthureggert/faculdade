package br.com.ahe.cop.copilador.gals3.acao;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import br.com.ahe.cop.copilador.gals2.Token;
import br.com.ahe.cop.utils.Utils;


public class SemanticRegister {
	private String arquivo = "";
	private StringBuilder codigo = new StringBuilder();
	private LinkedList<String> escopos = new LinkedList<String>();
	private Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	private Map<String, Modulo> modulos = new LinkedHashMap<String, Modulo>();

	public SemanticRegister(String fileName) {
		this.arquivo = fileName;
		this.codigo = new StringBuilder();
		this.escopos = new LinkedList<String>();
		this.simbolos = new LinkedHashMap<String, Simbolo>();
		this.modulos = new LinkedHashMap<String, Modulo>();
	}

	public String getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getCode() {
		return this.codigo.toString();
	}

	public LinkedList<String> getEscopos() {
		return this.escopos;
	}

	public Map<String, Simbolo> getSimbolos() {
		return this.simbolos;
	}

	public Map<String, Modulo> getModulos() {
		return this.modulos;
	}

	public Modulo getLastModule() {
		return this.modulos.get(this.escopos.getLast());
	}
	
	public void removeLastModule(){
		this.escopos.removeLast();
	}

	public void addEscopo(Modulo modulo) {
		this.escopos.add(modulo.getIdentificador());
	}

	public void addModule(Modulo module) {
		this.modulos.put(module.getIdentificador(), module);
	}

	public void addCode(String ... code) {
		for (int i = 0; i < code.length; i++) {
			this.codigo.append(code[i] + Utils.EOL);
		}
	}

	public boolean containsSymbol(String lexeme) {
		return this.simbolos.containsKey(lexeme);
	}

	public void addSymbol(Token token) {
		this.simbolos.put(token.getLexeme(), new Simbolo(token.getLexeme(), token.getMsilType()));
	}

	public Modulo getModule(String key) {
		return this.modulos.get(key);
	}
}
