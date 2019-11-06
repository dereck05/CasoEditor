/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Controller.Controller;
import Model.Commands.ICommand;
import View.Vista;
import javax.swing.JTextArea;

/**
 *
 * @author naty9
 */
public class CutCommand implements ICommand{
    private String copycontent;
    private Controller c;
    private Vista v;
    public CutCommand(Controller cont,Vista vista){
        this.c = cont;
        this.v = vista;
        this.copycontent="";
        
    }
    @Override
    public void execute(){
        JTextArea jtext = this.v.textArea;
        copycontent = jtext.getSelectedText();
        c.setCopy(copycontent);
        
        String textoOld = jtext.getText();
        int ini = jtext.getSelectionStart();
        int fin = jtext.getSelectionEnd();
        String st1 = textoOld.substring(0, ini);
        if(fin == textoOld.length()){
            this.v.textArea.setText(st1);
        }
        else{
            String st2 = textoOld.substring(fin+1,textoOld.length());
            this.v.textArea.setText(st1+st2);
        }
        
        
       
        
    }
    
}
