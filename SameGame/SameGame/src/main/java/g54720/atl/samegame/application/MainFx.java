package g54720.atl.samegame.application;

import g54720.atl.samegame.controller.ControllerFx;
import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.view.viewfx.ViewFx;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author g54720
 */
public class MainFx extends Application {

    /**
     * Launch the windows for the java Fx
     *
     * @param args array of string
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        var model = new Model();
        var controller = new ControllerFx(model, new ViewFx(model, stage));
    }
}


