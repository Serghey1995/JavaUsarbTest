package com.usarb.bd.dao;

import com.usarb.bd.entities.Discipline;
import com.usarb.bd.entities.Person;
import com.usarb.bd.entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    public Student getStudent(int personId) throws SQLException {
String query = "   Select persons.*,s.group_id\n" +
        "            From persons\n" +
        "            inner join students s on persons.id = s.id\n" +
        "            where persons.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, personId);

        ResultSet rs = preparedStatement.executeQuery();
        PersonDao personDao = new PersonDao(connection);
        GroupDao groupDao = new GroupDao(connection);
        Student student = new Student();
        Person person = personDao.getPerson(personId);

        student.setFirstName(person.getFirstName());
        student.setLastName(person.getLastName());
        student.setDateOfBirth(person.getDateOfBirth());
        student.setGender(person.getGender());
        student.setPicture(person.getPicture());
        student.setMail(person.getMail());
        student.setAddress(person.getAddress());
        student.setLibraryAbonament(person.getLibraryAbonament());
        DisciplineDao disciplineDao = new DisciplineDao(connection);
        while (rs.next()) {
           student.setGroup(groupDao.getGroup(rs.getInt("group_id")));
            List<Discipline> disciplines = new ArrayList<>();
            Discipline discipline = disciplineDao.getDiscipline(rs.getInt("id"));
            disciplines.add(discipline);
            student.setDisciplines(disciplines);

            System.out.println(student.getGroup());
        }

        return student;
    }
    public List<Student> getStudentList() throws SQLException {
      List<Student> studentList = new ArrayList<>();
        String query = "Select p.*,s.group_id\n" +
                "From persons p\n" +
                "inner join students s on p.id = s.id";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        AddressDao addressDao = new AddressDao(connection);
        PhoneDao phoneDao = new PhoneDao(connection);
        LibraryAbonamentDao libraryAbonamentDao = new LibraryAbonamentDao(connection);
        AverageDao averageDao = new AverageDao(connection);
        while (rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            System.out.println(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setDateOfBirth(rs.getDate("date_of_birth"));
            student.setGender(rs.getString("date_of_birth").charAt(0));
            student.setPicture(rs.getBytes("picture"));
            student.setMail(rs.getString("mail"));
            student.setAddress(addressDao.getAddress(rs.getInt("address_id")));
            student.setLibraryAbonament(libraryAbonamentDao.getLibraryAbonament(rs.getInt("library_abonament_id")));
            student.setPhones(phoneDao.getPhoneList(rs.getInt("id")));
            student.setAverages(averageDao.getAverageList(rs.getInt("id")));
            studentList.add(student);
        }
        return studentList;
    }
}