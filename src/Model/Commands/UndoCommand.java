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


public class UndoCommand implements ICommand {
    private Originator originator;
    private Caretaker caretaker;
    private Vista v;
    private Controller c;
    public UndoCommand(Controller cont,Vista vista,Originator o,Caretaker c){
        this.v= vista;
        this.caretaker = c;
        this.originator = o;
        this.c = cont;
    }
    @Override
    public void execute(){
        if(c.getEstado() == -1){
            
            String estadoAnterior = caretaker.getList().get(caretaker.getList().size()-2).getState();
            System.out.println("Estado anterior:"+estadoAnterior);
            c.setEstado(caretaker.getList().size()-2);
            v.textArea.setText(estadoAnterior);
        }
        else{
            if(c.getEstado()-1 >= 0){
                String estadoAnterior = caretaker.getList().get(c.getEstado()-1).getState();
                System.out.println("Estado anterior:"+estadoAnterior);
                c.setEstado(c.getEstado()-1);
                v.textArea.setText(estadoAnterior);
            }
            else{
                String estadoAnterior = caretaker.getList().get(0).getState();
                System.out.println("Estado anterior:"+estadoAnterior);
                c.setEstado(0);
                v.textArea.setText(estadoAnterior);
            }
            
        }
        
    }
    
}
