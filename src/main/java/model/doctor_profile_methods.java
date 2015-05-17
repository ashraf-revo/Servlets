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
public class doctor_profile_methods {
    static model.database ob = new model.database();

    public static boolean insert_doctor(model.doctor doc) {
        try {
            PreparedStatement pre_stmt = (PreparedStatement) ob.conn.prepareCall("insert into doctors values (?,?,?,?,?,?)");
            pre_stmt.setString(1, doc.getEmail());
            pre_stmt.setString(2, doc.getPassword());
            pre_stmt.setString(3, doc.getFull_name());
            pre_stmt.setString(4, doc.getPhone());
            pre_stmt.setString(5, doc.getAddress());
            pre_stmt.setString(6, doc.getHints());
            pre_stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(doctor_profile_methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<doctor> doctor_search(String col_name, String value) {
        List<doctor> list_doctor = new ArrayList<doctor>();
        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("select * from doctors where " + col_name + " like ?");
            ob.pre_stmt.setString(1, value);
            ResultSet rs = ob.pre_stmt.executeQuery();

            while (rs.next()) {
                doctor doc = new doctor();
                doc.setEmail(rs.getString(1));
                doc.setPassword(rs.getString(2));
                doc.setFull_name(rs.getString(3));
                doc.setPhone(rs.getString(4));
                doc.setAddress(rs.getString(5));
                doc.setHints(rs.getString(6));

                list_doctor.add(doc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(student_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_doctor;
    }

    public static boolean login(String email, String password) {
        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement("select email from doctors where email=? and password=?");
            ob.pre_stmt.setString(1, email);
            ob.pre_stmt.setString(2, password);
            ResultSet rs = ob.pre_stmt.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(student_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<List> get_students() {
        List<List> return_list = new ArrayList<List>();
        List<student> list_student = new ArrayList<student>();
        List<doctor> list_doctor = new ArrayList<doctor>();
        List<master> list_master = new ArrayList<master>();


        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement
                    ("select * from dms"
                                    + " right join students on dms.email_student=students.email "
                                    + " left join masters  on dms.id_master=masters.id_master "
                                    + " left join doctors  on dms.email_doctor=doctors.email "
                    );
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

    public static List<List> get_studentsWhere(String email) {
        List<List> return_list = new ArrayList<List>();
        List<student> list_student = new ArrayList<student>();
        List<doctor> list_doctor = new ArrayList<doctor>();
        List<master> list_master = new ArrayList<master>();


        try {
            ob.pre_stmt = (PreparedStatement) ob.conn.prepareStatement
                    ("select * from dms"
                                    + " right join students on dms.email_student=students.email "
                                    + " left join masters  on dms.id_master=masters.id_master "
                                    + " left join doctors  on dms.email_doctor=doctors.email " +
                                    " where students.email= ?"
                    );
            ob.pre_stmt.setString(1, email);
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ob.conn("root", "", "127.0.0.1");
        List<List> l = get_studentsWhere("ash");

        {
            for (int h = 0; h < l.get(0).size(); h++) {

                model.student d = (model.student) l.get(0).get(h);
                model.master v = (model.master) l.get(1).get(h);
                model.doctor g = (model.doctor) l.get(2).get(h);

            }

        }

    }
}
