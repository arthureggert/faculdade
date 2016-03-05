package br.com.ahe.poo.um.provas.p3;

/** Arthur Henrique Eggert **/

public class Motocicleta extends Veiculo {

    private int cilindradas;

    public static int nrMotos = 0;

    public Motocicleta(int cilindradas) throws AtributoException {
        setCilindradas(cilindradas);
    }

    public Motocicleta(String descricao, int ano, float valor, int cilindradas) throws AtributoException {
        super(descricao, ano, valor);
        setCilindradas(cilindradas);
    }

    public Motocicleta() {
    }

    public int getCilindradas() {
        return this.cilindradas;
    }

    public void setCilindradas(int cilindradas) throws AtributoException {
        if (cilindradas <= 0) {
            throw new AtributoException("Cilindradas n�o pode ser 0 ou menor!");
        } else {
        	this.cilindradas = cilindradas;
        }
    }

    @Override
    public float getValorIPVA() {
        if (this.cilindradas <= 150 || getAno() <= 1985) {
            return 0;
        } else {
        	return 0.02f * getValor();
        }
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();

        aux.append(getDescricao()).append(", ");
        aux.append(getAno()).append(", ");
        aux.append("no valor de ").append(FormatadorString.formataMoeda(getValor())).append(". ");
        aux.append(this.cilindradas).append(" cilindradas ");
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
