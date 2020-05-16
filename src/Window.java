import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
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

        this.addKeyListener(new KeyEventHeandler(new Controller()));
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
     * Meghívja a játék fő ciklusát tartalmazó függvényt.
     */
    public  void runGame(){
        //Az ablak meretének beállítása
        this.setSize(new Dimension(1920, 1080));
        //Az ablak cimének beállítása
        this.setTitle("IceField");
        this.setContentPane(Game.getInstance().getPanel());
        this.setResizable(true);
        this.revalidate();
        this.repaint();

        Game.getInstance().runGame();
    }


}
