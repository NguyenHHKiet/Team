/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;
import com.mycompany.htbanve.pojo.Admin;
import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.service.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Tuan Anh
 */
public class AdminServicesTest {
     public AdminServicesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private static Connection connect;
    
    @BeforeEach
    public static void setUp() {
        connect = JdbcUtils.getConnection();
    }
    
    @AfterEach
    public static void tearDown() {
        try {
            JdbcUtils.getConnection().close();
        } catch (SQLException ex) {
        }
    }

    /**
     * Test of getDataAdmin method, of class AdminServices.
     */
    @Test
    public void testGetDataAdmin() {
        try {
            List<Admin> result = AdminServices.getDataAdmin();
            Assert.assertEquals(7, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    /**
     * Test of addTKAdmin method, of class AdminServices.
     */
    @Test
    public void testAddTKAdmin(){
        String q = null,w = null,e =null;
        try{
        String a = "Mai";
        String b = "123456";
        String c = "Mai@gmail.com";
        AdminServices.addTKAdmin(a, b, c);
        List<Admin> list = AdminServices.getDataAdmin();
        for (Admin a1 : list){
            if(a1.getTk().equals("Test") && 
                    a1.getPass().equals("123456") &&  
                        a1.getEmail().equals("Test@gmail.com")){
                q = a1.getTk();
                w = a1.getPass();
                e = a1.getEmail();
            }
        }
            Assert.assertEquals("Tuan", q);
            Assert.assertEquals("123456", w);
            Assert.assertEquals("1851050169tuan@ou.edu.vn", e);
            JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
}
