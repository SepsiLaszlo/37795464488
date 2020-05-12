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

        this.printMenu();
    }

    public void printMenu() {

        //Ha nincs még menü, akkor annak létrehozása
        if (this.menu == null)
            menu = new Menu();

        //Az ablak meretenek megadasa
        this.setSize(new Dimension(500, 500));
        //Az ablak cimenek megadasa
        this.setTitle("IceField - Menu");
        //A menu szerkezetenek megoldasa
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


}
