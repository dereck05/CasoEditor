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
public interface IFactory {
    public PDFImp createPDF();
    public CSVImp createCSV();
    public XMLImp createXML();
    public JsonImp createJson();
}
