package com.usarb.bd.dao;


import com.usarb.bd.entities.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
    private static final String QUERY = "Select ph.id, ph.type_id,ph.value\n" +
            "From persons p\n" +
            "inner join persons_to_phones pth\n" +
            "ON pth.person_id=p.id\n" +
            "\n" +
            "inner join phones ph\n" +
            "ON ph.id=pth.phone_id" +
            " where p.id = ?";

    private Connection connection;

    public PhoneDao(Connection connection) {
        this.connection = connection;
    }

    public Phone getPhone(int personID) throws SQLException {
        Phone phone = new Phone();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, personID);

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
         PhoneTypeDao phoneTypeDao = new PhoneTypeDao(connection);
        while (rs.next()) {
            phone.setId(rs.getInt("id"));
            phone.setType(phoneTypeDao.getPhoneType(rs.getInt("type_id")));
            phone.setValue(rs.getString("value"));


            System.out.println(phone.getId() + "," +
                    phone.getValue()+ "," +
                    phone.getType());
        }
        return phone;
    }
    public List<Phone> getPhoneList(int personID) throws SQLException {
        List<Phone> phones = new ArrayList<>();
        String query = "Select p.id,type_id,value\n" +
                "From persons p\n" +
                "         inner join persons_to_phones pth\n" +
                "                    ON pth.person_id=p.id\n" +
                "\n" +
                "         inner join phones ph\n" +
                "                    ON ph.id=pth.phone_id\n" +
                "where p.id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, personID);
        ResultSet rs = preparedStatement.executeQuery();
        PhoneTypeDao phoneTypeDao = new PhoneTypeDao(connection);
        while (rs.next()){
            Phone phone = new Phone();
            phone.setId(rs.getInt("id"));
            phone.setType(phoneTypeDao.getPhoneType(rs.getInt("type_id")));
            phone.setValue(rs.getString("value"));
            phones.add(phone);

        }

        return phones;
    }
}