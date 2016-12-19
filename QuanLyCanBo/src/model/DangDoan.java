/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Windows 10
 */
public class DangDoan {
    private int id;
    private String maCB;
    private int doan;
    private Date ngayVaoDoan;
    private int dang;
    private Date ngayVaoDang;
    private int congDoan;
    private Date ngayVaoCongDoan;

    public DangDoan(int id, String maCB, int doan, Date ngayVaoDoan, int dang, Date ngayVaoDang, int congDoan, Date ngayVaoCongDoan) {
        this.id = id;
        this.maCB = maCB;
        this.doan = doan;
        this.ngayVaoDoan = ngayVaoDoan;
        this.dang = dang;
        this.ngayVaoDang = ngayVaoDang;
        this.congDoan = congDoan;
        this.ngayVaoCongDoan = ngayVaoCongDoan;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public int getDang() {
        return dang;
    }

    public void setDang(int dang) {
        this.dang = dang;
    }

    public Date getNgayVaoDang() {
        return ngayVaoDang;
    }

    public void setNgayVaoDang(Date ngayVaoDang) {
        this.ngayVaoDang = ngayVaoDang;
    }

    public int getDoan() {
        return doan;
    }

    public void setDoan(int doan) {
        this.doan = doan;
    }

    public Date getNgayVaoDoan() {
        return ngayVaoDoan;
    }

    public void setNgayVaoDoan(Date ngayVaoDoan) {
        this.ngayVaoDoan = ngayVaoDoan;
    }

    public int getCongDoan() {
        return congDoan;
    }

    public void setCongDoan(int congDoan) {
        this.congDoan = congDoan;
    }

    public Date getNgayVaoCongDoan() {
        return ngayVaoCongDoan;
    }

    public void setNgayVaoCongDoan(Date ngayVaoCongDoan) {
        this.ngayVaoCongDoan = ngayVaoCongDoan;
    }
    
}
