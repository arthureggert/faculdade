package utils;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AFormaterUtils {
	
	public static Date DataBR(String data){
		try {
			 SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
			 return SDF.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean isVazio(String str){
		return (str == null || str.isEmpty());
	}
	
    public static String formataMoeda(double numero) {
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("R$ 00.00");

        return format.format(numero);
    }

}
