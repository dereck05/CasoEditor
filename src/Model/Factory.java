/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author naty9
 */
public class Factory implements IFactory {

    @Override
    public PDFImp createPDF() {
        PDFImp pdfImp = new PDFImp();
        return pdfImp;
    }

    @Override
    public CSVImp createCSV() {
        CSVImp csvImp = new CSVImp();
        return csvImp;
    }

    @Override
    public XMLImp createXML() {
        XMLImp xmlImp = new XMLImp();
        return xmlImp;
    }

    @Override
    public JsonImp createJson() {
        JsonImp jsonImp = new JsonImp();
        return jsonImp;
    }
    
}
