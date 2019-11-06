/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author derec
 */
public class TxtImp implements IArchivo {
    @Override
    public void guardar(String text, String filename){
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(text);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(XMLImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String leer(String filename){
        return "";
    }
}
