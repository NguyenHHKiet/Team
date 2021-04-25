/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;
import java.sql.DriverManager;

import java.sql.SQLException;


import javax.swing.JOptionPane;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tuan Anh
 */
public class JdbcUtils {
    private static Connection conn;
      static
      {        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvexe","root","HoangKiet12");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            }catch(SQLException ex){
                Logger.getLogger(JdbcUtils.class.getName()).log(Level.SEVERE,null,ex);
            }   
    }  
    public static Connection getConnection(){
        return conn;
    }
}
