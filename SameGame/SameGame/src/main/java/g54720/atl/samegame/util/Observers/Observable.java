package g54720.atl.samegame.util.Observers; // tout en minuscule.

/**
 *
 * @author g54720
 */
public interface Observable {

    /**
     * Add the observer to the list of observer.
     *
     * @param observer a observer to be added.
     */
    void subscribe(Observer observer);

    /**
     * Remove the observer to the list of observer.
     *
     * @param observer a observer to be removed
     */
    void unsubscribe(Observer observer);


}
