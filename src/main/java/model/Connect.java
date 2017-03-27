package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection conn;

    //netstat -an -P TCP
    public Connection getSQLServerConnection()
            throws SQLException, ClassNotFoundException {
        String hostName = "ec2-54-243-185-132.compute-1.amazonaws.com";
        String database = "dfjlsru78osr4g";
        String userName = "hrnttbjqqfyiei";
        String password = "863507b5b58a9ff02f9e2f88c1be3d03ac4abf2fe155a7c2b125dea841789c2b";

        return getSQLServerConnection(hostName, database, userName, password);
    }

    public Connection getSQLServerConnection(String hostName, String database, String userName, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + database + "?sslmode=require";

            conn = DriverManager.getConnection(connectionURL, userName, password);
//            System.out.println("thanh cong");
        } catch (Exception e) {
            System.out.println("that bai " + e);
        }
        return conn;
    }
}
