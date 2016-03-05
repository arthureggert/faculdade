package br.com.ahe.poo.um.provas.p4;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAgenda {

    private Date data;
    private String efemeride;
    private Map<String, Compromisso> compromissos;

    public DataAgenda() {
        this.compromissos = new HashMap<String, Compromisso>();
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEfemeride() {
        return this.efemeride;
    }

    public void setEfemeride(String efemeride) {
        this.efemeride = efemeride;
    }

    public Map<String, Compromisso> getCompromissos() {
        return this.compromissos;
    }

    public int getTempoMedio() {
        int total = this.compromissos.size();
        int soma = 0;
        for (Compromisso c : this.compromissos.values()) {
            soma += c.getTempo();
        }
        return soma / total;
    }

    public void addCompromisso(Compromisso compromisso) {
        if(existeCompromisso(compromisso.getHora()))
            throw new ArrayStoreException();
        else
            this.compromissos.put(compromisso.getHora(), compromisso);
    }

    public List<Compromisso> getCompromissosPrioridade(char prioridade) {
        List<Compromisso> compromissosAux = new ArrayList<Compromisso>();
        for (Compromisso c : this.compromissos.values()) {
            if (c.getPrioridade() == prioridade) {
                compromissosAux.add(c);
            }
        }
        return compromissosAux;
    }

    public int getQtdCompromissosPrioridade(char prioridade) {
        return getCompromissosPrioridade(prioridade).size();
    }

    public String getDadosCompromissosPrioridade(char prioridade) {
        StringBuilder s = new StringBuilder();

        for (Compromisso c : getCompromissosPrioridade(prioridade)) {
            s.append(c.toString()).append("\n\r");
        }

        return s.toString();
    }

    public boolean existeCompromisso(String hora) {
        return this.compromissos.get(hora) != null;
    }
}
