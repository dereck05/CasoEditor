/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naty9
 */
public class CSVImp implements IArchivo{
    public CSVImp(){}

    @Override
    public void guardar(String text, String filename) {
        File file = new File(filename); 
        try {  
            FileWriter outputfile = new FileWriter(file); 
            CSVWriter writer = new CSVWriter(outputfile); 
            String[] header = { text }; 
            writer.writeNext(header); 
            writer.close(); 
        } catch (IOException ex) {
                Logger.getLogger(CSVImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

    @Override
    public String leer(String filename) {
        String text = "";
        try { 
            FileReader filereader = new FileReader(filename); 

            CSVReader csvReader = new CSVReader(filereader); 
            String[] nextRecord; 

            while ((nextRecord = csvReader.readNext()) != null) { 
                for (String cell : nextRecord) { 
                    text += cell;
                    System.out.print(cell + "\t"); 
                } 
                System.out.println(); 
            } 
        }catch (FileNotFoundException ex) {
            Logger.getLogger(CSVImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

    
}
