package org.revo;

import model.profile_methods;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ashraf on 5/14/15.
 */
@WebServlet(name = "updateState")
public class updateState extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String email = request.getParameter("email");
        final String reson = request.getParameter("reson");
        final String state = request.getParameter("state");
        if (state != null) new profile_methods().changeState(email, reson, "accept");
        else new profile_methods().changeState(email, reson, "Pending....");

        new Thread(new Runnable() {
            public void run() {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
                MailMail mm = (MailMail) context.getBean("mailMail");
                mm.sendMail("master", email, "your new state " + state, "your new reson" + reson);
            }
        }).start();
    response.sendRedirect("display");
    }

}
