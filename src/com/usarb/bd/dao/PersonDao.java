package com.usarb.bd.dao;



import com.usarb.bd.entities.Person;
import com.usarb.bd.entities.Phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private static final String QUERY = "select * from persons where id =?";
    private Connection connection;
    public PersonDao(Connection connection) { this.connection = connection; }


    public Person getPerson(int personId) throws SQLException {
        Person person = new Person();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, personId);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
         AddressDao addressDao = new AddressDao(connection);
        PhoneDao phoneDao = new PhoneDao(connection);
        LibraryAbonamentDao libraryAbonamentDao = new LibraryAbonamentDao(connection);



        while (rs.next()) {
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setDateOfBirth(rs.getDate("date_of_birth"));
            person.setGender(rs.getString("date_of_birth").charAt(0));
            person.setPicture(rs.getBytes("picture"));
            person.setMail(rs.getString("mail"));
            person.setAddress(addressDao.getAddress(rs.getInt("address_id")));
            person.setLibraryAbonament(libraryAbonamentDao.getLibraryAbonament(rs.getInt("library_abonament_id")));

            System.out.println(person.getId() + "," +
                    person.getFirstName() + "," +
                    person.getLastName() + "," +
                    person.getDateOfBirth() + "," +
                    person.getGender() + "," +
                    person.getPicture() + "," +
                    person.getMail()+ "," +
                    person.getAddress().getCity()+ "," +
                    person.getLibraryAbonament().getStatus()
            );
            List<Phone> phones = new ArrayList<>();
            Phone phone = phoneDao.getPhone(rs.getInt("id"));
            phones.add(phone);
            person.setPhones(phones);
        }
        return person;
    }
    public List<Person> getPersonList() throws SQLException {
        List<Person> personList = new ArrayList<>();
        String query = "select * from persons";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        AddressDao addressDao = new AddressDao(connection);
        PhoneDao phoneDao = new PhoneDao(connection);
        LibraryAbonamentDao libraryAbonamentDao = new LibraryAbonamentDao(connection);
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setDateOfBirth(rs.getDate("date_of_birth"));
            person.setGender(rs.getString("date_of_birth").charAt(0));
            person.setPicture(rs.getBytes("picture"));
            person.setMail(rs.getString("mail"));
            person.setAddress(addressDao.getAddress(rs.getInt("address_id")));
            person.setLibraryAbonament(libraryAbonamentDao.getLibraryAbonament(rs.getInt("library_abonament_id")));
            person.setPhones(phoneDao.getPhoneList(rs.getInt("id")));
            personList.add(person);

        }
//        for (int i = 0; i <personList.size() ; i++) {
//            List<Phone> phones = personList.get(i).getPhones();
//          System.out.println(personList.get(i).getFirstName()+" "
//                  + personList.get(i).getLastName()+" "
//                  + phones);
//       }


        return  personList;
    }
}