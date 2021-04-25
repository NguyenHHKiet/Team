/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
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
public class QLCXsServicesTest {
    
    public QLCXsServicesTest() {
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

    @Test
    public void testGetDataQLCXs() throws Exception {
        try {
            List<QLCX> result = QLCXsServices.getDataQLCXs();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    /**
     * Test of getDataQLCX method, of class QLCXsServices.
     */
    @Test
    public void testGetDataQLCX() {
        try {
            ObservableList<QLCX> result = QLCXsServices.getDataQLCX();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (Exception ex) {
            System.err.println("Test Unsuccessfully");
        }
    }
    /**
     * Test of addCX method, of class QLCXsServices.
     */
    @Test
    public void testAddCX() throws Exception {
        String m = null,n= null,o=null,u = null ,p= null,q= null,x=null,y=null,z=null;
        int l = 0;
        try{         
            String a = "6";
            String b = "b";
            String c = "c";
            String d = "d";
            String e = "e";
            String f = "f";
            String g = "g";
            String h = "h";
            String i = "j";
            String k = "k";
            QLCXsServices.addCX(a, b, c, d, e, f, g, h, i, k);
        List<QLCX> list = QLCXsServices.getDataQLCXs();
        for (QLCX a1 : list){
            {
                
                l = a1.getId();
                m = a1.getTencx();
                n = a1.getBsx();
                o = a1.getNgaykh();
                u = a1.getGiokh();
                p = a1.getGiave();
                q = a1.getTennv();
                x = a1.getSdtnv();
                y = a1.getLoaixe();
                z = a1.getGhe();         
                
            }
        }
            Assert.assertEquals(6, l);
            Assert.assertEquals("b", m);
            Assert.assertEquals("c", n);
            Assert.assertEquals("d", o);
            Assert.assertEquals("e", u);
            Assert.assertEquals("f", p);
            Assert.assertEquals("g", q);
            Assert.assertEquals("h", x);
            Assert.assertEquals("j", y);
            Assert.assertEquals("k", z);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Test of EditCX method, of class QLCXsServices.
     */
    @Test
    public void testEditCX() throws Exception {
        String  b = null,c= null,d=null,e = null ,f= null,g= null,h=null,j=null,k=null;
        try{
            String value1 = "5";
            String value2 = "hw";
            String value3 = "he";
            String value4 = "hr";
            String value5 = "ht";
            String value6 = "hy";
            String value7 = "hu";
            String value8 = "hi";
            String value9 = "ho";
            String value10 = "hp";
            QLCXsServices.EditCX(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10);
            List<QLCX> list = QLCXsServices.getDataQLCXs();
            for (QLCX a1 : list){
                {
                    b = a1.getTencx();
                    c = a1.getBsx();
                    d = a1.getLoaixe();
                    e = a1.getNgaykh();
                    f = a1.getGiokh();
                    g = a1.getGiave();
                    h = a1.getTennv();
                    j = a1.getSdtnv();
                    k = a1.getGhe(); 
                }
        }
            Assert.assertEquals("hw", b);
            Assert.assertEquals("he", c);
            Assert.assertEquals("hr", d);
            Assert.assertEquals("ht", e);
            Assert.assertEquals("hy", f);
            Assert.assertEquals("hu", g);
            Assert.assertEquals("hi", h);
            Assert.assertEquals("ho", j);
            Assert.assertEquals("hp", k);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Test of DeleteCX method, of class QLCXsServices.
     */
    @Test
    public void testDeleteCX() throws Exception {
        int b = 0;
        try{
            String a = "2";
            QLCXsServices.DeleteCX(a);
        List<QLCX> list = QLCXsServices.getDataQLCXs();
        for (QLCX a1 : list){
            {
                b = a1.getId();
            }
        }
            Assert.assertEquals(5, b);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
