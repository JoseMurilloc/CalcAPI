package Servers;

import Servers.DAO.IBasicOperations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerBasics extends UnicastRemoteObject implements IBasicOperations {
    public ServerBasics() throws RemoteException {
        super();
    }

    public long sum(long a, long b) throws RemoteException {
        return a + b;
    }

    public long subtraction(long a, long b) throws RemoteException {
        return a - b;
    }

    public long multiplication(long a, long b) throws RemoteException {
        return a * b;
    }

    public long division(long a, long b) throws RemoteException {
        return a / b;
    }
}
