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
public class DBhsLuong {
        //Lấy tất cả chức danh của cán bộ khi đã có MaCB
    public ArrayList<HeSoLuong> getAllCanBo(){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<HeSoLuong> arrayList = null;
        try {

            String sql = " SELECT * FROM `hsLuong`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idhsLuong = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                double hsLuong = resultSet.getDouble(3);
                Date thoiGianBD = resultSet.getDate(4);
                HeSoLuong hsluong = new HeSoLuong(idhsLuong, maCB, hsLuong, thoiGianBD);
                arrayList.add(hsluong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBhsLuong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Lấy tất cả chức danh của cán bộ khi đã có MaCB
    public ArrayList<HeSoLuong> getAll(String macb){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<HeSoLuong> arrayList = null;
        try {

            String sql = " SELECT * FROM `hsLuong` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,macb);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idhsLuong = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                double hsLuong = resultSet.getDouble(3);
                Date thoiGianBD = resultSet.getDate(4);
                HeSoLuong hsluong = new HeSoLuong(idhsLuong, maCB, hsLuong, thoiGianBD);
                arrayList.add(hsluong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBhsLuong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Chèn thêm chức danh cho 1 cán bộ cụ thể
    public HeSoLuong addNew(String macb,HeSoLuong hsLuong){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "INSERT INTO `hsLuong` VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hsLuong.getIdhesoluong());
            preparedStatement.setString(2, macb);
            preparedStatement.setDouble(3, hsLuong.getHsluong());
            Date thoiGianBD = hsLuong.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(4, dateSql);
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBhsLuong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return hsLuong;
        } else {
            return null;
        }
    }
    //Xóa chức danh của 1 cán bộ cụ thể
        public HeSoLuong deletehsLuong(HeSoLuong hsLuong) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int delete = 0;
        try {

            String sql = "DELETE FROM `hsLuong` WHERE `idhsluong` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,hsLuong.getIdhesoluong());
            delete = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (delete > 0) {
            return hsLuong;
        } else {
            return null;
        }
    }
    //Cập nhât chức danh của 1 cán bộ
    public HeSoLuong updatehsLuong(HeSoLuong hsLuong){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "UPDATE `hsLuong` SET `hsLuong`=?,`ThoiGianBD`=? WHERE `idhsluong`=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, hsLuong.getHsluong());
            Date thoiGianBD = hsLuong.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(2, dateSql);
            preparedStatement.setInt(3, hsLuong.getIdhesoluong());
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBhsLuong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return hsLuong;
        } else {
            return null;
        }
    }
}
