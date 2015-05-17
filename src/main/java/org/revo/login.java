/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo;

import model.doctor_profile_methods;
import model.student;
import model.student_database;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ashraf_atef
 */
@WebServlet(name = "login")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String doc = request.getParameter("doc");
        String forget = request.getParameter("forget");


        try {
            new model.database().conn("ashraf","Ashraf123","ashraf.mallah-soft.com");


        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }


        if (email != null && email.trim() != "") if (forget != null && forget.equals("forget")) {

            List<student> students = new student_database().student_search_with_Email("email", email);
            if (students.size() == 1) {
                System.out.println(students.get(0).getPassword());
                final String password1 = students.get(0).getPassword();
                if (password1 != null && !password1.trim().equals("")) {
                    new Thread(new Runnable() {
                        public void run() {
                            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
                            MailMail mm = (MailMail) context.getBean("mailMail");
                            mm.sendMail("master", email, "your new PASSWORD", password1);
                        }
                    }).start();

                }
            }


        }


        if (doc == null) {


            List list = new model.profile_methods().get_masters(email, password);
            List list1 = (List) list.get(0);
            if (list1.size() != 0) {


                HttpSession user = request.getSession();
                user.setAttribute("user_list", list);
                response.sendRedirect("profile.jsp");

            } else {


                response.sendRedirect("signin.jsp");
            }
        } else if (doc.equals("on")) {


            boolean login = new doctor_profile_methods().login(email, password);
            if (login == true) {

                HttpSession user = request.getSession();
                user.setAttribute("doc", email);
                response.sendRedirect("display");
            } else {

                response.sendRedirect("signin.jsp");
            }

        }

    }


}
