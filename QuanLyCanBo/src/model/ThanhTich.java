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
public class ThanhTich {
    private int idThanhTich;
    private int idGiaDinh;
    private String danhHieu;
    private String datGiaiCap;
    private int nam;

    public ThanhTich(int idThanhTich, int idGiaDinh, String danhHieu, String datGiaiCap, int nam) {
        this.idThanhTich = idThanhTich;
        this.idGiaDinh = idGiaDinh;
        this.danhHieu = danhHieu;
        this.datGiaiCap = datGiaiCap;
        this.nam = nam;
    }

    

    public int getIdThanhTich() {
        return idThanhTich;
    }

    public int getIdGiaDinh() {
        return idGiaDinh;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public int getNam() {
        return nam;
    }

    public void setIdThanhTich(int idThanhTich) {
        this.idThanhTich = idThanhTich;
    }

    public void setIdGiaDinh(int idGiaDinh) {
        this.idGiaDinh = idGiaDinh;
    }

    public void setDanhHieu(String danhHieu) {
        this.danhHieu = danhHieu;
    }

   
    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getDatGiaiCap() {
        return datGiaiCap;
    }

    public void setDatGiaiCap(String datGiaCap) {
        this.datGiaiCap = datGiaCap;
    }
    
}
