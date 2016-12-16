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
public class DBThanhTich {
    // Lay Du Lieu
    public  ArrayList<ThanhTich> getAll(){
        ArrayList<ThanhTich> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlCommand = "SELECT * FROM thanh_tich";
        
        connection = MyConnection.open();
        if (connection == null){
            return list;
        }
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                Integer idThanhTich = resultSet.getInt(1);
                Integer idGiaDinh = resultSet.getInt(2);
                String danhHieu  = resultSet.getString(3);
                String datGiaiCap = resultSet.getString(4);
                Integer nam = resultSet.getInt(5);
                ThanhTich thanhTich = new ThanhTich(idThanhTich, idGiaDinh, danhHieu, datGiaiCap, nam);
                list.add(thanhTich);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBThanhTich.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
        return list;
    }
    
    //Them moi
    public int addNew(ThanhTich thanhTich){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "INSERT INTO thanh_tich VALUES(?,?,?,?,?)";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, thanhTich.getIdThanhTich());
            ps.setInt(2, thanhTich.getIdGiaDinh());
            ps.setString(3, thanhTich.getDanhHieu());
            ps.setString(4, thanhTich.getDatGiaiCap());
            ps.setInt(5, thanhTich.getNam());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBThanhTich.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    // Xoa 
    public int deleteThanhTich(ThanhTich thanhTich){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "DELETE FROM thanh_tich WHERE idthanhtich = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, thanhTich.getIdThanhTich());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBThanhTich.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    // Cap nhat
    public int updateThanhTich(ThanhTich thanhTichCu, ThanhTich thanhTichMoi){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand  = "UPDATE thanh_tich SET idthanhtich = ?, DanhHieuHSG= ?,DatGiaiCap = ?,Nam = ? WHERE idthanhtich = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, thanhTichMoi.getIdThanhTich());
            ps.setInt(2, thanhTichMoi.getIdGiaDinh());
            ps.setString(3, thanhTichMoi.getDanhHieu());
            ps.setString(4, thanhTichMoi.getDatGiaiCap());
            ps.setInt(5, thanhTichMoi.getNam());
            ps.setInt(6, thanhTichCu.getIdThanhTich());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBThanhTich.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
}
