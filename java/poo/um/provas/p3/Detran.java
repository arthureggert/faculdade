package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Detran {

    private String unidadeFederacao;
    private List<Veiculo> veiculos;

    public Detran(String unidadeFederacao) throws AtributoException {
        setUnidadeFederacao(unidadeFederacao);
        this.veiculos = new ArrayList<Veiculo>();
    }

    public String getUnidadeFederacao() {
        return this.unidadeFederacao;
    }

    public void setUnidadeFederacao(String unidadeFederacao) throws AtributoException {
        if (FormatadorString.isVazio(unidadeFederacao)) {
            throw new AtributoException("A unidade da federa��o precisa ser preenchida!");
        } else {
        	this.unidadeFederacao = unidadeFederacao;
        }
    }

    public float addVeiculo(Veiculo veiculo) throws AtributoException {
        if (veiculo == null) {
            throw new AtributoException("O parametro veiculo precisa ser preenchido!");
        } else {
        	veiculo.setCodigo(getCodigoVeiculo(veiculo));
        	this.veiculos.add(veiculo);
        	return veiculo.getValorIPVA();
        }
    }

    private String getCodigoVeiculo(Veiculo veiculo) {
        if (veiculo instanceof Motocicleta) {
            Motocicleta.nrMotos++;
            return "MOT" + Motocicleta.nrMotos;
        } else {
        	Automovel.nrCarros++;
        	return "AUT" + Automovel.nrCarros;
        }
    }

    public String listaVeiculos() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Detran de ").append(this.unidadeFederacao).append("\n\r");

        Collections.sort(this.veiculos);
        for (Veiculo v : this.veiculos) {
            retorno.append(v).append("\r");
        }

        return retorno.toString();
    }

    public List<Veiculo> quaisVeiculosFaixa(float limiteInferior, float limiteSuperior) {
        List<Veiculo> aux = new ArrayList<Veiculo>();

        for (Veiculo v : this.veiculos) {
            float ipva = v.getValorIPVA();
            if (ipva >= limiteInferior && ipva <= limiteSuperior) {
                aux.add(v);
            }
        }

        return aux;
    }
}
