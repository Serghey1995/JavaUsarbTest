package com.usarb.bd.dao;

import com.usarb.bd.entities.Discipline;
import com.usarb.bd.entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String QUERY = "select * from student where id =?";
    private Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    public Student getStudent(int studentId) throws SQLException {
        Student student = new Student();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, studentId);


        ResultSet rs = preparedStatement.executeQuery();
        GroupDao groupDao = new GroupDao(connection);
        DisciplineDao disciplineDao = new DisciplineDao(connection);
        while (rs.next()) {
           student.setGroup(groupDao.getGroup(rs.getInt("group_id")));
            List<Discipline> disciplines = new ArrayList<>();
            Discipline discipline = disciplineDao.getDiscipline(rs.getInt("id"));
            disciplines.add(discipline);
            student.setDisciplines(disciplines);

            System.out.println(student.getGroup());
        }
        return student;
    }
}