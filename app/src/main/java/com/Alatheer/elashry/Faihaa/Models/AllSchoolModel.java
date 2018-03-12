
package com.Alatheer.elashry.Faihaa.Models;


public class AllSchoolModel {

    private String id;
    private String branch_id_fk;
    private String school_name;
    private String ministerial_number;
    private String phone;
    private String fax;
    private String email;
    private String publisher;
    private String date;
    private String date_s;


    public AllSchoolModel() {
    }

    public AllSchoolModel(String id, String branch_id_fk, String school_name, String ministerial_number, String phone, String fax, String email, String publisher, String date, String date_s) {
        this.id = id;
        this.branch_id_fk = branch_id_fk;
        this.school_name = school_name;
        this.ministerial_number = ministerial_number;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.publisher = publisher;
        this.date = date;
        this.date_s = date_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch_id_fk() {
        return branch_id_fk;
    }

    public void setBranch_id_fk(String branch_id_fk) {
        this.branch_id_fk = branch_id_fk;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getMinisterial_number() {
        return ministerial_number;
    }

    public void setMinisterial_number(String ministerial_number) {
        this.ministerial_number = ministerial_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_s() {
        return date_s;
    }

    public void setDate_s(String date_s) {
        this.date_s = date_s;
    }
}
