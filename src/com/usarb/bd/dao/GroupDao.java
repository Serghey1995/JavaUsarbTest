package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao {
    private static final String QUERY = "select * from groups where id =?";

    public Group getGroup(int groupId) throws SQLException {
        Group group = new Group();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));

            System.out.println(group.getId() + "," + group.getName());
        }
        return group;
    }
}