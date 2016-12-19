/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CanBo;
import model.DBDangDoan;
import model.DangDoan;

/**
 *
 * @author Windows 10
 */
public class HienThi_DangDoan extends javax.swing.JFrame {
    //Khởi tạo dữ liệu
    ArrayList<DangDoan> arrayList;
    DBDangDoan dBDangDoan;
    DefaultTableModel defaultTableModel;
    SimpleDateFormat dateFormat;
    int Id;
    int size;
    /**
     * Creates new form HienThi_DangDoan
     */
    public HienThi_DangDoan(CanBo canbo) {
        initComponents();
        String maCB = canbo.getMaCB();
        jLabel_MaCB.setText(maCB);
        defaultTableModel = new DefaultTableModel();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dBDangDoan = new DBDangDoan();
        arrayList = dBDangDoan.getAll(maCB);
        size = arrayList.size();
        ArrayList<DangDoan> list = dBDangDoan.getAllCanBo();
        //ID để tính cho vị trí tiếp theo chèn vào sẽ không bị trùng
        Id = list.get(list.size() - 1).getId() + 1;
        loadNameColumn();
        loadDataTable(arrayList);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jTextField_DoanVien.setEnabled(false);
        jTextField_DangVien.setEnabled(false);
        jTextField_CongDoanVien.setEnabled(false);
    }
    //Tên các cột trong bảng 
    private void loadNameColumn() {
        ArrayList<String> listColumnName = new ArrayList<>();
        listColumnName.add("STT");
        listColumnName.add("Đoàn Viên");
        listColumnName.add("Ngày vào Đoàn");
        listColumnName.add("Đảng Viên");
        listColumnName.add("Ngày vào Đảng");
        listColumnName.add("Công đoàn Viên");
        listColumnName.add("Ngày vào Công Đoàn");
        defaultTableModel.setColumnIdentifiers(listColumnName.toArray());
    }
    //load data lên bảng
    private void loadDataTable(ArrayList<DangDoan> al) {
        Id++;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Làm mới bảng
        defaultTableModel.setRowCount(0);

        ArrayList<Object> listRow = new ArrayList<>();
        if (al != null) {
            for (int i = 0; i < al.size(); i++) {
                listRow.add(i + 1);
                if(al.get(i).getDoan()==1){
                    listRow.add("Có");
                    Date date = al.get(i).getNgayVaoDoan();
                    String ngayVaoDoan = dateFormat.format(date);
                    listRow.add(ngayVaoDoan);
                }else{
                    listRow.add("Không");
                    listRow.add("");
                }
                if(al.get(i).getDang()==1){
                    listRow.add("Có");
                    Date date1 = al.get(i).getNgayVaoDang();
                    String ngayVaoDang = dateFormat.format(date1);
                    listRow.add(ngayVaoDang);
                }else{
                    listRow.add("Không");
                    listRow.add("");
                }
                if(al.get(i).getCongDoan()==1){
                    listRow.add("Có");
                    Date date2 = al.get(i).getNgayVaoCongDoan();
                    String ngayVaoCongDoan = dateFormat.format(date2);
                    listRow.add(ngayVaoCongDoan);
                }else{
                    listRow.add("Không");
                    listRow.add("");
                }
                defaultTableModel.addRow(listRow.toArray());
                listRow.clear();
            }
            jTable_DangDoan.setModel(defaultTableModel);
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

        jPanel1 = new javax.swing.JPanel();
        jButton_Sua = new javax.swing.JButton();
        jButton_Dong = new javax.swing.JButton();
        jButton_Them = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_MaCB = new javax.swing.JLabel();
        jRadioButton_DoanVien = new javax.swing.JRadioButton();
        jTextField_DoanVien = new javax.swing.JTextField();
        jRadioButton_DangVien = new javax.swing.JRadioButton();
        jTextField_DangVien = new javax.swing.JTextField();
        jRadioButton_CongDoanVien = new javax.swing.JRadioButton();
        jTextField_CongDoanVien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DangDoan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Sua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_Sua.setText("Sửa");
        jButton_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SuaActionPerformed(evt);
            }
        });

        jButton_Dong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_Dong.setText("Đóng");
        jButton_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DongActionPerformed(evt);
            }
        });

        jButton_Them.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_Them.setText("Thêm");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jButton_Xoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã Cán Bộ");

        jLabel_MaCB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_MaCB.setText("jLabel5");

        jRadioButton_DoanVien.setText("Đoàn viên");
        jRadioButton_DoanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_DoanVienActionPerformed(evt);
            }
        });

        jRadioButton_DangVien.setText("Đảng viên");
        jRadioButton_DangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_DangVienActionPerformed(evt);
            }
        });

        jRadioButton_CongDoanVien.setText("Công đoàn viên");
        jRadioButton_CongDoanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_CongDoanVienActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Ngày vào:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Ngày vào:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ngày vào:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel_MaCB)
                        .addContainerGap(311, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_CongDoanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_CongDoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_DangVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_DangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_DoanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_MaCB))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_DoanVien)
                    .addComponent(jTextField_DoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_DangVien)
                    .addComponent(jTextField_DangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_CongDoanVien)
                    .addComponent(jTextField_CongDoanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        jTable_DangDoan.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_DangDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DangDoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_DangDoan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SuaActionPerformed
        // TODO add your handling code here:
        int index = jTable_DangDoan.getSelectedRow();
        DangDoan dangdoan_selected = arrayList.get(index);
        String maCB = jLabel_MaCB.getText();
        int doan;
        if(jRadioButton_DoanVien.isSelected()){
            doan = 1;
        }else{
            doan =0;
        }
        String ngayVaoDoan = jTextField_DoanVien.getText();
        Date date1=null;
        if(ngayVaoDoan.length()==0){
            date1 = null;
        }
        else{
            try {
            date1 = dateFormat.parse(ngayVaoDoan);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        int dang;
        if(jRadioButton_DangVien.isSelected()){
            dang = 1;
        }else{
            dang =0;
        }
        String ngayVaoDang = jTextField_DangVien.getText();
        Date date2=null;
        if(ngayVaoDang.length()==0){
            date2 = null;
        }
        else{
            try {
            date2 = dateFormat.parse(ngayVaoDang);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        int congdoan;
        if(jRadioButton_CongDoanVien.isSelected()){
            congdoan = 1;
        }else{
            congdoan =0;
        }
        String ngayVaoCongDoan = jTextField_CongDoanVien.getText();
        Date date3=null;
        if(ngayVaoCongDoan.length()==0){
            date3 = null;
        }
        else{
            try {
            date3 = dateFormat.parse(ngayVaoCongDoan);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        dangdoan_selected.setDoan(doan);
        dangdoan_selected.setNgayVaoDoan(date1);
        dangdoan_selected.setDang(dang);
        dangdoan_selected.setNgayVaoDang(date2);
        dangdoan_selected.setCongDoan(congdoan);
        dangdoan_selected.setNgayVaoCongDoan(date3);
        DangDoan result = dBDangDoan.updateDangDoan(dangdoan_selected);
        if (result != null) {
            JOptionPane.showMessageDialog(null, "Update thanh cong");
            arrayList = dBDangDoan.getAll(maCB);
            loadDataTable(arrayList);
                //            jTable1.setModel(defaultTableModel);
        } else {
                JOptionPane.showMessageDialog(null, "Update that bai !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton_SuaActionPerformed

    private void jButton_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_DongActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        // TODO add your handling code here
        String maCB = jLabel_MaCB.getText();
        int doan;
        if(jRadioButton_DoanVien.isSelected()){
            doan = 1;
        }else{
            doan =0;
        }
        String ngayVaoDoan = jTextField_DoanVien.getText();
        Date date1=null;
        if(ngayVaoDoan.length()==0){
            date1 = null;
        }
        else{
            try {
            date1 = dateFormat.parse(ngayVaoDoan);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        int dang;
        if(jRadioButton_DangVien.isSelected()){
            dang = 1;
        }else{
            dang =0;
        }
        String ngayVaoDang = jTextField_DangVien.getText();
        Date date2=null;
        if(ngayVaoDang.length()==0){
            date2 = null;
        }
        else{
            try {
            date2 = dateFormat.parse(ngayVaoDang);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        int congdoan;
        if(jRadioButton_CongDoanVien.isSelected()){
            congdoan = 1;
        }else{
            congdoan =0;
        }
        String ngayVaoCongDoan = jTextField_CongDoanVien.getText();
        Date date3=null;
        if(ngayVaoCongDoan.length()==0){
            date3 = null;
        }
        else{
            try {
            date3 = dateFormat.parse(ngayVaoCongDoan);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Nhap khong dung dinh dang cua date !!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            }
        }
        //tạo 1 đối tượng mới
        DangDoan dangdoan = new DangDoan(Id,maCB,doan,date1, dang,date2,congdoan,date3);
        DangDoan result = dBDangDoan.addNew(maCB, dangdoan);
        if (result != null) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            arrayList = dBDangDoan.getAll(maCB);
            loadDataTable(arrayList);
            jButton_Them.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
        int index = jTable_DangDoan.getSelectedRow();
        String maCB = jLabel_MaCB.getText();

        if (index >= 0) {
            DangDoan dangdoan = arrayList.get(index);
            int conf = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dòng  : ID :  " + dangdoan.getId(), "Thông báo!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conf == JOptionPane.YES_OPTION) {
                DangDoan result = dBDangDoan.deleteDangDoan(dangdoan);
                if (result != null) {
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
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jTable_DangDoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DangDoanMouseClicked
        // TODO add your handling code here:
        int index = jTable_DangDoan.getSelectedRow();
        int doan = arrayList.get(index).getDoan();
        if(doan==1){
            jRadioButton_DoanVien.setSelected(true);
            Date date = arrayList.get(index).getNgayVaoDoan();
            jTextField_DoanVien.setText(dateFormat.format(date));
            jTextField_DoanVien.setEnabled(true);
        }else{
            jRadioButton_DoanVien.setSelected(false);
            jTextField_DoanVien.setEnabled(false);
            jTextField_DoanVien.setText("");
        }
        int dang = arrayList.get(index).getDang();
        if(dang==1){
            jRadioButton_DangVien.setSelected(true);
            Date date1 = arrayList.get(index).getNgayVaoDang();
            jTextField_DangVien.setText(dateFormat.format(date1));
            jTextField_DangVien.setEnabled(true);
        }else{
            jRadioButton_DangVien.setSelected(false);
            jTextField_DangVien.setEnabled(false);
            jTextField_DangVien.setText("");
        }
        int congdoan = arrayList.get(index).getCongDoan();
        if(congdoan==1){
            jRadioButton_CongDoanVien.setSelected(true);
            Date date = arrayList.get(index).getNgayVaoCongDoan();
            jTextField_CongDoanVien.setText(dateFormat.format(date));
            jTextField_CongDoanVien.setEnabled(true);
        }else{
            jRadioButton_CongDoanVien.setSelected(false);
            jTextField_CongDoanVien.setEnabled(false);
            jTextField_CongDoanVien.setText("");
        }
    }//GEN-LAST:event_jTable_DangDoanMouseClicked

    private void jRadioButton_DoanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_DoanVienActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_DoanVien.isSelected()){
            jTextField_DoanVien.setEnabled(true);
        }else{
            jTextField_DoanVien.setEnabled(false);
            jTextField_DoanVien.setText("");
        }
    }//GEN-LAST:event_jRadioButton_DoanVienActionPerformed

    private void jRadioButton_DangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_DangVienActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_DangVien.isSelected()){
            jTextField_DangVien.setEnabled(true);
        }else{
            jTextField_DangVien.setEnabled(false);
            jTextField_DangVien.setText("");
        }
    }//GEN-LAST:event_jRadioButton_DangVienActionPerformed

    private void jRadioButton_CongDoanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_CongDoanVienActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_CongDoanVien.isSelected()){
            jTextField_CongDoanVien.setEnabled(true);
        }else{
            jTextField_CongDoanVien.setEnabled(false);
            jTextField_CongDoanVien.setText("");
        }
    }//GEN-LAST:event_jRadioButton_CongDoanVienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HienThi_DangDoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HienThi_DangDoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HienThi_DangDoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HienThi_DangDoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HienThi_DangDoan(canBo).setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Dong;
    private javax.swing.JButton jButton_Sua;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_MaCB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_CongDoanVien;
    private javax.swing.JRadioButton jRadioButton_DangVien;
    private javax.swing.JRadioButton jRadioButton_DoanVien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DangDoan;
    private javax.swing.JTextField jTextField_CongDoanVien;
    private javax.swing.JTextField jTextField_DangVien;
    private javax.swing.JTextField jTextField_DoanVien;
    // End of variables declaration//GEN-END:variables
}