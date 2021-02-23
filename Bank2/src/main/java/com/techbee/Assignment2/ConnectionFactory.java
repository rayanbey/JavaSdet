package com.techbee.Assignment2;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://bankaccounts.cdst7y4ceke1.us-west-1.rds.amazonaws.com:3306/BankAccount?useSSL=false";
    public static final String USER = "admin";
    public static final String PASS = "mypassword";
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
