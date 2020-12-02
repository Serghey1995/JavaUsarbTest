package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.PhoneDao;
import com.usarb.bd.entities.Phone;

import java.sql.Connection;
import java.sql.SQLException;

public class PhoneService {
    private PhoneDao phoneDao;

    public PhoneService(){
        Connection connection = new BdConnection().getConnection();
        this.phoneDao= new PhoneDao(connection);
    }
    public Phone getPhone() throws SQLException {
        return phoneDao.getPhone(1);
    }
}
