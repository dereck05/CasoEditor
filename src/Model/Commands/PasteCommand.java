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


public class PasteCommand implements ICommand{
    private Controller c;
    private Vista v;
    public PasteCommand(Controller cont,Vista vista){
        this.c = cont;
        this.v = vista;
        
    }
    @Override
    public void execute(){
        JTextArea jtext = this.v.textArea;
        String paste = this.c.getCopy();
        int pos = jtext.getSelectionStart();
        String textoOld = jtext.getText();
        String st1 = textoOld.substring(0, pos);
        if(pos == textoOld.length()){
            this.v.textArea.setText(st1+paste);
        }
        else{
            String st2 = textoOld.substring(pos+1,textoOld.length());
            this.v.textArea.setText(st1+paste+st2);
        }
        
    }
    
}
