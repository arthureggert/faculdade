package br.com.ahe.sd.trabalho.view;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings( "unused" )
public class SimuBolsaValoresApp {

    @Getter @Setter
    private JFrame frame;

    @Getter @Setter
    private JPanel panelSuperior;

    @Getter @Setter
    private JPanel panelInferior;

    @Getter @Setter
    private JPanel panelMeio;

    @Getter @Setter
    private JPanel panelDireita;

    @Getter
    private JPanel panelSeparador;

    @Getter @Setter
    private CompraPanel compraPanel;

    @Getter @Setter
    private VendaPanel vendaPanel;

    @Getter @Setter
    private CarteiraPanel carteiraPanel;

    @Getter @Setter
    private PendenciaPanel pendenciaPanel;

    @Getter @Setter
    private HistoricoPanel histPanel;

    @Getter @Setter
    private CotacoesPanel cotacoesPanel;

    @Getter @Setter
    private JButton btnComprar;

    @Getter @Setter
    private JButton btnVender;

    @Getter @Setter
    private JButton btnCarterira;

//    @Getter @Setter
//    private JButton btnHistrico;

//    @Getter @Setter
//    private JButton btnPendencias;

    @Getter @Setter
    private JButton btnCotacoes;

    @Getter @Setter
    private JLabel lblUsuario;

    @Getter @Setter
    private JLabel lblNomeUsuario;

    @Getter @Setter
    private JLabel lblSeparador1;

//    @Getter @Setter
//    private JLabel lblSaldoDisponivel;
//
//    @Getter @Setter
//    private JLabel lblValorSaldoDisponivel;

    @Getter @Setter
    private JLabel lblSeparador2;

    @Getter @Setter
    private JLabel lblSaldoGeral;

    @Getter @Setter
    private JLabel lblValorSaldoGeral;

    @Getter @Setter
    private List<JPanel> paineis;

    private String nomeUsuario;

    public SimuBolsaValoresApp() {
        criaFrame();
        criaPanelBackground();
        criaBotoes();
        criaPanelInferior();
        criaPanelMeio();
        criaPanelPersonalizado();
        criaActionListenerBotoes();
//        criaPanelSeparador();
//        criaPanelDireita();
    }

    public void setPanelSeparador(JPanel panelSeparador) {
        panelSeparador.setBackground(SystemColor.textInactiveText);
        this.panelSeparador = panelSeparador;
    }


    public void setVisible(boolean visible) {
        getFrame().setVisible(visible);
    }

