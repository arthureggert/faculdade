package br.com.ahe.sd.trabalho.model;

import java.math.BigDecimal;
import java.util.Date;

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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MovimentacaoAcao extends DefaultTable {

    private static final long serialVersionUID = -411902642925932423L;

    @Getter
    @Setter
    private BigDecimal valorMaxima;

    @Getter
    @Setter
    private BigDecimal valorMinima;

    @Getter
    @Setter
    private BigDecimal valorAtual;

    @Getter
    @Setter
    private BigDecimal percentualOsilacao;

    @Getter
    @Setter
    private Date dataMoviemnto;

    @Setter
    @Getter
    private Long acao;
}
