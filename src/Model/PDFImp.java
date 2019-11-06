/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naty9
 */
public class PDFImp implements IArchivo {
    public PDFImp(){}

    //Filename se debe agregar con .pdf
    @Override
    public void guardar(String text, String filename) {
        try{
           Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.add(new Paragraph(text));
            document.close();            
        } catch (DocumentException ex) {
            System.out.println("Error");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String leer(String filename) {
        String pageContent = "";
        try {
            PdfReader pdfReader = new PdfReader(filename);    
            int pages = pdfReader.getNumberOfPages(); 
            for(int i=1; i<=pages; i++) { 
                pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
                System.out.println("Content on Page " + i + ": " + pageContent);
            }
            pdfReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pageContent;
    }
}
