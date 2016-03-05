/** HelloServer.java **/
package br.com.ahe.sd.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloWorld {
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	public HelloServer() throws RemoteException {
		super();
	}

	// main()
	public static void main(String[] args) {
		try {
			HelloServer obj = new HelloServer();
			Naming.rebind("//localhost/HelloWorld", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		} 
	}

	// hello()
	public String hello() throws RemoteException {
		System.out.println("Executando hello()");
		return "Hello!!!";
	}


}
