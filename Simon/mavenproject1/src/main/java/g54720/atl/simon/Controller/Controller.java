
package g54720.atl.simon.Controller;

import g54720.atl.Simon.Model.Model;
import g54720.atl.simon.View.SimonView;
import javafx.stage.Stage;

/**
 *
 * @author g54720
 */
public class Controller {
    private final Model model;
    private final SimonView view;
    
    public Controller(Model model,Stage stage){
        this.model=model;
        this.view = new SimonView(this,model);
        this.view.start(stage);
        //model.initialize();       
    }
}
