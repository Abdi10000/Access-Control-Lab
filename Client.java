// Created by group 111
// Course: Data Security
// Autumn 2022
// Program File for Role-Based Access Control

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


// client part
public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        // From server 2000 in ApplicationServer.java file
        Service service = (Service) Naming.lookup("rmi://localhost:2000/printer");

        Scanner scanner = new Scanner(System.in);

        // username input
        System.out.println("Enter username: ");
        String username = scanner.next();

        // password input
        System.out.println("Enter password: ");
        String password = scanner.next();

        // This input is meant to be id card from the job,
        // scan your user id on the printer
        System.out.println("Enter User ID: ");
        int userid = scanner.nextInt();

        // variable for handling login credentials
        boolean status = service.credentials(username, password, userid);

        // method to print out, printer functions the user is allowed to use
        String methodAccessible = service.access(userid);

        if (status) {
            System.out.println("--- " + "You got access to the printer");
            System.out.println("--- " + "You have access to these functions: ");
            System.out.println(methodAccessible);
        } else {
            System.out.println("--- " + "You are not authorized to use this printer");
        }
        scanner.close();
    }
}