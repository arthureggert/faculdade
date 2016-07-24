package utils;


import java.util.Random;

public class ARandomUtils {

	private static ARandomUtils instance;
	
	private Random random;
	
	public static ARandomUtils getInstance() {
		return AObjectUtils.isObjectNull(instance) ? new ARandomUtils() : instance;
	}
	
	private ARandomUtils() {
		this.random = new Random();
	}

	public Integer getRandomNumber(){
		return this.random.nextInt();
	}
	
	public Integer getRandomNumerMaxNumber(int maxNumero){
		return this.random.nextInt(maxNumero);
	}
	
}
