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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BaoTapChi;
import model.CanBo;
import model.DBBaoTapChi;
import model.DBDeTaiNghienCuu;
import model.DBGiaoTrinh;
import model.DBThanhTich;
import model.DBThongTinCaNhan;
import model.DBThongTinGiaDinh;
import model.DeTaiNghienCuu;
import model.GiaoTrinh;
import model.ThanhTich;
import model.ThongTinGiaDinh;
import static view.SuaBaoTapChi.hangDuLieu;
import static view.SuaDeTai.hangDuLieu;
import static view.SuaThongTinGiaDinh.hangDuLieu;

/**
 *
 * @author tu
 */
public class ThongTinChiTiet extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinChiTiet
     */
    public static CanBo canBo;
    public static String maCanBo = "cb01";
    DBThongTinGiaDinh dbttgd;
    DBThongTinCaNhan dbttcn;
    DBDeTaiNghienCuu dbdtnc;
    DefaultTableModel tableModelThongTinGiaDinh;
    DefaultTableModel tableModelThanhTich;
    DefaultTableModel tableModelDeTai;
    DefaultTableModel tableModelGiaoTrinh;
    DefaultTableModel tableModelBaoTapChi;

    

    public ThongTinChiTiet() {
        this.setVisible(true);
        this.setTitle("Thông tin chi tiết");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        khoiTaoBang();
        hienThiTTGiaDinh();
        hienThiTTDeTai();
        hienThiTTGiaoTrinh();
        hienThiTTBaoTapChi();

    }

    public void khoiTaoBang() {
        tableModelBaoTapChi = new DefaultTableModel();
        tableModelDeTai = new DefaultTableModel();
        tableModelGiaoTrinh = new DefaultTableModel();
        tableModelThanhTich = new DefaultTableModel();
        tableModelThongTinGiaDinh = new DefaultTableModel();

        tableModelThongTinGiaDinh.addColumn("ID");
        tableModelThongTinGiaDinh.addColumn("Mã Cán Bộ");
        tableModelThongTinGiaDinh.addColumn("Họ Tên Con");
        tableModelThongTinGiaDinh.addColumn("Ngay Sinh");
        tbGiaDinh.setModel(tableModelThongTinGiaDinh);

        tableModelDeTai.addColumn("Ma DT");
        tableModelDeTai.addColumn("Ma CB");
        tableModelDeTai.addColumn("Ten DT");
        tableModelDeTai.addColumn("Cap");
        tableModelDeTai.addColumn("Kinh Phi");
        tableModelDeTai.addColumn("Ngay Bat Dau");
        tableModelDeTai.addColumn("Ngay Ket Thuc");
        tableModelDeTai.addColumn("Chu Tri De Tai");
        tableModelDeTai.addColumn("Ket Qua");
        tbDeTai.setModel(tableModelDeTai);
        
        tableModelGiaoTrinh.addColumn("ID");
        tableModelGiaoTrinh.addColumn("Ma CB");
        tableModelGiaoTrinh.addColumn("Ten Giao Trinh");
        tableModelGiaoTrinh.addColumn("Nam Xuat Ban");
        tableModelGiaoTrinh.addColumn("Nha Xuat Ban");
        tbGiaoTrinh.setModel(tableModelGiaoTrinh);
        
        tableModelBaoTapChi.addColumn("ID");
        tableModelBaoTapChi.addColumn("Ma CB");
        tableModelBaoTapChi.addColumn("Ten Bao");
        tableModelBaoTapChi.addColumn("So Bao");
        tableModelBaoTapChi.addColumn("Ngay Xuat Ban");
        tableModelBaoTapChi.addColumn("Chi So ISSN");
        tableModelBaoTapChi.addColumn("He So IF");
        tbBaoTapChi.setModel(tableModelBaoTapChi);
        
        tableModelThanhTich.addColumn("ID");
        tableModelThanhTich.addColumn("Danh Hieu");
        tableModelThanhTich.addColumn("Dat Giai Cap");
        tableModelThanhTich.addColumn("Nam");
        tbThanhTich.setModel(tableModelThanhTich);
        
    }
    
    public void hienThiTTBaoTapChi(){
        ArrayList<BaoTapChi> dsBaoTapChi = new ArrayList<>();
        ArrayList<BaoTapChi> thongTinBao = new ArrayList<>();
        DBBaoTapChi bBaoTapChi = new DBBaoTapChi();
        
        dsBaoTapChi = bBaoTapChi.getAll();
        
        for (BaoTapChi baoTapChi : dsBaoTapChi) {
            if (baoTapChi.getMaCB().equals(maCanBo)){
                thongTinBao.add(baoTapChi);
            }
        }
        
        for (BaoTapChi baoTapChi : thongTinBao) {
            Vector<String> hangDuLieu = new Vector<>();
            hangDuLieu.add(String.valueOf(baoTapChi.getIdBao()));
            hangDuLieu.add(baoTapChi.getMaCB());
            hangDuLieu.add(baoTapChi.getTenBao());
            hangDuLieu.add(String.valueOf(baoTapChi.getSoBao()));
            hangDuLieu.add(new SimpleDateFormat("dd/MM/yyyy").format(baoTapChi.getNgayXuatBan()));
            hangDuLieu.add(String.valueOf(baoTapChi.getChiSoISSN()));
            hangDuLieu.add(String.valueOf(baoTapChi.getHeSoIF()));
            tableModelBaoTapChi.addRow(hangDuLieu);
        }
    }
    
    public void hienThiTTGiaoTrinh(){
        ArrayList<GiaoTrinh> dsGiaoTrinh = new ArrayList<>();
        ArrayList<GiaoTrinh> thongTinGT = new ArrayList<>();
        DBGiaoTrinh bGiaoTrinh = new DBGiaoTrinh();
        
        dsGiaoTrinh = bGiaoTrinh.getAll();
        
        for (GiaoTrinh giaoTrinh : dsGiaoTrinh) {
            if (giaoTrinh.getMaCB().equals(canBo.getMaCB())){
                thongTinGT.add(giaoTrinh);
            }
        }
        
        for (GiaoTrinh giaoTrinh : thongTinGT) {
            Vector<String> hangDuLieu = new Vector<>();
            hangDuLieu.add(String.valueOf(giaoTrinh.getIdGiaoTrinh()));
            hangDuLieu.add(giaoTrinh.getMaCB());
            hangDuLieu.add(giaoTrinh.getTenGiaoTrinh());
            hangDuLieu.add(String.valueOf(giaoTrinh.getNamXuatBan()));
            hangDuLieu.add(giaoTrinh.getNhaXuatBan());
            tableModelGiaoTrinh.addRow(hangDuLieu);
        }
    }

    public void hienThiTTDeTai() {
        dbdtnc = new DBDeTaiNghienCuu();
        ArrayList<DeTaiNghienCuu> dsDeTai = new ArrayList<>();
        ArrayList<DeTaiNghienCuu> thongTinDeTai = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        dsDeTai = dbdtnc.getAll();

        for (DeTaiNghienCuu deTaiNghienCuu : dsDeTai) {

            if (deTaiNghienCuu.getMaCanBo().equals(canBo.getMaCB())) {
                thongTinDeTai.add(deTaiNghienCuu);
            }
        }

        for (DeTaiNghienCuu deTaiNghienCuu : thongTinDeTai) {
            Vector<String> hangDuLieu = new Vector<>();
            hangDuLieu.add(deTaiNghienCuu.getMaDeTai());
            hangDuLieu.add(deTaiNghienCuu.getMaCanBo());
            hangDuLieu.add(deTaiNghienCuu.getTenDeTai());
            hangDuLieu.add(deTaiNghienCuu.getCap());
            hangDuLieu.add(String.valueOf(deTaiNghienCuu.getKinhPhi()));
            hangDuLieu.add(dateFormat.format(deTaiNghienCuu.getNgayBatDau()));
            hangDuLieu.add(dateFormat.format(deTaiNghienCuu.getNgayKetThuc()));
            hangDuLieu.add(deTaiNghienCuu.getChuTriDeTai());
            hangDuLieu.add(deTaiNghienCuu.getKetQua());
            tableModelDeTai.addRow(hangDuLieu);
        }

    }

    public void hienThiTTGiaDinh() {
        dbttgd = new DBThongTinGiaDinh();
        ArrayList<ThongTinGiaDinh> dsGiaDinh = new ArrayList<>();
        ArrayList<ThongTinGiaDinh> thongTinGiaDinhCB = new ArrayList<>();
        dsGiaDinh = dbttgd.getAll();

        for (ThongTinGiaDinh thongTinGiaDinh : dsGiaDinh) {
            if (thongTinGiaDinh.getMaCB().equals(canBo.getMaCB())) {
                thongTinGiaDinhCB.add(thongTinGiaDinh);
            }
        }

        for (ThongTinGiaDinh thongTinGiaDinh : thongTinGiaDinhCB) {
            Vector<String> hangDuLieu = new Vector<>();
            hangDuLieu.add(String.valueOf(thongTinGiaDinh.getId()));
            hangDuLieu.add(thongTinGiaDinh.getMaCB());
            hangDuLieu.add(thongTinGiaDinh.getHoTen());
            hangDuLieu.add(new SimpleDateFormat("dd/MM/yyyy").format(thongTinGiaDinh.getNgaySinh()));
            tableModelThongTinGiaDinh.addRow(hangDuLieu);
        }
    }
    
    public void xoaCon(){
        Vector<String> hangDuLieu = new Vector<>();
        hangDuLieu = (Vector<String>) tableModelThongTinGiaDinh.getDataVector().elementAt(tbGiaDinh.getSelectedRow());
        Integer id = Integer.parseInt(hangDuLieu.get(0));
        String maCB = hangDuLieu.get(1);
        String hoTen = hangDuLieu.get(2);
        Date ngaySinh = null;
        try {
            ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(hangDuLieu.get(3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaThongTinGiaDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ThongTinGiaDinh con = new ThongTinGiaDinh(id, maCB, hoTen, ngaySinh);
        DBThongTinGiaDinh bThongTinGiaDinh = new DBThongTinGiaDinh();
        if (bThongTinGiaDinh.deleteGiaDinh(con) > 0){
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong !");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Xoa khong thanh cong !");
    }

    public void xoaDeTai() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DBDeTaiNghienCuu bDeTaiNghienCuu = new DBDeTaiNghienCuu();
        
        Vector<String> hangDuLieu = new Vector<>();
        hangDuLieu = (Vector<String>) tableModelDeTai.getDataVector().elementAt(tbDeTai.getSelectedRow());
        String maDeTai = hangDuLieu.get(0);
        String maCanBo = hangDuLieu.get(1);
        String tenDeTai = hangDuLieu.get(2);
        String cap = hangDuLieu.get(3);
        Double kinhPhi = Double.parseDouble(hangDuLieu.get(4));
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        
        try {
            ngayBatDau = dateFormat.parse(hangDuLieu.get(5));
            ngayKetThuc = dateFormat.parse(hangDuLieu.get(6));
        } catch (ParseException ex) {
            Logger.getLogger(SuaDeTai.class.getName()).log(Level.SEVERE, null, ex);
        }
        String chuTriDeTai = hangDuLieu.get(7);
        String ketQua = hangDuLieu.get(8);
        DeTaiNghienCuu deTaiNghienCuu = new DeTaiNghienCuu(maDeTai, maCanBo, tenDeTai, cap, kinhPhi, ngayBatDau, ngayKetThuc, chuTriDeTai, ketQua);
        if (bDeTaiNghienCuu.deleteDeTai(deTaiNghienCuu) > 0){
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong !");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xoa khong thanh cong !");
        }
    }
    
    public void xoaGiaoTrinh(){
        Vector<String>  hangDuLieu = (Vector<String>) tableModelGiaoTrinh.getDataVector().elementAt(tbGiaoTrinh.getSelectedRow());
        Integer id = Integer.parseInt(hangDuLieu.get(0));
        String maCB = hangDuLieu.get(1);
        String tenGT = hangDuLieu.get(2);
        Integer namXB = Integer.parseInt(hangDuLieu.get(3));
        String nhaXB = hangDuLieu.get(4);
        
        GiaoTrinh giaoTrinh = new GiaoTrinh(id, maCB, tenGT, namXB, nhaXB);
        
        DBGiaoTrinh bGiaoTrinh = new DBGiaoTrinh();
        if (bGiaoTrinh.deleteGiaoTrinh(giaoTrinh) > 0){
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Xoa khong thanh cong !");
    }
    
    public void xoaBaoTapChi(){
        Vector<String> hangDuLieu = (Vector<String>) tableModelBaoTapChi.getDataVector().elementAt(tbBaoTapChi.getSelectedRow());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Integer id = Integer.parseInt(hangDuLieu.get(0));
        String maCB = hangDuLieu.get(1);
        String tenBao = hangDuLieu.get(2);
        Integer soBao = Integer.parseInt(hangDuLieu.get(3));
        Date ngayXB = null;
        try {
            ngayXB = dateFormat.parse(hangDuLieu.get(4));
        } catch (ParseException ex) {
            Logger.getLogger(SuaBaoTapChi.class.getName()).log(Level.SEVERE, null, ex);
        }
        Double chiSoISSN = Double.parseDouble(hangDuLieu.get(5));
        Double heSoIF = Double.parseDouble(hangDuLieu.get(6));
        
        BaoTapChi baoTapChi = new BaoTapChi(id, maCB, tenBao, soBao, ngayXB, chiSoISSN, heSoIF);
        DBBaoTapChi bBaoTapChi = new DBBaoTapChi();
        
        if (bBaoTapChi.deleteBaoTapChi(baoTapChi) > 0){
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong !");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Xoa khong thanh cong !");
        
    }
    
    public void hienThiThanhTich(){
        Vector<String> hangDuLieu = new Vector<>();
        hangDuLieu = (Vector<String>) tableModelThongTinGiaDinh.getDataVector().elementAt(tbGiaDinh.getSelectedRow());
        Integer idGiaDinh = Integer.parseInt(hangDuLieu.get(0));
        ArrayList<ThanhTich> dsThanhTich = new ArrayList<>();
        ArrayList<ThanhTich> thongTinTT = new ArrayList<>();
        
        DBThanhTich bThanhTich = new DBThanhTich();
        dsThanhTich = bThanhTich.getAll();
        
        for (ThanhTich thanhTich : dsThanhTich) {
            if (thanhTich.getIdThanhTich() == idGiaDinh){
                thongTinTT.add(thanhTich);
            }
        }
        
        for (ThanhTich thanhTich : thongTinTT) {
            Vector<String> duLieu = new Vector<>();
            duLieu.add(String.valueOf(thanhTich.getIdThanhTich()));
            duLieu.add(thanhTich.getDanhHieu());
            duLieu.add(thanhTich.getDatGiaiCap());
            duLieu.add(String.valueOf(thanhTich.getNam()));
            tableModelThanhTich.addRow(duLieu);
            
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
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGiaDinh = new javax.swing.JTable();
        btnThemGiaDinh = new javax.swing.JButton();
        btnSuaGiaDinh = new javax.swing.JButton();
        btnXoaGiaDinh = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThanhTich = new javax.swing.JTable();
        btnThemThanhTich = new javax.swing.JButton();
        btnSuaThanhTich = new javax.swing.JButton();
        btnXoaThanhTich = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBaoTapChi = new javax.swing.JTable();
        btnThemBao = new javax.swing.JButton();
        btnSuaBao = new javax.swing.JButton();
        btnXoaBao = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbGiaoTrinh = new javax.swing.JTable();
        btnThemGiaoTrinh = new javax.swing.JButton();
        btnSuaGiaoTrinh = new javax.swing.JButton();
        btnXoaGiaoTrinh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDeTai = new javax.swing.JTable();
        btnThemDeTai = new javax.swing.JButton();
        btnSuaDeTai = new javax.swing.JButton();
        btnXoaDeTai = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN CHI TIẾT");

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin các con", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tbGiaDinh.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGiaDinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGiaDinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGiaDinh);

        btnThemGiaDinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemGiaDinh.setText("Thêm");
        btnThemGiaDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiaDinhActionPerformed(evt);
            }
        });

        btnSuaGiaDinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaGiaDinh.setText("Sửa");
        btnSuaGiaDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaGiaDinhActionPerformed(evt);
            }
        });

        btnXoaGiaDinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaGiaDinh.setText("Xóa");
        btnXoaGiaDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGiaDinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemGiaDinh, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(btnSuaGiaDinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addComponent(btnXoaGiaDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemGiaDinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaGiaDinh)
                    .addComponent(btnXoaGiaDinh))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thành tích", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tbThanhTich.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbThanhTich);

        btnThemThanhTich.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemThanhTich.setText("Thêm");

        btnSuaThanhTich.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaThanhTich.setText("Sửa");

        btnXoaThanhTich.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaThanhTich.setText("Xóa");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemThanhTich, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(btnSuaThanhTich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addComponent(btnXoaThanhTich, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnThemThanhTich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThanhTich)
                    .addComponent(btnXoaThanhTich))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin gia đình", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin báo, tạp chí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tbBaoTapChi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbBaoTapChi);

        btnThemBao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemBao.setText("Thêm");
        btnThemBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBaoActionPerformed(evt);
            }
        });

        btnSuaBao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaBao.setText("Sửa");
        btnSuaBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBaoActionPerformed(evt);
            }
        });

        btnXoaBao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaBao.setText("Xóa");
        btnXoaBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnSuaBao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(btnXoaBao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemBao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnThemBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaBao)
                    .addComponent(btnXoaBao))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bài báo tạp chí", jPanel3);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin giáo trình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tbGiaoTrinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbGiaoTrinh);

        btnThemGiaoTrinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemGiaoTrinh.setText("Thêm ");
        btnThemGiaoTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiaoTrinhActionPerformed(evt);
            }
        });

        btnSuaGiaoTrinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaGiaoTrinh.setText("Sửa ");
        btnSuaGiaoTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaGiaoTrinhActionPerformed(evt);
            }
        });

        btnXoaGiaoTrinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaGiaoTrinh.setText("Xóa");
        btnXoaGiaoTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGiaoTrinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnSuaGiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(btnXoaGiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemGiaoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnThemGiaoTrinh)
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaGiaoTrinh)
                    .addComponent(btnSuaGiaoTrinh))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giáo trình", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đề tài nghiên cứu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tbDeTai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbDeTai);

        btnThemDeTai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemDeTai.setText("Thêm");
        btnThemDeTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDeTaiActionPerformed(evt);
            }
        });

        btnSuaDeTai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaDeTai.setText("Sửa");
        btnSuaDeTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDeTaiActionPerformed(evt);
            }
        });

        btnXoaDeTai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaDeTai.setText("Xóa");
        btnXoaDeTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDeTaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnSuaDeTai, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)
                                .addComponent(btnXoaDeTai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThemDeTai, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnThemDeTai)
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaDeTai)
                    .addComponent(btnXoaDeTai))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Đề tài nghiên cứu", jPanel5);

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThoat)))
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemGiaDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiaDinhActionPerformed
        // TODO add your handling code here:
        ThemThongTinGiaDinh.canBo = canBo;
        new ThemThongTinGiaDinh();
    }//GEN-LAST:event_btnThemGiaDinhActionPerformed

    private void btnThemDeTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDeTaiActionPerformed
        // TODO add your handling code here:
        ThemDeTai.canBo = this.canBo;
        new ThemDeTai();
    }//GEN-LAST:event_btnThemDeTaiActionPerformed

    private void btnSuaDeTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDeTaiActionPerformed
        // TODO add your handling code here:
        SuaDeTai.hangDuLieu = (Vector<String>) tableModelDeTai.getDataVector().elementAt(tbDeTai.getSelectedRow());
        new SuaDeTai();
    }//GEN-LAST:event_btnSuaDeTaiActionPerformed

    private void btnXoaDeTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDeTaiActionPerformed
        // TODO add your handling code here:
        xoaDeTai();
    }//GEN-LAST:event_btnXoaDeTaiActionPerformed

    private void btnThemGiaoTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiaoTrinhActionPerformed
        // TODO add your handling code here:
        ThemGiaoTrinh.canBo = this.canBo;
        new ThemGiaoTrinh();
    }//GEN-LAST:event_btnThemGiaoTrinhActionPerformed

    private void btnSuaGiaoTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaGiaoTrinhActionPerformed
        // TODO add your handling code here:
        SuaGiaoTrinh.hangDuLieu = (Vector<String>) tableModelGiaoTrinh.getDataVector().elementAt(tbGiaoTrinh.getSelectedRow());
        new SuaGiaoTrinh();
    }//GEN-LAST:event_btnSuaGiaoTrinhActionPerformed

    private void btnXoaGiaoTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGiaoTrinhActionPerformed
        // TODO add your handling code here:
        xoaGiaoTrinh();
    }//GEN-LAST:event_btnXoaGiaoTrinhActionPerformed

    private void btnThemBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBaoActionPerformed
        // TODO add your handling code here:
        ThemBaoTapChi.canBo = this.canBo;
        new ThemBaoTapChi();
    }//GEN-LAST:event_btnThemBaoActionPerformed

    private void btnSuaBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBaoActionPerformed
        // TODO add your handling code here:
        Vector<String> hangDuLieu = new Vector<>();
        hangDuLieu = (Vector<String>) tableModelBaoTapChi.getDataVector().elementAt(tbBaoTapChi.getSelectedRow());
        SuaBaoTapChi.hangDuLieu = hangDuLieu;
        new SuaBaoTapChi();
    }//GEN-LAST:event_btnSuaBaoActionPerformed

    private void btnXoaBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBaoActionPerformed
        // TODO add your handling code here:
        xoaBaoTapChi();
    }//GEN-LAST:event_btnXoaBaoActionPerformed

    private void btnSuaGiaDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaGiaDinhActionPerformed
        // TODO add your handling code here:
        Vector<String> hangDuLieu = new Vector<>();
        hangDuLieu = (Vector<String>) tableModelThongTinGiaDinh.getDataVector().elementAt(tbGiaDinh.getSelectedRow());
        SuaThongTinGiaDinh.hangDuLieu = hangDuLieu;
        new SuaThongTinGiaDinh();
    }//GEN-LAST:event_btnSuaGiaDinhActionPerformed

    private void btnXoaGiaDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGiaDinhActionPerformed
        // TODO add your handling code here:
        xoaCon();
    }//GEN-LAST:event_btnXoaGiaDinhActionPerformed

    private void tbGiaDinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGiaDinhMouseClicked
        // TODO add your handling code here:
        hienThiThanhTich();
    }//GEN-LAST:event_tbGiaDinhMouseClicked

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
            java.util.logging.Logger.getLogger(ThongTinChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaBao;
    private javax.swing.JButton btnSuaDeTai;
    private javax.swing.JButton btnSuaGiaDinh;
    private javax.swing.JButton btnSuaGiaoTrinh;
    private javax.swing.JButton btnSuaThanhTich;
    private javax.swing.JButton btnThemBao;
    private javax.swing.JButton btnThemDeTai;
    private javax.swing.JButton btnThemGiaDinh;
    private javax.swing.JButton btnThemGiaoTrinh;
    private javax.swing.JButton btnThemThanhTich;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoaBao;
    private javax.swing.JButton btnXoaDeTai;
    private javax.swing.JButton btnXoaGiaDinh;
    private javax.swing.JButton btnXoaGiaoTrinh;
    private javax.swing.JButton btnXoaThanhTich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbBaoTapChi;
    private javax.swing.JTable tbDeTai;
    private javax.swing.JTable tbGiaDinh;
    private javax.swing.JTable tbGiaoTrinh;
    private javax.swing.JTable tbThanhTich;
    // End of variables declaration//GEN-END:variables
}
