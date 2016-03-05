package br.com.ahe.cg.n3;

import javax.media.opengl.GL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public enum Globais {
  
  GLOBAL;
  
  @Getter @Setter
  private boolean modoInsercao = false;
    
  @Getter @Setter
  private boolean desenhando = false;
  
  @Getter @Setter
  private int primitivaGrafica = GL.GL_LINE_STRIP;


}
