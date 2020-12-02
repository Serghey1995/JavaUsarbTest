package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.AverageDao;
import com.usarb.bd.entities.Average;

import java.sql.Connection;
import java.sql.SQLException;


public class AverageService {
    private AverageDao averageDao;



    public AverageService() {
        Connection connection = new BdConnection().getConnection();
        this.averageDao = new AverageDao(connection);
    }
    public Average getAverage() throws SQLException {
        return averageDao.getAverage(1);
    }
}
