package br.com.ahe.cg.n3;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ponto {

	@NonNull
	private Integer x,
					y;
    private int z = 0;

	
}
