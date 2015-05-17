/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ashraf_atef
 */
public class profile_methods {
    static model.database ob = new model.database();

    public List<List> get_masters(String username, String password) {
        List<List> return_list = new ArrayList<List>();
        List<student> list_student = new ArrayList<student>();
        List<doctor> list_doctor = new ArrayList<doctor>();
        List<master> list_master = new ArrayList<master>();


        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement
                    ("select * from dms"
                            + " right join students on dms.email_student=students.email "
                            + " left join masters  on dms.id_master=masters.id_master "
                            + " left join doctors  on dms.email_doctor=doctors.email where students.email=? " +
                            " and students.password=?");
            ob.pre_stmt.setString(1, username);
            ob.pre_stmt.setString(2, password);
            ResultSet rs = ob.pre_stmt.executeQuery();
            while (rs.next()) {
                model.student st = new model.student();
                st.setAddress(rs.getString("students.address"));
                st.setDate_of_birth(rs.getString("date_of_birth"));
                st.setDate_of_gradution(rs.getString("date_of_gradution"));
                st.setEmail(rs.getString("students.email"));
                st.setFaculty(rs.getString("faculty"));
                st.setFull_name(rs.getString("students.full_name"));
                st.setHints(rs.getString("students.hints"));
                st.setPassword(rs.getString("students.password"));
                st.setPhone(rs.getString("students.phone"));
                st.setProfile_picture(rs.getString("profile_picture"));
                st.setSnn(rs.getString("snn"));
                st.setUnvirsity(rs.getString("unvirsity"));
                list_student.add(st);

                model.doctor doc = new model.doctor();
                doc.setAddress(rs.getString("doctors.address"));
                doc.setEmail(rs.getString("doctors.email"));
                doc.setFull_name(rs.getString("doctors.full_name"));
                doc.setHints(rs.getString("doctors.hints"));
                doc.setPassword(rs.getString("doctors.password"));
                doc.setPhone(rs.getString("doctors.phone"));
                list_doctor.add(doc);

                model.master mas = new model.master();
                mas.setArabic_name(rs.getString("arabic_name"));
                mas.setDate_Regist(rs.getString("date_regist"));
                mas.setDate_remake_status(rs.getString("date_Remake_status"));
                mas.setEnglish_name(rs.getString("english_name"));
                mas.setId_master(rs.getString("id_master"));
                mas.setResion(rs.getString("resion"));
                mas.setStatus(rs.getString("status"));
                mas.setSubject(rs.getString("subject"));
                list_master.add(mas);


            }
            return_list.add(list_student);
            return_list.add(list_master);
            return_list.add(list_doctor);
        } catch (SQLException ex) {
            Logger.getLogger(profile_methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return return_list;
    }


    public static void changeState(String email, String reson, String state) {
        String id_master = "";
        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("select masters.id_master from dms left JOIN  masters on dms.id_master=" +
                    "       masters.id_master where dms.email_student=? ");
            ob.pre_stmt.setString(1, email);
            ResultSet rs = ob.pre_stmt.executeQuery();
            if (rs.next()) id_master = rs.getString(1);
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("update masters set resion=? , status=? where id_master =" + id_master);
            ob.pre_stmt.setString(1, reson);
            ob.pre_stmt.setString(2, state);
            ob.pre_stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String[] find_byemailInfo(String email) {
        String arr[] = new String[2];


        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement
                    ("select masters.resion , masters.status from dms"

                                    + " left join masters  on dms.id_master=masters.id_master "
                                    +
                                    "  where dms.email_student=? "
                    );
            ob.pre_stmt.setString(1, email);
            ResultSet rs = ob.pre_stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1) == null) {
                    arr[0] = "";
                } else {
                    arr[0] = rs.getString(1);
                }


                if (rs.getString(2) == null) {
                    arr[1] = "Pending....";

                } else arr[1] = rs.getString(2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(profile_methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }


    public static boolean add_master(model.master mas, String student) {

        try {
            ob.stmt = ob.conn.createStatement();
            ResultSet rs = ob.stmt.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'masters'");
            rs.next();
            String nextid = rs.getString("Auto_increment");
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("insert into masters values (?,?,?,?,default,?,?,?)");
            ob.pre_stmt.setString(1, nextid);
            ob.pre_stmt.setString(2, mas.getArabic_name());
            ob.pre_stmt.setString(3, mas.getEnglish_name());
            ob.pre_stmt.setString(4, mas.getSubject());
            //  ob.pre_stmt.setString(5,mas.getStatus());
            ob.pre_stmt.setString(5, mas.getResion());
            ob.pre_stmt.setString(6, mas.getDate_Regist());
            ob.pre_stmt.setString(7, mas.getDate_remake_status());
            ob.pre_stmt.execute();
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("insert into dms values ('',?,?)");
            ob.pre_stmt.setString(1, nextid);
            ob.pre_stmt.setString(2, student);
            ob.pre_stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(profile_methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static List Attchments(String email) {
        List l = new ArrayList<String>();
        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement
                    ("select attachments from students_attachments where email=?");
            ob.pre_stmt.setString(1, email);

            ResultSet rs = ob.pre_stmt.executeQuery();
            while (rs.next()) {
                l.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return l;

    }

}
