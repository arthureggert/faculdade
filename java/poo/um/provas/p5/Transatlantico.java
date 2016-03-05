package br.com.ahe.poo.um.provas.p5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Transatlantico extends Embarcacao implements Comparador {

    private String nome;
    private Date dataInauguracao;
    private List<BoteSalvaVidas> botes = new ArrayList<BoteSalvaVidas>();

    public Transatlantico() {
    }

    public Transatlantico(String nome, Date dataInauguracao) throws AtributoObrigatorioException {
        setNome(nome);
        setDataInauguracao(dataInauguracao);
    }

    public List<BoteSalvaVidas> getBotes() {
        return this.botes;
    }

    public void setBotes(List<BoteSalvaVidas> botes) {
        this.botes = botes;
    }

    public Date getDataInauguracao() {
        return this.dataInauguracao;
    }

    public void setDataInauguracao(Date dataInauguracao) throws AtributoObrigatorioException {
        if (dataInauguracao == null) {
            throw new AtributoObrigatorioException("Data de inauguração é obrigatória!");
        }
        this.dataInauguracao = dataInauguracao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws AtributoObrigatorioException {
        if (StringUtil.isVazio(nome)) {
            throw new AtributoObrigatorioException("Nome do transatlântico é obrigatório!");
        }
        this.nome = nome;
    }

    @Override
    public String verificaSeguranca() {
        int somaCapacidadeBotes = getSomaCapacidadeBotes();
        if (somaCapacidadeBotes >= getQtdePessoas()) {
            return "Está em condições adequadas de segurança";
        }

        Date dtHoje = new Date();
        if (this.dataInauguracao.after(dtHoje)) {
            return "ALERTA: navio necessitando de mais botes!";
        }

        return "CUIDADO: navio em perigo!";
    }

    private int getSomaCapacidadeBotes() {
        int soma = 0;
        for (BoteSalvaVidas bote : this.botes) {
            soma += bote.getQtdePessoas();
        }
        return soma;
    }

    @Override
    public int comparaCom(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return 1;
        }
        //
        Transatlantico outro = (Transatlantico) obj;
        if (getQtdePessoas() > outro.getQtdePessoas()) {
            return 1;
        }
        if (getQtdePessoas() < outro.getQtdePessoas()) {
            return -1;
        }
        return 0;
    }

    public void addBote(String registroCapitania, int qtdePessoas, int qtdeRemos, int qtdeColetes, boolean inflavel) throws AtributoObrigatorioException {
        BoteSalvaVidas bote = new BoteSalvaVidas();
        //
        bote.setRegistroCapitania(registroCapitania);
        bote.setInflavel(inflavel);
        bote.setQtdeColetes(qtdeColetes);
        bote.setQtdeRemos(qtdeRemos);
        bote.setQtdePessoas(qtdePessoas);
        //
        addBote(bote);
    }

    public void addBote(BoteSalvaVidas bote) throws AtributoObrigatorioException {
        if (bote == null) {
            throw new AtributoObrigatorioException("O paramêtro bote não pode ser nulo!");
        }
        this.botes.add(bote);
    }
}
