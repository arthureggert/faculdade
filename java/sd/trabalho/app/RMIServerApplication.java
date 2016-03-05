package br.com.ahe.sd.trabalho.app;

import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;
import br.com.ahe.sd.trabalho.rmi.RMIUtils;

public class RMIServerApplication {

    public static void main(String[] args) {
        CorbaUtils.get().runClient(args);
//        System.out.println(CorbaUtils.get().getFuncoesCORBA().formataValores(0.00d));
        RMIUtils.runServer();
    }

}
