package br.com.ahe.sd.corba.calculadora;

@SuppressWarnings({"all"})
class calc_numericaImpl extends calc_numericaPOA {  

	public boolean soma_int (short p1, short p2, org.omg.CORBA.ShortHolder ret) {
		ret.value = new Integer(p1 + p2).shortValue();
		System.out.println("Executada Soma");
		return true;
	};

	public boolean sub_int (short p1, short p2, org.omg.CORBA.ShortHolder ret) {
		ret.value = new Integer(p1 - p2).shortValue();
		System.out.println("Executada Subtra��o");
		return true;
	};

	public boolean div_double (double p1, double p2, org.omg.CORBA.ShortHolder ret) {
		ret.value = new Double(p1 / p2).shortValue();
		System.out.println("Executada Divis�o");  	  
		return true;

	};

	public boolean mul_double (double p1, double p2, org.omg.CORBA.ShortHolder ret) {
		ret.value = new Double(p1 * p2).shortValue();
		System.out.println("Executada Multiplica��o");  	  
		return true;

	};


}