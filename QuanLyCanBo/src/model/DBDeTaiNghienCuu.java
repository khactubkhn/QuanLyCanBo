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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class DBDeTaiNghienCuu {
    
    // Lay du lieu
    public  ArrayList<DeTaiNghienCuu> getAll(){
        ArrayList<DeTaiNghienCuu> list = new  ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlCommand = "SELECT * FROM de_tai";
        
        connection = MyConnection.open();
        if (connection == null){
            return list;
        }
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()){
                String maDeTai = resultSet.getString(1);
                String maCB  = resultSet.getString(2);
                String tenDeTai = resultSet.getString(3);
                String cap = resultSet.getString(4);
                Double kinhPhi = resultSet.getDouble(5);
                Date ngayBatDau = dateFormat.parse(dateFormat.format(resultSet.getDate(6)));
                Date ngayKetThuc = dateFormat.parse(dateFormat.format(resultSet.getDate(7)));
                String chuTriDeTai = resultSet.getString(8);
                String ketQua = resultSet.getString(9);
                DeTaiNghienCuu nghienCuu = new DeTaiNghienCuu(maDeTai, maCB, tenDeTai, cap, kinhPhi, ngayBatDau, ngayKetThuc, chuTriDeTai, ketQua);
                list.add(nghienCuu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDeTaiNghienCuu.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } catch (ParseException ex) {
            Logger.getLogger(DBDeTaiNghienCuu.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
        return list;
    }
    
    // Them moi
    public int addNew(DeTaiNghienCuu deTaiNghienCuu){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int row = 0;
        Connection connection  = null;
        PreparedStatement ps = null;
        String sqlCommand = "INSERT INTO de_tai VALUES(?,?,?,?,?,?,?,?,?)";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, deTaiNghienCuu.getMaDeTai());
            ps.setString(2, deTaiNghienCuu.getMaCanBo());
            ps.setString(3, deTaiNghienCuu.getTenDeTai());
            ps.setString(4, deTaiNghienCuu.getCap());
            ps.setDouble(5, deTaiNghienCuu.getKinhPhi());
            ps.setDate(6, new java.sql.Date(deTaiNghienCuu.getNgayBatDau().getTime()));
            ps.setDate(7, new java.sql.Date(deTaiNghienCuu.getNgayKetThuc().getTime()));
            ps.setString(8, deTaiNghienCuu.getChuTriDeTai());
            ps.setString(9, deTaiNghienCuu.getKetQua());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBDeTaiNghienCuu.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    // Xoa
    public int deleteDeTai(DeTaiNghienCuu deTaiNghienCuu ){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "DELETE FROM de_tai WHERE MaDeTai = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, deTaiNghienCuu.getMaDeTai());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBDeTaiNghienCuu.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    // Cap nhat
    public  int updateDeTai(DeTaiNghienCuu deTaiCu, DeTaiNghienCuu deTaiMoi){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "UPDATE de_tai SET MaDeTai = ?, TenDeTai = ?, Cap = ?, KinhPhi = ?, ThoiGianBatDau = ?,  ThoiGianKetThuc = ?, ChuTriDeTai = ?, KetQua = ? WHERE MaDeTai = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, deTaiMoi.getMaDeTai());
            ps.setString(2, deTaiMoi.getTenDeTai());
            ps.setString(3, deTaiMoi.getCap());
            ps.setDouble(4, deTaiMoi.getKinhPhi());
            ps.setDate(5, new java.sql.Date(deTaiMoi.getNgayBatDau().getTime()));
            ps.setDate(6, new java.sql.Date(deTaiMoi.getNgayKetThuc().getTime()));
            ps.setString(7, deTaiMoi.getChuTriDeTai());
            ps.setString(8, deTaiMoi.getKetQua());
            ps.setString(9, deTaiCu.getMaDeTai());
            row = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBDeTaiNghienCuu.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
}
