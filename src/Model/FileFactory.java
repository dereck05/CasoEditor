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
public class FileFactory extends AbstractFactory {

    @Override
    public IArchivo crear(int tipo){
        IArchivo objeto;
        switch(tipo){
            case PDF:
                objeto = new PDFImp();
                break;
            case CSV:
                objeto = new CSVImp();
                break;
            case XML:
                objeto = new XMLImp();
                break;
            case JSON:
                objeto = new JsonImp();
            case TXT:
                objeto = new TxtImp();
            case TXTab:
                objeto = new TxtTabImp();
            default:
                objeto = null;
                   
            
        }
        return objeto;
    }
    
}
