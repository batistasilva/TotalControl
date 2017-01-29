package com.ossb.totalcontrolhs.model;


import com.ossb.totalcontrolhs.util.UtilDate;

/**
 * Created by batista on 29/07/15.
 */
public class User extends UtilDate {
    private String name, email, username, password;
    private long id;
    private String status;
    private String datecreat;
    private String dateupdate;
    private String dateinactive;

    public User() {
    }

    public User(String name, String email, String username, String password, long id, String status) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = "";
        this.email = "";
    }


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
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



