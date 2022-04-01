/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residencymanagement;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author patel
 */
public class SavePDF {
    
    private static Document document;
    private static PdfWriter writer;
    
    public static void openPdf(File f) throws FileNotFoundException, DocumentException {
        document = new Document(PageSize.A4, 30, 30, 30, 30);
        
        writer = PdfWriter.getInstance(document, new FileOutputStream(f+".pdf"));
        document.open();
    }

    public static void closePdf() {
        document.close();
    }

    public static void addData(PdfPTable pdfTable, javax.swing.JTable table, String head, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(head, FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.BLACK));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        
        Paragraph paragraph2 = new Paragraph(text, FontFactory.getFont(FontFactory.HELVETICA, 14, Font.PLAIN, BaseColor.BLACK));
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        
        pdfTable.setHeaderRows(1);
        pdfTable.setWidthPercentage(100);
        pdfTable.getDefaultCell().setFixedHeight(26f);
        pdfTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        

        PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(0)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setFixedHeight(30f);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);

        cell = new PdfPCell(new Paragraph(table.getColumnName(1)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);

        cell = new PdfPCell(new Paragraph(table.getColumnName(2)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(table.getColumnName(3)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(table.getColumnName(4)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(table.getColumnName(5)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(table.getColumnName(6)));
        cell.setBackgroundColor(new GrayColor(0.7f));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfTable.addCell(cell);

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                pdfTable.addCell(table.getModel().getValueAt(i, j).toString());
            }
        }

        document.add(paragraph);
        document.add(paragraph2);
        document.add(pdfTable);
    }
    
}
