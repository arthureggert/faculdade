package br.com.ahe.cg.n3;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public enum Mundo {

	MUNDO;

	@Getter
	private List<Poligono> poligonos = new ArrayList<Poligono>();
	
	@Getter 
	private Camera camera = new Camera(0f , 500f , 500f , 0f);
	
	@Setter
	private Renderer renderer;
		
	public void addPoligono(Poligono poligno) {
		poligonos.add(poligno);
	}

	public Poligono getUltimoPoligno() {
		return poligonos.get(poligonos.size() - 1);
	}
	
	public void redrawDisplay() {
		renderer.getGlDrawable().display();
	}
		
}
