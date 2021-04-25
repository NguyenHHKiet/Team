/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;

/**
 *
 * @author Tuan Anh
 */
public class Admin {
    private String tk,pass,email;
    public Admin(String tk, String pass, String email) {
        this.tk = tk;
        this.pass = pass;
        this.email = email;
    }

    /**
     * @return the tk
     */
    public String getTk() {
        return tk;
    }

    /**
     * @param tk the tk to set
     */
    public void setTk(String tk) {
        this.tk = tk;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
