package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.TeacherDao;
import com.usarb.bd.entities.Teacher;

import java.sql.Connection;
import java.sql.SQLException;

public class TeacherService {
    private TeacherDao teacherDao;

    public TeacherService(){
        Connection connection = new BdConnection().getConnection();
        this.teacherDao = new TeacherDao(connection);
    }
    public Teacher getTeacher() throws SQLException {
        return teacherDao.getTeacher(1);
    }
}
