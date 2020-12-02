package com.usarb.controllers;

import com.usarb.bd.Services.*;
import com.usarb.bd.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/students")

public class MainServlet extends HttpServlet {
private PersonService personService;
private AddressService addressService;
private AverageService averageService;
private DisciplineService disciplineService;
private GroupService groupService;
private LibraryAbonamentService libraryAbonamentService;
private MarkService markService;
private PhoneService phoneService;
private PhoneTypeService phoneTypeService;
private StudentService studentService;
private TeacherService teacherService;

public void init(){
    personService = new PersonService();
    addressService = new AddressService();
    averageService = new AverageService();
    disciplineService = new DisciplineService();
    groupService = new GroupService();
    libraryAbonamentService = new LibraryAbonamentService();
    markService = new MarkService();
    phoneService = new PhoneService();
    phoneTypeService = new PhoneTypeService();
    studentService = new StudentService();
    teacherService = new TeacherService();


}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
          response.setContentType("text/html");
        try {
            List<Person> p = personService.getPersonList();

            request.setAttribute("listPersons", p);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
       } catch (SQLException throwables) {
        throwables.printStackTrace();
            }

        }
    }
