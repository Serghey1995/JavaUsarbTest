package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.MarkDao;
import com.usarb.bd.entities.Mark;

import java.sql.Connection;
import java.sql.SQLException;

public class MarkService {
    private MarkDao markDao;

    public MarkService(){
        Connection connection = new BdConnection().getConnection();
        this.markDao= new MarkDao(connection);
    }
    public Mark getMark() throws SQLException {
        return markDao.getMark(1);
    }
}
