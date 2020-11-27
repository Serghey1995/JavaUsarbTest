package com.usarb.controllers;

import com.usarb.bd.Services.PersonService;
import com.usarb.bd.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/student")
public class MainServlet extends HttpServlet {
private PersonService personService;
public void init(){
    personService = new PersonService();

//    try {
//         personService = new PersonService();
//        System.out.println("=========");
//    } catch (SQLException throwables) {
//        throwables.printStackTrace();
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }

 }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
        //    try {
                personService.hello();
           //     Person person = personService.getPerson();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
           // }
            writer.println("<h2>Hello from HelloServlet</h2>");
        } finally {
            writer.close();
        }
    }
}
