/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Model.Commands.ICommand;
import Model.Memento.Caretaker;
import Model.Memento.Originator;
import View.Vista;

/**
 *
 * @author naty9
 */
public class UndoCommand implements ICommand {
    private Originator originator;
    private Caretaker caretaker;
    private Vista v;
    public UndoCommand(Vista vista,Originator o,Caretaker c){
        this.v= vista;
        this.caretaker = c;
        this.originator = o;
    }
    @Override
    public void execute(){
        String estadoAnterior = caretaker.getList().get(caretaker.getList().size()-1).getState();
        v.textArea.setText(estadoAnterior);
    }
    
}
