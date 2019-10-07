package com.cpsc4910.cpscbackend.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String accountID;

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getAccountID() { return accountID; }

    public void setAccountID(String accountID) { this.accountID = accountID; }
}