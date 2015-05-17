package org.revo;

import model.displayx;
import model.doctor_profile_methods;
import model.profile_methods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashraf on 5/8/15.
 */
@WebServlet(name = "display")
public class display extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session =
                request.getSession();


        if (session == null || ((String) session.getAttribute("doc")) == null || ((String) session.getAttribute("doc")).trim() == "") {
            response.sendRedirect("signin.jsp");
        } else {
            List<List> l = new ArrayList<List>();
            String search = request.getParameter("search");
            if (search != null && search.trim() != "") {
                l = doctor_profile_methods.get_studentsWhere(search);

            } else {
                l = doctor_profile_methods.get_students();
            }
            List<displayx> e = new ArrayList<displayx>();
            for (int h = 0; h < l.get(0).size(); h++) {
                model.student d = (model.student) l.get(0).get(h);
                model.master v = (model.master) l.get(1).get(h);
                model.doctor g = (model.doctor) l.get(2).get(h);
                e.add(new displayx(d.getProfile_picture(), d.getEmail(), v.getEnglish_name(), v.getSubject(), profile_methods.Attchments(d.getEmail()), v.getStatus()));
            }
            request.setAttribute("data", e);
            request.getRequestDispatcher("disply.jsp").forward(request, response);
        }

    }


}
