package br.com.ahe.sd.trabalho.model;

import lombok.Getter;

/**
 * Created by aheggert on 01/07/14.
 */
public enum ETipoMovimentacaoCarteria {

    COMPRA("COMPRA"),
    VENDA("VENDA"),
    PENDENTE("PENDENTE");

    @Getter
    private String tipo;

    private ETipoMovimentacaoCarteria(String tipo) {
        this.tipo = tipo;
    }

    public static ETipoMovimentacaoCarteria getFromString(String tipo) {
        ETipoMovimentacaoCarteria[] values = values();
        for (ETipoMovimentacaoCarteria tipoMv : values) {
            if (tipoMv.getTipo().equalsIgnoreCase(tipo)) {
                return tipoMv;
            }
        }
        return null;
    }
}
