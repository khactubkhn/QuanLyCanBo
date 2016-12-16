/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wh1t3r0s3
 */
public class DBDangNhap {
    public String getMatKhau(CanBo canBo){
        //Lay mat khau tu bang can_bo
        Connection con = MyConnection.open();
        if(con == null)
            return null;
        try{
            String sql = "select password from can_bo where maCB = "+"'"+canBo.getMaCB()+"'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            String passwd = rs.getString(1);
            return passwd;
        } catch (SQLException ex) {
            Logger.getLogger(DBDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
