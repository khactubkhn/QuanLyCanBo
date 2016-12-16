/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DeMo {

    public static void main(String[] args) {
        Connection connection = MyConnection.open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            String sql = "select HoTen, NgayNop  from cham_thi ct, can_bo cb where ct.MaCB = cb.MaCB;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println("so cot la : " + resultSetMetaData.getColumnCount());
        } catch (SQLException ex) {
            Logger.getLogger(DeMo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MyConnection.closeConnection(resultSet, preparedStatement, connection);
        }

    }

}
