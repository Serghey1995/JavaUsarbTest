package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.PhoneTypeDao;
import com.usarb.bd.entities.PhoneType;

import java.sql.Connection;
import java.sql.SQLException;

public class PhoneTypeService {
    private PhoneTypeDao phoneTypeDao;

    public PhoneTypeService(){
        Connection connection = new BdConnection().getConnection();
        this.phoneTypeDao = new PhoneTypeDao(connection);
    }
    public PhoneType getPhoneType() throws SQLException {
        return phoneTypeDao.getPhoneType(1);
    }
}
