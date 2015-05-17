package org.revo;

import model.profile_methods;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ashraf on 5/11/15.
 */
@WebServlet(name = "ajaxstate")
public class ajaxstate extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String  email=request.getParameter("email");

        String[] byemailInfo = new profile_methods().find_byemailInfo(email);




        JSONObject json = new JSONObject();



        JSONObject address;
        address = new JSONObject();
        address.put("resion", byemailInfo[0]);
        address.put("status", byemailInfo[1]);


        address.put("email",email);
        json.put("data", address);
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}
