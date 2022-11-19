// Created by group 111
// Course: Data Security
// Autumn 2022
// Program File for Role-Based Access Control

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {

    public static void main(String[] args) throws RemoteException {

        Registry registry = LocateRegistry.createRegistry(2000);
        registry.rebind("printer", new Server());
        System.out.println("Server is starting up");
    }
}