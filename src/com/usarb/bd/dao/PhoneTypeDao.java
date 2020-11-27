package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.PhoneType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneTypeDao {
    private static final String QUERY = "select * from phone_types where id =?";

    public PhoneType getPhoneType(int phoneTypeId) throws SQLException {
        PhoneType pt = new PhoneType();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            pt.setId(rs.getInt("id"));
            pt.setName(rs.getString("name"));

            System.out.println(pt.getId() + "," + pt.getName());
        }
        return pt;
    }
}