package br.com.ahe.poo.um.provas.p5;

public class BoteSalvaVidas extends Embarcacao {

    private boolean inflavel;
    private int qtdeRemos;
    private int qtdeColetes;

    public BoteSalvaVidas(boolean inflavel, int qtdeRemos, int qtdeColetes) {
        setInflavel(inflavel);
        setQtdeColetes(qtdeColetes);
        setQtdeRemos(qtdeRemos);
    }

    public BoteSalvaVidas() {
    }

    public boolean isInflavel() {
        return this.inflavel;
    }

    public void setInflavel(boolean inflavel) {
        this.inflavel = inflavel;
    }

    public int getQtdeColetes() {
        return this.qtdeColetes;
    }

    public void setQtdeColetes(int qtdeColetes) {
        this.qtdeColetes = qtdeColetes;
    }

    public int getQtdeRemos() {
        return this.qtdeRemos;
    }

    public void setQtdeRemos(int qtdeRemos) {
        this.qtdeRemos = qtdeRemos;
    }

    @Override
    public String verificaSeguranca() {
        if (this.qtdeColetes >= getQtdePessoas()) {
            return "Bote OK!";
        }
        return "Insuficiência de " + (getQtdePessoas() - this.qtdeColetes) + " coletes salva-vidas!";
    }
}
