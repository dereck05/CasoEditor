/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Model.Commands.ICommand;
import Model.Memento.Caretaker;
import Model.Memento.Originator;

/**
 *
 * @author naty9
 */
public class SaveCommand implements ICommand{
    private String state;
    private Originator originator;
    private Caretaker caretaker;
    public SaveCommand(String str,Originator o,Caretaker c){
        this.state = str;
        this.caretaker = c;
        this.originator = o;
    }
    @Override
    public void execute(){
        originator.setState(state);
        caretaker.addMemento(originator.saveStateToMemento());
        System.out.println("Guardado! Estado:"+originator.getStateFromMemento(caretaker.getMemento(0)));
    }
    
    
    
}
