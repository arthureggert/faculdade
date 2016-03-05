package br.com.ahe.cg.n3;

import static br.com.ahe.cg.n3.Mundo.MUNDO;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.jogamp.opengl.util.gl2.GLUT;

@RequiredArgsConstructor
public class Renderer implements GLEventListener{

	private GL2 gl;

	private GLU glu;

	@SuppressWarnings("unused")
	private GLUT glut;

	@Getter
	private GLAutoDrawable glDrawable;

	@NonNull
	private Float minX;

	@NonNull
	private Float maxX;

	@NonNull
	private Float minY;

	@NonNull
	private Float maxY;

	@Override
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;  
		gl = drawable.getGL().getGL2();       
		glu = new GLU();
		glut = new GLUT();
		gl.glClearColor(0.80f, 0.80f, 0.80f , 1.0f);		

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		MUNDO.getPoligonos().clear();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();    
		glu.gluOrtho2D(minX , maxX , minY , maxY);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		desenhaEixoXYZ();
		desenhaPoligonos();
		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl.glViewport(0, 0, width, height);   
	}

	private void desenhaEixoXYZ() {
		//Eixo X e Y e Z

		gl.glLineWidth(2f);

		gl.glBegin(GL.GL_LINES);

		//X
		gl.glColor3f(1f,0f,0f);
		gl.glVertex2f(minX,maxY);
		gl.glVertex2f(minY,minX);

		//Y
		gl.glColor3f(0f,0f,1f);
		gl.glVertex2f(0, minY);
		gl.glVertex2f(0, maxY);
//
//		//Z
		gl.glColor3f(0f,1f,0f);
		gl.glVertex2f(minX,maxY);
		gl.glVertex2f(minY,maxX);

		gl.glEnd();
	}

	public void desenhaPoligonos() {
		for (Poligono poligono : MUNDO.getPoligonos() ) {
			poligono.desenha(glDrawable);
		}		
	}
}
