package g54720.atl.ascii.view;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Shape;
import g54720.atl.ascii.model.Point;
import java.util.Scanner;

/**
 *
 * @author g54720
 */
public class MyView implements View {

    AsciiPaint paint;

    public MyView(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void startWelcome() {
        System.out.println("---------- ASCII Paint ----------\n\n");
        this.paint = new AsciiPaint();
    }

    @Override
    public void displayGame(AsciiPaint model) {
        String board = new String();
        for (int x = 0; x < model.getHeight(); x++) {
            for (int y = 0; y < model.getWidth(); y++) {
                Shape shape = model.getShapeAt(new Point(x, y));
                if (shape == null) {
                    board += " ";
                } else {
                    board += shape.getColor();
                }
            }
            board += "\n";
        }
        System.out.println(board);
    }

    @Override
    public void askCommande() {
        System.out.println("Give me a task\n-->"
                + "show :see the map \n-->exit"
                + "\n-->list :give the list with order shape"
                + "\n-->color 'n°shape' 'newcolor' : change color of shape"
                + "\n-->ungroup 'n°shape' : ungroup a shape "
                + "\n-->group 'n°shape' 'n°shape': group two shape||group of shape "
                + "\n-->move 'n°shape' 'addX' 'addY' "
                + "\n-->delete 'shape' : delete a shape "
                + "\n-->add 'rectangle|circle|square|line' 'x' 'y' "
                + "{'width' 'heigth''}||'radius'||'side'||'dx' 'dy'  'color' "
                + "\n-->undo : cancel the last commande"
                + "\n-->redo :re-run the last cancel commande ");
        ;
    }

    @Override
    public void stopGame() {
        System.out.println("\n\n Bye Bye ! ");
    }

}
