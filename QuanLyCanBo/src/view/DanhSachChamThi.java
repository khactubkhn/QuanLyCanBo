/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import model.CanBo;
import model.ChamThi;
import model.DBCanBo;
import model.DBChamThi;
import model.DBThongTinCaNhan;
import model.LopHoc;

/**
 *
 * @author Admin
 */
public class DanhSachChamThi extends javax.swing.JPanel {

    ArrayList<ChamThi> arrayList;
    ArrayList<CanBo> listCB;
    ArrayList<LopHoc> al;
    DBChamThi dBChamThi;
    DBCanBo  dBCanBo;
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModelLopHoc;
    DefaultTableModel defaultTableModelCanbo;
    public static int indexDanhSachChamThi;
    JTabbedPane jTabbedPane;

    /**
     * Creates new form DanhSachChamThi1
     */
    public DanhSachChamThi(JTabbedPane jTabbedPane) {
        initComponents();
        this.jTabbedPane = jTabbedPane;
        indexDanhSachChamThi = -1;
//        jbChiTiet.setEnabled(false);
        editText(false);
        defaultTableModel = new DefaultTableModel();
        defaultTableModelCanbo = new DefaultTableModel();
        defaultTableModelLopHoc = new DefaultTableModel();
        dBChamThi = new DBChamThi();
        dBCanBo = new DBCanBo();
        arrayList = dBChamThi.getAll();
        listCB = new ArrayList<>();
        al =new ArrayList<>();
        loadNameColumn();
        loadDataTable(arrayList);
        loadTableLopHoc();
        loadThongTinCanBo();
        this.setVisible(true);
    }
    private void loadThongTinCanBo(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMyyyy");
        ArrayList<String> nameColumn = new ArrayList<>();
        nameColumn.add("STT");
        nameColumn.add("Mã số CB");
        nameColumn.add("Họ và tên");
        nameColumn.add("Ngày sinh");
        nameColumn.add("SĐT");
        defaultTableModelCanbo.setColumnIdentifiers(nameColumn.toArray());
        listCB = dBCanBo.getAll();
        ArrayList<String> rowTable = new ArrayList<>();
        for(int i=0;i< listCB.size();i++){
            rowTable.add((i + 1) +"");
            rowTable.add(listCB.get(i).getMaCB());
            rowTable.add(listCB.get(i).getHoTen());
            rowTable.add(dateFormat.format(listCB.get(i).getNgaySinh()));
            rowTable.add(listCB.get(i).getSDT());
            
            defaultTableModelCanbo.addRow(rowTable.toArray());
            rowTable.clear();
        }
        jTable3.setModel(defaultTableModelCanbo);
        
        
    }
    

    private void loadTableLopHoc() {
        ArrayList<String> listColumnName = new ArrayList<>();
        listColumnName.add("STT");
        listColumnName.add("Mã lớp");
        listColumnName.add("Mã môn học");
        listColumnName.add("Số tín chỉ");
        defaultTableModelLopHoc.setColumnIdentifiers(listColumnName.toArray());

         al = dBChamThi.getAllLopHoc();
        ArrayList<Object> listRow = new ArrayList<>();
        if (al != null) {
            for (int i = 0; i < al.size(); i++) {
                listRow.add((i + 1));
                listRow.add(al.get(i).getMaLop());
                listRow.add(al.get(i).getMaMH());
                listRow.add(al.get(i).getSoTC());
                defaultTableModelLopHoc.addRow(listRow.toArray());
                listRow.clear();

            }
        }
        jTable2.setModel(defaultTableModelLopHoc);
    }

    private void loadNameColumn() {
        ArrayList<String> listColumnName = new ArrayList<>();
        listColumnName.add("STT");
        listColumnName.add("Mã lớp");
        listColumnName.add("Mã cán bộ");
        listColumnName.add("Ngày nộp");
        listColumnName.add("Số bài thi");
        defaultTableModel.setColumnIdentifiers(listColumnName.toArray());
    }

    private void loadDataTable(ArrayList<ChamThi> al) {
//        arrayList = dBChamThi.getAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel.setRowCount(0);

        ArrayList<Object> listRow = new ArrayList<>();
        if (al != null) {
            for (int i = 0; i < al.size(); i++) {
                listRow.add(i + 1);
                listRow.add(al.get(i).getMaLop());
                listRow.add(al.get(i).getMaCanBo());
                Date date = al.get(i).getNgayNop();
                if (date != null) {
                    String ngayNop = dateFormat.format(date);
                    listRow.add(ngayNop);
                } else {
                    listRow.add("");
                }
                listRow.add(al.get(i).getSoBaiThi());
                defaultTableModel.addRow(listRow.toArray());
                listRow.clear();
            }
            jTable1.setModel(defaultTableModel);
        }
    }

