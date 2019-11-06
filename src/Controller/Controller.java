/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AbstractFactory;
import Model.Commands.CopyCommand;
import Model.Commands.CutCommand;
import Model.CSVImp;
import Model.Commands.ICommand;
import Model.Commands.Invoker;
import Model.Commands.PasteCommand;
import Model.Commands.RedoCommand;
import Model.Commands.SaveCommand;
import Model.Commands.UndoCommand;
import Model.FileFactory;
import Model.JsonImp;
import Model.Memento.Caretaker;
import Model.Memento.Originator;
import Model.PDFImp;
import Model.TxtTabImp;
import Model.XMLImp;
import View.Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;

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
    private String copycontent;
    private int estado;

    public Controller(Vista v){
        this.vista = v;
        this.inv = new Invoker();
        this.copycontent = "";
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
        this.estado = -1;
        this.vista.setVisible(true);
        Runnable runnable = new Runnable() {
        @Override
        public void run() {
          // Esto se ejecuta en segundo plano una única vez
          while (true) {
            // Pero usamos un truco y hacemos un ciclo infinito
            try {
              // En él, hacemos que el hilo duerma
              Thread.sleep(500000);
              // Y después realizamos las operaciones
              comando = new SaveCommand(vista.textArea.getText(),originator,careTaker);
              inv.execute(comando);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();



    }

    public void setCopy(String s){
        this.copycontent = s;
    }
    public String getCopy(){
        return this.copycontent;
    }
    public void setEstado(int s){
        this.estado = s;
    }
    public int getEstado(){
        return this.estado;
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
        JTextArea area = vista.textArea;
        Color color = JColorChooser.showDialog(vista, "Colors", Color.yellow);
        area.getSelectedText();
        area.setSelectionColor(color);
        area.requestFocusInWindow();
        FileFactory f = new FileFactory();
        
        //TxtTabImp t = (TxtTabImp)f.crear(f.);
        //t.guardar(this.vista.textArea.getText(), "PruebaTxtTab");
        //pdf.guardar(this.vista.textArea.getText(), "Pruebaxml.xml");
        //pdf.leer("Pruebaxml.xml");
        
    }
    public void undo(){
        comando = new UndoCommand(this,this.vista,this.originator,this.careTaker);
        inv.execute(comando);
    }
    public void redo(){
        comando = new RedoCommand(this,this.vista,this.originator,this.careTaker);
        inv.execute(comando);
    }
    public void copy(){
        comando = new CopyCommand(this,this.vista);
        inv.execute(comando);

    }
    public void cut(){
        comando = new CutCommand(this,this.vista);
        inv.execute(comando);
    }
    public void paste(){
        comando = new PasteCommand(this,this.vista);
        inv.execute(comando);
    }
}
