/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tu
 */
public class DeTaiNghienCuu {
    private String maDeTai;
    private String maCanBo;
    private String tenDeTai;
    private String cap;
    private double kinhPhi;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String chuTriDeTai;
    private String ketQua;

    public DeTaiNghienCuu(String maDeTai, String maCanBo, String tenDeTai, String cap, double kinhPhi, Date ngayBatDau, Date ngayKetThuc, String chuTriDeTai, String ketQua) {
        this.maDeTai = maDeTai;
        this.maCanBo = maCanBo;
        this.tenDeTai = tenDeTai;
        this.cap = cap;
        this.kinhPhi = kinhPhi;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.chuTriDeTai = chuTriDeTai;
        this.ketQua = ketQua;
    }

    public String getMaDeTai() {
        return maDeTai;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public String getCap() {
        return cap;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public String getChuTriDeTai() {
        return chuTriDeTai;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setKinhPhi(double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public void setChuTriDeTai(String chuTriDeTai) {
        this.chuTriDeTai = chuTriDeTai;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    
    
}
