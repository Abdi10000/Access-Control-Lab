// Created by group 111
// Course: Data Security
// Autumn 2022

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


// client part
public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        // From server 5099 in ApplicationServer.java file
        Service service = (Service) Naming.lookup("rmi://localhost:3000/printer");

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

        boolean status = service.credentials(username, password, userid);

        if (status) {

            System.out.println("--- " + "You got access to the printer");
            System.out.println();


            // testing the program using the methods/functions from the Server.java file
            System.out.println("--- " + service.print("picture.pdf", "X2"));
            System.out.println("--- " + service.queue("X2"));
            System.out.println("--- " + service.topQueue("X2", 2));
            System.out.println("--- " + service.start());
            System.out.println("--- " + service.stop());
            System.out.println("--- " + service.restart());
            System.out.println("--- " + service.status("printer status"));
            System.out.println("--- " + service.readConfig("token"));
            System.out.println("--- " + service.setConfig("map", "treasure"));
        }


        // goals:
        // done with inserting employees in the database
        // done with giving every employee an access control credential level in the database



        // include login attempts
        // include hashed and salted values for password in the database
        // hide password
        // control input of big letters and small letters



        //if () {
            // root admin
            //System.out.println("--- " + service.print("picture.pdf", "X2"));
            //System.out.println("--- " + service.queue("X2"));
            //System.out.println("--- " + service.topQueue("X2", 2));
            //System.out.println("--- " + service.start());
            //System.out.println("--- " + service.stop());
            //System.out.println("--- " + service.restart());
            //System.out.println("--- " + service.status("printer status"));
            //System.out.println("--- " + service.readConfig("token"));
            //System.out.println("--- " + service.setConfig("map", "treasure"));
        //}


        //else if () {
            // technician
            //System.out.println("--- " + service.start());
            //System.out.println("--- " + service.stop());
            //System.out.println("--- " + service.restart());
            //System.out.println("--- " + service.status("printer status"));
            //System.out.println("--- " + service.readConfig("token"));
            //System.out.println("--- " + service.setConfig("map", "treasure"));
        //}



        //else if () {
            // power user
            //System.out.println("--- " + service.print("picture.pdf", "X2"));
            //System.out.println("--- " + service.queue("X2"));
            //System.out.println("--- " + service.topQueue("X2", 2));
            //System.out.println("--- " + service.restart());
        //}


        //else if () {
            // ordinary user
            //System.out.println("--- " + service.print("picture.pdf", "X2"));
            //System.out.println("--- " + service.queue("X2"));
        //}


        else {
            System.out.println("You are not authorized to use this printer");
        }
        scanner.close();
    }
}