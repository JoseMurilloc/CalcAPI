package Servers.RMI;

import Servers.ServerBasics;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
    What is RMI registry in Java?

    A Java RMI registry is a simplified name service that allows clients to get a reference (a stub) to
    a remote object. In general, a registry is used (if at all) only to locate the first remote
    object a client needs to use.
 */

public class ServerOperationsBasics {
    public static void main (String[] args){
        try{
            Registry registry = LocateRegistry.createRegistry(3333);
            ServerBasics basic = new ServerBasics();
            registry.rebind("ServerBasic", basic);
            System.out.println("The serve basic already");
        }catch (Exception e){
            System.out.println("Server Basic error" + e.getMessage());
        }
    }

    public int sum(int i, int j) {
        return i + j;
    }
}
