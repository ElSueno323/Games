package g54720.atl.ascii.controller;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.view.MyView;

/**
 * Execute the Ascii.
 *
 * @author g54720
 */
public class Application {

    public static void main(String[] args) {
        AsciiPaint model = new AsciiPaint();
        Controller controller = new Controller(model, new MyView(model));
        controller.start();
    }
}
