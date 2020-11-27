package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Average;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageDao {
    private static final String QUERY = "select * from averages where id =?";

    public Average getAverage(int averageId) throws SQLException {
        Average average = new Average();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            average.setId(rs.getInt("id"));
            average.setValue(rs.getDouble("value"));
            System.out.println(average.getId() + "," + average.getValue());
        }
        return average;
    }
}