/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ashraf_atef
 */
public class master {
    private String id_master ;
    private String arabic_name ;
    private String english_name ;

    public String getDate_Regist() {
        return date_Regist;
    }

    public void setDate_Regist(String date_Regist) {
        this.date_Regist = date_Regist;
    }

    public String getDate_remake_status() {
        return date_remake_status;
    }

    public void setDate_remake_status(String date_remake_status) {
        this.date_remake_status = date_remake_status;
    }
    private String subject ;
    private String status ;
    private String resion ;
    private String date_Regist ;
    private String date_remake_status;
    
    public String getId_master() {
        return id_master;
    }

    public void setId_master(String id_master) {
        this.id_master = id_master;
    }

    public String getArabic_name() {
        return arabic_name;
    }

    public void setArabic_name(String arabic_name) {
        this.arabic_name = arabic_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResion() {
        return resion;
    }

    public void setResion(String resion) {
        this.resion = resion;
    }
    
}
