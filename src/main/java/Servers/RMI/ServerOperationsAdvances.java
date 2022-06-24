package Servers.RMI;

import Servers.ServerAdvances;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
    What is RMI registry in Java?

    A Java RMI registry is a simplified name service that allows clients to get a reference (a stub) to
    a remote object. In general, a registry is used (if at all) only to locate the first remote
    object a client needs to use.
 */


public class ServerOperationsAdvances {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.createRegistry(3000);
            ServerAdvances advances = new ServerAdvances();
            registry.rebind("ServerAdvance", advances);
            System.out.println("The Server Advance already");
        }catch (Exception e){
            System.out.println("Server Advance error" + e.getMessage());
        }
    }
}
