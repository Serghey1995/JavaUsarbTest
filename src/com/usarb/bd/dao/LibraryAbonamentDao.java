package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.LibraryAbonament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryAbonamentDao {
    private static final String QUERY = "select * from library_abonaments where id =?";
    private Connection connection;

    public LibraryAbonamentDao(Connection connection) {
        this.connection = connection;

    }

    public LibraryAbonament getLibraryAbonament(int LibraryAbonamentId) throws SQLException {
        LibraryAbonament lb = new LibraryAbonament();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, LibraryAbonamentId);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            lb.setId(rs.getInt("id"));
            lb.setStatus(rs.getString("status"));
            lb.setStartDate(rs.getDate("start_date"));
            lb.setEndDate(rs.getDate("end_date"));
            System.out.println(lb.getId() + "," +
                               lb.getStatus() + "," +
                               lb.getStartDate() + "," +
                               lb.getEndDate());
        }
        return lb;
    }
}