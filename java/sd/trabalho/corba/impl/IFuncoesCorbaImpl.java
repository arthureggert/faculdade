package br.com.ahe.sd.trabalho.corba.impl;

import java.text.DecimalFormat;

import br.com.ahe.sd.trabalho.corba.IFuncoesCorbaPOA;

public class IFuncoesCorbaImpl extends IFuncoesCorbaPOA {

    @Override
    public String formataValores(double textoValor) {
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("R$ 000.00");
        return format.format(textoValor);
    }
}
