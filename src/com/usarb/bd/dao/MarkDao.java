package com.usarb.bd.dao;


import com.usarb.bd.entities.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkDao {
    private static final String QUERY = "select * from marks where id =?";

    public Mark getMark(int markId) throws SQLException {
        Mark mark = new Mark();
        Connection connection = null;
        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            mark.setId(rs.getInt("id"));
            mark.setValue(rs.getDouble("value"));
            mark.setCreatedDate(rs.getDate("create_data"));
          //  mark.setDiscipline(rs.getDiscipline(""));
          //student, teacher ,discipline
            System.out.println(mark.getId() + "," + mark.getValue() + "," + mark.getCreatedDate() );
        }
        return mark;
    }
}