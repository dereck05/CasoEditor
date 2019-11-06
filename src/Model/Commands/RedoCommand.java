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

/**
 *
 * @author naty9
 */
public class RedoCommand implements ICommand{
    private Originator originator;
    private Caretaker caretaker;
    private Vista v;
    private Controller c;
    public RedoCommand(Controller cont,Vista vista,Originator o,Caretaker c){
        this.v= vista;
        this.caretaker = c;
        this.originator = o;
        this.c = cont;
    }
    @Override
    public void execute(){
        if(c.getEstado() != -1){
            
            if(c.getEstado()+1  < caretaker.getList().size()){
                String estadoPosterior = caretaker.getList().get(c.getEstado()+1).getState();
                System.out.println("Estado posterior:"+estadoPosterior);
                c.setEstado(c.getEstado()+1);
                v.textArea.setText(estadoPosterior);
            }
            else{
                String estadoAnterior = caretaker.getList().get(c.getEstado()).getState();
                System.out.println("Estado posterior:"+estadoAnterior);
               
                v.textArea.setText(estadoAnterior);
            }
        }
        else{
            
            
        }
        
    }
    
}
