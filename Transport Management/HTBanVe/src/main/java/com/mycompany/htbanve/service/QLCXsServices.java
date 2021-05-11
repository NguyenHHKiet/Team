/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Tuan Anh
 */
public class QLCXsServices {
    
    private Connection conn = JdbcUtils.getConnection();

    public QLCXsServices(Connection conn) {
        this.conn = conn;
    }
    
    public List<QLCX> getDataQLCXs(String kw) throws SQLException{
        if (kw == null) {
            throw new SQLDataException();
        }

        String sql = "SELECT * FROM qlcx WHERE name like concat('%', ?, '%') ORDER BY id DESC";
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, kw);

        ResultSet rs = stm.executeQuery();
        
        
        List<QLCX> results = new ArrayList<>();
        while(rs.next()){
            QLCX c = new QLCX();
            c.setId(rs.getInt("idQLCX"));
            c.setTencx(rs.getString("QLCXtencx"));
            c.setBsx(rs.getString("QLCXbsx"));
            c.setLoaixe(rs.getString("QLCXloaixe"));
            c.setNgaykh(rs.getString("QLCXngaykh"));
            c.setGiokh(rs.getString("QLCXgiokh"));
            c.setGiave(rs.getString("QLCXgiave"));
            c.setGhe(rs.getString("QLCXghe"));
            c.setTennv(rs.getString("QLCXtennv"));
            c.setSdtnv(rs.getString("QLCXsdtnv"));
            
              
            results.add(c);
        }
        return results;
    }
    public static ObservableList<QLCX> getDataQLCX(){
        Connection conn = JdbcUtils.getConnection();
        ObservableList<QLCX> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from qlcx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 list.add(new QLCX(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx")
                         ,rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXngaykh"),rs.getString("QLCXgiokh")
                         ,rs.getString("QLCXgiave"),rs.getString("QLCXghe"),rs.getString("QLCXtennv")
                         ,rs.getString("QLCXsdtnv"),rs.getString("idphanbiet")));  

            }
        } catch (SQLException e) {
        }
        return list;
    }
    public static void addCX(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "INSERT INTO qlcx (idQLCX,QLCXtencx,QLCXbsx,QLCXloaixe,QLCXngaykh,QLCXgiokh,QLCXgiave"
                    + ",QLCXghe,QLCXtennv,QLCXsdtnv,idphanbiet)values(?,?,?,?,?,?,?,?,?,?,?)";
        String rd = UUID.randomUUID().toString();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst .setInt(1, Integer.parseInt(a));
        pst.setString(2,b);
        pst.setString(3,c);
        pst.setString(4,d);
        pst.setString(5,e);
        pst.setString(6,f);
        pst.setString(7,g);
        pst.setString(8,h);
        pst.setString(9,i);
        pst.setString(10,k);
        pst.setString(11,rd);               
        pst.execute();
    }
    public static void EditCX(String value1, String value2, String value3, String value4
            ,String value5,String value6,String value7,String value8,String value9,String value10) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "UPDATE qlcx set idQLCX= '"+value1+ "', QLCXtencx= '"+value2+"',QLCXbsx= '"+value3+"',QLCXloaixe= '"+
                value4+"',QLCXngaykh= '"+value5+"',QLCXgiokh= '"+value6+"',QLCXgiave= '"+
                value7 +"',QLCXghe='"+value8 +"',QLCXtennv= '"+value9+"',QLCXsdtnv= '"+value10+"' where idQLCX = '"+value1+"'";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }
    public static boolean deleteQLCX(int id) throws SQLException{
        try {
            Connection conn = JdbcUtils.getConnection();
            String sql = "DELETE FROM qlcx where idQLCX = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            
            int row = stm.executeUpdate();
            
            return row > 0;
        } catch (SQLException ex) {
            Logger.getLogger(QLCXsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    

}
