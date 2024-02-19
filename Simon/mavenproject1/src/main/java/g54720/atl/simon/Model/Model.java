package g54720.atl.Simon.Model;

import g54720.atl.simon.Util.Obervable;
import g54720.atl.simon.Util.Observer;
import g54720.atl.simon.View.Color;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 *
 * @author g54720
 */
public class Model implements Obervable {

    private List<Observer> observers = new ArrayList<>();

    private List<Color> actualSequence = new ArrayList<>();
    private List<Color> longestSequence = new ArrayList<>();
    private List<Color> lastSequence = new ArrayList<>();
    private int comptage = 0;

    public Model() {

    }

    /**
     * Create a new sequence with 3 colors.
     */
    private void newSequence() {
        emptySequence(lastSequence);
        lastSequence.addAll(actualSequence);

        if (actualSequence.size() > longestSequence.size()) {
            emptySequence(longestSequence);
            longestSequence.addAll(actualSequence);
        }
        emptySequence(actualSequence);
        addColorSequence();
    }

    /**
     * Remove all color in the give sequence.
     *
     * @param seqUtil the list of color
     */
    private void emptySequence(List<Color> seqUtil) {
        while (!(seqUtil.isEmpty())) {
            seqUtil.remove(0);
        }
    }

    /**
     * Add a color tho the sequence past in parameters.
     *
     */
    private void addColorSequence() {
        switch (ColorRandom()) {
            case 1:
                actualSequence.add(Color.GREEN);
                break;
            case 2:
                actualSequence.add(Color.RED);
                break;
            case 3:
                actualSequence.add(Color.YELLOW);
                break;
            case 4:
                actualSequence.add(Color.BLUE);
                break;
        }
        comptage=0;
    }

    /**
     * Give a integer between 1 and 4.
     *
     * @return a integer.
     */
    private int ColorRandom() {
        return ((int) (Math.random() * 4)+1);
    }

    /**
     * Start the game with a new sequence.
     */
    public void start() {
        newSequence();
    }

    public void click(String color) {
        if (comptage < actualSequence.size()) {
            if (color.equals(actualSequence.get(comptage).toString())) {
                comptage++;
                System.out.println("gg"+comptage);
            } else {
                System.out.println("perdu");
                comptage = 0;
            }
        }
        
        if (comptage == actualSequence.size()) {
            addColorSequence();
            
            System.out.println("new color"+comptage );
            var pause = new PauseTransition(Duration.seconds(0.50));
            pause.play();
            Notify("play");
        }
    }

    /**
     *
     */
    public void longest() {
        comptage = 0;
        if (longestSequence.size() < actualSequence.size()) {
            actualSequence = List.copyOf(longestSequence);
        }
    }

    /**
     *
     */
    public void last() {
        comptage = 0;
        actualSequence = List.copyOf(lastSequence);
    }

    @Override
    public void Subscribe(Observer newObserver) {
        if (!observers.contains(newObserver)) {
            observers.add(newObserver);
        }
    }

    @Override
    public void Unsubscribe(Observer newObserver) {
        if (observers.contains(newObserver)) {
            observers.remove(newObserver);
        }
    }

    @Override
    public void Notify(String message) {
        observers.forEach(observer -> {
            observer.update(message);
        });
    }

    public List<Color> getActualSequence() {
        return actualSequence;
    }

    public List<Color> getLongestSequence() {
        return longestSequence;
    }

    public List<Color> getLastSequence() {
        return lastSequence;
    }

    public int getComptage() {
        return comptage;
    }
}
