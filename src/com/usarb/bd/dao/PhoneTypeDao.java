package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.PhoneType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneTypeDao {
    private static final String QUERY = "select * from phone_types where id =?";
    private Connection connection;

    public PhoneTypeDao(Connection connection) {
        this.connection = connection;
    }

    public PhoneType getPhoneType(int phoneTypeId) throws SQLException {
        PhoneType pt = new PhoneType();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, phoneTypeId);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            pt.setId(rs.getInt("id"));
            pt.setName(rs.getString("name"));

            System.out.println(pt.getId()
                    + "," + pt.getName());
        }
        return pt;
    }
}