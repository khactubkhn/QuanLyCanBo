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
public class DBChucVu {
        //Lấy tất cả chức danh của tất cả cán bộ
        public ArrayList<ChucVu> getAllCanBo(){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChucVu> arrayList = null;
        try {

            String sql = " SELECT * FROM `chuc_vu`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idChucDanh = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String chucVu = resultSet.getString(3);
                double pcChucVu = resultSet.getDouble(4);
                Date thoiGianBD = resultSet.getDate(5);
                ChucVu chucvu = new ChucVu(idChucDanh, maCB, chucVu,pcChucVu, thoiGianBD);
                arrayList.add(chucvu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Lấy tất cả chức danh của cán bộ khi đã có MaCB
    public ArrayList<ChucVu> getAll(String macb){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChucVu> arrayList = null;
        try {

            String sql = " SELECT * FROM `chuc_vu` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,macb);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int idChucVu = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String chucVu = resultSet.getString(3);
                double pcChucVu = resultSet.getDouble(4);
                Date thoiGianBD = resultSet.getDate(5);
                ChucVu chucvu = new ChucVu(idChucVu, maCB, chucVu, pcChucVu, thoiGianBD);
                arrayList.add(chucvu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChucVu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Chèn thêm chức danh cho 1 cán bộ cụ thể
    public ChucVu addNew(String macb,ChucVu ChucVu){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "INSERT INTO `chuc_vu` VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ChucVu.getIdchucvu());
            preparedStatement.setString(2, macb);
            preparedStatement.setString(3, ChucVu.getChucVu());
            preparedStatement.setDouble(3, ChucVu.getPCChucVu());
            Date thoiGianBD = ChucVu.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(5, dateSql);
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChucVu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return ChucVu;
        } else {
            return null;
        }
    }
    //Xóa chức danh của 1 cán bộ cụ thể
        public ChucVu deleteChucVu(ChucVu chucvu) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int delete = 0;
        try {

            String sql = "DELETE FROM `chuc_vu` WHERE idchucvu = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,chucvu.getIdchucvu());
            delete = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (delete > 0) {
            return chucvu;
        } else {
            return null;
        }
    }
    //Cập nhât chức danh của 1 cán bộ
    public ChucVu updateChucVu(CanBo canBo,ChucVu ChucVu){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "UPDATE `chuc_vu` SET `idChucVu`=?,`ChucVu`=?,`PCChucVu`=?,`ThoiGianBD`=? WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ChucVu.getIdchucvu());
            preparedStatement.setString(2, ChucVu.getChucVu());
            preparedStatement.setDouble(3, ChucVu.getPCChucVu());
            Date thoiGianBD = ChucVu.getThoiGianBD();
            java.sql.Date dateSql = new java.sql.Date(thoiGianBD.getTime());
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setString(5, canBo.getMaCB());
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChucVu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return ChucVu;
        } else {
            return null;
        }
    }
}
