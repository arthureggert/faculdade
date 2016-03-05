package br.com.ahe.poo.um.provas.p5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    public static boolean isVazio(String s) {
        return s == null || s.isEmpty();
    }

    public static Date dataBr(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(data);
        } catch (Exception e) {
            return null;
        }
    }
}
