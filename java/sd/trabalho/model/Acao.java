package br.com.ahe.sd.trabalho.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Table(schema = "pregao")
@EqualsAndHashCode(callSuper = true)
public class Acao extends DefaultTable {

    private static final long serialVersionUID = -7477612653078011825L;

    @Getter
    @Setter
    private Long empresa;

    @Getter
    @Setter
    private BigDecimal quantidadeNegocios;
}
