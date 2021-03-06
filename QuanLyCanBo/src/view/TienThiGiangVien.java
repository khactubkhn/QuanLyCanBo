/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class TienThiGiangVien extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    ArrayList<String> listDataTable;
    DBThongKe dBThongKe;
    PrintPDF printPDF;
    public static final float HE_SO = 10000;

    /**
     * Creates new form TienThiGiangVien
     */
    public TienThiGiangVien() {
        initComponents();
        defaultTableModel = new DefaultTableModel();
        dBThongKe = new DBThongKe();
        printPDF = new PrintPDF();
        loadNameColumn();
        loadDataTable();

    }

    public void loadNameColumn() {
        ArrayList<String> nameColumn = new ArrayList<>();
        nameColumn.add("STT");
        nameColumn.add("Mã cán bộ");
        nameColumn.add("Họ và tên");
        nameColumn.add("Tên môn học");
        nameColumn.add("Số lượng SV");
        nameColumn.add("Tiền học");
        defaultTableModel.setColumnIdentifiers(nameColumn.toArray());
        jTable1.setModel(defaultTableModel);
    }

    public void loadDataTable() {
//        defaultTableModel.setRowCount(0);
//        listDataTable = new ArrayList<>();
//        ArrayList<String> listRow = new ArrayList<>();
//        try {
//
//            ResultSet resultSet = dBThongKe.thongkeTienGiaoVien();
//            int i = 0;
//            while (resultSet.next()) {
//                listRow.add((i + 1) + "");
//                listDataTable.add((i + 1) + "");
//                listRow.add(resultSet.getString(1));
//                listDataTable.add(resultSet.getString(1));
//                listRow.add(resultSet.getString(2));
//                listDataTable.add(resultSet.getString(2));
//                listRow.add(resultSet.getString(3));
//                listDataTable.add(resultSet.getString(3));
//                int soSV = resultSet.getInt(4);
//                listRow.add(soSV + "");
//                listDataTable.add(soSV + "");
//                float tongTien = soSV * HE_SO;
//                listRow.add(tongTien + "");
//                listDataTable.add(tongTien + "");
//                defaultTableModel.addRow(listRow.toArray());
//                listRow.clear();
//                i++;
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TienThiGiangVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbInThongKe = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tiền thi của giảng viên");

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

        jbInThongKe.setText("In thong ke");
        jbInThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbInThongKe)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jbInThongKe)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbInThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInThongKeActionPerformed
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
        else JOptionPane.showMessageDialog(null, "Danh sách trống  ", "Thông báo ", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbInThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbInThongKe;
    // End of variables declaration//GEN-END:variables
}
