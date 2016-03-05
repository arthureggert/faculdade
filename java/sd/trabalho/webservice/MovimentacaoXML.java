package br.com.ahe.sd.trabalho.webservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class MovimentacaoXML {

    @Getter @Setter
    private String minimo;

    @Getter @Setter
    private String maximo;

    @Getter @Setter
    private String atual;

    @Getter @Setter
    private String oscilacao;
}
