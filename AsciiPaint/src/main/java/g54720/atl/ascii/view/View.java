
package g54720.atl.ascii.view;

import g54720.atl.ascii.model.AsciiPaint;

/**
 *
 * @author g54720
 */
public interface View {

    void startWelcome();

    void displayGame(AsciiPaint paint );
    
    void askCommande();
    
    void stopGame();
}
