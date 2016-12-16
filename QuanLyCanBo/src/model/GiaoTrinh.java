/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tu
 */
public class GiaoTrinh {
    private int idGiaoTrinh;
    private String maCB;
    private String tenGiaoTrinh;
    private int namXuatBan;
    private String nhaXuatBan;

    public GiaoTrinh(int idGiaoTrinh, String maCB, String tenGiaoTrinh, int namXuatBan, String nhaXuatBan) {
        this.idGiaoTrinh = idGiaoTrinh;
        this.maCB = maCB;
        this.tenGiaoTrinh = tenGiaoTrinh;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
    }

    

    public void setIdGiaoTrinh(int idGiaoTrinh) {
        this.idGiaoTrinh = idGiaoTrinh;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public void setTenGiaoTrinh(String tenGiaoTrinh) {
        this.tenGiaoTrinh = tenGiaoTrinh;
    }

    

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getIdGiaoTrinh() {
        return idGiaoTrinh;
    }

    public String getMaCB() {
        return maCB;
    }

    public String getTenGiaoTrinh() {
        return tenGiaoTrinh;
    }

    

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    
    
}
