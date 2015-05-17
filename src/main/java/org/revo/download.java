package org.revo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ashraf on 5/11/15.
 */
@WebServlet(name = "download")
public class download extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment;filename="+filename);
        java.io.FileInputStream fileInputStream=new java.io.FileInputStream(request.getServletContext().getRealPath("")+"/img/personal/" + filename);
        PrintWriter out=response.getWriter();
        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
    }
}
