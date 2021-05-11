/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;
import com.mycompany.htbanve.pojo.QLBV;

import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
/**
 *
 * @author Tuan Anh
 */
public class QLBVServices {
    private Connection conn = JdbcUtils.getConnection();

    public QLBVServices(Connection conn) {
        this.conn = conn;
    }
    public List<QLBV> getDataQLBV(String kw) throws SQLException {
        if (kw == null)
            throw new SQLDataException();
        
        String sql = "Select * from qlbv WHERE name like concat('%', ?, '%') ORDER BY id DESC";
        
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, kw);
       
        ResultSet rs = stm.executeQuery();
        
        
        List<QLBV> results = new ArrayList<>();
        while(rs.next()){
            QLBV v = new QLBV();
            v.setId(rs.getString("QLBVid"));
            v.setTencx(rs.getString("QLBVtencx"));
            v.setBsx(rs.getString("QLBVbsx"));
            v.setLoaixe(rs.getString("QLBVloaixe"));
            v.setNgaykh(rs.getString("QLBVngaykh"));
            v.setGiokh(rs.getString("QLBVgiokh"));
            v.setGiave(rs.getString("QLBVgiave"));
            v.setGhe(rs.getString("QLBVghe"));
            v.setTennv(rs.getString("QLBVtennv"));
            v.setSdtnv(rs.getString("QLBVsdtnv"));
            v.setTenkh(rs.getString("QLBVtenkh"));
            v.setSdtkh(rs.getString("QLBVsdtkh"));
            results.add(v);
        }
        return results;
    }
    public static ObservableList<QLBV> getDataQLBV2(){
        Connection conn = JdbcUtils.getConnection();
        ObservableList<QLBV> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from qlbv");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 list.add(new QLBV((rs.getString("QLBVid")),rs.getString("QLBVtencx"),rs.getString("QLBVbsx")
                         ,rs.getString("QLBVloaixe"),rs.getString("QLBVngaykh"), rs.getString("QLBVgiokh")
                         ,rs.getString("QLBVgiave"),rs.getString("QLBVghe"),rs.getString("QLBVtennv"),rs.getString("QLBVsdtnv")
                         , rs.getString("QLBVtenkh"),rs.getString("QLBVsdtkh"),rs.getString("idphanbiet")));  

            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static void updateQLBV(String value1, String value2, String value3, String value4) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "UPDATE qlbv set QLBVtenkh= '"+value1+"',QLBVsdtkh= '"+value2+"',QLBVghe='"+value3+"' where QLBVid = '"+value4+"' ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }
    public static void addVe(String value1, String value2, String value3, String value4
            ,String value5,String value6,String value7,String value8,String value9,String value10
            ,String value11, String value12) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String rd = UUID.randomUUID().toString();
        String sql = "INSERT INTO qlbv (QLBVid,QLBVtencx,QLBVbsx,QLBVloaixe,QLBVngaykh,QLBVgiokh"
                + ",QLBVgiave,QLBVghe,QLBVtennv,QLBVsdtnv,QLBVtenkh,QLBVsdtkh,idphanbiet)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);                
            pst.setString(1, value1 );
            pst.setString(2,value2);
            pst.setString(3,value3);
            pst.setString(4,value4);
            pst.setString(5,value5);
            pst.setString(6,value6);
            pst.setString(7,value7);
            pst.setString(8,value8);
            pst.setString(9,value9);
            pst.setString(10,value10);
            pst.setString(11,value11);
            pst.setString(12,value12);
            pst.setString(13,rd);
            pst.execute();   
    }
    public static void GiamGhe(String value1, String value2) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql2 = "UPDATE qlcx set QLCXghe= '"+value1+"' where idQLCX = '"+value2+"' ";
        PreparedStatement pst = conn.prepareStatement(sql2);
        pst.execute(); 
    }
    public static void KiemtraNgayGio(String a, String b) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "Select * from qlbv where QLBVngaykh = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            String sql1 = "Select * from qlbv where QLBVgiokh = ? ";
                PreparedStatement pst1 = conn.prepareStatement(sql1);
                pst1.setString(1,b);
                ResultSet rs1 = pst1.executeQuery();
            if(rs1.next()){
                String sql3 = "DELETE FROM qlcx where QLCXngaykh = ? and QLCXgiokh = ?";
                    PreparedStatement pst2 = conn.prepareStatement(sql3);
                    pst2.setString(1, a);
                    pst2.setString(2, b);
                    pst2.execute();
                String sql4 = "DELETE FROM qlbv where QLBVngaykh = ? and QLBVgiokh = ?";
                    PreparedStatement pst3 = conn.prepareStatement(sql4);
                    pst3.setString(1,a);
                    pst3.setString(2,b);
                    pst3.execute();
            }
        }
    }
    public static void XoaVe(String a) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        
        try {
                String sql1 = "select QLCXghe from qlcx"; 
                PreparedStatement pst1 = conn.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();              
                if(rs1.next()){ 
                    Integer d = (Integer.parseInt(rs1.getString(1))) + 1;
                    String value1 = d.toString();
                    String value2 = a;
                    String sql3 = "UPDATE qlcx set QLCXghe= '"+value1+"' where QLCXid = '"+value2+"' ";
                    PreparedStatement pst2 = conn.prepareStatement(sql3);
                    pst2.execute(); 
                    
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
        String sql = "DELETE FROM qlbv where QLBVid = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, a);
        pst.execute();
    }
}
