/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author naty9
 */
public abstract class AbstractFactory {
    public static final int PDF = 1 ;
    public static final int CSV = 2 ;
    public static final int XML = 3 ;
    public static final int JSON = 4 ;
    public static final int TXT = 5;
    public static final int TXTab = 6;
    
    public abstract IArchivo crear(int n);

}
