package br.com.ahe.sd.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote {
   public String hello() throws RemoteException;
}
