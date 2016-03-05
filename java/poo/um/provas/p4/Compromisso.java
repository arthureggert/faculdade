package br.com.ahe.poo.um.provas.p4;

public class Compromisso {

    private String hora;
    private String descricao;
    private int tempo;
    private char prioridade;

    public Compromisso() {
    }

    public Compromisso(String hora, String descricao, int tempo, char prioridade) {
        this.hora = hora;
        this.descricao = descricao;
        this.tempo = tempo;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public char getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(char prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempo() {
        return this.tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Hora: ").append(this.hora).append(" - ");
        s.append("Descrição: ").append(this.descricao).append(" - ");
        s.append("Tempo: ").append(this.tempo).append(" - ");
        s.append("Prioridade: ").append(Prioridade.getDescricaoPrioridade(this.prioridade));
        return s.toString();
    }


}
