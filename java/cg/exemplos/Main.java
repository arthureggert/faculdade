package br.com.ahe.cg.exemplos;

/// \file Exemplo_N2_Jogl_Eclipse.java
/// \brief Exemplo_N2_Jogl_Eclipse: desenha uma linha na diagonal.
/// \version $Revision: 1.0 $
/// \author Dalton Reis.
/// \date 03/05/13.
/// Obs.: variaveis globais foram usadas por questoes didaticas mas nao sao recomendas para aplicacoes reais.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.DebugGL2;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


public class Main implements GLEventListener, KeyListener {
	private float ortho2D_minX = -400.0f, ortho2D_maxX =  400.0f, ortho2D_minY = -400.0f, ortho2D_maxY =  400.0f;
	private GL2 gl;
	private GLU glu;
	private GLAutoDrawable glDrawable;
	private double valorX = 0.0;

	public void init(GLAutoDrawable drawable) {
		System.out.println(" --- init ---");
		glDrawable = drawable;
		gl = drawable.getGL().getGL2();
		glu = new GLU();
		glDrawable.setGL(new DebugGL2(gl));
		System.out.println("Espa�o de desenho com tamanho: " + drawable.getSurfaceWidth() + " x " + drawable.getSurfaceHeight());
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public void SRU() {
		//		gl.glDisable(gl.GL_TEXTURE_2D);
		//		gl.glDisableClientState(gl.GL_TEXTURE_COORD_ARRAY);
		//		gl.glDisable(gl.GL_LIGHTING); //TODO: [D] FixMe: check if lighting and texture is enabled

		// eixo x
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glLineWidth(1.0f);
		gl.glBegin( GL.GL_LINES );
		gl.glVertex2f( -200.0f, 0.0f );
		gl.glVertex2f(  200.0f, 0.0f );
		gl.glEnd();
		// eixo y
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin( GL.GL_LINES);
		gl.glVertex2f(  0.0f, -200.0f);
		gl.glVertex2f(  0.0f, 200.0f );
		gl.glEnd();
	}

	//exibicaoPrincipal
	public void display(GLAutoDrawable arg0) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D( ortho2D_minX,  ortho2D_maxX,  ortho2D_minY,  ortho2D_maxY);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

		SRU();

		// seu desenho ...
		//		 gl.glColor3f(0.0f, 0.0f, 0.0f);
		//		 gl.glLineWidth(3.0f);
		//		 gl.glBegin(GL.GL_LINES);
		//		 	gl.glVertex2d(0.0, 0.0);
		//		    gl.glVertex2d(valorX, 200.0);
		//		 gl.glEnd();

		gl.glFlush();
	}	

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_E:
			valorX -= 10.0;
			glDrawable.display();
			break;
		case KeyEvent.VK_D:
			valorX += 10.0;
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			gl.glLineWidth(3.0f);
			gl.glBegin(GL.GL_LINES);
			gl.glVertex2d(0.0, 0.0);
			gl.glVertex2d(valorX, 200.0);
			gl.glEnd();
			glDrawable.display();
			break;
		}
	}

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		System.out.println(" --- reshape ---");
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
		System.out.println(" --- displayChanged ---");
	}

	public void keyReleased(KeyEvent arg0) {
		System.out.println(" --- keyReleased ---");
	}

	public void keyTyped(KeyEvent arg0) {
		System.out.println(" --- keyTyped ---");
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

}
