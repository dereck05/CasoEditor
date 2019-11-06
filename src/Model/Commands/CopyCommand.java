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


public class CopyCommand implements ICommand {
    private String copycontent;
    private Controller c;
    public CopyCommand(String copy ,Controller cont){
        this.c = cont;
        this.copycontent = copy;
        
    }
    
    
    
    @Override
    public void execute(){
        this.c.setCopy(copycontent);
    }
    
    
}
