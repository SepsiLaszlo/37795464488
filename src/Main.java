import javax.swing.*;

public class Main {
    static boolean det = false;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(128 * 5,128 * 6);
        Game.getInstance().setupGame(2, 2);
        f.add(Game.getInstance().getPanel());
        f.setVisible(true);
        Game.getInstance().runGame();

        //Window window = new Window();
    }
}