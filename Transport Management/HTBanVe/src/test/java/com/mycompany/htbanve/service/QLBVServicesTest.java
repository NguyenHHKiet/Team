/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Tuan Anh
 */
public class QLBVServicesTest {
    
    public QLBVServicesTest() {
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
    public void testGetDataQLBV() throws Exception {
        try {
            List<QLBV> result = QLBVServices.getDataQLBV();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    @Test
    public void testGetDataQLBV2() {
        try {       
            ObservableList<QLBV> result = QLBVServices.getDataQLBV2();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (Exception e) {
            System.err.println("Test Unsuccessfully");
        }
    }

    @Test
    public void testUpdateQLBV() throws Exception {
        String a = null, b = null,c= null,d=null;
        try{
        String value1 = "Lu";
        String value2 = "123456";
        String value3 = "A05";
        String value4 = "20690da8-d2b3-4898-8434-f3bb677a9e53";
        QLBVServices.updateQLBV(value1, value2, value3, value4);
        List<QLBV> list = QLBVServices.getDataQLBV();
        for (QLBV a1 : list){
            if(a1.getTenkh().equals("Lu") && 
                    a1.getSdtkh().equals("123456") &&  
                        a1.getGhe().equals("A05")){
                a = a1.getTenkh();
                b = a1.getSdtkh();
                c = a1.getGhe();
            }
        }
            Assert.assertEquals("Lu", a);
            Assert.assertEquals("123456", b);
            Assert.assertEquals("A05", c);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }   
    }

    @Test
    public void testAddVe(){
        String a = null, b = null,c= null,d=null,e = null ,f= null,g= null,h=null,j=null,k=null,l=null,m=null,n=null;
        try{
        String value1 = "a";
        String value2 = "b";
        String value3 = "c";
        String value4 = "d";
        String value5 = "e";
        String value6 = "f";
        String value7 = "g";
        String value8 = "h";
        String value9 = "j";
        String value10 = "k";
        String value11 = "l";
        String value12 = "m";
        String value13 = "n";
        QLBVServices.addVe(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13);
        List<QLBV> list = QLBVServices.getDataQLBV();
        for (QLBV a1 : list){
            if(a1.getId().equals("a") && a1.getTencx().equals("b") &&  a1.getBsx().equals("c")&&
                    a1.getGiokh().equals("d") && a1.getNgaykh().equals("e") &&  a1.getGiave().equals("f")&&
                    a1.getLoaixe().equals("g") && a1.getTenkh().equals("h") &&  a1.getSdtkh().equals("j")&&
                    a1.getTennv().equals("k") && a1.getSdtnv().equals("l") &&  a1.getGhe().equals("m") && a1.getIdphanbiet().equals("n")){
                a = a1.getId();
                b = a1.getTencx();
                c = a1.getBsx();
                d = a1.getGiokh();
                e = a1.getNgaykh();
                f = a1.getGiave();
                g = a1.getLoaixe();
                h = a1.getTenkh();
                j = a1.getSdtkh();
                k = a1.getTennv();
                l = a1.getSdtnv();
                m = a1.getGhe();
                n = a1.getIdphanbiet();
            }
        }
            Assert.assertEquals("a", a);
            Assert.assertEquals("b", b);
            Assert.assertEquals("c", c);
            Assert.assertEquals("d", d);
            Assert.assertEquals("e", e);
            Assert.assertEquals("f", f);
            Assert.assertEquals("g", g);
            Assert.assertEquals("h", h);
            Assert.assertEquals("j", j);
            Assert.assertEquals("k", k);
            Assert.assertEquals("l", l);
            Assert.assertEquals("m", m);
            Assert.assertEquals("n", n);
            JOptionPane.showMessageDialog(null, "Them ve thanh cong");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
    }

    @Test
    public void testGiamGhe() {
        String a= null,b=null;
        try{
        String value1 = "4";
        String value2 = "c70f85b4-b598-4f41-a540-ae7427da23a6";
        QLBVServices.GiamGhe(value1, value2);
        List<QLCX> list = QLCXsServices.getDataQLCXs();
        for (QLCX a1 : list){
            {
                a = a1.getGhe();
            }
        }
            Assert.assertEquals("4", a);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Test
    public void testKiemtraNgayGio(){
        String q = null, w = null,e =null,r=null;
        try{
        String a = "2020-12-13";
        String b = "15:30";
        QLBVServices.KiemtraNgayGio(a, b);
        List<QLBV> list = QLBVServices.getDataQLBV();
        for (QLBV a1 : list){
                q = a1.getNgaykh();
                w = a1.getGiokh();
            }
            Assert.assertNotNull( q);
            Assert.assertNotNull( w);
        List<QLCX> list1 = QLCXsServices.getDataQLCXs();
        for(QLCX a2 :list1){
            e = a2.getNgaykh();
            r = a2.getGiokh();
        }
            Assert.assertNotNull( e);
            Assert.assertNotNull( r);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }  
    }

    @Test
    public void testXoaVe() throws Exception {
        String q = null,e =null;
        try{
        String a = "a";
        String b = "52083611-94b5-46bc-ab8a-918442e763cb";
        QLBVServices.XoaVe(a, b);
        List<QLBV> list = QLBVServices.getDataQLBV();
        for (QLBV a1 : list){
                q = a1.getId();
            }
            Assert.assertNotNull( q);
        List<QLCX> list1 = QLCXsServices.getDataQLCXs();
        for(QLCX a2 :list1){
            e = a2.getGhe();
        }
            Assert.assertEquals("6", e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }  
    }
}
