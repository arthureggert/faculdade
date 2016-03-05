package br.com.ahe.cg.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.DebugGL2;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;

public abstract class Renderer implements GLEventListener , ExercicioCG , KeyListener {

	protected GL2 gl;

	protected GLU glu;
	
	protected GLUT glut;

	protected GLAutoDrawable glDrawable;
	
	protected float minX = -400.0f,
	        		maxX =  400.0f,
	        		minY = -400.0f,
	        		maxY =  400.0f;

	@Override
	public void init(GLAutoDrawable drawable)  {
		glDrawable = drawable;  
		gl = drawable.getGL().getGL2();       
		glu = new GLU();
		glut = new GLUT();
		gl.glClearColor(0.80f, 0.80f, 0.80f , 1.0f);
		glDrawable.setGL(new DebugGL2(gl));
        Animator animator = new Animator(glDrawable);
        animator.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();    
		glu.gluOrtho2D(minX , maxX , minY , maxY);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		desenha();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl.glViewport(0, 0, width, height);   
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		System.out.println("DISPOSE");
	}

	private void desenha() {
		desenhaEixoXeY();
		desenho();
	}

	private void desenhaEixoXeY() {
		gl.glColor3f(1f,0f,0f);

		gl.glLineWidth(1.0f);

		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(-200,0);
		gl.glVertex2f( 200,0);
		gl.glEnd();

		gl.glColor3f(0f,1f,0f);

		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(0,-200);
		gl.glVertex2f(0, 200);
		gl.glEnd();
	}

	@Override
	public abstract void desenho();

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) { }
	
	
}

