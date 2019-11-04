/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Factory;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author naty9
 */
public class MainPageController implements ActionListener {
    public MainFrame vista;
    public Factory factory;
    
    public MainPageController(MainFrame pVista, Factory pFactory){
        this.vista = pVista;
        this.factory = pFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(e.getSource()==this.vista.jBtnNew){
            
        } else if(e.getSource()==this.vista.jBtnOpen){
            
        } else if(e.getSource()==this.vista.jBtnSave){
            
        } else if(e.getSource()==this.vista.jBtnSaveAs){
            
        } else if(e.getSource()==this.vista.jBtnFontColor){
            
        } else if(e.getSource()==this.vista.jBtnUndo){
            
        } else if(e.getSource()==this.vista.jBtnRedo){
            
        } else if(e.getSource()==this.vista.jBtnCopy){
            
        } else if(e.getSource()==this.vista.jBtnCut){
            
        } else if(e.getSource()==this.vista.jBtnPaste){
            
        }
    }
    
}
