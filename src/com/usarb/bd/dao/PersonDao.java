package com.usarb.bd.dao;
// нужно доделать phone

import com.usarb.bd.entities.Address;
import com.usarb.bd.entities.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDao {
    private static final String QUERY = "select * from persons where id =?";
    private Connection connection;

    public PersonDao(Connection connection) {
        this.connection = connection;
    }

    public Person getPerson(int personId) throws SQLException {
        System.out.println("3a метод getperson в персон дао");
        Person person = new Person();

        //Доделать на 16 строчке код таким образов , чтобы он получал из файла bdconnection
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, personId);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        // обрабатываем полученный результат запроса и добавляем в обьект, к которому сделан DAO
        while (rs.next()) {
            System.out.println("3б запись данных в персон");
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setDateOfBirth(rs.getDate("date_of_birth"));
            person.setGender(rs.getString("date_of_birth").charAt(0));
            person.setPicture(rs.getBytes("picture"));
            person.setMail(rs.getString("mail"));
            //person.setAddress(rs.getInt("address_id"));
            //  person.setLibraryAbonament(rs.getInt("library_abonament_id"));
            System.out.println(person.getId() + "," + person.getFirstName() + "," + person.getLastName() + "," + person.getDateOfBirth() + "," + person.getGender() + "," + person.getPicture() + "," + person.getMail());
        }
        return person;
    }
}