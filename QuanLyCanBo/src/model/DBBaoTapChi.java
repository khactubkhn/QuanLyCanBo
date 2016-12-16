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
public class DBBaoTapChi {
    
    public ArrayList<BaoTapChi> getAll(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<BaoTapChi> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlCommand = "SELECT * FROM bao_tapchi";
        
        connection = MyConnection.open();
        if (connection == null){
            return list;
        }
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()){
                Integer idBao = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String tenBao = resultSet.getString(3);
                Integer soBao = resultSet.getInt(4);
                Date ngayXuatBan = dateFormat.parse(dateFormat.format(resultSet.getDate(5)));
                double chiSoISSN = resultSet.getDouble(6);
                double heSoIF = resultSet.getDouble(7);
                
                BaoTapChi baoTapChi = new BaoTapChi(idBao, maCB, tenBao, soBao, ngayXuatBan, chiSoISSN, heSoIF);
                list.add(baoTapChi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } catch (ParseException ex) {
            Logger.getLogger(DBBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
        
        return list;
    }
    
    public  int addNew(BaoTapChi baoTapChi){
        int row = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection  = null;
        PreparedStatement ps = null;
        String sqlCommand = "INSERT INTO bao_tapchi VALUES(?,?,?,?,?,?,?)";
        
        connection  = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, baoTapChi.getIdBao());
            ps.setString(2, baoTapChi.getMaCB());
            ps.setString(3, baoTapChi.getTenBao());
            ps.setInt(4, baoTapChi.getSoBao());
            ps.setDate(5, new java.sql.Date(baoTapChi.getNgayXuatBan().getTime()));
            ps.setDouble(6, baoTapChi.getChiSoISSN());
            ps.setDouble(7, baoTapChi.getHeSoIF());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    public int deleteBaoTapChi(BaoTapChi baoTapChi){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "DELETE FROM bao_tapchi WHERE IDBao = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, baoTapChi.getIdBao());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    public int updateBaoTapChi(BaoTapChi baoCu, BaoTapChi baoMoi){
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "UPDATE bao_tapchi SET IDBao = ?, MaCB = ?, TenBao = ?, SoBao = ?, ThoiGianXuatBan = ?, ChiSoISSN = ?, HeSoIF = ? WHERE IDBao = ?";
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int row = 0;
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps  = connection.prepareStatement(sqlCommand);
            ps.setInt(1, baoMoi.getIdBao());
            ps.setString(2, baoMoi.getMaCB());
            ps.setString(3, baoMoi.getTenBao());
            ps.setInt(4, baoMoi.getSoBao());
            ps.setDate(5, new java.sql.Date(baoMoi.getNgayXuatBan().getTime()));
            ps.setDouble(6, baoMoi.getChiSoISSN());
            ps.setDouble(7, baoMoi.getHeSoIF());
            ps.setInt(8, baoCu.getIdBao());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
}
