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
public class ChucVu {
    private int idchucvu;
    private String maCB;
    private String chucVu;
    private double PCChucVu;
    private Date thoiGianBD;
    public ChucVu(int id,String ma,String chuc,double pc,Date a){
        this.idchucvu = id;
        this.maCB = ma;
        this.PCChucVu = pc;
        this.chucVu = chuc;
        this.thoiGianBD = a;
    }

    public void setIdchucvu(int idchucvu) {
        this.idchucvu = idchucvu;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setPCChucVu(double PCChucVu) {
        this.PCChucVu = PCChucVu;
    }

    public void setThoiGianBD(Date thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public int getIdchucvu() {
        return idchucvu;
    }

    public String getMaCB() {
        return maCB;
    }

    public String getChucVu() {
        return chucVu;
    }

    public double getPCChucVu() {
        return PCChucVu;
    }

    public Date getThoiGianBD() {
        return thoiGianBD;
    }
    
}
