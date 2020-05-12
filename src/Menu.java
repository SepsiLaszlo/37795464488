import javax.swing.*;
import java.awt.*;

public class Menu {

    final JPanel topPanel;
    final JPanel centerPanel;
    final JPanel bottomPanel;
    //Jatekosszam
//    private int eskimoNumber = 0;
//    private int researcherNumber = 0;

    //Konstruktor
    Menu() {
        //JPanelok létrehozása
        topPanel = new JPanel();
        topPanel.setOpaque(false);
        centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        JPanel panel_center_down = new JPanel();
        panel_center_down.setOpaque(false);

        //Középső rész beállítása
        JLabel eskimoLabel = new JLabel("Eskimo number:");
        JLabel researcherLabel = new JLabel("Researcher number:");
        JTextField eskimoTextBox = new JTextField(10);
        JTextField researcherTextBox = new JTextField(10);

        topPanel.setLayout(new FlowLayout());
        topPanel.add(eskimoLabel, BorderLayout.WEST);
        topPanel.add(eskimoTextBox, BorderLayout.WEST);
        topPanel.add(researcherLabel, BorderLayout.EAST);
        topPanel.add(researcherTextBox, BorderLayout.EAST);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            int eskimoNum = Integer.parseInt(eskimoTextBox.getText());
            int researcherNum = Integer.parseInt(researcherTextBox.getText());

//            if (eskimoNum > 0 && researcherNum > 0)
//                Game.getInstance().setupGame( eskimoNum, researcherNum );
        });

        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(newGameButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(exitButton);
    }
}
