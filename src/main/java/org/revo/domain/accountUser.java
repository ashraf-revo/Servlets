package org.revo.domain;

/**
 * Created by ashraf on 4/25/15.
 */
public class accountUser {
    private String images;


    private String email;
    private String password;
    private String mobile;
    private String adress;
    private String date_birth;
    private String University;
    private String faculty;
    private String snn;
    private String date_grad;
    private String hints;


    @Override
    public String toString() {
        return this.images+" "+ this.email + " " + password + " " + mobile + " " + adress + " " + date_birth + " " + University + " " + faculty + " " + snn + " " + date_grad + " " + hints;
    }
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSnn() {
        return snn;
    }

    public void setSnn(String snn) {
        this.snn = snn;
    }

    public String getDate_grad() {
        return date_grad;
    }

    public void setDate_grad(String date_grad) {
        this.date_grad = date_grad;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }
}
