package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.GroupDao;
import com.usarb.bd.entities.Group;

import java.sql.Connection;
import java.sql.SQLException;

public class GroupService {
    private GroupDao groupDao;

    public GroupService() {
        Connection connection = new BdConnection().getConnection();
        this.groupDao = new GroupDao(connection);
    }

    public Group getGroup() throws SQLException {
     return groupDao.getGroup(1);

    }
}