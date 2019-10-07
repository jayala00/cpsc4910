package com.cpsc4910.cpscbackend.Admin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminID;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public Admin() {
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

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
