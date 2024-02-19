package g54720.atl.simon.View;

import g54720.atl.simon.Controller.Controller;
import g54720.atl.Simon.Model.Model;
import g54720.atl.simon.Util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class SimonView implements Observer {

    private final Button greene = new Button();
    private final Button rede = new Button();
    private final Button yellowe = new Button();
    private final Button bluee = new Button();
    private Slider slide;
    private CheckBox silent;
    private Button btnstart;

    private Controller controller;
    private Model model;

    public SimonView(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.Subscribe(this);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Simon");

        GridPane gride = new GridPane();
        gride.setPadding(new Insets(10));
        GridPane colors = new GridPane();
        VBox game = new VBox();

        greene.setStyle("-fx-background-color : green; ");
        greene.setOpacity(0.3);
        greene.setPrefSize(999, 999);

        rede.setStyle("-fx-background-color : red; ");
        rede.setOpacity(0.3);
        rede.setPrefSize(999, 999);

        yellowe.setStyle("-fx-background-color : yellow; ");
        yellowe.setOpacity(0.3);
        yellowe.setPrefSize(999, 999);

        bluee.setStyle("-fx-background-color : blue;  ");
        bluee.setOpacity(0.3);
        bluee.setPrefSize(999, 999);

        colors.add(greene, 0, 0);
        colors.add(yellowe, 0, 1);
        colors.add(rede, 1, 0);
        colors.add(bluee, 1, 1);
        colors.setAlignment(Pos.BOTTOM_CENTER);

        gride.setAlignment(Pos.CENTER);
        VBox top = new VBox(10);
        HBox mid = new HBox(10);
        VBox bottom = new VBox(10);

        btnstart = new Button("Start");
        btnstart.setStyle("-fx-border-color:#000000; " + "-fx-border-radius: 20px;"
                + "-fx-border-width: 3px;" + "-fx-border-radius: 20px;"
                + "-fx-background-color : red ;" + " -fx-background-radius: 20px;"
                + "-fx-text-fill: white;");

        Button longest = new Button("Longest");
        longest.setStyle("-fx-border-color:#000000; " + "-fx-border-radius: 20px;"
                + "-fx-border-width: 3px;" + "-fx-border-radius: 20px;"
                + "-fx-background-color : orange ;" + " -fx-background-radius: 20px;"
                + "-fx-text-fill: white;");

        Button last = new Button("last");
        last.setStyle("-fx-border-color:#000000; " + "-fx-border-radius: 20px;"
                + "-fx-border-width: 3px;" + "-fx-border-radius: 20px;"
                + "-fx-background-color : orange ;" + " -fx-background-radius: 20px;"
                + "-fx-text-fill: white;");

        slide = new Slider(0.50, 1.50, 1.50);
        slide.setMajorTickUnit(0.25);
        slide.setMinorTickCount(0);
        slide.setShowTickMarks(true);
        Text speed = new Text("Speed");

        Text simone = new Text("SIMON");
        simone.setStyle("-fx-font: 25 arial;");

        Text info = new Text("Info");
        silent = new CheckBox("Silent mode");

        List<Color> j = new ArrayList<>();
        btnstart.setOnAction((t) -> {
            this.update("start");
        });
        last.setOnAction((t) -> {
            this.update("last");
        });
        longest.setOnAction((t) -> {
            this.update("longest");
        });
        greene.setOnAction((ActionEvent actionEvent) -> {
            onAction(greene, 69, silent);
            this.update("click GREEN");
        });
        rede.setOnAction((ActionEvent actionEvent) -> {
            onAction(rede, 71, silent);
            this.update("click RED");
        });
        yellowe.setOnAction((ActionEvent actionEvent) -> {
            onAction(yellowe, 73, silent);
            this.update("click YELLOW");
        });
        bluee.setOnAction((ActionEvent actionEvent) -> {
            onAction(bluee, 77, silent);
            this.update("click BLUE");
        });

        top.getChildren().addAll(simone, speed, slide);
        top.setAlignment(Pos.CENTER);

        gride.addRow(0, top);

        mid.getChildren().addAll(longest, btnstart, last);

        gride.addRow(1, mid);

        bottom.getChildren().addAll(info, silent);
        bottom.setAlignment(Pos.CENTER);

        gride.addRow(2, bottom);

        game.setAlignment(Pos.CENTER);
        game.getChildren().addAll(colors, gride);

        Scene scene = new Scene(game, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Its use for click and illuminate color and play a sound.
     *
     * @param btn a button, a button colored.
     * @param note a int , a music note.
     * @param silence a checkbox, the silent checkbox.
     */
    private void onAction(Button btn, int note, CheckBox silence) {
        btn.setOpacity(1);
        var pause = new PauseTransition(Duration.seconds(0.25));
        pause.setOnFinished(event -> {
            try {
                btn.setOpacity(0.3);
                var synth = MidiSystem.getSynthesizer();
                if (!silence.isSelected()) {
                    synth.open();
                    var channel = synth.getChannels()[0];
                    channel.noteOn(note, 100);
                }
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(SimonView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pause.play();
    }

    /**
     * Play a sequence of color with the list of color take in the parameter.
     *
     * @param colors a list of Color.
     */
    private void playSequence(List<Color> colors) {
        rede.setDisable(true);
        bluee.setDisable(true);
        yellowe.setDisable(true);
        greene.setDisable(true);
        List<Color> colorsCopy = new ArrayList<>();
        for (int i = 0; i < colors.size(); i++) {
            colorsCopy.add(colors.get(i));
        }
        int size = colors.size();
        var timeline = new Timeline(new KeyFrame(Duration.seconds(
                slide.getValue()), (t) -> {

            switch (colorsCopy.get(0)) {
                case GREEN:
                    System.out.println("g");
                    onAction(greene, 69, silent);
                    break;
                case RED:
                    System.out.println("r");
                    onAction(rede, 71, silent);
                    break;
                case YELLOW:
                    System.out.println("y");
                    onAction(yellowe, 73, silent);
                    break;
                case BLUE:
                    System.out.println("b");
                    onAction(bluee, 77, silent);
                    break;
            };

            colorsCopy.remove(0);
        }));
        rede.setDisable(false);
        bluee.setDisable(false);
        yellowe.setDisable(false);
        greene.setDisable(false);
        timeline.setCycleCount(size);
        timeline.play();

    }

    @Override
    public void update(String message) {
        String[] msgCut = message.split(" ");
        switch (msgCut[0]) {
            case "start":
                System.out.println(message);
                model.start();
                update("play");                
                break;
            case "longest":
                if (!(model.getLongestSequence().isEmpty())) {
                    model.longest();
                    update("play");
                } else {
                    System.out.println("choose start");
                }
                break;
            case "last":
                if (!(model.getLastSequence().isEmpty())) {
                    model.last();
                    update("play");
                } else {
                    System.out.println("choose start");
                }
                break;
            case "click":
                model.click(msgCut[1]);
                if (model.getComptage() == (model.getActualSequence().size())) {
                    update("play");
                }
                break;
            case "play":
                playSequence(model.getActualSequence());
                break;
        }
    }

}
