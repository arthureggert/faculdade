package br.com.ahe.poo.um.lista.zero.exercicio.um;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;
import enums.EEstadoCivil;
import enums.ESexo;

@EqualsAndHashCode
@ToString
@AllArgsConstructor(staticName = "createWithParameter")
@NoArgsConstructor(staticName = "createWithNoParameter" )
@Builder(builderClassName = "PessoaBuilder" , builderMethodName = "createBuilder" , buildMethodName = "create")
public class Pessoa {

	@Getter
	private String nome;

	@Getter
	private ESexo sexo;

	@Getter
	private EEstadoCivil estadoCivil;

	@Getter
	private LocalDate dataNascimento;


}
