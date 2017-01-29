package com.ossb.totalcontrolhs.model;

import com.ossb.totalcontrolhs.util.UtilDate;

/**
 * Created by batista on 18/10/16.
 */

public class Customer extends UtilDate {
    private String name, email, telphone, mobilphone, whatsup;
    private long id;
    private long user_id;
    private Character status;
    private String datecreat;
    private String dateupdate;
    private String dateinactive;


    public Customer() {
    }

    public Customer(String name, String email, String telphone, String mobilphone, String whatsup, long id, long user_id, Character status, String datecreat, String dateupdate, String dateinactive) {
        this.name = name;
        this.email = email;
        this.telphone = telphone;
        this.mobilphone = mobilphone;
        this.whatsup = whatsup;
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.datecreat = datecreat;
        this.dateupdate = dateupdate;
        this.dateinactive = dateinactive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getMobilphone() {
        return mobilphone;
    }

    public void setMobilphone(String mobilphone) {
        this.mobilphone = mobilphone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getWhatsup() {
        return whatsup;
    }

    public void setWhatsup(String whatsup) {
        this.whatsup = whatsup;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getDatecreat() {
        datecreat = getActualDateToString("yyyy-MM-dd HH:mm:ss");//Ansi format
        return datecreat;
    }

    public void setDatecreat(String datecreat) {
        this.datecreat = datecreat;
    }

    public String getDateupdate() {
        dateupdate = getActualDateToString("yyyy-MM-dd HH:mm:ss");//Ansi format
        return dateupdate;
    }

    public void setDateupdate(String dateupdate) {
        this.dateupdate = dateupdate;
    }

    public String getDateinactive() {
        dateinactive = getActualDateToString("yyyy-MM-dd HH:mm:ss");//Ansi format
        return dateinactive;
    }

    public void setDateinactive(String dateinactive) {
        this.dateinactive = dateinactive;
    }
}
