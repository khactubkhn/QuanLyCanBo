/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MyConnection {
    public static String url ="jdbc:mysql://localhost:3307/projecti";
    public static String user ="root";
    public static String pass ="6506885";
    public static String driver ="com.mysql.jdbc.Driver";
    
    
    public static Connection open(){
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay driver", "Thongbao", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi ket noi ! ket noi that bai", "Thong bao", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    
    public static void closeConnection( ResultSet resultSet,Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(connection!= null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
