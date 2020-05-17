import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    private Menu menu;

    //Konstruktor
    public Window() {
        //Ablak paramétereinek beállítása
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Az ablak cimenek megadasa
        this.setTitle("IceField");
        //Atallitjuk nem atmeretezhetore az ablakot
        this.setResizable(false);
        //Az ablak meretenek megadasa
        this.setSize(new Dimension(500, 500));
        //Az ablak lathatova tevese
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.addKeyListener(new KeyEventHandler(new Controller()));
        this.printMenu();
    }

    /**
     * A menü kirajzolásért felelős függvény
     */
    public void printMenu() {
        //Ha nincs még menü, akkor annak létrehozása
        if (this.menu == null)
            menu = new Menu(this);

        //Az ablak meretének beállítása
        this.setSize(new Dimension(500, 500));
        //Az ablak cimének beállítása
        this.setTitle("IceField - Menu");
        //A menu szerkezetenek beállítása
        this.setLayout(new GridLayout(3, 1));
        this.add(menu.topPanel, BorderLayout.NORTH);
        this.add(menu.centerPanel, BorderLayout.CENTER);
        this.add(menu.bottomPanel, BorderLayout.SOUTH);
        //Atallitjuk nem atmeretezhetore az ablakot
        this.setResizable(false);
        //Ujraervenyesitjuk es ujra kirajzoljuk
        this.revalidate();
        this.repaint();
    }


    /**
     * Beállítja az ablakot és meghívja a játék fő ciklusát tartalmazó függvényt.
     */
    @Override
    public void run() {
        this.setFocusable(true);
        //Az ablak meretének beállítása

        this.setSize(new Dimension(128 * 6 + 10, 128 * 4 + 110));

        //Az ablak cimének beállítása
        this.setTitle("IceField");
        this.setContentPane(Game.getInstance().getPanel());
        this.setResizable(true);
        this.revalidate();
        this.repaint();

        Game.getInstance().runGame();

        this.setContentPane(new Container());
        this.revalidate();
        this.repaint();

        this.printMenu();
    }
}
