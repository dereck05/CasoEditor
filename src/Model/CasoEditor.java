/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import View.Vista;
import javax.swing.JFrame;

/**
 *
 * @author derec
 */
public class CasoEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controller c = new Controller(vista);
    }
    
}
