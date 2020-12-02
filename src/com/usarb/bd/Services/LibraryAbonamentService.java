package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.LibraryAbonamentDao;
import com.usarb.bd.entities.LibraryAbonament;

import java.sql.Connection;
import java.sql.SQLException;

public class LibraryAbonamentService {
    private LibraryAbonamentDao libraryAbonamentDao;

    public LibraryAbonamentService(){
        Connection connection = new BdConnection().getConnection();
        this.libraryAbonamentDao = new LibraryAbonamentDao(connection);
    }
    public LibraryAbonament getLibraryAbonament() throws SQLException {
        return libraryAbonamentDao.getLibraryAbonament(1);
    }
}
