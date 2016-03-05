package br.com.ahe.sd.trabalho.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ahe.sd.trabalho.corba.impl.CorbaUtils;
import br.com.ahe.sd.trabalho.rmi.RMIUtils;

public class CompraPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textFieldAcao;

    private JTextField textFieldPreco;

    private JTextField textFieldQuantidade;

    private JTextField textFieldOrdem;

    public CompraPanel(SimuBolsaValoresApp simuBolsaValoresApp) {
        setLayout(null);

        JLabel lblAcao = new JLabel("Ação:");
        lblAcao.setBounds(12, 12, 77, 15);
        add(lblAcao);

        JLabel lblPreco = new JLabel("Preço(R$):");
        lblPreco.setBounds(12, 39, 77, 15);
        add(lblPreco);

        JLabel lblQuantidade = new JLabel("Quantidade: ");
        lblQuantidade.setBounds(12, 66, 77, 15);
        add(lblQuantidade);

        JLabel lblOrdem = new JLabel("Ordem: ");
        lblOrdem.setBounds(12, 93, 77, 15);
//        add(lblOrdem);

        this.textFieldPreco = new JTextField();
        this.textFieldPreco.setColumns(10);
        this.textFieldPreco.setBounds(86, 39, 114, 19);
        add(this.textFieldPreco);

        this.textFieldQuantidade = new JTextField();
        this.textFieldQuantidade.setColumns(10);
        this.textFieldQuantidade.setBounds(86, 64, 114, 19);
        add(this.textFieldQuantidade);

        this.textFieldOrdem = new JTextField();
        this.textFieldOrdem.setEditable(false);
        this.textFieldOrdem.setColumns(10);
        this.textFieldOrdem.setBounds(86, 91, 114, 19);
//        add(this.textFieldOrdem);

        this.textFieldAcao = new JTextField();
        this.textFieldAcao.setColumns(10);
        this.textFieldAcao.setBounds(86, 12, 114, 19);
        add(this.textFieldAcao);

        JButton buttonComprar = new JButton("Comprar");
        buttonComprar.setBounds(12, 91, 98, 25);
        buttonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String qtd = CompraPanel.this.textFieldQuantidade.getText().replaceAll(",", ".");
                    String preco = CompraPanel.this.textFieldPreco.getText().replaceAll("," , ".");
                    String nomeUsuario = simuBolsaValoresApp.getNomeUsuario();
                    RMIUtils.getFuncoesRMI().comprarAcao(CompraPanel.this.textFieldAcao.getText() ,  nomeUsuario , Double.valueOf(qtd)  , Double.valueOf(preco));
                    double saldoGeral = CorbaUtils.get().getUsuarioDAO().buscaSaldoGeral(nomeUsuario);
                    @SuppressWarnings( "unused" )
                    double saldoDisp = CorbaUtils.get().getUsuarioDAO().buscaSaldoDisponivel(nomeUsuario);
//                    simuBolsaValoresApp.atualizaLabel(simuBolsaValoresApp.getLblValorSaldoDisponivel(), CorbaUtils.get().getFuncoesCORBA().formataValores(saldoDisp));
                    simuBolsaValoresApp.atualizaLabel(simuBolsaValoresApp.getLblValorSaldoGeral(), CorbaUtils.get().getFuncoesCORBA().formataValores(saldoGeral));
                    CompraPanel.this.textFieldPreco.setText("");
                    CompraPanel.this.textFieldQuantidade.setText("");
                    CompraPanel.this.textFieldAcao.setText("");
                    JOptionPane.showMessageDialog(getParent() , "Compra Efetuada" , "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                    try {
                        JOptionPane.showMessageDialog(getParent() , RMIUtils.getFuncoesRMI().getLastError() , "Erro" , JOptionPane.ERROR_MESSAGE);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(getParent() , "Qtd/Valor em branco" , "Erro" , JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        add(buttonComprar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(115, 91, 98, 25);
        add(btnCancelar);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(494 , 216);
    }
}
