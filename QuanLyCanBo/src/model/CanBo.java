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
public class CanBo {

    private String maCB;
    private String hoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private String maSoThue;
    private String soTaiKhoan;
    private String diaChi;
    private String SDT;
    private String email;
    private double PCGiangDay;
    private String thanhTichKhac;
    private int user_level;
    private String password;
    private Date ngayBD;

    public CanBo(String maCB, String hoTen, Date ngaySinh, int gioiTinh, String maSoThue, String soTaiKhoan, String diaChi, String SDT, String email, double PCGiangDay, String thanhTichKhac, int user_level, String password, Date ngayBD) {
        this.maCB = maCB;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maSoThue = maSoThue;
        this.soTaiKhoan = soTaiKhoan;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
        this.PCGiangDay = PCGiangDay;
        this.thanhTichKhac = thanhTichKhac;
        this.user_level = user_level;
        this.password = password;
        this.ngayBD = ngayBD;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPCGiangDay() {
        return PCGiangDay;
    }

    public void setPCGiangDay(double PCGiangDay) {
        this.PCGiangDay = PCGiangDay;
    }

    public String getThanhTichKhac() {
        return thanhTichKhac;
    }

    public void setThanhTichKhac(String thanhTichKhac) {
        this.thanhTichKhac = thanhTichKhac;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    

}
