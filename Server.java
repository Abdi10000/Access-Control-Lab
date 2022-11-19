// Created by group 111
// Course: Data Security
// Autumn 2022
// Program File for Role-Based Access Control

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class Server extends UnicastRemoteObject implements Service {

    public Server() throws RemoteException {
        super();
    }

    // a method which prints a file based on the filename and specified printer
    public String print(String filename, String printer) throws RemoteException {
        return "From server: printing the file";
    }


    // method used to list the print queue for a given printer
    public String queue(String printer) throws RemoteException {
        return "From server: Returning the list";
    }


    // method for moving the job to the top of the queue
    public String topQueue(String printer, int job) throws RemoteException {
        return "From server: Moved to top of queue";
    }


    // method for starting the server
    public String start() throws RemoteException {
        return "From server: Server started";
    }


    // method for stopping the server
    public String stop() throws RemoteException {
        return "From server: Server stopped";
    }


    // method for restarting the server
    public String restart() throws RemoteException  {
        return "From server: Server restarts";
    }


    // method for showing the status of the printer
    public String status(String printer) throws RemoteException {
        // returns the status of printer on user's display
        return "From server: Shows the status of the printer";
    }


    // method for printing the value of the parameter
    public String readConfig(String parameter) throws RemoteException {
        return "From server: printing parameter value";
    }


    // method for editing the value
    public String setConfig(String parameter, String value) throws RemoteException {
        return "From server: changing the value";
    }


    // function used to allow access to printer having the right
    // credentials stored in the database
    public boolean credentials(String username, String password, int userID) {

        try {
            String url = "jdbc:sqlite:Printer.db";
            Connection connection = getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");

            while (resultSet.next()) {
                String name = resultSet.getString("Username");
                String passWord = resultSet.getString("Password");
                int userid = resultSet.getInt("User_ID");

                if (username.equals(name) && password.equals(passWord) && userID == userid) {
                    System.out.println("Correctly logged inside the account");
                    System.out.println();
                    return true;
                } else {
                    System.out.println("User does not exist in the database");
                    System.out.println("Please check username and password again");
                    }
                }
            connection.close();
            } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    // Method used to show printer functions the user has access to
    // based on Role-Based Access Control
    public String access(int userid) {
        String accessFunction = "";

        try {
            String url = "jdbc:sqlite:Printer.db";
            Connection connection = getConnection(url);
            Statement statement = connection.createStatement();
            String sql = "SELECT Role_Details.Permission FROM Role_Details INNER JOIN Role ON Role_Details.Role_ID = Role.Role_ID WHERE Role.User_ID = '" + userid + "';";
            ResultSet resultSet1 = statement.executeQuery(sql);

            while (resultSet1 != null && resultSet1.next()) {

                accessFunction = resultSet1.getString(1);
                System.out.println(accessFunction);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return accessFunction;
    }
}