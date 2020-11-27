package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
    private static final String QUERY = "select * from student where id =?";

    public Student getStudent(int studentId) throws SQLException {
        Student student = new Student();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
           // student.setId(rs.getInt("id"));
            //
            System.out.println();
        }
        return student;
    }
}