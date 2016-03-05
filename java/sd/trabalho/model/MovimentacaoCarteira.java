package br.com.ahe.sd.trabalho.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class MovimentacaoCarteira extends DefaultTable {

    private static final long serialVersionUID = 1L;

	@Getter
    @Setter
    private Long acao;

    @Getter
    @Setter
    private Date dataMovimentacao;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    private ETipoMovimentacaoCarteria tipoMovimentacaoCarteria;

    @Getter
    @Setter
    private BigDecimal valor;

    @Getter
    @Setter
    private BigDecimal quantidade;

    @Getter
    @Setter
    private Long carteira;

    public double getValorTotal() {
        return this.valor.multiply(this.quantidade).doubleValue();
    }
}
