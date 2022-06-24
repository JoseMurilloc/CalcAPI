package Servers.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdvanceOperations extends Remote {
    public long percentage(long a, long b) throws RemoteException;
    public long potency(long a, long b) throws RemoteException;
    public long sqrt(long a) throws RemoteException;
}
