package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

public class Automovel extends Veiculo {

    private boolean importado;

    public static int nrCarros = 0;

    public Automovel(boolean importado) throws AtributoException {
        setImportado(importado);
    }

    public Automovel(String descricao, int ano, float valor, boolean importado) throws AtributoException {
        super(descricao, ano, valor);
        setImportado(importado);
    }

    public Automovel() {
    }

    public boolean isImportado() {
        return this.importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    @Override
    public float getValorIPVA() {
        if (this.importado) {
            return 0.04f * getValor();
        }

        if (getAno() > 1985) {
            return 0.02f * getValor();
        }

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();

        aux.append(getDescricao()).append(", ");
        aux.append(getAno()).append(", ");
        aux.append("no valor de ").append(FormatadorString.formataMoeda(getValor())).append(". ");
        if (isImportado()) {
            aux.append("Importado ");
        } else {
            aux.append("Nacional ");
        }
        aux.append("(").append(getCodigo()).append("): ");
        float ipva = getValorIPVA();
        if (ipva == 0) {
            aux.append("isento de IPVA (IPVA = 0)");
        } else {
            aux.append("IPVA de ").append(FormatadorString.formataMoeda(ipva));
        }

        return aux.toString();
    }
}
