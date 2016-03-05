package br.com.ahe.sd.trabalho.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFuncoesRMI extends Remote {

    public void comprarAcao(String codEmpresa , String usuario , double quantidade, double valor) throws RemoteException;

    public void venderAcao(String codEmpresa , String usuario , double quantidade, double valor) throws RemoteException;

    public String getLastError() throws RemoteException;

}
