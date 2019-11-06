/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Controller.Controller;
import Model.Commands.ICommand;
import Model.Memento.Caretaker;
import Model.Memento.Originator;
import View.Vista;
import javax.swing.JTextArea;


public class CopyCommand implements ICommand {
    private String copycontent;
    private Controller c;
    private Vista v;
    public CopyCommand(Controller cont,Vista vista){
        this.c = cont;
        this.v = vista;
        this.copycontent="";
        
    }
    
    
    
    @Override
    public void execute(){
        JTextArea jtext = this.v.textArea;
        copycontent = jtext.getSelectedText();
        c.setCopy(copycontent);
    }
    
    
}
