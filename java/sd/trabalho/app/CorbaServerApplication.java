package br.com.ahe.sd.trabalho.app;

import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;

/**
 * Created by aheggert on 23/06/14.
 */
public class CorbaServerApplication {

    public static void main(String[] args) {
        CorbaUtils.get().runServer(args);
    }
}
