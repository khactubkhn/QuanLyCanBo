/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author wh1t3r0s3
 */
public class HeSoLuong {
    private int idhesoluong;
    private String maCB;
    private double hsluong;
    private Date thoiGianBD;
    public HeSoLuong(int id,String ma,double hs,Date da){
        this.idhesoluong = id;
        this.hsluong = hs;
        this.maCB = ma;
        this.thoiGianBD = da;
    }

    public void setIdhesoluong(int idhesoluong) {
        this.idhesoluong = idhesoluong;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public void setHsluong(double hsluong) {
        this.hsluong = hsluong;
    }

    public void setThoiGianBD(Date thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public int getIdhesoluong() {
        return idhesoluong;
    }

    public String getMaCB() {
        return maCB;
    }

    public double getHsluong() {
        return hsluong;
    }

    public Date getThoiGianBD() {
        return thoiGianBD;
    }
    
}
