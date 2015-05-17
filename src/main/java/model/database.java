/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_atef
 */
public class database {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement pre_stmt = null;

    public static void conn(String user_name, String password, String ip) throws ClassNotFoundException, SQLException {
        String unicode = "?useUnicode=yes&characterEncoding=UTF-8";

        final String DB_URL = "jdbc:mysql://" + ip + "/ashraf_graduate_studies";
        final String USER = user_name;
        final String PASS = password;


        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(DB_URL + unicode, USER, PASS);
        stmt = conn.createStatement();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        conn("root", "", "127.0.0.1");
        List<List> l = model.doctor_profile_methods.get_students();
        List<displayx> e = new ArrayList<displayx>();
        for (int h = 0; h < l.get(0).size(); h++) {
            model.student d = (model.student) l.get(0).get(h);
            model.master v = (model.master) l.get(1).get(h);
            model.doctor g = (model.doctor) l.get(2).get(h);
            //   e.add(new displayx(d.getProfile_picture(),d.getEmail(), v.getEnglish_name(), v.getSubject(), profile_methods.Attchments(d.getEmail())));
        }
    }
}
