/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Commands;

import Model.Commands.CommandManager;
import java.io.OutputStream;

/**
 *
 * @author naty9
 */
public abstract class BaseCommand {
    
    public void execute(ICommand command){
        CommandManager cm = CommandManager.getInstance();
        cm.registerCommand(command);
        ICommand c=cm.getCommand();
        c.execute();
    }
}
