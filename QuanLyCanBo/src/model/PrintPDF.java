/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PrintPDF {

    SimpleDateFormat dateFormat;

    public PrintPDF() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void inThongKeCanBo(ArrayList< CanBo> listCanBo, String pathName, String nam, int gt, String tongNhanVien, String soNVVH) {
        PdfWriter pdfWriter = null;
        String gioiTinh = "";
        if (gt == 1) {
            gioiTinh = "nữ";
        } else {
            gioiTinh = "nam";
        }

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê cán bộ " + gioiTinh + " năm " + nam + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 2, 4, 3, 4};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Ngày sinh").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Số điện thoại").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));

            //  nội dung của bảng thống kê
            for (int i = 0; i < listCanBo.size(); i++) {
                table.addCell(new Paragraph((i + 1) + "").setFont(hfont).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Paragraph(listCanBo.get(i).getMaCB()).setFont(hfont).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Paragraph(listCanBo.get(i).getHoTen()).setFont(hfont).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Paragraph(dateFormat.format(listCanBo.get(i).getNgaySinh())).setFont(hfont).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Paragraph(listCanBo.get(i).getSDT()).setFont(hfont).setTextAlignment(TextAlignment.CENTER));
            }
            document.add(table);
            document.add(new Paragraph("\n\n Tổng số nhân viên            :  " + tongNhanVien).setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph(" Tổng số nhân viên sắp về hưu :  " + tongNhanVien).setFont(hfont).setTextAlignment(TextAlignment.LEFT));

            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void thongKeDoanPhi(ArrayList<String> listDataTable, String pathName, String nam, String tongDoanVien, String tienDoanPhi) {
        PdfWriter pdfWriter = null;
        String gioiTinh = "";

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê đoàn viên  " + gioiTinh + " năm " + nam + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 2, 4, 3, 4};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Ngày sinh").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Số tài khoản ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));

            //  nội dung của bảng thống kê
            for (int i = 0; i < listDataTable.size(); i++) {
                table.addCell(new Paragraph(listDataTable.get(i)).setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            }

            document.add(table);
            document.add(new Paragraph("\n\n Tổng số đoàn viên           :  " + tongDoanVien ).setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph(" Đoàn phí (VNĐ / Đoàn Viên) :  " + tienDoanPhi +"VNĐ").setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            double tongTienDoanPhi = Integer.parseInt(tongDoanVien) * Integer.parseInt(tienDoanPhi);
            document.add(new Paragraph(" Tổng số tiền đoàn phí            :  " + tongTienDoanPhi + " VND").setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void thongKeCongDoanPhi(ArrayList<String> listDataTable, String pathName, String nam, String tongCongDoanVien, String tienCongDoanPhi) {
        PdfWriter pdfWriter = null;
      

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê công đoàn viên  năm " + nam + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 2, 4, 3, 3 ,3};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Ngày sinh").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Chức vụ ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Công đoàn phí ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            //  nội dung của bảng thống kê
            for (int i = 0; i < listDataTable.size(); i++) {
                table.addCell(new Paragraph(listDataTable.get(i)).setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            }

            document.add(table);
            document.add(new Paragraph("\n\n Tổng số nhân viên           :  " + tongCongDoanVien).setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph(" Tổng công đoàn phí  :  " + tienCongDoanPhi).setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            
            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
     public void thongKeDangPhi(ArrayList<String> listDataTable, String pathName, String nam, String tongDangVien) {
        PdfWriter pdfWriter = null;  

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê đảng viên  " + " năm " + nam + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 2, 4, 3, 4,4};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Ngày sinh").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Chức vụ ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Đảng phí ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));

            //  nội dung của bảng thống kê
            for (int i = 0; i < listDataTable.size(); i++) {
                table.addCell(new Paragraph(listDataTable.get(i)).setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            }

            document.add(table);
            document.add(new Paragraph("\n\n Tổng số đảng viên           :  " + tongDangVien).setFont(hfont).setTextAlignment(TextAlignment.LEFT));
            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
     public void thongKeTienThi(ArrayList<String> listDataTable, String pathName) {
        PdfWriter pdfWriter = null;  

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê tiền thi giảng viên  " + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 2, 4, 3, 4,4};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Môn học").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Số SV ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Phí thi").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));

            //  nội dung của bảng thống kê
            for (int i = 0; i < listDataTable.size(); i++) {
                table.addCell(new Paragraph(listDataTable.get(i)).setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            }

            document.add(table);
            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
     public void thongKeThieuNhi(ArrayList<String> listDataTable, String pathName) {
        PdfWriter pdfWriter = null;  

        try {
            pdfWriter = new PdfWriter(pathName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            document.setMargins(50, 50, 50, 50);
            document.add(new Paragraph("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI ").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Thống kê các cháu thiếu nhi   " + "\n\n").setFont(hfont).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            float[] columnWidths = {1, 3, 3, 3, 4};
            Table table = new Table(columnWidths);
            table.setWidthPercent(100);
            table.addHeaderCell(new Paragraph("STT").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Ngày sinh ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Mã cán bộ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            table.addHeaderCell(new Paragraph("Họ và tên cán bộ ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(14));
            

            //  nội dung của bảng thống kê
            for (int i = 0; i < listDataTable.size(); i++) {
                table.addCell(new Paragraph(listDataTable.get(i)).setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14));
            }

            document.add(table);
            document.add(new Paragraph("\n\n\n Hà Nội, ngày    tháng        năm     \n  Người lập phiếu \n  ( Ghi rõ họ tên) ").setFont(hfont).setTextAlignment(TextAlignment.RIGHT).setItalic().setMarginRight(40));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
