package com.usarb.bd.connection;

import java.sql.*;

public class BdConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/UsarbTest";

    //Database credentials
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public Connection getConnection() {
        System.out.println("Test connection PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC isn't found");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connected Successfully");
        } else {
            System.out.println("Failed make connection");
        }
        return connection;
    }
}




