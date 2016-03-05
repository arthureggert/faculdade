package br.com.ahe.cg.n3;

import static br.com.ahe.cg.n3.Mundo.MUNDO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Janela extends JFrame {

  private static final long serialVersionUID = 1L;

  private GLCanvas canvas;

  private Renderer renderer = new Renderer(MUNDO.getCamera().getXMin() , 
      MUNDO.getCamera().getXMax() ,
      MUNDO.getCamera().getYMin() ,
      MUNDO.getCamera().getYMax());

  private KeyListener callbackTeclado = new CallbackTeclado();

  private CallbackMouse callbackMouse = new CallbackMouse();

  public Janela(String titulo) {
    super(titulo);
    setResizable(false);
    setSize(500, 500);
    setBackground(Color.WHITE);
    getContentPane().setPreferredSize(new Dimension(500, 500));
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    GLProfile glProfile = GLProfile.get(GLProfile.GL2);
    GLProfile.initSingleton();
    GLCapabilities glCapabilities = new GLCapabilities(glProfile);
    canvas = new GLCanvas(glCapabilities);
    add(canvas,BorderLayout.CENTER);
    canvas.addGLEventListener(renderer);
    canvas.addKeyListener(callbackTeclado);
    canvas.addMouseListener(callbackMouse);
    canvas.addMouseMotionListener(callbackMouse);
    canvas.requestFocus();
    MUNDO.setRenderer(renderer);
  }

}