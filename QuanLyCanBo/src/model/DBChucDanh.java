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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class DBChucDanh {
    //Lấy tất cả chức danh của tất cả cán bộ
        public ArrayList<ChucDanh> getAllCanBo(){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChucDanh> arrayList = null;
        try {

            String sql = " SELECT * FROM `chuc_danh`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idChucDanh = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String chucDanh = resultSet.getString(3);
                Date thoiGianBD = resultSet.getDate(4);
                ChucDanh chucdanh = new ChucDanh(idChucDanh, maCB, chucDanh, thoiGianBD);
                arrayList.add(chucdanh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Lấy tất cả chức danh của cán bộ khi đã có MaCB
    public ArrayList<ChucDanh> getAll(String macb){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChucDanh> arrayList = null;
        try {

            String sql = " SELECT * FROM `chuc_danh` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,macb);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idChucDanh = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String chucDanh = resultSet.getString(3);
                Date thoiGianBD = resultSet.getDate(4);
                ChucDanh chucdanh = new ChucDanh(idChucDanh, maCB, chucDanh, thoiGianBD);
                arrayList.add(chucdanh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Chèn thêm chức danh cho 1 cán bộ cụ thể
    public ChucDanh addNew(String maCB,ChucDanh chucDanh){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "INSERT INTO `chuc_danh` VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chucDanh.getId());
            preparedStatement.setString(2, maCB);
            preparedStatement.setString(3, chucDanh.getChucDanh());
            Date thoiGianBD = chucDanh.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(4, dateSql);
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return chucDanh;
        } else {
            return null;
        }
    }
    //Xóa chức danh của 1 cán bộ cụ thể
        public ChucDanh deleteChucDanh(ChucDanh chucDanh) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int delete = 0;
        try {

            String sql = "DELETE FROM `chuc_danh` WHERE idchucdanh = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,chucDanh.getId());
            delete = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (delete > 0) {
            return chucDanh;
        } else {
            return null;
        }
    }
    //Cập nhât chức danh của 1 cán bộ
    public ChucDanh updateChucDanh(ChucDanh chucDanh){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "UPDATE `chuc_danh` SET `ChucDanh`=?,`ThoiGianBD`=? WHERE `idchucdanh`=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chucDanh.getChucDanh());
            Date thoiGianBD = chucDanh.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(2, dateSql);
            preparedStatement.setInt(3, chucDanh.getId());
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return chucDanh;
        } else {
            return null;
        }
    }

}
