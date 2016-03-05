package br.com.ahe.cg.n3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static br.com.ahe.cg.n3.Globais.GLOBAL;

public class CallbackTeclado implements KeyListener {

  @Override
  public void keyTyped(KeyEvent keyEvent) {
    switch (keyEvent.getKeyChar()) {
      case 'i':
        GLOBAL.setModoInsercao(true);
        GLOBAL.setDesenhando(true);
        break;
      case 's':
        GLOBAL.setModoInsercao(false);
        GLOBAL.setDesenhando(false);
        break;
      case 27:
        GLOBAL.setDesenhando(false);
        break;
      default:
        break;
    }

  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

  }

}
