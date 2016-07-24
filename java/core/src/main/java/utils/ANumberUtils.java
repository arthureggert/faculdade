package utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ANumberUtils {
	
	public static BigDecimal getBigDecimalCEM(){
		return new BigDecimal("100");
	}

	public static Integer getRandomNumer() {
		return ARandomUtils.getInstance().getRandomNumber();
	}
	
	public static Integer getRandomNumberWithMaxNumber(int maxNumero) {
		return ARandomUtils.getInstance().getRandomNumerMaxNumber(maxNumero);
	}
	
	public static Integer getRandomPositiveNumber(){
		Integer num = -1;
		while(num < 0){
			num = ARandomUtils.getInstance().getRandomNumber();
		}
		return num;
	}
	
    public static String formataMoeda(double numero) {
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("R$ 00.00");
        return format.format(numero);
    }

}
