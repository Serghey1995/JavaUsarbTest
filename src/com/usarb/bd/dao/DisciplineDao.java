package com.usarb.bd.dao;

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Discipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplineDao {
    private static final String QUERY = "select * from disciplines where id =?";

    public Discipline getDiscipline(int disciplineId) throws SQLException {
        Discipline discipline = new Discipline();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            discipline.setId(rs.getInt("id"));
            discipline.setTitle(rs.getString("title"));
            //discipline.setTeacher();
            System.out.println(discipline.getId() + "," + discipline.getTitle());
        }
        return discipline;
    }
}