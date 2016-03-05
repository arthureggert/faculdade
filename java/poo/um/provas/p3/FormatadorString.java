package br.com.ahe.poo.um.provas.p3;
/** Arthur Henrique Eggert **/

import java.text.DecimalFormat;

public class FormatadorString {

    public static boolean isVazio(String s) {
        return s == null || s.isEmpty();
    }

    public static String formataMoeda(double numero) {
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("R$ 00.00");

        return format.format(numero);
    }
}
