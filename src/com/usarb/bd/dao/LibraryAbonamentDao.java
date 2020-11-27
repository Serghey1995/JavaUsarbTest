package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.LibraryAbonament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryAbonamentDao {
    private static final String QUERY = "select * from library_abonaments where id =?";

    public LibraryAbonament getLibraryAbonament(int LibraryAbonamentId) throws SQLException {
        LibraryAbonament lb = new LibraryAbonament();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            lb.setId(rs.getInt("id"));
            lb.setStatus(rs.getString("status"));
            lb.setStartDate(rs.getDate("start_data"));
            lb.setEndDate(rs.getDate("end_data"));
            System.out.println(lb.getId() + "," + lb.getStatus() + "," + lb.getStartDate() + "," + lb.getEndDate());
        }
        return lb;
    }
}