/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
/**
 *
 * @author Tuan Anh
 */
public class QLCX {
    private int id;
    private String tencx,bsx,giokh,giave,tennv,sdtnv,loaixe,ghe,ngaykh,idphanbiet;
    public QLCX(int id, String tencx, String bsx,String loaixe, String giokh, String ngaykh, String giave, String tennv, String sdtnv,String ghe,String idphanbiet) {
        this.id = id;
        this.tencx = tencx;
        this.bsx = bsx;
        this.loaixe = loaixe;
        this.giokh = giokh;
        this.ngaykh = ngaykh;
        this.giave = giave;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.ghe = ghe;
        this.idphanbiet = idphanbiet;
    }
    public QLCX(int id, String tencx, String bsx,String loaixe, String giokh, String ngaykh, String giave, String tennv, String sdtnv,String ghe) {
        this.id = id;
        this.tencx = tencx;
        this.bsx = bsx;
        this.loaixe = loaixe;
        this.giokh = giokh;
        this.ngaykh = ngaykh;
        this.giave = giave;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.ghe = ghe;
        
    }

    public QLCX(String id, String text, String text0, String text1, String text2, Callback<DatePicker, DateCell> dayCellFactory, String text3, String text4, String text5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGhe(String ghe) {
        this.ghe = ghe;
    }

    public String getGhe() {
        return ghe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTencx(String tencx) {
        this.tencx = tencx;
    }

    public void setBsx(String bsx) {
        this.bsx = bsx;
    }

    public void setGiokh(String giokh) {
        this.giokh = giokh;
    }

    public void setNgaykh(String ngaykh) {
        this.ngaykh = ngaykh;
    }

    public void setGiave(String giave) {
        this.giave = giave;
    }


    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }
    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }
    public String getIdphanbiet() {
        return idphanbiet;
    }

    public void setIdphanbiet(String idphanbiet) {
        this.idphanbiet = idphanbiet;
    }

    public int getId() {
        return id;
    }

    public String getTencx() {
        return tencx;
    }

    public String getBsx() {
        return bsx;
    }

    public String getGiokh() {
        return giokh;
    }

    public String getNgaykh() {
        return ngaykh;
    }

    public String getGiave() {
        return giave;
    }


    public String getTennv() {
        return tennv;
    }

    public String getSdtnv() {
        return sdtnv;
    }
}
