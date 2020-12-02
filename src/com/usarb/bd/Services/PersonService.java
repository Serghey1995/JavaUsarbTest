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

    /*public String getStr(String s) {
        return s;
    }

    public List<String> getList(List<String> stringList) {
        stringList.add("gmege");
        return stringList;
    }


    public List<String> hello(ArrayList<String> list) {
        List<String> list1 = new ArrayList<>();
        list1.add("ejge");
        return list1;
    }

    // String в данном примере представляет из себя какой то результат
    // в зависимости от метода тип данных может изменяться
    public String getServlet(String urlPath) {
        String result = getService("some command");
        return result;
    }

    public String getService(String whatCommandNeedToDo) {
        String createdConnection="connection";
        String result = getDao("send Id for concrete Dao to return result",createdConnection,whatCommandNeedToDo);
        return result;
    }

    public String getDao(String concreteId,String createdConnection,String command) {
        String result = getFromDb("get concrete entity from concrete tables by something id,use sql query",createdConnection);
        return result;
    }

    public String getFromDb(String concreteId, String connection) {
        String result = "result полученный при подключении к базе бд используя connection";
        return result;
    }*/


