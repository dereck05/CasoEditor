/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Commands.ICommand;
import Model.Commands.Invoker;
import Model.Commands.SaveCommand;
import Model.Memento.Caretaker;
import Model.Memento.Originator;
import View.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author derec
 */
public class Controller implements ActionListener {
    private Vista vista;
    private Invoker inv ;
    ICommand comando;
    Originator originator;
    Caretaker careTaker;
    
    public Controller(Vista v){
        this.vista = v;
        this.inv = new Invoker();
        this.careTaker = new Caretaker();
        this.originator = new Originator();
        this.vista.jBtnCopy.addActionListener(this);
        this.vista.jBtnCut.addActionListener(this);
        this.vista.jBtnFontColor.addActionListener(this);
        this.vista.jBtnNew.addActionListener(this);
        this.vista.jBtnOpen.addActionListener(this);
        this.vista.jBtnPaste.addActionListener(this);
        this.vista.jBtnRedo.addActionListener(this);
        this.vista.jBtnSave.addActionListener(this);
        this.vista.jBtnSaveAs.addActionListener(this);
        this.vista.jBtnUndo.addActionListener(this);
        this.vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "New":
                newDoc();
                break;
            case "Open":
                open();
                break;
            case "Save":
                save();
                break;
            case "Save As":
                saveAs();
                break;
            case "Font color":
                font();
                break;
                
            case "Undo":
                undo();
                break;
                
            case "Redo":
                redo();
                break;
            case "Copy":
                copy();
                break;
                
            case "Cut":
                cut();
                break;
            case "Paste":
                paste();
                break;
            default:
                JOptionPane.showMessageDialog(vista, "Opción no registrada");
                break;
        }
    }
    
    public void newDoc(){
        
    }
    
    public void open(){
        
    }
    public void save(){
        comando = new SaveCommand(this.vista.textArea.getText(),this.originator,this.careTaker);
        inv.execute(comando);
        
    }
    public void saveAs(){
        
    }
    public void font(){
        
    }
    public void undo(){
        
    }
    public void redo(){
        
    }
    public void copy(){
        
    }
    public void cut(){
        
    }
    public void paste(){
        
    }
}
