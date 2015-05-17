/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.Part;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ashraf_atef
 */
public class other_method {
   public  void upload_file_mehtod(Part filePart) throws FileNotFoundException, IOException
{
 //File f=new File(path);


 File saved_file=new File(this.getClass().getResource("/Files").getPath()+"/"+"556");

 FileOutputStream fos=new FileOutputStream(saved_file);
 FileInputStream fis=(FileInputStream) filePart.getInputStream();
 int x=0 ;
 byte b[]=new byte[1024];
    while (fis.read(b)!=-1) { 
       
        fos.write(b);
    }
    
    fos.close();
    fis.close();
    
}
   public  String date_now() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.setTime(c.getTime()); // Now use today date.

        String output = sdf.format(c.getTime());

        return output;
    }

   public String time_now() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Calendar c = Calendar.getInstance();
        c.setTime(c.getTime()); // Now use today date.

        String output = sdf.format(c.getTime());

        return output;
    }
   public   String primary_name()
    {
        String text=date_now()+time_now()+String.valueOf( (int)(Math.random()*1000) );
        return text;
    }
   
}
