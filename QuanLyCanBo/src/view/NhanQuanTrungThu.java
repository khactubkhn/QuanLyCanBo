/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.javafx.print.PrintHelper;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBThongKe;
import model.PrintPDF;

/**
 *
 * @author Admin
 */
public class NhanQuanTrungThu extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    PrintPDF printPDF;
    ArrayList<String> listDataTable;
    DBThongKe dBThongKe;

    /**
     * Creates new form NhanQuanTrungThu
     */
    public NhanQuanTrungThu() {
        initComponents();
        defaultTableModel = new DefaultTableModel();
        printPDF = new PrintPDF();
        dBThongKe = new DBThongKe();
        loadNameColumn();
        loadDataTable();

    }

    public void loadNameColumn() {
        ArrayList<String> nameColumn = new ArrayList<>();
        nameColumn.add("STT");
        nameColumn.add("Họ và tên");
        nameColumn.add("Ngày sinh");
        nameColumn.add("Mã cán bộ");
        nameColumn.add("Họ và tên cán bộ");
        defaultTableModel.setColumnIdentifiers(nameColumn.toArray());
        jTable1.setModel(defaultTableModel);

    }

    public void loadDataTable() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel.setRowCount(0);
        listDataTable = new ArrayList<>();
        ArrayList<String> listRow = new ArrayList<>();
        try {
            ResultSet resultSet = dBThongKe.thongkeThieuNhi();
            int i = 0;
            while (resultSet.next()) {
                listRow.add((i + 1) + "");
                listDataTable.add((i + 1) + "");
                listRow.add(resultSet.getString(1));
                listDataTable.add(resultSet.getString(1));
                Date ngaySinh = resultSet.getDate(2);
                int tuoi = dBThongKe.getYear(new Date()) - dBThongKe.getYear(ngaySinh);
                if (tuoi > 15) {
                    listRow.clear();
                    listDataTable.clear();
                    i = 0;
                    continue;
                }
                listRow.add(dateFormat.format(ngaySinh));
                listDataTable.add(dateFormat.format(ngaySinh));
                listRow.add(resultSet.getString(3));
                listDataTable.add(resultSet.getString(3));
                listRow.add(resultSet.getString(4));
                listDataTable.add(resultSet.getString(4));
                defaultTableModel.addRow(listRow.toArray());
                listRow.clear();
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanQuanTrungThu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbInthongke = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Danh sách các cháu nhận quà trung thu");

        jbInthongke.setText("In thống kê");
        jbInthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInthongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbInthongke)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jbInthongke)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbInthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInthongkeActionPerformed
        // TODO add your handling code here:
         if( listDataTable.size() > 0){
         try {
            JFileChooser fileChooser = new JFileChooser();
            int a = fileChooser.showSaveDialog(this);
            if (a == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
               
                printPDF.thongKeThieuNhi(listDataTable, file.getPath());
                
            }
        } catch (NullPointerException e) {

        }
         
        }
        else JOptionPane.showMessageDialog(null, "Danh sách không có cháu thiếu nhi nào cả ", "Thông báo ", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbInthongkeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbInthongke;
    // End of variables declaration//GEN-END:variables
}
