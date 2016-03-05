package br.com.ahe.cg.utils;

import java.awt.BorderLayout;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GLCanvas canvas;
	
	public Janela(String titulo , Renderer renderer) {
		super(titulo);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GLProfile glProfile = GLProfile.get(GLProfile.GL2);
		GLProfile.initSingleton();
		GLCapabilities glCapabilities = new GLCapabilities(glProfile);
		canvas = new GLCanvas(glCapabilities);
		add(canvas,BorderLayout.CENTER);
		canvas.addGLEventListener(renderer);
		canvas.addKeyListener(renderer);
		canvas.requestFocus();	
	}

	public void display() {
		canvas.display();
	}
}

