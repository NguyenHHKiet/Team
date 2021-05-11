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
public class QLBV {
    private String id,tencx,bsx,loaixe,ngaykh,giokh,giave,ghe,tennv,sdtnv,tenkh,sdtkh,idphanbiet;
    public QLBV(String id,String tencx, String bsx,String loaixe, String ngaykh, String giokh, String giave,String ghe
            ,String tennv, String sdtnv,String tenkh, String sdtkh, String idphanbiet) {
        this.id = id;
        this.tencx = tencx;
        this.bsx = bsx;
        this.loaixe = loaixe;
        this.ngaykh = ngaykh;
        this.giokh = giokh;
        this.giave = giave;
        this.ghe = ghe;
        this.tenkh = tenkh;
        this.sdtkh = sdtkh;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.idphanbiet = idphanbiet;
    }

    public QLBV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setGiave(String giave) {
        this.giave = giave;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

    public void setNgaykh(String ngaykh) {
        this.ngaykh = ngaykh;
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

    public String getGiave() {
        return giave;
    }

    public String getTennv() {
        return tennv;
    }

    public String getSdtnv() {
        return sdtnv;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public String getTenkh() {
        return tenkh;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public String getNgaykh() {
        return ngaykh;
    }
    public void setGhe(String ghe) {
        this.ghe = ghe;
    }

    public String getGhe() {
        return ghe;
    }

    /**
     * @return the idphanbiet
     */
    public String getIdphanbiet() {
        return idphanbiet;
    }

    /**
     * @param idphanbiet the idphanbiet to set
     */
    public void setIdphanbiet(String idphanbiet) {
        this.idphanbiet = idphanbiet;
    }

    
}
