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
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wh1t3r0s3
 */
public class DBThongTinCaNhan {

    public CanBo getCanBo(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CanBo canBo = null;
        try {

            String sql = " select * from `can_bo` where MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maCanBo = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
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
                canBo = new CanBo(maCanBo, hoTen, ngaySinh, gioiTinh, maSoThue, soTK, diaChi, sdt, email, pcgd, thanhtich, user, pass, ngayBD);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canBo;
    }

    public ResultSet  getChucVu(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select * from chuc_vu cv, can_bo cb where cv.MaCB = cb.MaCB and cv.ThoiGianBD = (select max(cv1.ThoiGianBD) from chuc_vu cv1 where cv1.MaCB = cv.MaCB) and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
     public ResultSet  getLSChucVu(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select cv.ChucVu , cv.ThoiGianBD from chuc_vu cv, can_bo cb where cv.MaCB = cb.MaCB and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
      public ResultSet  getChucDanh(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select * from chuc_danh cd, can_bo cb where cd.MaCB = cb.MaCB and cd.ThoiGianBD = (select max(cd1.ThoiGianBD) from chuc_danh cd1 where cd1.MaCB = cb.MaCB) and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
      
       public ResultSet  getLSChucDanh(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select cd.ChucDanh , cd.ThoiGianBD from chuc_danh cd, can_bo cb where cd.MaCB = cb.MaCB and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
        public ResultSet  getHeSoLuong(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select * from hsluong hs, can_bo cb where hs.MaCB = cb.MaCB and hs.ThoiGianBD = (select max(hs1.ThoiGianBD) from hsluong hs1 where hs1.MaCB = cb.MaCB) and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
         public ResultSet  getLSHeSoLuong(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select hs.hsluong , hs.ThoiGianBD from hsluong hs, can_bo cb where hs.MaCB = cb.MaCB and cb.MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
        
        
    public static void main(String[] args) {
        DBThongTinCaNhan bThongTinCaNhan = new DBThongTinCaNhan();
        ResultSet resultSet = bThongTinCaNhan.getLSHeSoLuong("cb01");
    }

}
