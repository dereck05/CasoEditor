/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Controller.Controller;
import Model.Commands.ICommand;
import Model.Memento.Caretaker;
import Model.Memento.Memento;
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
        if(!caretaker.getList().isEmpty()){
            String last = caretaker.getList().get(caretaker.getList().size()-1).getState();
            if(!last.equals(state)){
                originator.setState(state);
                caretaker.addMemento(originator.saveStateToMemento()); 
            }
            else{
                System.out.println("Mismo estado, no se guardo\n");
            }
        }
        else{
            originator.setState(state);
            caretaker.addMemento(originator.saveStateToMemento());
            
        }
        
        for(Memento i : caretaker.getList()){
            System.out.println("Estado:"+i.getState());

        }
    }
    
    
    
}
