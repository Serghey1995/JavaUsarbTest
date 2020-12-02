package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.AddressDao;
import com.usarb.bd.entities.Address;

import java.sql.Connection;
import java.sql.SQLException;

public class AddressService {
    private AddressDao addressDao;

    public AddressService() {
        Connection connection = new BdConnection().getConnection();
        this.addressDao = new AddressDao(connection);
    }
    public Address getAddress() throws SQLException {
        return addressDao.getAddress(1);
    }
}
