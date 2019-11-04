/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Memento;

/**
 *
 * @author naty9
 */
public class Originator {
    private String state;
    
    public Memento createMemento(){
        return new Memento(state);
    }
    
    public void setMemento(String pState){
        this.state = pState;
    }
    
    public void restoreToState(Memento memento) {
        state = memento.getState();
  }
}
