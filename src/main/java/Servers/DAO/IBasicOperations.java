package Servers.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBasicOperations extends Remote {
    public long sum(long a, long b) throws RemoteException;
    public long subtraction(long a, long b) throws RemoteException;
    public long multiplication(long a, long b) throws RemoteException;
    public long division(long a, long b) throws RemoteException;
}
