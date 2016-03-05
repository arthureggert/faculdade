package br.com.ahe.sd.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(schema = "pregao")
@AllArgsConstructor(staticName = "criaUsuario")
public class Usuario extends DefaultTable {

    private static final long serialVersionUID = 1L;

	@Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String senha;

    @Getter
    @Setter
    @OneToOne
    private Carteira carteira;
}
