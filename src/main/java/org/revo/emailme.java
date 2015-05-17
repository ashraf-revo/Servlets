package org.revo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ashraf on 5/17/15.
 */
@WebServlet(name = "emailme")
public class emailme extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String from = request.getParameter("from");
        final String title = request.getParameter("title");
        final String message = request.getParameter("message");
        if (from!=null&&!from.trim().equals("")&&title!=null&&title.trim()!=""&&message!=null&&message.trim()!=""){


            new Thread(new Runnable() {
                public void run() {
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
                    MailMail mm = (MailMail) context.getBean("mailMail");
                    mm.sendMail(from, "master1app@gmail.com", title, message);
                }
            }).start();



        }

response.sendRedirect("contact_us.jsp");
    }
}
