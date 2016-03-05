package br.com.ahe.cg.n3;

import static br.com.ahe.cg.n3.Globais.GLOBAL;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GLAutoDrawable;

public abstract class ObjetoGrafico {

	protected Color cor = Color.BLACK;

	protected int primitivaGrafica = GLOBAL.getPrimitivaGrafica();
	
	protected List<Ponto> pontos = new ArrayList<Ponto>();
	
	protected List<ObjetoGrafico> filhos = new ArrayList<ObjetoGrafico>();
	
	public abstract void desenha(GLAutoDrawable glDrawable);
	
	public abstract void trocaCor();

	public void addPonto(Ponto ponto) {
		pontos.add(ponto);
	}
	
	public Ponto getUltimoPonto() {
		return pontos.get(pontos.size() - 1);
	}
	
	public void setUltimoPonto(Ponto ponto) {
		pontos.set(pontos.size() - 1, ponto);
	}
	
}
