/*
package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.AverageDao;
import com.usarb.bd.entities.Average;
import com.usarb.bd.entities.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class AverageService {
    private AverageDao averageDao;



    public AverageService() {
        Connection connection = new BdConnection().getConnection();
        this.averageDao = new AverageDao(connection);
    }
    public List<Average> getAverageList(List<Student> studentList) throws SQLException {
        for (Student student: studentList) {
            averageDao.getAverageList();
        }
       return averageDao.getAverageList( );
    }
}
*/
