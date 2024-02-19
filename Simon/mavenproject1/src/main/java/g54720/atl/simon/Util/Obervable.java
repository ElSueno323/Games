package g54720.atl.simon.Util;

/**
 *
 * @author g54720
 */
public interface Obervable {

    /**
     * Add the observer to the list of observer.
     *
     * @param observer a observer to be added.
     */
    void Subscribe(Observer observer);

    /**
     * Remove the observer to the list of observer.
     *
     * @param observer a observer to be removed
     */
    void Unsubscribe(Observer observer);

    /**
     *Notify all oberservers of the list by calling their 'update' method.
     * @param message
     */
    void Notify(String message);

}
