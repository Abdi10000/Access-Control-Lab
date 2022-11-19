// Created by group 111
// Course: Data Security
// Autumn 2022
// Program File for Access Control List

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {

    String print(String filename, String printer) throws RemoteException;

    String queue(String printer) throws RemoteException;

    String topQueue(String printer, int job) throws RemoteException;

    String start() throws RemoteException;

    String stop() throws RemoteException;

    String restart() throws RemoteException;

    String status(String printer) throws RemoteException;

    String readConfig(String parameter) throws RemoteException;

    String setConfig(String parameter, String value) throws RemoteException;

    boolean credentials(String username, String password, int userID) throws RemoteException;

    String access(int userid) throws RemoteException;
}