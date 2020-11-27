package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDao {
    private static final String QUERY = "select * from phones where id =?";

    public Phone getPhone(int addressId) throws SQLException {
        Phone phone = new Phone();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            phone.setId(rs.getInt("id"));
            phone.setValue(rs.getString("value"));


            System.out.println(phone.getId() + "," + phone.getValue());
        }
        return phone;
    }
}