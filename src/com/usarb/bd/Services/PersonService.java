package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.PersonDao;
import com.usarb.bd.entities.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonService {
    private PersonDao personDao;

    public PersonService() {
        Connection connection = new BdConnection().getConnection();
        this.personDao = new PersonDao(connection);

    }

    public Person getPersons() throws SQLException {
        return personDao.getPerson(1);
    }
    public List<Person> getPersonList() throws SQLException {
        return personDao.getPersonList();
    }
}

//
