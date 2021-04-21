package puzzlegamefake;

import Controller.GameController;
import Controller.HandlingButton;
import GUI.GameForm;
import java.util.HashMap;
import javax.swing.JButton;
public class puzzlegamefake {
    public static void main(String[] args) {
        GameForm game = new GameForm();
        game.setVisible(true);
        HashMap<Integer, JButton> listButton = new HashMap<>();
        GameController control = new GameController();
        Thread elapse = control.ThreadElapse(game);
        elapse.start();
        control.addAction(listButton, game);
        control.createGameArea(listButton, game);
        HandlingButton handle = new HandlingButton();
        handle.removeButtonAction(listButton);
      
    }

}
