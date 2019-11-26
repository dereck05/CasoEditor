/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author derec
 */
public class TxtImp implements IArchivo {
    public TxtImp(){}
    
    @Override
    public void guardar(String text, String filename){
        File file = new File(filename); 
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(text);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(TxtImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String leer(String filename){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            System.out.println(line);
        } catch(IOException ex) {
            Logger.getLogger(TxtImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }
}
