/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBThongKe {

    public ArrayList<CanBo> thongKeGioTinh(int gioiTinh, int nam) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> listCanBo = null;
        try {

            String sql = " select * from `can_bo` where GioiTinh = ?  and NgayBD < ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gioiTinh);
            String ngay = "30/12/" + nam;
            Date dateUtil = dateFormat.parse(ngay);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            preparedStatement.setDate(2, dateSql);
            resultSet = preparedStatement.executeQuery();
            listCanBo = new ArrayList<>();
            while (resultSet.next()) {
                String maCanBo = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gt = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTK = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcgd = resultSet.getDouble(10);
                String thanhtich = resultSet.getString(11);
                int user = resultSet.getInt(12);
                String pass = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canBo = new CanBo(maCanBo, hoTen, ngaySinh, gt, maSoThue, soTK, diaChi, sdt, email, pcgd, thanhtich, user, pass, ngayBD);
                listCanBo.add(canBo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCanBo;
    }

    public int getYear(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngayCurrent = dateFormat.format(date);
        String s[] = new String[3];
        s = ngayCurrent.split("/");
        String nam = s[2];
        return Integer.parseInt(nam);
    }

    public ResultSet getResultSetDoanVien(String nam) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select c.MaCB ,c. HoTen, c.NgaySinh,c .SoTaiKhoan from can_bo c, doan_dang_congdoan d where c. MaCB = d.MaCB and d.NgayVaoDoan < ? and c.MaCB not in (select d1.MaCB from doan_dang_congdoan d1 where d1.NgayVaoDang < ?)";
            preparedStatement = connection.prepareStatement(sql);
            String ngay = "30/12/" + nam;
            Date dateUtil = dateFormat.parse(ngay);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            preparedStatement.setDate(1, dateSql);
            preparedStatement.setDate(2, dateSql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }

    public ResultSet getResultSetDangVien(String nam) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select cb.MaCB, cb. HoTen, cb.NgaySinh,hs.hsluong,cv.ChucVu, cv.PCChucVu, cb.PCGiangDay from can_bo as cb,chuc_vu as cv ,doan_dang_congdoan as dd,hsluong as hs "
                    + " where  cb.MaCB = cv.MaCB and cb.MaCB = hs.MaCB and cb.MaCB = dd.MaCB "
                    + " and dd.DangVien = 1 and dd.NgayVaoDang < ? "
                    + " and cv.ThoiGianBD = ( select max(ThoiGianBD) from chuc_vu cv1 where cv1.MaCB = cb.MaCB and cv1.ThoiGianBD < ? )"
                    + " and hs.ThoiGianBD = ( select max(ThoiGianBD) from hsluong hs1 where hs1.MaCB = hs.MaCB and hs1.ThoiGianBD < ? )";
            preparedStatement = connection.prepareStatement(sql);
            String ngay = "30/12/" + nam;
            Date dateUtil = dateFormat.parse(ngay);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            preparedStatement.setDate(1, dateSql);
            preparedStatement.setDate(2, dateSql);
            preparedStatement.setDate(3, dateSql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }

    public ResultSet getResultSetCongDoanVien(String nam) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select cb.MaCB,cb.HoTen,cb.NgaySinh,cv.ChucVu, cv.PCChucVu, hs.hsluong from  can_bo AS  cb, hsluong AS  hs, chuc_vu AS cv where cb.MaCB = hs .MaCB and cb.MaCB = cv.MaCB and cv.ThoiGianBD >= ALL (select cv1.ThoiGianBD FROM chuc_vu cv1 where cv1.MaCB = cb.MaCB ) AND hs.ThoiGianBD >= ALL(SELECT hs1.ThoiGianBD from hsluong hs1 where hs1.MaCB = cb.MaCB)  AND hs.ThoiGianBD <?  and cv.ThoiGianBD < ? ";
            preparedStatement = connection.prepareStatement(sql);
            String ngay = "30/12/" + nam;
            Date dateUtil = dateFormat.parse(ngay);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            preparedStatement.setDate(1, dateSql);
            preparedStatement.setDate(2, dateSql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }

    public ResultSet thongkeTienGiaoVien() {
//        Connection connection = MyConnection.open();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//
//            String sql = "select cb.MaCB, cb.HoTen,gd.TenMH,gd.SoSinhVien from  can_bo cb , giang_day gd where cb.MaCB = gd.MaCB";
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return resultSet;
        return null;

    }

    public ResultSet thongkeThieuNhi() {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = " select  gd.HoTen,gd.NgaySinh , gd.MaCB ,cb.HoTen from gia_dinh gd , can_bo cb where cb.MaCB = gd.MaCB;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }

    public static void main(String[] args) {
        DBThongKe dBThongKe = new DBThongKe();
        ResultSet resultSet = dBThongKe.getResultSetDangVien("2014");
        if (resultSet == null) {
            System.out.println("sai mat roi em oi");
        } else {
            try {
                while (resultSet.next()) {
                    System.out.println("dfdfdf" + resultSet.getString(1));
                }
                System.out.println("dung roi em oi");
            } catch (SQLException ex) {
                Logger.getLogger(DBThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
