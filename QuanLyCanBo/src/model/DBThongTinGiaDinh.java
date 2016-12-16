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
public class DBThongTinGiaDinh {
    
    // Lay du lieu tu bang gia_dinh
    public  ArrayList<ThongTinGiaDinh> getAll(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<ThongTinGiaDinh> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlCommand = "SElECT * FROM gia_dinh";
        
        connection = MyConnection.open();
        if (connection == null){
            return list;
        }
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String maCB = resultSet.getString(2);
                String hoTen = resultSet.getString(3);
                Date ngaySinh = dateFormat.parse(dateFormat.format(resultSet.getDate(4)));
                ThongTinGiaDinh con = new ThongTinGiaDinh(id, maCB, hoTen, ngaySinh);
                list.add(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } catch (ParseException ex) {
            Logger.getLogger(DBThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
        return list;
    }
    
    public  int addNew(ThongTinGiaDinh con){
        int row = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "INSERT INTO gia_dinh VALUES (?,?,?,?)";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareCall(sqlCommand);
            ps.setInt(1, con.getId());
            ps.setString(2, con.getMaCB());
            ps.setString(3, con.getHoTen());
            ps.setDate(4, new java.sql.Date(con.getNgaySinh().getTime()));
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    
    public  int deleteGiaDinh(ThongTinGiaDinh con){
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "DELETE FROM gia_dinh WHERE idgiadinh = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareCall(sqlCommand);
            ps.setInt(1, con.getId());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        return row;
    }
    
    public  int updateGiaDinh(ThongTinGiaDinh conCu, ThongTinGiaDinh conMoi){
        int row = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement ps = null;
        String sqlCommand = "UPDATE gia_dinh SET idgiadinh = ?,MaCB = ?, HoTen = ?, NgaySinh = ? WHERE idgiadinh = ?";
        
        connection = MyConnection.open();
        if (connection == null){
            return row;
        }
        
        try {
            ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, conMoi.getId());
            ps.setString(2, conMoi.getMaCB());
            ps.setString(3, conMoi.getHoTen());
            ps.setDate(4, new java.sql.Date(conMoi.getNgaySinh().getTime()));
            ps.setInt(5, conCu.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DBThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
            return row;
        }
        
        return row;
    }
    
    public static void main(String[] args) throws ParseException {
        ThongTinGiaDinh thongTinGiaDinh = new ThongTinGiaDinh(2, "cb01", "Nguyen Van B", new SimpleDateFormat("dd/MM/yyyy").parse("12/12/1996"));
        DBThongTinGiaDinh dbttgd = new DBThongTinGiaDinh();
        if (dbttgd.addNew(thongTinGiaDinh) > 0){
            System.out.println("ok");
        }
    }
}
