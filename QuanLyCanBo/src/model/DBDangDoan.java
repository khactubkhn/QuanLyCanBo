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
public class DBDangDoan {
        //Lấy tất cả đảng đoàn của tất cả cán bộ
        public ArrayList<DangDoan> getAllCanBo(){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DangDoan> arrayList = null;
        try {

            String sql = " SELECT * FROM `doan_dang_congdoan`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                int doan = resultSet.getInt(3);
                Date ngayVaoDoan = resultSet.getDate(4);
                int dang = resultSet.getInt(5);
                Date ngayVaoDang = resultSet.getDate(6);
                int congDoan = resultSet.getInt(7);
                Date ngayVaoCongDoan = resultSet.getDate(8);
                DangDoan dangDoan = new DangDoan(id,maCB,doan,ngayVaoDoan,dang,ngayVaoDang,congDoan,ngayVaoCongDoan);
                arrayList.add(dangDoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDangDoan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Lấy tất cả đảng đoàn của cán bộ khi đã có MaCB
    public ArrayList<DangDoan> getAll(String macb){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DangDoan> arrayList = null;
        try {

            String sql = " SELECT * FROM `doan_dang_congdoan` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,macb);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                int doan = resultSet.getInt(3);
                Date ngayVaoDoan = resultSet.getDate(4);
                int dang = resultSet.getInt(5);
                Date ngayVaoDang = resultSet.getDate(6);
                int congDoan = resultSet.getInt(7);
                Date ngayVaoCongDoan = resultSet.getDate(8);
                DangDoan dangDoan = new DangDoan(id,maCB,doan,ngayVaoDoan,dang,ngayVaoDang,congDoan,ngayVaoCongDoan);
                arrayList.add(dangDoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Chèn thêm đảng đoàn cho 1 cán bộ cụ thể
    public DangDoan addNew(String maCB,DangDoan dangDoan){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "INSERT INTO `doan_dang_congdoan` VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dangDoan.getId());
            preparedStatement.setString(2, maCB);
            preparedStatement.setInt(3, dangDoan.getDoan());
            Date ngayVaoDoan = dangDoan.getNgayVaoDoan();
            if(ngayVaoDoan == null){
                preparedStatement.setNull(4, java.sql.Types.DATE); 
            }else{
                java.sql.Date dateSql = new java.sql.Date(ngayVaoDoan.getTime());
                preparedStatement.setDate(4, dateSql);
            }
            preparedStatement.setInt(5, dangDoan.getDang());
            Date ngayVaoDang = dangDoan.getNgayVaoDang();
            if (ngayVaoDang == null ) { 
                preparedStatement.setNull(6, java.sql.Types.DATE); 
            } else {
                java.sql.Date dateSql1 = new java.sql.Date(ngayVaoDang.getTime());
                preparedStatement.setDate(6, dateSql1); 
            } 
            preparedStatement.setInt(7, dangDoan.getCongDoan());
            Date ngayVaoCongDoan = dangDoan.getNgayVaoCongDoan();
            if(ngayVaoCongDoan==null){
                preparedStatement.setNull(8, java.sql.Types.DATE); 
            }else{
                java.sql.Date dateSql2 = new java.sql.Date(ngayVaoCongDoan.getTime());
                preparedStatement.setDate(8, dateSql2);
            }
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBDangDoan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return dangDoan;
        } else {
            return null;
        }
    }
    //Xóa đảng đoàn của 1 cán bộ cụ thể
        public DangDoan deleteDangDoan(DangDoan dangdoan) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int delete = 0;
        try {

            String sql = "DELETE FROM `doan_dang_congdoan` WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dangdoan.getId());
            delete = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (delete > 0) {
            return dangdoan;
        } else {
            return null;
        }
    }
    //Cập nhât đảng đoàn của 1 cán bộ
    public DangDoan updateDangDoan(DangDoan dangdoan){
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "UPDATE `doan_dang_congdoan` SET `DoanVien`=?,`NgayVaoDoan`=?,`DangVien`=?,`NgayVaoDang`=?,`CongDoanVien`=?,`NgayVaoCongDoan`=? WHERE `id`=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dangdoan.getDoan());
            Date ngayVaoDoan = dangdoan.getNgayVaoDoan();
            if(ngayVaoDoan == null){
                preparedStatement.setNull(2, java.sql.Types.DATE); 
            }else{
                java.sql.Date dateSql = new java.sql.Date(ngayVaoDoan.getTime());
                preparedStatement.setDate(2, dateSql);
            }
            preparedStatement.setInt(3, dangdoan.getDang());
            Date ngayVaoDang = dangdoan.getNgayVaoDang();
            if(ngayVaoDang == null){
                preparedStatement.setNull(4, java.sql.Types.DATE); 
            }else{
                java.sql.Date dateSql1 = new java.sql.Date(ngayVaoDang.getTime());
                preparedStatement.setDate(4, dateSql1);
            }
            preparedStatement.setInt(5, dangdoan.getCongDoan());
            Date ngayVaoCongDoan = dangdoan.getNgayVaoCongDoan();
            if(ngayVaoCongDoan==null){
                preparedStatement.setNull(6, java.sql.Types.DATE); 
            }else{
                java.sql.Date dateSql2 = new java.sql.Date(ngayVaoCongDoan.getTime());
                preparedStatement.setDate(6, dateSql2);
            }
            preparedStatement.setInt(7, dangdoan.getId());
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChucDanh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return dangdoan;
        } else {
            return null;
        }
    }
}
