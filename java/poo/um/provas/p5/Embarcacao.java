package br.com.ahe.poo.um.provas.p5;

public abstract class Embarcacao {

    private String registroCapitania;
    private int qtdePessoas;

    public Embarcacao(String registroCapitania, int qtdePessoas) throws AtributoObrigatorioException {
        setRegistroCapitania(registroCapitania);
        setQtdePessoas(qtdePessoas);
    }

    public Embarcacao() {
    }

    public int getQtdePessoas() {
        return this.qtdePessoas;
    }

    public void setQtdePessoas(int qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public String getRegistroCapitania() {
        return this.registroCapitania;
    }

    public void setRegistroCapitania(String registroCapitania) throws AtributoObrigatorioException {
        if (StringUtil.isVazio(registroCapitania)) {
            throw new AtributoObrigatorioException("Registro da capitania é obrigatório!");
        }
        this.registroCapitania = registroCapitania;
    }

    public abstract String verificaSeguranca();
}
