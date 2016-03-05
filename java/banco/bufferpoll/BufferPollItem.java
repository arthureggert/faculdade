package br.com.ahe.banco.bufferpoll;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import br.com.ahe.banco.pagina.Pagina;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"pagina"})
public class BufferPollItem {
	
	@Getter @Setter
	private Pagina pagina;
	
	@Getter @Setter
	private BufferPollItem proximo;
}
