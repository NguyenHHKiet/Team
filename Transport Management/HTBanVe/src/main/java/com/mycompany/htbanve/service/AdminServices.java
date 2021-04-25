/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;
import com.mycompany.htbanve.pojo.Admin;
import com.mycompany.htbanve.pojo.QLBV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Tuan Anh
 */
public class AdminServices {
    public static List<Admin> getDataAdmin() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * From admin");
        List<Admin> results = new ArrayList<>();
        while(rs.next()) {
            Admin c = new Admin(rs.getString("Admintk"),rs.getString("Adminpass"), rs.getString("Adminemail"));  
            results.add(c);
        }
        return results;
    }
    public static void addTKAdmin(String a, String b, String c) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "Insert into admin (Admintk,Adminpass,Adminemail) value (?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, a);
        pst.setString(2, b);
        pst.setString(3, c);
        pst.execute();
    }
}
