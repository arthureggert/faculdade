package br.com.ahe.poo.dois.prova.grupo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Grupo implements Comparable<Grupo>{

	private String nomeGrupo;
	private List<Integrante> integrantes = new ArrayList<Integrante>();
	
	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	public Grupo(String nomeGrupo) {
		super();
		this.nomeGrupo = nomeGrupo;
	}
	
	public void addIntegrante(Integrante i){
		this.integrantes.add(i);
		JOptionPane.showMessageDialog(null, "Integrante "+i.getNome()+" adicionado com sucesso");
	}
	
	public void removeIntegrante(Integrante i){
		this.integrantes.remove(i);
		JOptionPane.showMessageDialog(null, "Integrante "+i.getNome()+" removido com sucesso");
	}

	@Override
	public String toString() {
		String saida = "Grupo: " + this.nomeGrupo+"\n";
		for(Integrante i : this.integrantes){
			saida += i.toString()+"\n";
		}
		return saida ;
	}
	
	public void imprimeIntegrantesOrdemAlfabetica(){
		Comparator<Integrante> ComparadorNome = new ComparadorIntegranteNome();
		Collections.sort(this.integrantes, ComparadorNome);
	}
	
	public void imprimeIntegrantesIdade(){
		Collections.sort(this.integrantes);
	}

	@Override
	public int compareTo(Grupo o) {
        if (getNomeGrupo().equalsIgnoreCase(o.getNomeGrupo())) {
            return -1;
        }    
        return 0;
	}	
	
	
	
	
	
}
