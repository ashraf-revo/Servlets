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

import static model.database.pre_stmt;

/**
 *
 * @author ashraf_atef
 */
public class student_database {
    static database db=new database();
    public boolean insert_student(student ob)
    {
        try {
            db.pre_stmt=(PreparedStatement) db.conn.prepareStatement
        ("insert into students values (?,?,?,?,?,?,?,?,?,?,?,?)");
            db.pre_stmt.setString(1, ob.getEmail());
            db.pre_stmt.setString(2, ob.getPassword());
            db.pre_stmt.setString(3, ob.getFull_name());
            db.pre_stmt.setString(4, ob.getDate_of_birth());
            db.pre_stmt.setString(5, ob.getFaculty());
            db.pre_stmt.setString(6, ob.getUnvirsity());
            db.pre_stmt.setString(7, ob.getDate_of_gradution());
            db.pre_stmt.setString(8, ob.getHints());
            db.pre_stmt.setString(9, ob.getPhone());
            db.pre_stmt.setString(10, ob.getAddress());
            db.pre_stmt.setString(11, ob.getSnn());
            db.pre_stmt.setString(12, ob.getProfile_picture());
            db.pre_stmt.execute();
            
            return  true ;
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }
   
        public static List<student>  student_search_with_Email(String col_name ,String value)
    {
       List <student> list_students=new ArrayList<student>();
        try {
            db.pre_stmt=(PreparedStatement) db.conn.prepareStatement("select * from students where "+col_name+" like ?");
            db.pre_stmt.setString(1, value);

            ResultSet rs=db.pre_stmt.executeQuery();
           
            while(rs.next())
            {
                student ob=new student();
                ob.setEmail(rs.getString(1));
                ob.setPassword(rs.getString(2));
                ob.setFull_name(rs.getString(3));
                ob.setDate_of_birth(rs.getString(4));
                ob.setFaculty(rs.getString(5));
                ob.setUnvirsity(rs.getString(6));
                ob.setDate_of_gradution(rs.getString(7));
                ob.setHints(rs.getString(8));
                ob.setPhone(rs.getString(9));
                ob.setAddress(rs.getString(10));
                ob.setSnn(rs.getString(11));
                
                list_students.add(ob);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
       return list_students;
    }
    
     public boolean update_student(student ob , String Email)
     {  try {
         String sql="update students set ";
         pre_stmt=(PreparedStatement) db.conn.prepareStatement(sql);
        
         int index=1 ;
         if (!ob.getAddress().equals(null))
         {
             sql+=" address =? ";
          
             
         }
        
         if (! ob.getDate_of_birth().equals(null))
         {
             sql+=", date_of_birth =? ";
            
         }
         
         if (!ob.getDate_of_gradution().equals(null))
         {
             sql+=", date_of_gradution =? ";

         }

        
         if (! ob.getFaculty().equals(null))
         {
             sql+=", faculty =? ";

         }
         
         if (!ob.getFull_name().equals(null))
         {
             sql+=", full_name =? ";

         }
         
         if (!ob.getHints().equals(null))
         {
             sql+=", hints =? ";

         }
         
         if (!ob.getPassword().equals(null))
         {
             sql+=", password =? ";

         }
         
         if (ob.getPhone().equals(null))
         {
             sql+=", phonne =? ";

         }
         
         if (!ob.getSnn().equals(null))
         {
             sql+=", snn =? ";
         }
         
         if (!ob.getUnvirsity().equals(null))
         {
             sql+=", unvirsity =? ";

         }
        
           if (!ob.getEmail().equals(null))
         {
             
             sql+=" , email =? ";
         }
         sql+=" where email =?";
        

        pre_stmt=(PreparedStatement) db.conn.prepareStatement(sql);
       
           if (!ob.getAddress().equals(null))
         {
            
             pre_stmt.setString(index++, ob.getAddress());
             
         }
        
         if (! ob.getDate_of_birth().equals(null))
         {
           
             pre_stmt.setString(index++,  ob.getDate_of_birth());
         }
         
         if (!ob.getDate_of_gradution().equals(null))
         {

             pre_stmt.setString(index++, ob.getDate_of_gradution());
         }
          
       
        
         if (! ob.getFaculty().equals(null))
         {
  
            pre_stmt.setString(index++,  ob.getFaculty());
         }
         
         
         if (!ob.getFull_name().equals(null))
         {
 
             pre_stmt.setString(index++, ob.getFull_name());
         }
         
         if (!ob.getHints().equals(null))
         {
  
          pre_stmt.setString(index++, ob.getHints());
         }
         
         if (!ob.getPassword().equals(null))
         {

             pre_stmt.setString(index++, ob.getPassword());
         }
         
         if (ob.getPhone().equals(null))
         {
 
             pre_stmt.setString(index++, ob.getPhone());
         }
         
         if (!ob.getSnn().equals(null))
         {
 
            pre_stmt.setString(index++, ob.getSnn());
         }
         
         if (!ob.getUnvirsity().equals(null))
         {
  
            pre_stmt.setString(index++, ob.getUnvirsity());
         }
          if (! ob.getEmail().equals(null))
         {
  
            pre_stmt.setString(index++,  ob.getEmail());
         }
           pre_stmt.setString(index, Email);
         pre_stmt.execute();
        return true ;
        } catch (SQLException ex) {
            Logger.getLogger(student_database.class.getName()).log(Level.SEVERE, null, ex);
        } 
     return false ;
     }
     public boolean delete_student(String Email)
     {
        try {
            db.pre_stmt=(PreparedStatement) db.conn.prepareStatement("delete from students where email=? ");
            db.pre_stmt.setString(1, Email);
            db.pre_stmt.execute();
            return true ;
        } catch (SQLException ex) {
            Logger.getLogger(student_database.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false ;
     }
     public boolean login (String email , String password)
     {
        try {
            db.pre_stmt=(PreparedStatement)db.conn.prepareStatement("select email from students where email=? and password=?");
            db.pre_stmt.setString(1, email); db.pre_stmt.setString(2, password);
            ResultSet rs=pre_stmt.executeQuery();
            if (rs.next())
                return true ;
        } catch (SQLException ex) {
            Logger.getLogger(student_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
     }
    
    public boolean insert_attachment(String email , String filename)
    {
        try {
            db.pre_stmt=(PreparedStatement)  db.conn.prepareStatement("insert into  students_attachments values(?,?)");
      db.pre_stmt.setString(1,email);
            db.pre_stmt.setString(2,filename);
            db.pre_stmt.execute();
            return true ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false ;
    }

    public static void main(String[] args) {
        try {
            new database().conn("root","","127.0.0.1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(student_search_with_Email("ashraf1abdelrasool@gmail.com","ash").get(0).getPassword());
    }
}
