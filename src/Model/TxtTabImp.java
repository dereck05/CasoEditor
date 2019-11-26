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
public class TxtTabImp implements IArchivo {
    public TxtTabImp() {}
    
    @Override
    public void guardar(String text, String filename){
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(filename));
            int cont= 0;
            for(char i:text.toCharArray()){
                if(cont %10 != 0 && cont !=0){
                    cont++;
                    
                }
                else{
                    String s1 = text.substring(0,cont);
                    String s2 = text.substring(cont+1,text.length());
                    text = s1+ "\t" + "s2";
                }
            }
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
