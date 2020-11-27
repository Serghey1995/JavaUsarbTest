package com.usarb.bd.connection;

import com.usarb.bd.entities.*;

import java.sql.*;
import java.util.Date;
import java.util.List;

// пиздануть 9
public class BdConnection {
    // менять значение querry в зависимости от dao
    // пиздануть 9
    // private static final String QUERY = "select * from teachers where id =?";

    //  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    //    getConnection();
    //}
    //   public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        String userName = "postgres";
//        String password = "postgres";
//        String connectionURL = "jdbc:postgresql://localhost:5432/UsarbTest";
//        Connection con;
//        Class.forName("org.postgresql.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
//            con = connection;
//            System.out.println("1 Подключены");
//            // c 24 по 38  копировать
//            // в зависимости от значения запроса QUERY в prepareStatement добавлять необходимые параметры
//           // PreparedStatement preparedStatement = con.prepareStatement(QUERY);
//           // preparedStatement.setInt(1, 1);
//
//           // System.out.println(preparedStatement);
//         //   ResultSet rs = preparedStatement.executeQuery();
//            // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
//         //   while (rs.next()) {
//              //  int id = rs.getInt("id");
//            //    Double salary = rs.getDouble("salary");
//
//
//            //    System.out.println(id+","+salary);
//            }
//
//      //  }
//        return con;
//    }
    // JDBC driver and name database URL
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




