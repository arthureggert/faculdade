package br.com.ahe.banco.slot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RID {

	@Getter
	private int numeroPagina;
	
	@Getter
	private int numeroSlot;
}