    private void editText(boolean a) {
        jtfMaCanBo.setEnabled(a);
        jtfMaLop.setEnabled(a);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jrbMaCanBo = new javax.swing.JRadioButton();
        jtfMaCanBo = new javax.swing.JTextField();
        jrbMaLop = new javax.swing.JRadioButton();
        jtfMaLop = new javax.swing.JTextField();
        jbTimKiem1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jbThem = new javax.swing.JButton();
        jbSua = new javax.swing.JButton();
        jbXoa = new javax.swing.JButton();
        jbClose = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jrbMaCanBo.setText("Mã cán bộ");
        jrbMaCanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMaCanBoActionPerformed(evt);
            }
        });

        jrbMaLop.setText("Mã lớp");
        jrbMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMaLopActionPerformed(evt);
            }
        });

        jbTimKiem1.setText("Tìm kiếm");
        jbTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbMaCanBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfMaCanBo))
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jrbMaLop)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
                        .addComponent(jbTimKiem1)
                        .addGap(53, 53, 53))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMaCanBo)
                    .addComponent(jrbMaLop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaCanBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbTimKiem1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 15));

        jButton1.setText("Quản lí môn học");
        jPanel2.add(jButton1);

        jbThem.setText("Thêm");
        jbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbThemActionPerformed(evt);
            }
        });
        jPanel2.add(jbThem);

        jbSua.setText("Chỉnh sửa");
        jbSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuaActionPerformed(evt);
            }
        });
        jPanel2.add(jbSua);

        jbXoa.setText("Xóa");
        jbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXoaActionPerformed(evt);
            }
        });
        jPanel2.add(jbXoa);

        jbClose.setText("CloseTab");
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCloseActionPerformed(evt);
            }
        });
        jPanel2.add(jbClose);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXoaActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
//        arrayList = dBChamThi.getAll();
        String maCanBo = jtfMaCanBo.getText();
        String maLop = jtfMaLop.getText();
        String mcb = "%" + maCanBo.trim() + "%";
        String malop = "%" + maLop.trim() + "%";
        arrayList = dBChamThi.findBy(mcb, malop);

        if (index >= 0) {
            ChamThi chamThi = arrayList.get(index);
            int conf = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dòng  : ID =  " + chamThi.getID() + "Mã lớp  =  " + chamThi.getMaLop() + "  MaCB = " + chamThi.getMaCanBo(), "Thông báo!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conf == JOptionPane.YES_OPTION) {
                chamThi = dBChamThi.deleteChamThi(chamThi);
                if (chamThi != null) {
                    arrayList.remove(index);
                    loadDataTable(arrayList);
                    JOptionPane.showMessageDialog(null, "Xóa thành công !!");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa !!", "Thông báo ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbXoaActionPerformed

    private void jbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThemActionPerformed
        // TODO add your handling code here:
        ThemChamThi chamThi = new ThemChamThi(defaultTableModel);
//        arrayList = dBChamThi.getAll();
    }//GEN-LAST:event_jbThemActionPerformed

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();

        if (index >= 0) {
            String maCanBo = jtfMaCanBo.getText();
            String maLop = jtfMaLop.getText();
            String mcb = "%" + maCanBo.trim() + "%";
            String malop = "%" + maLop.trim() + "%";
            arrayList = dBChamThi.findBy(mcb, malop);
            System.out.println(arrayList.size());
            ChamThi chamThi = arrayList.get(index);
            new SuaChamThi(defaultTableModel, chamThi, mcb, malop);

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbSuaActionPerformed

    private void jbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseActionPerformed
        // TODO add your handling code here:
        jTabbedPane.remove(jTabbedPane.getSelectedIndex());
        indexDanhSachChamThi = -1;
        GiaoDienChinh.soLuongTab--;
        System.out.println("so luong tab" + GiaoDienChinh.soLuongTab);
    }//GEN-LAST:event_jbCloseActionPerformed

    private void jrbMaCanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMaCanBoActionPerformed
        // TODO add your handling code here:
        if (jrbMaCanBo.isSelected()) {
            jtfMaCanBo.setEnabled(true);
            jtfMaCanBo.requestFocus();
        } else {
            jtfMaCanBo.setEnabled(false);
            jtfMaCanBo.setText("");
        }
    }//GEN-LAST:event_jrbMaCanBoActionPerformed

    private void jrbMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMaLopActionPerformed
        // TODO add your handling code here:
        if (jrbMaLop.isSelected()) {
            jtfMaLop.setEnabled(true);
            jtfMaLop.requestFocus();
        } else {
            jtfMaLop.setEnabled(false);
            jtfMaLop.setText("");
        }
    }//GEN-LAST:event_jrbMaLopActionPerformed

    private void jbTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTimKiem1ActionPerformed
        // TODO add your handling code here:
        String maCanBo = jtfMaCanBo.getText();
        String maLop = jtfMaLop.getText();
        String mcb = "%" + maCanBo.trim() + "%";
        String malop = "%" + maLop.trim() + "%";
        arrayList = dBChamThi.findBy(mcb, malop);
        loadDataTable(arrayList);
    }//GEN-LAST:event_jbTimKiem1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbSua;
    private javax.swing.JButton jbThem;
    private javax.swing.JButton jbTimKiem1;
    private javax.swing.JButton jbXoa;
    private javax.swing.JRadioButton jrbMaCanBo;
    private javax.swing.JRadioButton jrbMaLop;
    private javax.swing.JTextField jtfMaCanBo;
    private javax.swing.JTextField jtfMaLop;
    // End of variables declaration//GEN-END:variables
}
