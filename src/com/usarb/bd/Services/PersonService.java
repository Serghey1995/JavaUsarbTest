package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.PersonDao;
import com.usarb.bd.entities.Person;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonService {
    private PersonDao personDao;
    public PersonService() {
        System.out.println("2а мы в сервисе");
        Connection connection = new BdConnection().getConnection();
        this.personDao = new PersonDao(connection);

    }
    public String hello(){
        return "fefe";
    }
//    public static PersonService getInstance() {
//        if (personService == null) {
//            studentService = new PersonService();
//        }
//        return studentService;
//    }
//    public Person getPerson() throws SQLException {
//        System.out.println("2б пытаемся получить персон");
//     return personDao.getPerson(1);
//
//    }
}
