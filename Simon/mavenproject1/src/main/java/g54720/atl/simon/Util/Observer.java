package g54720.atl.simon.Util;

/**
 *
 * @author g54720
 */
public interface Observer {

    /**
     * Call the observed when has changed.
     *
     * @param message
     */
    void update(String message);
}
