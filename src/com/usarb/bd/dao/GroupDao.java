package com.usarb.bd.dao;

import com.usarb.bd.entities.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao {
    private static final String QUERY = "select * from groups where id =?";
    private Connection connection;

    public GroupDao(Connection connection) {
        this.connection = connection;
    }

    public Group getGroup(int groupId) throws SQLException {
        Group group = new Group();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, groupId);



        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));

            System.out.println(group.getId() + "," +
                    group.getName());
        }
        return group;
    }
}