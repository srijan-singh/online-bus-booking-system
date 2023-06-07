package com.ibm.usermodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String email;
    @Column(length = 20)
    private String pasword;
    
    public User(String name, String email, String pasword) {
        this.name = name;
        this.email = email;
        this.pasword = pasword;
    }
    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getPasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    
}
