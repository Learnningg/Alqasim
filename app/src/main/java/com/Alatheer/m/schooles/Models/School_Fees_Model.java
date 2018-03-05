package com.Alatheer.m.schooles.Models;

/**
 * Created by m on 3/5/2018.
 */


public class School_Fees_Model {

    private String ar_name;
    private String tuition_fees;
    private String transfer_fees_1;
    private String message;

    public School_Fees_Model(String ar_name, String tuition_fees, String transfer_fees_1) {
        this.ar_name = ar_name;
        this.tuition_fees = tuition_fees;
        this.transfer_fees_1 = transfer_fees_1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAr_name() {
        return ar_name;
    }

    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }

    public String getTuition_fees() {
        return tuition_fees;
    }

    public void setTuition_fees(String tuition_fees) {
        this.tuition_fees = tuition_fees;
    }

    public String getTransfer_fees_1() {
        return transfer_fees_1;
    }

    public void setTransfer_fees_1(String transfer_fees_1) {
        this.transfer_fees_1 = transfer_fees_1;
    }
}
