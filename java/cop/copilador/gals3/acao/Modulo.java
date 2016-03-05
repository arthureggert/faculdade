package br.com.ahe.cop.copilador.gals3.acao;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import br.com.ahe.cop.copilador.gals2.Token;
import br.com.ahe.cop.utils.Utils;

public class Modulo {

	private String identificador;
	private boolean main = false;
	private StringBuilder codigoFonte = new StringBuilder();
	private String operador = "";
	private Stack<String> tipos = new Stack<String>();
	private Stack<String> labels = new Stack<String>();
	private LinkedList<Token> identificadores = new LinkedList<Token>();
	private Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	private List<String> parametros = new LinkedList<String>();
	private String tipoExp = "";

	public Modulo(String identificador) {
		this.identificador = identificador;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public boolean isMain(){
		return this.main;
	}

	public void limpar() {
		this.operador = "";
		this.tipos.clear();
		this.labels.clear();
		this.codigoFonte = new StringBuilder();
		this.identificadores.clear();
		this.simbolos.clear();
	}

	public void addCode(String ... code){
		for (int i = 0; i < code.length; i++) {
			this.codigoFonte.append(code[i] + Utils.EOL);
		}
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public LinkedList<Token> getIdentificadores() {
		return this.identificadores;
	}

	public boolean containsSymbol(String symbol){
		return this.simbolos.containsKey(symbol);
	}

	public void addSymbol(Token token) {
		this.simbolos.put(token.getLexeme(), new Simbolo(token.getLexeme(), token.getMsilType()));
	}

	public void addIdentifier(Token token){
		this.identificadores.add(token);
	}

	public String getCode() {
		return this.codigoFonte.toString();
	}

	public void clearIdentifiers(){
		this.identificadores.clear();
	}

	public void typeStackPush(String msilType) {
		this.tipos.push(msilType);
	}

	public String typeStatckPop() {
		return this.tipos.pop();
	}

	public Token getFirstId() {
		return this.identificadores.poll();
	}

	public Token getLastId() {
		return this.identificadores.pollLast();
	}

	public void addOperador(Token token) {
		this.operador = token.getLexeme();	
	}

	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Simbolo getSymbol(String lexeme) {
		return this.simbolos.get(lexeme);
	}

	public void addLabel(String label) {
		this.labels.push(label);
	}

	public String removeLastLabel() {
		return this.labels.pop();
	}

	public int getLabelsSize(){
		return this.labels.size();
	}

	public void addParameter(Token t) {
		this.parametros.add(t.getLexeme());
	}

	public void setTipoExp(String tipo) {
		this.tipoExp   = tipo;
	}

	public String getTipoExp() {
		return this.tipoExp;
	}

	public boolean containsParameter(Token token) {
		return this.parametros.contains(token.getLexeme());
	}
}
