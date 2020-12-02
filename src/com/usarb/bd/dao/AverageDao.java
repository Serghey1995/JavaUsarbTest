package com.usarb.bd.dao;

import com.usarb.bd.entities.Average;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageDao {
    private static final String QUERY = "select * from averages where id =?";
    private Connection connection;

    public AverageDao(Connection connection) {
        this.connection = connection;
    }

    public Average getAverage(int averageId) throws SQLException {
        Average average = new Average();

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, averageId);


        ResultSet rs = preparedStatement.executeQuery();
       StudentDao studentDao = new StudentDao(connection);
        DisciplineDao disciplineDao = new DisciplineDao(connection);

        while (rs.next()) {
            average.setId(rs.getInt("id"));
            average.setStudent(studentDao.getStudent(rs.getInt("student_id")));
            average.setDiscipline(disciplineDao.getDiscipline(rs.getInt("discipline_id")));
            average.setValue(rs.getDouble("value"));
            System.out.println(average.getId() + "," +
                    average.getValue() + "," +
                    average.getStudent() + "," +
                    average.getDiscipline());
        }
        return average;
    }
}