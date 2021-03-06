package com.cm.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String loginname;
    private String password;
    private String status;
    private Date createDate;
    private String username;

    public User() {
    }

    public User(Integer id, String loginname, String password, String status, Date createDate, String username) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.status = status;
        this.createDate = createDate;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                '}';
    }
}
