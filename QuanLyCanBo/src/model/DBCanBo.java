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
public class DBCanBo {
    //Lấy tất cả dữ liệu từ bảng CanBo trả về 1 ArrayList
    public ArrayList<CanBo> getAll() {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> arrayList = null;
        try {

            String sql = " SELECT * FROM `can_bo`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                String maCB = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTaiKhoan = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcGiangDay = resultSet.getDouble(10);
                String thanhTichKhac = resultSet.getString(11);
                int user_level = resultSet.getInt(12);
                String password = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canbo = new CanBo(maCB, hoTen, ngaySinh, gioiTinh, maSoThue, soTaiKhoan, diaChi, sdt, email, pcGiangDay, thanhTichKhac, user_level, password, ngayBD);
                arrayList.add(canbo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //trả về 1 đối tượng Cán bộ nếu insert thành công
    public CanBo addNew(CanBo canBo) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "INSERT INTO `can_bo`(`MaCB`, `HoTen`, `NgaySinh`, `GioiTinh`, `MaSoThue`, `SoTaiKhoan`, `DiaChi`, `SDT`, `Email`, `PCGiangDay`, `ThanhTichKhac`, `user_level`, `password`,`ngayBD`) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, canBo.getMaCB());
            preparedStatement.setString(2, canBo.getHoTen());
            //Chèn ngày sinh kiểu Date
            Date ngaySinh = canBo.getNgaySinh();
            java.sql.Date dateSQL = new java.sql.Date(ngaySinh.getTime());
            preparedStatement.setDate(3, dateSQL);
            preparedStatement.setInt(4, canBo.getGioiTinh());
            preparedStatement.setString(5, canBo.getMaSoThue());
            preparedStatement.setString(6, canBo.getSoTaiKhoan());
            preparedStatement.setString(7, canBo.getDiaChi());
            preparedStatement.setString(8, canBo.getSDT());
            preparedStatement.setString(9, canBo.getEmail());
            preparedStatement.setDouble(10, canBo.getPCGiangDay());
            preparedStatement.setString(11, canBo.getThanhTichKhac());
            preparedStatement.setInt(12, canBo.getUser_level());
            preparedStatement.setString(13, canBo.getPassword());
            Date ngayBD = canBo.getNgayBD();
            java.sql.Date datesql = new java.sql.Date(ngayBD.getTime());
            preparedStatement.setDate(14, datesql);
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBCanBo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return canBo;
        } else {
            return null;
        }
    }
    //Delete 1 cán bộ khi biết MaCB
    public CanBo deleteCanBo(CanBo canBo) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int delete = 0;
        try {

            String sql = "DELETE FROM `can_bo` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, canBo.getMaCB());
            delete = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBCanBo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (delete > 0) {
            return canBo;
        } else {
            return null;
        }
    }
    //Cập nhật thông tin 1 cán bộ khi biết MaCB
    public CanBo updateCanBo(CanBo canBo) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "UPDATE `can_bo` SET `HoTen`=?,`NgaySinh`=?,`GioiTinh`=?,`MaSoThue`=?,`SoTaiKhoan`=?,"
                    + "`DiaChi`=?,`SDT`=?,`Email`=?,`PCGiangDay`=?,`ThanhTichKhac`=?,`user_level`=?,`password`=? ,`ngayBD`=?"
                    + "WHERE `MaCB`=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, canBo.getHoTen());
            //Chèn ngày sinh kiểu Date
            Date ngaySinh = canBo.getNgaySinh();
            java.sql.Date dateSQL = new java.sql.Date(ngaySinh.getTime());
            preparedStatement.setDate(2, dateSQL);
            preparedStatement.setInt(3, canBo.getGioiTinh());
            preparedStatement.setString(4, canBo.getMaSoThue());
            preparedStatement.setString(5, canBo.getSoTaiKhoan());
            preparedStatement.setString(6, canBo.getDiaChi());
            preparedStatement.setString(7, canBo.getSDT());
            preparedStatement.setString(8, canBo.getEmail());
            preparedStatement.setDouble(9, canBo.getPCGiangDay());
            preparedStatement.setString(10, canBo.getThanhTichKhac());
            preparedStatement.setInt(11, canBo.getUser_level());
            preparedStatement.setString(12, canBo.getPassword());
            //Thêm ngày BD
            Date ngayBD = canBo.getNgayBD();
            java.sql.Date datesql = new java.sql.Date(ngayBD.getTime());
            preparedStatement.setDate(13, datesql);
            preparedStatement.setString(14, canBo.getMaCB());
            update = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBCanBo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (update > 0) {
            return canBo;
        } else {
            return null;
        }
    }
    //Tìm kiếm cán bộ theo MaCB
    public ArrayList<CanBo> findByMaCB(String MaCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> arrayList = null;
        try {

            String sql = " SELECT * FROM `can_bo` WHERE MaCB=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,MaCB);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                String maCB = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTaiKhoan = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcGiangDay = resultSet.getDouble(10);
                String thanhTichKhac = resultSet.getString(11);
                int user_level = resultSet.getInt(12);
                String password = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canbo = new CanBo(maCB, hoTen, ngaySinh, gioiTinh, maSoThue, soTaiKhoan, diaChi, sdt, email, pcGiangDay, thanhTichKhac, user_level, password,ngayBD);
                arrayList.add(canbo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Tìm kiếm theo tên Cán Bộ
        public ArrayList<CanBo> findByHoTen(String HoTen) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> arrayList = null;
        try {

            String sql = " SELECT * FROM `can_bo` WHERE HoTen=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,HoTen);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                String maCB = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTaiKhoan = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcGiangDay = resultSet.getDouble(10);
                String thanhTichKhac = resultSet.getString(11);
                int user_level = resultSet.getInt(12);
                String password = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canbo = new CanBo(maCB, hoTen, ngaySinh, gioiTinh, maSoThue, soTaiKhoan, diaChi, sdt, email, pcGiangDay, thanhTichKhac, user_level, password,ngayBD);
                arrayList.add(canbo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
    //Tìm theo Mã Cán Bộ và Tên cán bộ
    public ArrayList<CanBo> findBy(String maCB, String tenCanBo) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> arrayList = null;
        String sql = " SELECT * FROM `can_bo` where `MaCB` like ? and `HoTen` like ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            preparedStatement.setString(2, tenCanBo);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                String macb = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTaiKhoan = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcGiangDay = resultSet.getDouble(10);
                String thanhTichKhac = resultSet.getString(11);
                int user_level = resultSet.getInt(12);
                String password = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canbo = new CanBo(macb, hoTen, ngaySinh, gioiTinh, maSoThue, soTaiKhoan, diaChi, sdt, email, pcGiangDay, thanhTichKhac, user_level, password,ngayBD);
                arrayList.add(canbo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCanBo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }
}
    
    
