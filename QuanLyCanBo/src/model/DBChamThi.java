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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DBChamThi {

    public ArrayList<ChamThi> getAll() {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChamThi> arrayList = null;
        try {

            String sql = " select * from `cham_thi`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String maLop = resultSet.getString(2);
                String maCanBo = resultSet.getString(3);
                Date ngayNop = resultSet.getDate(4);
                int soBaiThi = resultSet.getInt(5);
                ChamThi chamThi = new ChamThi(ID, maLop, maCanBo, ngayNop, soBaiThi);
                arrayList.add(chamThi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }

    public ChamThi addNew(ChamThi chamThi) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int upDate = 0;
        try {

            String sql = "insert into `cham_thi` values (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chamThi.getID());
            preparedStatement.setString(2, chamThi.getMaLop());
            preparedStatement.setString(3, chamThi.getMaCanBo());
            Date ngayNop = chamThi.getNgayNop();
            java.sql.Date dateSql = new java.sql.Date(ngayNop.getTime());
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setInt(5, chamThi.getSoBaiThi());
            upDate = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
//            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Lỗi SQL", JOptionPane.WARNING_MESSAGE);
        } finally {
            MyConnection.closeConnection(null, preparedStatement, connection);
        }
        if (upDate > 0) {
            return chamThi;
        } else {
            return null;
        }

    }

    public ChamThi deleteChamThi(ChamThi chamThi) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int deleteChamThi = 0;
        try {

            String sql = "delete from `cham_thi` where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chamThi.getID());
            deleteChamThi = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (deleteChamThi > 0) {
            return chamThi;
        } else {
            return null;
        }
    }

    public ChamThi updateChamThi(ChamThi chamThi) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        int update = 0;
        try {

            String sql = "update `cham_thi` set MaLop = ?, MaCB = ?,NgayNop = ?, SoBaiThi = ? where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chamThi.getMaLop());
            preparedStatement.setString(2, chamThi.getMaCanBo());
            Date ngayNop = chamThi.getNgayNop();
            java.sql.Date dateSql = new java.sql.Date(ngayNop.getTime());
            preparedStatement.setDate(3, dateSql);
            preparedStatement.setInt(4, chamThi.getSoBaiThi());
            preparedStatement.setInt(5, chamThi.getID());
            update = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (update > 0) {
            return chamThi;
        } else {
            return null;
        }
    }

    public ArrayList<ChamThi> findBy(String maCB, String maLp) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChamThi> arrayList = null;
        String sql = " select * from `cham_thi` where `MaCB` like ? and `MaLop`like ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maCB);
            preparedStatement.setString(2, maLp);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String maLop = resultSet.getString(2);
                String maCanBo = resultSet.getString(3);
                Date ngayNop = resultSet.getDate(4);
                int soBaiThi = resultSet.getInt(5);
                ChamThi chamThi = new ChamThi(ID, maLop, maCanBo, ngayNop, soBaiThi);
                arrayList.add(chamThi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }

    public ArrayList<ChamThi> findBuMaLop(String maLopHoc) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ChamThi> arrayList = null;
        String sql = " select * from `cham_thi` where `MaCB` = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maLopHoc);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String maLop = resultSet.getString(2);
                String maCanBo = resultSet.getString(3);
                Date ngayNop = resultSet.getDate(4);
                int soBaiThi = resultSet.getInt(5);
                ChamThi chamThi = new ChamThi(ID, maLop, maCanBo, ngayNop, soBaiThi);
                arrayList.add(chamThi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }

    public ArrayList<LopHoc> getAllLopHoc() {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<LopHoc> arrayList = null;
        try {

            String sql = " select * from `lop_hoc`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            while (resultSet.next()) {
                String malop = resultSet.getString(1);
                String mamh = resultSet.getString(2);
                int soTC = resultSet.getInt(3);
                LopHoc lh = new LopHoc(malop, mamh, soTC);
                arrayList.add(lh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBChamThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }
        return arrayList;
    }

  
   

    public static void main(String[] args) {
        DBChamThi bChamThi = new DBChamThi();
        bChamThi.getAllLopHoc();
    }
}
