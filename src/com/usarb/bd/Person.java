package com.usarb.bd;

import java.util.Date;
import java.util.List;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private byte[] picture;
    private String mail;
    private Address address;
    private LibraryAbonament libraryAbonament;
    private List<Phone> phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LibraryAbonament getLibraryAbonament() {
        return libraryAbonament;
    }

    public void setLibraryAbonament(LibraryAbonament libraryAbonament) {
        this.libraryAbonament = libraryAbonament;
    }
}

