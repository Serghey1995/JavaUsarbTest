package com.usarb.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "postgres";
        String password = "postgres";
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection(connectionURL,
                userName,
                password)){
            System.out.println("Подключены");
        }
    }
}
