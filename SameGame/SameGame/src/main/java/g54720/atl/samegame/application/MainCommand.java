
package g54720.atl.samegame.application;

import g54720.atl.samegame.controller.Controller;

import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.view.viewconsole.ViewConsole;

/**
 *
 * @author g54720
 */
public class MainCommand {
    /**
     * Begin the game in console mode.
     * @param args a array of string
     */
    public static void main(String[] args) {
        
        Model model =new Model();
        Controller control=new Controller(model,new ViewConsole(model));
        control.Begin();
    }
}








