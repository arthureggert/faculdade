package br.com.ahe.poo.dois.prova.Imovel;

public class ErroNoCadastroException extends Throwable {
    
	private static final long serialVersionUID = 1L;

    public ErroNoCadastroException(String msgErro) {
    	super(msgErro);
    }
    
    @Override
    public void printStackTrace() {
    	String str = "";
    	str += "Problema ao executar a��o.\n" + "MOTIVO: ";
    	System.out.println(str);
    	super.printStackTrace();
    }

}
