package br.com.ahe.poo.um.lista.zero.exercicio.dois;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.experimental.Builder;

@Builder
@EqualsAndHashCode
public class Produto {

	private String nome;

	private String descricao;

	private BigDecimal precoUnitario;

	private int desconto;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( String.format( "Nome = %s\n" , this.nome) );
		builder.append( String.format( "Descrição = %s\n" , this.descricao) );
		builder.append( String.format( "Preço = %s\n" , this.precoUnitario) );
		builder.append( String.format( "Desconto = %s" , this.desconto) );
		return builder.toString();
	}
}
