/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residencymanagement;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author patel
 */
public class ReceiptPDF {
    
    public static void createReceipt(File f, String bno, String hno, String name, String email, String cost, String tstamp, String socName, String recId) throws FileNotFoundException, IOException, DocumentException {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4, 30, 30, 30, 30);
        
        com.itextpdf.text.pdf.PdfWriter writer = com.itextpdf.text.pdf.PdfWriter.getInstance(document, new FileOutputStream(f+".pdf"));
        document.open();
        
//        Image img = Image.getInstance("paid_stamp.png");
//        img.scaleToFit(90f, 90f);
//        img.setAbsolutePosition(450, 750);
        
        com.itextpdf.text.Paragraph paragraph0 = new com.itextpdf.text.Paragraph(socName, FontFactory.getFont(FontFactory.HELVETICA, 22, Font.PLAIN, BaseColor.BLACK));
        
        com.itextpdf.text.Paragraph paragraph = new com.itextpdf.text.Paragraph("RECEIPT", FontFactory.getFont(FontFactory.HELVETICA, 26, Font.PLAIN, BaseColor.BLACK)
                );
        
        com.itextpdf.text.Paragraph paragraph2 = new com.itextpdf.text.Paragraph("------------------------------------------------------------------------------------------------------------------\n"
                + "Receipt No.: " + recId +"\n\n"
                + "Date and Time: "+tstamp+" \n--------------------------------\n"+bno+" "+hno+"\n"+name+"\n"+email+"\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.PLAIN, BaseColor.BLACK));
        
        PdfPTable pdfTable = new PdfPTable(2);
        pdfTable.setHeaderRows(1);
        pdfTable.setWidthPercentage(100);
        pdfTable.getDefaultCell().setFixedHeight(26f);
        pdfTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        

        PdfPCell cell = new PdfPCell(new com.itextpdf.text.Paragraph("Description"));
        cell.setBackgroundColor(new GrayColor(0.9f));
        cell.setFixedHeight(25f);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);

        cell = new PdfPCell(new com.itextpdf.text.Paragraph("Charge"));
        cell.setBackgroundColor(new GrayColor(0.9f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);

        cell = new PdfPCell(new com.itextpdf.text.Paragraph("Maintenance"));
        cell.setFixedHeight(35f);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        
        cell = new PdfPCell(new com.itextpdf.text.Paragraph("Rs. "+cost));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        

//        document.add(img);
        document.add(paragraph0);
        document.add(paragraph);
        document.add(paragraph2);
        document.add(pdfTable);
        
        
//        String file
//            = "sample.pdf";
//
//        // Creating a PdfDocument object
//        PdfDocument pdfDoc
//            = new PdfDocument(new PdfWriter(file));
//
//        // Creating a Document object
//        Document doc = new Document(pdfDoc);
//
//        // Adding text to the document
//        Text text1 = new Text("Society\nINVOICE\n-----------------------------------------------------------");
//
//        // Setting color to the text
////        text1.setFontColor(Color.BLACK);
//
//        // Setting font to the text
//        text1.setFont(PdfFontFactory.createFont(
//            FontConstants.HELVETICA));
//        text1.setFontSize(20);
//
//        // Creating a paragraph 1
//        Paragraph para1 = new Paragraph(text1);
//
//        Text text2 = new Text(
//            "\n\nBill To\n--------------------------------------\nA 403\nName\nEmail\nContact\n\n");
//        text2.setFontSize(10);
//
//        // Setting color to the text
////        text2.setFontColor(Color.BLACK);
//
//        // Setting font to the text
//        text2.setFont(PdfFontFactory.createFont(
//            FontConstants.HELVETICA));
//
//        // Creating a paragraph 2
//        Paragraph para2 = new Paragraph(text2);
//        
//        
//        
//        Text text3 = new Text("---------------------------------------------------\n"
//                + "Description\t\t\t\t\tCharge\n"
//                + "---------------------------------------------------\n"
//                + "Maintenance\t\t\t\t\t1500");
//        text3.setFontSize(10);
//        text3.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        
//        // Setting font to the text
//        text3.setFont(PdfFontFactory.createFont(
//            FontConstants.HELVETICA));
//
//        // Creating a paragraph 2
//        Paragraph para3 = new Paragraph(text3);
//
//        // Adding paragraphs to the document
//        doc.add(para1);
//        doc.add(para2);
//        doc.add(para3);

        // Closing the document
        document.close();
        System.out.println("Text added successfully..");
        
        JOptionPane.showMessageDialog(null, "Receipt saved successfully!");
    }
    
}
