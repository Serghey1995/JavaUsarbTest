package com.usarb.bd.dao;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.entities.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao {
    private static final String QUERY = "select * from addresses where id =?";

    public Address getAddress(int addressId) throws SQLException {
        Address address = new Address();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            address.setId(rs.getInt("id"));
            address.setCountry(rs.getString("country"));
            address.setCity(rs.getString("city"));
            address.setAddress(rs.getString("address"));
            System.out.println(address.getId() + "," + address.getCountry() + "," + address.getCity() + "," + address.getAddress());
        }
        return address;
    }
}