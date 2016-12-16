/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ChamThi {

    private int ID;
    private String maLop;
    private String maCanBo;
    private Date ngayNop;
    private int soBaiThi;

    public ChamThi(int ID, String maLop, String maCanBo,Date ngayNop, int soBaiThi) {
        this.ID = ID;
        this.maLop = maLop;
        this.maCanBo = maCanBo;
        this.ngayNop = ngayNop;
        this.soBaiThi = soBaiThi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }


    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public int getSoBaiThi() {
        return soBaiThi;
    }

    public void setSoBaiThi(int soBaiThi) {
        this.soBaiThi = soBaiThi;
    }

   

}
