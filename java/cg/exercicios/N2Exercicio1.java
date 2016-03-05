package br.com.ahe.cg.exercicios;

import javax.media.opengl.GL;

import br.com.ahe.cg.utils.Renderer;

public class N2Exercicio1 extends Renderer {

	@Override
	public void desenho() {	
		
		gl.glColor3f(0f,0f,1f);
		
		gl.glBegin(GL.GL_POINTS);

		gl.glPointSize(2f);
		
		for(int i = 0; i < 72; i++) {
			double angle = 2.0f * Math.PI * i / 72;

			double x = 100 * Math.cos(angle);
			double y = 100 * Math.sin(angle);

			gl.glVertex2d(x + 0, y + 0);
		}

		gl.glEnd();
	}

}
