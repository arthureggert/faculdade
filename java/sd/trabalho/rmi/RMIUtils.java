package br.com.ahe.sd.trabalho.rmi;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import lombok.extern.java.Log;

@Log
public class RMIUtils {

    public static String getNome() {
        return "IFuncoesRMI";
    }

    public static void runServer() {
        try {
            IFuncoesRMIImpl obj = new IFuncoesRMIImpl();
            IFuncoesRMI stub = (IFuncoesRMI) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(getNome(), stub);
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    public static IFuncoesRMI getFuncoesRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            IFuncoesRMI stub = (IFuncoesRMI) registry.lookup(getNome());
            return stub;
        } catch (AccessException e) {
            log.severe(e.getMessage());
        } catch (RemoteException e) {
            log.severe(e.getMessage());
        } catch (NotBoundException e) {
            log.severe(e.getMessage());
        }
        return null;
    }
}
