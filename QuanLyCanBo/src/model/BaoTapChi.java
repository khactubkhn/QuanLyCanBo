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
public class BaoTapChi {
    private int idBao;
    private String  maCB;
    private String tenBao;
    private int soBao;
    private Date ngayXuatBan;
    private double chiSoISSN;
    private double heSoIF;

    public BaoTapChi(int idBao, String maCB, String tenBao, int soBao, Date ngayXuatBan, double chiSoISSN, double heSoIF) {
        this.idBao = idBao;
        this.maCB = maCB;
        this.tenBao = tenBao;
        this.soBao = soBao;
        this.ngayXuatBan = ngayXuatBan;
        this.chiSoISSN = chiSoISSN;
        this.heSoIF = heSoIF;
    }

    public int getIdBao() {
        return idBao;
    }

    public String getMaCB() {
        return maCB;
    }

    public String getTenBao() {
        return tenBao;
    }

    public int getSoBao() {
        return soBao;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public double getChiSoISSN() {
        return chiSoISSN;
    }

    public double getHeSoIF() {
        return heSoIF;
    }

    public void setIdBao(int idBao) {
        this.idBao = idBao;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public void setTenBao(String tenBao) {
        this.tenBao = tenBao;
    }

    public void setSoBao(int soBao) {
        this.soBao = soBao;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public void setChiSoISSN(double chiSoISSN) {
        this.chiSoISSN = chiSoISSN;
    }

    public void setHeSoIF(double heSoIF) {
        this.heSoIF = heSoIF;
    }
    
}
