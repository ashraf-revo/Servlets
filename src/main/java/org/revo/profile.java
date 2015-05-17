package org.revo;

import org.revo.domain.accountStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ashraf on 4/25/15.
 */
@WebServlet(name = "profile")
public class profile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("p", new accountStat("sssssssss"));
        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }
}