    private void criaFrame() {
        setFrame(new JFrame("Simulador Bolsa de Valores"));
        getFrame().setBounds(100, 100, 520, 300);
        getFrame().getContentPane().setLayout(null);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void criaPanelBackground() {
        setPanelSuperior(new JPanel());
        getPanelSuperior().setBounds(0, 0, 514, 35);
        getPanelSuperior().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        getFrame().getContentPane().add(getPanelSuperior());
    }

    private void criaBotoes(){
        setBtnComprar(new JButton("Comprar"));
        setBtnVender(new JButton("Vender"));
        setBtnCarterira(new JButton("Carteira"));
//        setBtnHistrico(new JButton("Histórico"));
//        setBtnPendencias(new JButton("Pendencias"));
        setBtnCotacoes(new JButton("Cotações"));
        getPanelSuperior().add(getBtnComprar());
        getPanelSuperior().add(getBtnVender());
        getPanelSuperior().add(getBtnCarterira());
//        getPanelSuperior().add(getBtnPendencias());
//        getPanelSuperior().add(getBtnHistrico());
        getPanelSuperior().add(getBtnCotacoes());
    }

    private void criaPanelInferior(){
        setLblUsuario(new JLabel("Usuário: "));
        setLblNomeUsuario(new JLabel("Arthur H. Eggert"));
        setLblSeparador1(new JLabel("|"));
//        setLblSaldoDisponivel(new JLabel("Saldo Disponivel: "));
//        setLblValorSaldoDisponivel(new JLabel("R$ 000.000,00"));
//        setLblSeparador2(new JLabel("|"));
        setLblSaldoGeral(new JLabel("Saldo Geral: "));
        setLblValorSaldoGeral(new JLabel("R$ 000.000,00"));
        setPanelInferior(new JPanel());
        getPanelInferior().setBounds(0, 250, 633, 25);
        getPanelInferior().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        getFrame().getContentPane().add(getPanelInferior());
        getPanelInferior().add(getLblUsuario());
        getPanelInferior().add(getLblNomeUsuario());
        getPanelInferior().add(getLblSeparador1());
//        getPanelInferior().add(getLblSaldoDisponivel());
//        getPanelInferior().add(getLblValorSaldoDisponivel());
//        getPanelInferior().add(getLblSeparador2());
        getPanelInferior().add(getLblSaldoGeral());
        getPanelInferior().add(getLblValorSaldoGeral());
    }

    private void criaPanelMeio() {
        setPanelMeio(new JPanel());
        getPanelMeio().setBounds(0, 35, 514, 216);
        getFrame().getContentPane().add(getPanelMeio());
        getPanelMeio().setLayout(new BoxLayout(getPanelMeio(), BoxLayout.X_AXIS));
    }

    private void criaPanelSeparador() {
        setPanelSeparador(new JPanel());
        getPanelSeparador().setBounds(518, 5, 1, 251);
        getFrame().getContentPane().add(getPanelSeparador());
        getPanelSeparador().setLayout(null);
    }

    private void criaPanelDireita(){
        setPanelDireita(new JPanel());
        getPanelDireita().setBounds(527, 0, 106, 251);
        getPanelDireita().setLayout(new FlowLayout());


        getFrame().getContentPane().add(getPanelDireita());
    }


    private void criaPanelPersonalizado() {
        setCompraPanel(new CompraPanel(this));
        setVendaPanel(new VendaPanel(this));
        setCarteiraPanel(new CarteiraPanel());
        setPendenciaPanel(new PendenciaPanel());
        setHistPanel(new HistoricoPanel());
        setCotacoesPanel(new CotacoesPanel());
    }

    private void criaActionListenerBotoes() {
        getBtnComprar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll(getPanelMeio() , getCompraPanel());
            }
        });
        getBtnVender().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll(getPanelMeio() , getVendaPanel());
            }
        });
        getBtnCarterira().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll(getPanelMeio() , getCarteiraPanel());
            }
        });
//        getBtnPendencias().addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                removeAll(getPanelMeio(), getPendenciaPanel());
//
//            }
//        });
//        getBtnHistrico().addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                removeAll(getPanelMeio(), getHistPanel());
//            }
//        });
        getBtnCotacoes().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll(getPanelMeio(), getCotacoesPanel());
            }
        });
    }

    private void criaListaPaineis() {
        setPaineis(new ArrayList<>());
        getPaineis().add(getCompraPanel());
        getPaineis().add(getVendaPanel());
        getPaineis().add(getCarteiraPanel());
        getPaineis().add(getPendenciaPanel());
        getPaineis().add(getHistPanel());
        getPaineis().add(getCotacoesPanel());
    }


    public void removeAll(JPanel panelParent, JPanel panelChild) {
        if (getPaineis() == null) {
            criaListaPaineis();
        }
        for (JPanel panel : getPaineis()) {
            if(panelChild.equals(panel)) {
                panelParent.add(panelChild);
            }else {
                panelParent.remove(panel);
            }
        }

        panelParent.revalidate();
        panelParent.repaint();
    }

    public void atualizaLabel(JLabel label, String text) {
        label.setText(text);
        label.getParent().revalidate();
        label.getParent().repaint();
    }

    public void setNomeUsuario(String text) {
        System.out.println("=================>" + text);
        this.nomeUsuario = text;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }
}
