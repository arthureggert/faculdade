package br.com.ahe.cg.n3;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Camera {

	@NonNull
	private Float xMin,
				xMax,
				yMin,
				yMax;
	
	public void zoom() {
		
	}
	
	public void pam() {
		
	}
}
