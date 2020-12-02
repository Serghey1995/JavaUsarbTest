package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao {
    private static final String QUERY = "select * from addresses where id =?";
    private Connection connection;
    public AddressDao(Connection connection) {
        this.connection=connection;
    }

    public Address getAddress(int addressId) throws SQLException {
        Address address = new Address();

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, addressId);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            address.setId(rs.getInt("id"));
            address.setCountry(rs.getString("country"));
            address.setCity(rs.getString("city"));
            address.setAddress(rs.getString("address"));
            System.out.println(address.getId() + "," +
                    address.getCountry() + "," +
                    address.getCity() + "," +
                    address.getAddress());
        }
        return address;
    }
}