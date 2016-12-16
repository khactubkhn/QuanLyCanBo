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
public class ThongTinGiaDinh {
    private Integer id;
    private String maCB;
    private String hoTen;
    private Date ngaySinh;

    public ThongTinGiaDinh(Integer id, String maCB, String hoTen, Date ngaySinh) {
        this.id = id;
        this.maCB = maCB;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public Integer getId() {
        return id;
    }

    public String getMaCB() {
        return maCB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }  
}
