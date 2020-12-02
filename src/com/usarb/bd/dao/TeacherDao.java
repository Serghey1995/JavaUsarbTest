package com.usarb.bd.dao;
import com.usarb.bd.entities.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {
    private static final String QUERY = "select * from addresses where id =?";
    private Connection connection;
    public TeacherDao(Connection connection) {
        this.connection = connection;
    }

    public Teacher getTeacher(int teacherId) throws SQLException {
        Teacher t = new Teacher();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, teacherId);


        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            t.setSalary(rs.getDouble("salary"));

            System.out.println(t.getSalary());
        }
        return t;
    }
}