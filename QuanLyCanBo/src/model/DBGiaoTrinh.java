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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class DBGiaoTrinh {
    
    //Lay du lieu
    public  ArrayList<GiaoTrinh> getAll(){
        ArrayList<GiaoTrinh> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlCommand = "SElECT * FROM giao_trinh";
        
        connection = MyConnection.open();
        if (connection == null){
            return list;
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()){
                Integer idGiaoTrinh = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String tenGiaoTrinh = resultSet.getString(3);
                
                Integer namXuatBan = resultSet.getInt(4);
                String nhaXuatBan  = resultSet.getString(5);
                GiaoTrinh giaoTrinh = new GiaoTrinh(idGiaoTrinh, maCB, tenGiaoTrinh,namXuatBan, nhaXuatBan);
                list.add(giaoTrinh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
        return list;
    }
    
    // Them moi
    public  int addNew(GiaoTrinh giaoTrinh){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "INSERT INTO giao_trinh VALUES(?,?,?,?,?)";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, giaoTrinh.getIdGiaoTrinh());
            ps.setString(2, giaoTrinh.getMaCB());
            ps.setString(3, giaoTrinh.getTenGiaoTrinh());
            ps.setInt(4, giaoTrinh.getNamXuatBan());
            ps.setString(5, giaoTrinh.getNhaXuatBan());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    // Xoa 
    public  int deleteGiaoTrinh(GiaoTrinh giaoTrinh){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "DELETE FROM giao_trinh WHERE IDGiaoTrinh = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, giaoTrinh.getIdGiaoTrinh());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    //Cap nhat
    public int updateGiaoTrinh(GiaoTrinh giaoTrinhCu, GiaoTrinh giaoTrinhMoi){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "UPDATE giao_trinh SET IDGiaoTrinh = ?, MaCB = ?, TenGT = ?, NamXuatBan = ?, NhaXuatBan = ? WHERE IDGiaoTrinh = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, giaoTrinhMoi.getIdGiaoTrinh());
            ps.setString(2, giaoTrinhMoi.getMaCB());
            ps.setString(3, giaoTrinhMoi.getTenGiaoTrinh());
            ps.setInt(4, giaoTrinhMoi.getNamXuatBan());
            ps.setString(5, giaoTrinhMoi.getNhaXuatBan());
            ps.setInt(6, giaoTrinhCu.getIdGiaoTrinh());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        
        return row;
    }
}
