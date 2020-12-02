package com.usarb.bd.dao;



import com.usarb.bd.entities.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkDao {
    private static final String QUERY = "select * from marks where id =?";
 private Connection connection;
    public MarkDao(Connection connection) {
        this.connection = connection;
    }


    public Mark getMark(int markId) throws SQLException {
        Mark mark = new Mark();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, markId);


        ResultSet rs = preparedStatement.executeQuery();
        StudentDao studentDao = new StudentDao(connection);
        DisciplineDao disciplineDao  = new DisciplineDao(connection);
        TeacherDao teacherDao = new TeacherDao(connection);

        while (rs.next()) {
            mark.setId(rs.getInt("id"));
            mark.setValue(rs.getDouble("value"));
          mark.setStudent(studentDao.getStudent(rs.getInt("student_id")));
            mark.setDiscipline(disciplineDao.getDiscipline(rs.getInt("discipline_id")));
           mark.setTeacher(teacherDao.getTeacher(rs.getInt("teacher_id")));
            mark.setCreatedDate(rs.getDate("create_data"));
            System.out.println(mark.getId() + "," +
                    mark.getValue() + "," +
                    mark.getCreatedDate() + "," +
                    mark.getDiscipline() + "," +
                    mark.getTeacher() + "," +
                    mark.getStudent() );
        }
        return mark;
    }
}