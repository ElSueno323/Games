package g54720.atl.Simon.Application;

import g54720.atl.simon.Controller.Controller;
import g54720.atl.Simon.Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author g54720
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        var model = new Model();
        var controller = new Controller(model,stage);
    }
}
