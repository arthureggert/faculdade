package br.com.ahe.sd.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ahe.sd.trabalho.corba.Usuario;
import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;

public class LoginDialog extends JDialog {

    private static final long serialVersionUID = -2058032293687971762L;

    private final JTextField textFieldUsuario;

    private final JPasswordField passwordFieldSenha;

    private final JButton buttonOK;

    private final JLabel labelStatus;

    private SimuBolsaValoresApp parent;

    public LoginDialog() {
        this(null, true);
    }

    public LoginDialog(SimuBolsaValoresApp parent, boolean modal) {
        super(parent.getFrame(),"Simulador Bolsa de Valores", modal);
        this.textFieldUsuario = new JTextField(15);
        this.passwordFieldSenha = new JPasswordField();
        this.buttonOK = new JButton("Login");
        this.labelStatus = new JLabel(" ");
        this.parent = parent;
        initialize();
    }

    public void initialize() {

        JPanel dadosLabelPanel = new JPanel(new GridLayout(2, 1));
        JLabel labelUsuario = new JLabel("Usuário");
        dadosLabelPanel.add(labelUsuario);
        JLabel labelSenha = new JLabel("Senha");
        dadosLabelPanel.add(labelSenha);

        JPanel dadosFieldPanel = new JPanel(new GridLayout(2, 1));

        dadosFieldPanel.add(this.textFieldUsuario);
        dadosFieldPanel.add(this.passwordFieldSenha);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.add(dadosLabelPanel);
        backgroundPanel.add(dadosFieldPanel);

        JPanel botoesPanel = new JPanel();

        botoesPanel.add(this.buttonOK);
        JButton jbtCancel = new JButton("Cancelar");
        botoesPanel.add(jbtCancel);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(botoesPanel, BorderLayout.CENTER);

        statusPanel.add(this.labelStatus, BorderLayout.NORTH);
        this.labelStatus.setForeground(Color.RED);
        this.labelStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(backgroundPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        this.buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isUsuarioValido()) {
                    LoginDialog.this.parent.setVisible(true);
                    setVisible(false);
                } else {
                    LoginDialog.this.labelStatus.setText("Usuário ou senha inválido");
                }
            }
        });
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginDialog.this.parent.getFrame().dispose();
                System.exit(0);
            }
        });
    }

    @SuppressWarnings( "unused" )
    private boolean isUsuarioValido() {
        Usuario retorno = null;
        double saldoDisp = 0;
        double saldoGeral = 0;
        try {
            retorno =  CorbaUtils.get().getUsuarioDAO().validaUsuario(this.textFieldUsuario.getText() , new String(this.passwordFieldSenha.getPassword()));
        } catch (Exception e) {
            return false;
        }
        saldoGeral = CorbaUtils.get().getUsuarioDAO().buscaSaldoGeral(this.textFieldUsuario.getText());
        saldoDisp = CorbaUtils.get().getUsuarioDAO().buscaSaldoDisponivel(this.textFieldUsuario.getText());
        if(retorno != null) {
            this.parent.setNomeUsuario(this.textFieldUsuario.getText());
            this.parent.atualizaLabel(this.parent.getLblNomeUsuario() , this.textFieldUsuario.getText().substring(0 , 1).toUpperCase() + this.textFieldUsuario.getText().substring(1));
//            parent.atualizaLabel(parent.getLblValorSaldoDisponivel() , CorbaUtils.get().getFuncoesCORBA().formataValores(saldoDisp));
            this.parent.atualizaLabel(this.parent.getLblValorSaldoGeral() , CorbaUtils.get().getFuncoesCORBA().formataValores(saldoGeral));
        }
        return retorno != null;
    }
}
