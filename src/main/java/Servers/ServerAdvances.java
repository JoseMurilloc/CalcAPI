package Servers;
import Servers.DAO.IAdvanceOperations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerAdvances extends UnicastRemoteObject implements IAdvanceOperations {
    public ServerAdvances() throws RemoteException {
        super();
    }

    public long percentage(long a, long b) throws RemoteException {
        return (a * b)/100;
    }

    public long potency(long a, long b) throws RemoteException {
        return (long) Math.pow(a, b);
    }

    public long sqrt(long a) throws RemoteException {
        return (long)Math.sqrt(a);
    }
}
