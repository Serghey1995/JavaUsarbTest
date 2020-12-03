package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.StudentDao;
import com.usarb.bd.entities.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(){
        Connection connection = new BdConnection().getConnection();
        this.studentDao = new StudentDao(connection);
    }
    public Student getStudents() throws SQLException {
        return studentDao.getStudent(1);
    }

public List<Student> getStudentList() throws SQLException {
        return studentDao.getStudentList();
}

}
