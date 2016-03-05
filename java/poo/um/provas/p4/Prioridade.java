package br.com.ahe.poo.um.provas.p4;


public class Prioridade {

    public static final char ALTA = 'A';
    public static final char NORMAL = 'N';
    public static final char BAIXA = 'B';

    public static String getDescricaoPrioridade(char prioridade){
        switch(prioridade) {
            case ALTA : return "Alta";
            case BAIXA : return "Baixa";
            case NORMAL : return "Normal";
        }

        return "";
    }

}
