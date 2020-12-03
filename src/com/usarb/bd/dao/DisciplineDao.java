package com.usarb.bd.dao;

import com.usarb.bd.entities.Discipline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplineDao {
    private static final String QUERY = "select * from disciplines where id =?";
    private Connection connection;
    public DisciplineDao(Connection connection) {
        this.connection = connection;
    }


    public Discipline getDiscipline(int studentId) throws SQLException {
        Discipline discipline = new Discipline();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, studentId);


        ResultSet rs = preparedStatement.executeQuery();
        TeacherDao teacherDao = new TeacherDao(connection);
        while (rs.next()) {
            discipline.setId(rs.getInt("id"));
            discipline.setTeacher(teacherDao.getTeacher(rs.getInt("teacher_id")));
            discipline.setTitle(rs.getString("title"));
            System.out.println(discipline.getId() + "," +
                    discipline.getTitle()+ "," +
                    discipline.getTeacher().getSalary());
        }
        return discipline;
    }
}