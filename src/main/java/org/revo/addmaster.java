package org.revo;

import model.other_method;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ashraf on 4/28/15.
 */
@WebServlet(name = "addmaster")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class addmaster extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String master_nameA = request.getParameter("ar");
        String master_nameE = request.getParameter("en");
        String desc = request.getParameter("desc");
        Part file = request.getPart("file");


        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + "img" + File.separator + "personal";
        model.master mas = new model.master();
        mas.setArabic_name(master_nameA);
        mas.setEnglish_name(master_nameE);
        mas.setDate_Regist(new other_method().date_now());
        mas.setDate_remake_status(null);
        mas.setResion(null);
        mas.setStatus(null);
        mas.setSubject(desc);

        Object my_ob = (Object) request.getSession().getAttribute("user_list");
        List l1 = (List) my_ob;
        List l2 = (List) l1.get(0);
        model.student st = (model.student) (l2.get(0));
        String email = st.getEmail();
        String s = "";
        if (file != null) {
            String fileName = extractFileName(file);

            if (fileName.length() > 0) {
                s = new other_method().primary_name();
                s += fileName.substring(fileName.indexOf("."));
                file.write(savePath + File.separator + s);

            }
        }
        if (new model.profile_methods().add_master(mas, email) == true && new model.student_database().insert_attachment(email, s) == true)

            request.getSession().setAttribute("user_list", new model.profile_methods().get_masters(email, st.getPassword()));
        response.sendRedirect("profile.jsp");
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
