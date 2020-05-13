import javax.swing.*;

public class Main {
    static boolean det = false;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(128 * 4,128 * 4);
        View v = new View();
        v.init(4, 4);
        f.add(v);
        f.setVisible(true);
        //Window window = new Window();
    }

}