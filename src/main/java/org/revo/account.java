package org.revo;

import model.other_method;
import model.student;
import model.student_database;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ashraf on 4/24/15.
 */
@WebServlet(name = "account")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class account extends HttpServlet {
    model.database ob = new model.database();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + "img" + File.separator + "personal";

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part image = request.getPart("image");

        student student = new student();

        if (image != null) {
            String fileName = extractFileName(image);

            if (fileName.length() > 0) {
                String s = new other_method().primary_name();
                s += fileName.substring(fileName.indexOf("."));
                image.write(savePath + File.separator + s);
                student.setProfile_picture(s);
            }
        }


        student.setEmail(request.getParameter("Email"));
        student.setPassword(request.getParameter("password"));
        student.setPhone(request.getParameter("mobile"));
        student.setAddress(request.getParameter("adress"));
        student.setDate_of_birth(request.getParameter("date_birth"));
        student.setUnvirsity(request.getParameter("University"));
        student.setFaculty(request.getParameter("faculty"));
        student.setSnn(request.getParameter("snn"));
        student.setDate_of_gradution(request.getParameter("date_grad"));
        student.setHints(request.getParameter("hints"));
        student.setFull_name(request.getParameter("name"));

        try {
            new model.database().conn("ashraf","Ashraf123","ashraf.mallah-soft.com");
            new student_database().insert_student(student);
            List list = new model.profile_methods().get_masters(student.getEmail(), student.getPassword());
            if (list.size() != 0) {

                HttpSession user = request.getSession();
                user.setAttribute("user_list", list);
                response.sendRedirect("profile.jsp");
            } else {
                response.sendRedirect("signin.jsp");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("account.jsp");
    }


    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
