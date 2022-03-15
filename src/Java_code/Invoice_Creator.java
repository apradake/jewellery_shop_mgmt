/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_code;

import static com.itextpdf.kernel.colors.ColorConstants.GRAY;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.pdfa.PdfADocument;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;

/**
 *
 * @author radake_a
 */
public class Invoice_Creator 

{
public static void main (String[] args) throws FileNotFoundException
{
    // SETTING PATHS, CREATING PDF DOC
    String path="Invoice\\New_invoice.pdf";    
    PdfWriter writer= new PdfWriter(path);    
    PdfDocument pdfdoc = new PdfDocument(writer);   
    pdfdoc.setDefaultPageSize(PageSize.A4);    
    Document document = new Document(pdfdoc);    
    document.add(new Paragraph("KHEDIKAR JEWELLERS")).setFontColor(GRAY).setTextAlignment(TextAlignment.CENTER);
     
    // INITIAL VARIABLE SETTING
    float twoCol=285f;
    float twoCol150=twoCol+150f;
    float threecol= 190f;
    float twoColumnWidth[]= {twoCol, twoCol150};
    float fullWidth[]= {threecol*3}; 
    Paragraph oneSpace= new Paragraph("\n");
    
    
    //CREATING PDF
    Table table= new Table(twoColumnWidth);
    document.setBorder(Border.NO_BORDER);
    table.addCell("SALE INVOICE").setBorder(Border.NO_BORDER); 
    
    Table nestedTab= new Table(new float[]{twoCol/2,twoCol/2});
    nestedTab.addCell("Invoice No").setBorder(Border.NO_BORDER).setBold();  nestedTab.addCell("KJ XX XX ").setBorder(Border.NO_BORDER); 
    nestedTab.addCell("Invoice Timestamp:").setBorder(Border.NO_BORDER).setBold(); nestedTab.addCell("XX XX XX ").setBorder(Border.NO_BORDER); 
   
    table.addCell(nestedTab.setBorder(Border.NO_BORDER));
    
    Border bor = new SolidBorder(GRAY, 3f);
    Table divider= new Table(fullWidth);
    divider.setBorder(bor);
    
    
    
    
    document.add(table);
    document.add(oneSpace);
    document.add(divider);
    
    document.close();
    
}  
}
