package br.com.ahe.sd.trabalho.webservice;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmpresaXML {

    private String sigla;

    private String nome;

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
