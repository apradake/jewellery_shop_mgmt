/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_code;

/**
 *
 * @author radake_a
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


class PageNumeration extends PdfPageEventHelper
{
/** The template with the total number of pages. */
PdfTemplate total;
Font f,normal,normalSmall,f1;
//private Font normal, normalSmall;
//private Company company;
//private Font font, font2;
public PageNumeration ()
{
    try{
      //  this.normal = new Font(BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 8);
       // this.normalSmall = new Font(BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 6);
     //   Font font = FontFactory.getFont(FontFactory.ZAPFDINGBATS,
   // BaseFont.ZAPFDINGBATS, BaseFont.EMBEDDED, 12);
    //    Font font2 = FontFactory.getFont(FontFactory.ZAPFDINGBATS,
  //  BaseFont.ZAPFDINGBATS, BaseFont.EMBEDDED, 10);
  //  com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 8, com.itextpdf.text.Font.NORMAL, GrayColor.GRAYWHITE);
   //     com.itextpdf.text.Font f1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 6, com.itextpdf.text.Font.NORMAL, GrayColor.GRAYWHITE);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * Creates the PdfTemplate that will hold the total number of pages.
 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
 *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
 */
public void onOpenDocument(PdfWriter writer, Document document) {
    total = writer.getDirectContent().createTemplate(30, 16);
}

/**
 * Adds a header to every page
 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
 *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
 */
public void onEndPage(PdfWriter writer, Document document) {
    PdfPTable table = new PdfPTable(3);
    try {
        table.setWidths(new int[]{24, 24, 2});
        table.getDefaultCell().setFixedHeight(8);
        table.getDefaultCell().setBorder(Rectangle.ALIGN_TOP);
        PdfPCell cell = new PdfPCell();
        cell.setBorder (0);
        cell.setBorderWidthTop (1);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setPhrase(new Phrase("Software by GAMA CONSULTING, +91 8668872673",FontFactory.getFont(java.awt.Font.MONOSPACED,8,java.awt.Font.PLAIN,BaseColor.BLACK)));
        table.addCell(cell);
       
        cell = new PdfPCell();
        cell.setBorder (0);
        cell.setBorderWidthTop (1);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPhrase(new Phrase(String.format("Page %d of", writer.getPageNumber()),FontFactory.getFont(java.awt.Font.MONOSPACED,10,java.awt.Font.BOLD,BaseColor.BLACK)));
        table.addCell(cell);

        cell = new PdfPCell(Image.getInstance(total));
        cell.setBorder (0);
        cell.setBorderWidthTop (1);
        cell.setHorizontalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        table.setTotalWidth(document.getPageSize().getWidth()
                - document.leftMargin() - document.rightMargin());
        table.writeSelectedRows(0, -1, document.leftMargin(),
                document.bottomMargin() - 15, writer.getDirectContent());
    }
    catch(DocumentException de) {
        throw new ExceptionConverter(de);
    }
}

/**
 * Fills out the total number of pages before the document is closed.
 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
 *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
 */
public void onCloseDocument(PdfWriter writer, Document document)
{
    ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
            new Phrase(String.valueOf(writer.getPageNumber()),FontFactory.getFont(java.awt.Font.MONOSPACED,11,java.awt.Font.BOLD,BaseColor.RED)),
            2, 2, 0);
    }
}  
