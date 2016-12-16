/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wh1t3r0s3
 */
public class DBTimKiem {

   

    public CanBo SearchCanBoTheoMaCB(String maCB) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CanBo canBo = null;
        try {

            String sql = " select * from `can_bo` where MaCB = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maCanBo = resultSet.getString(1);
                String hoTen = resultSet.getString(2);
                Date ngaySinh = resultSet.getDate(3);
                int gioiTinh = resultSet.getInt(4);
                String maSoThue = resultSet.getString(5);
                String soTK = resultSet.getString(6);
                String diaChi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcgd = resultSet.getDouble(10);
                String thanhtich = resultSet.getString(11);
                int user = resultSet.getInt(12);
                String pass = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                canBo = new CanBo(maCanBo, hoTen, ngaySinh, gioiTinh, maSoThue, soTK, diaChi, sdt, email, pcgd, thanhtich, user, pass, ngayBD);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canBo;
    }

    public  ArrayList<CanBo> timKiemCanBo(String maCB, String hoTen, String gioiTinh) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<CanBo> listCanBo = null;
        try {

            String sql = " select * from can_bo where `MaCB` like ? and `HoTen`  like ? and `GioiTinh` like ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            preparedStatement.setString(2, hoTen);
            preparedStatement.setString(3, gioiTinh);
            resultSet = preparedStatement.executeQuery();
            listCanBo = new ArrayList<>();
            while(resultSet.next()){
                String maCb = resultSet.getString(1);
                String hoten = resultSet.getString(2);
                Date ngaysinh = resultSet.getDate(3);
                int gioitinh = resultSet.getInt(4);
                String msThue = resultSet.getString(5);
                String stk = resultSet.getString(6);
                String diachi = resultSet.getString(7);
                String sdt = resultSet.getString(8);
                String email = resultSet.getString(9);
                double pcgd = resultSet.getDouble(10);
                String thanhtichkhac = resultSet.getString(11);
                int userLevel = resultSet.getInt(12);
                String pass = resultSet.getString(13);
                Date ngayBD = resultSet.getDate(14);
                CanBo canBo = new CanBo(maCb, hoten, ngaysinh, gioitinh, msThue, stk, diachi, sdt, email, pcgd, thanhtichkhac, userLevel, pass, ngayBD);
                listCanBo.add(canBo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCanBo;

    }
    public static void main(String[] args) {
        DBTimKiem bTimKiem =new DBTimKiem();
        ArrayList<CanBo>list = bTimKiem.timKiemCanBo("%", "%", "%");
        System.out.println(list.size());
    }

}
