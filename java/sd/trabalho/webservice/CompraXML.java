package br.com.ahe.sd.trabalho.webservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class CompraXML {

    @Getter @Setter
    private String aprovada;

    @Getter @Setter
    private String mensagem;


}
