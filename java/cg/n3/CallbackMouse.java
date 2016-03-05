package br.com.ahe.cg.n3;

import static br.com.ahe.cg.n3.Globais.GLOBAL;
import static br.com.ahe.cg.n3.Mundo.MUNDO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class CallbackMouse extends MouseAdapter implements MouseMotionListener {

  private static final int BOTAO_ESQUERDO = 1;

  private static final int BOTAO_DIREITO = 3;

  @Override
  public void mouseClicked(MouseEvent e) {
    if(GLOBAL.isModoInsercao()) {
      if( e.getButton() == BOTAO_ESQUERDO ) {
        Poligono p = new Poligono();
        p.addPonto(new Ponto(e.getX() , e.getY()));
        p.addPonto(new Ponto(e.getX() , e.getY()));
        MUNDO.addPoligono(p);
      }		
      MUNDO.redrawDisplay();
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    if(GLOBAL.isModoInsercao() && GLOBAL.isDesenhando()) {
      if(!MUNDO.getPoligonos().isEmpty()) {
        Ponto ponto = MUNDO.getUltimoPoligno().getUltimoPonto();
        ponto.setX(e.getX());
        ponto.setY(e.getY());
        MUNDO.getUltimoPoligno().setUltimoPonto(ponto);	
      }
      MUNDO.redrawDisplay();	
    }
  }


}
