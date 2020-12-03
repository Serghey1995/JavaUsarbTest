package com.usarb.bd.dao;

import com.usarb.bd.entities.Average;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AverageDao {
    private static final String QUERY = "Select a.id,a.student_id,a.discipline_id,value\n" +
            "From students\n" +
            "inner join disciplines_to_students dts on students.id = dts.student_id\n" +
            "inner join disciplines d on d.id = dts.discipline_id\n" +
            "inner join averages a on students.id = a.student_id and a.discipline_id=d.id\n" +
            "where students.id = ?" ;
    private Connection connection;

    public AverageDao(Connection connection) {
        this.connection = connection;
    }

    public List<Average> getAverageList(int studentId) throws SQLException {
        List<Average> listAverage = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1,studentId);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
       StudentDao studentDao = new StudentDao(connection);
        DisciplineDao disciplineDao = new DisciplineDao(connection);

        while (rs.next()) {
            Average average = new Average();
            average.setId(rs.getInt("id"));
            average.setStudent(studentDao.getStudent(rs.getInt("student_id")));
            average.setDiscipline(disciplineDao.getDiscipline(rs.getInt("discipline_id")));
            average.setValue(rs.getDouble("value"));
            System.out.println(average.getId() + "," +
                    average.getValue() + "," +
                    average.getStudent() + "," +
                    average.getDiscipline());
            listAverage.add(average);
        }
        return listAverage;
    }

}