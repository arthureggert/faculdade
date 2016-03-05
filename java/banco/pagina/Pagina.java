package br.com.ahe.banco.pagina;

import java.io.Serializable;
import java.util.Date;

import br.com.ahe.banco.slot.DiretorioSlot;
import static lombok.AccessLevel.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;

@ToString
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Builder(fluent = true , chain = true)
public class Pagina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private int id;
	
	@Getter
	private DiretorioSlot slots;
	
	@Getter @Setter
	private boolean sujo;
	
	@Getter
	private int pinCount;
	
	@Getter
	private Date ultimoAcesso;

	public boolean isEmUso() {
		return this.pinCount > 0;
	}

}
