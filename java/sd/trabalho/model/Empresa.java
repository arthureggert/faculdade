package br.com.ahe.sd.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(schema = "pregao")
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Empresa extends DefaultTable {

    private static final long serialVersionUID = -4041262379727461887L;

    @Getter
    @Setter
    private String nomeEmpresa;

    @Getter
    @Setter
    private String siglaEmpresa;

}
