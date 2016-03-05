package br.com.ahe.cg.n3;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;


public class Poligono extends ObjetoGrafico {

	@Override
	public void desenha(GLAutoDrawable glDrawable) {
		GL2 gl = glDrawable.getGL().getGL2();
		gl.glPointSize(2f);
		gl.glLineWidth(2f);
		gl.glColor3d(cor.getRed(), cor.getGreen(), cor.getBlue());
		gl.glBegin(primitivaGrafica);
		for (Ponto p : pontos) {
			gl.glVertex2f(p.getX(), p.getY());
		}
		gl.glEnd();
	}

	@Override
	public void trocaCor() {
			
	}

		
}
