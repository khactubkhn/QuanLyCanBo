/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Admin
 */
public class ThongKe extends javax.swing.JPanel {

    int indexThongKe;
    JTabbedPane jTabbedPane;
    DoanPhi doanPhi;
    CanBoNu canBoNu;
    CanBoNam canBoNam;
    DangPhi dangPhi;
    CongDoanPhi congDoanPhi;
    TienThiGiangVien tienThiGiangVien;
    NhanQuanTrungThu nhanQuanTrungThu;

    /**
     * Creates new form ThongKe
     */
    public ThongKe(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
        initComponents();

        doanPhi = new DoanPhi();
        dangPhi = new DangPhi();
        canBoNam = new CanBoNam();
        nhanQuanTrungThu = new NhanQuanTrungThu();
        congDoanPhi = new CongDoanPhi();
        indexThongKe = -1;
        canBoNu = new CanBoNu();
        tienThiGiangVien = new TienThiGiangVien();
        jpThongKe.add(canBoNu, BorderLayout.CENTER);

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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jbOK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jpThongKe = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout(20, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jLabel1.setText("Thống kê theo : ");
        jPanel1.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cán bộ nữ", "Cán bộ nam", "Đoàn phí", "Đảng phí", "Công đoàn phí", "Tiền thi của giảng viên", "Các cháu nhận quà trung thu" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);

        jbOK.setText(">>");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });
        jPanel1.add(jbOK);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("CloseTab");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        add(jPanel4, java.awt.BorderLayout.LINE_END);

        jpThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpThongKe.setLayout(new java.awt.BorderLayout());
        add(jpThongKe, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane.remove(jTabbedPane.getSelectedIndex());
        indexThongKe = -1;
        GiaoDienChinh.soLuongTab--;
        System.out.println("so luong tab" + GiaoDienChinh.soLuongTab);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        int index = jComboBox1.getSelectedIndex();
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            System.out.println("dang chon item  : " + index);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
//        
        int index = jComboBox1.getSelectedIndex();
        if (index == 0) {
            jpThongKe.removeAll();
            jpThongKe.add(canBoNu, BorderLayout.CENTER);
            jpThongKe.updateUI();

        } else if (index == 1) {
            jpThongKe.removeAll();
            jpThongKe.add(canBoNam, BorderLayout.CENTER);
            jpThongKe.updateUI();
        } else if (index == 2) {
            jpThongKe.removeAll();
            jpThongKe.add(doanPhi, BorderLayout.CENTER);
            jpThongKe.updateUI();
        } else if (index == 3) {
            jpThongKe.removeAll();
            jpThongKe.add(dangPhi, BorderLayout.CENTER);
            jpThongKe.updateUI();
        } else if (index == 4) {
            jpThongKe.removeAll();
            jpThongKe.add(congDoanPhi);
            jpThongKe.updateUI();
        }
        else if(index == 5){
            jpThongKe.removeAll();
            jpThongKe.add(tienThiGiangVien);
            jpThongKe.updateUI();
        }
        else if(index == 6){
            jpThongKe.removeAll();
            jpThongKe.add(nhanQuanTrungThu);
            jpThongKe.updateUI();
        }

    }//GEN-LAST:event_jbOKActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbOK;
    private javax.swing.JPanel jpThongKe;
    // End of variables declaration//GEN-END:variables
}
