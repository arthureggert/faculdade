package br.com.ahe.sd.trabalho.model;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Carteira extends DefaultTable {

    private static final long serialVersionUID = 1L;

	@Getter
    @Setter
    @Column(name = "valorCarteira")
    private BigDecimal valorReal;

    @Getter
    @Setter
    @OneToMany(mappedBy = "carteira")
    private List<MovimentacaoCarteira> movimentacoes;

    public double getSaldoDiponivel() {
        return this.valorReal.doubleValue();
    }
}
