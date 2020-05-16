import javax.swing.*;

public class Main {
    static boolean det = false;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(128 * 6 + 10,128 * 4 + 115);
        Game.getInstance().setupGame(1, 1);
        f.add(Game.getInstance().getPanel());
        f.setVisible(true);
        Game.getInstance().runGame();

        //Window window = new Window();
    }
}