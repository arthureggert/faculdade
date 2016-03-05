package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

public abstract class Veiculo implements Comparable<Veiculo> {

    private String descricao;
    private int ano;
    private float valor;
    private String codigo;

    public Veiculo(String descricao, int ano, float valor) throws AtributoException {
        setDescricao(descricao);
        setAno(ano);
        setValor(valor);
    }

    public Veiculo() {
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) throws AtributoException {
        if (ano <= 0) {
            throw new AtributoException("O ano deve ser maior que zero!");
        }
        this.ano = ano;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) throws AtributoException {
        if (FormatadorString.isVazio(descricao)) {
            throw new AtributoException("A descric�o do veiculo precisa ser preenchida");
        }
        this.descricao = descricao;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) throws AtributoException {
        if (valor <= 0) {
            throw new AtributoException("O valor deve ser maior que zero!");
        } else {    
        	this.valor = valor;
        }
    }

    public abstract float getValorIPVA();

    public int compareTo(Veiculo o) {
        return Float.valueOf(o.getValorIPVA()).compareTo(this.getValorIPVA());
    }
}
