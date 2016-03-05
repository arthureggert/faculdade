package br.com.ahe.sd.trabalho.app;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;
import br.com.ahe.sd.trabalho.view.LoginDialog;
import br.com.ahe.sd.trabalho.view.SimuBolsaValoresApp;

public class SimuBolsaValoresApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CorbaUtils.get().runClient(args);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    SimuBolsaValoresApp app = new SimuBolsaValoresApp();
                    LoginDialog login = new LoginDialog(app,true);
                    login.setVisible(true);
//                    SDApp br.com.ahe.sd.trabalho.app = getApplicationContext().getBean(SDApp.class);
//                    br.com.ahe.sd.trabalho.app.criaTabelas();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
