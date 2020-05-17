import javax.swing.*;
import java.awt.*;

/**
 * Menü osztály a játék felparaméterezéséhez és elindításához.
 */
public class Menu {
	final JPanel topPanel;
	final JPanel centerPanel;
	final JPanel bottomPanel;

	/**
	 * Konstruktor, ami beállítja a menüt.
	 * @param window A menühoz tartozó ablak.
	 */
	Menu(Window window) {
		//JPanelok létrehozása
		topPanel = new JPanel();
		topPanel.setOpaque(false);
		centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		JPanel panel_center_down = new JPanel();
		panel_center_down.setOpaque(false);

		//Felső rész beállítása
		JLabel eskimoLabel = new JLabel("Eskimo number:");
		JLabel researcherLabel = new JLabel("Researcher number:");
		JTextField eskimoTextBox = new JTextField(10);
		JTextField researcherTextBox = new JTextField(10);

		topPanel.setLayout(new FlowLayout());
		topPanel.add(eskimoLabel, BorderLayout.WEST);
		topPanel.add(eskimoTextBox, BorderLayout.WEST);
		topPanel.add(researcherLabel, BorderLayout.EAST);
		topPanel.add(researcherTextBox, BorderLayout.EAST);

		//Középső rész beállítása (Új játék indítása)
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(e -> {
			int eskimoNum = 0;
			int researcherNum = 0;
			try {
				eskimoNum = Integer.parseInt(eskimoTextBox.getText());
				researcherNum = Integer.parseInt(researcherTextBox.getText());
			} catch(Exception ex) { }

			if (eskimoNum + researcherNum > 1) {
				Game.getInstance().setupGame(eskimoNum, researcherNum);
				new Thread(window).start();
			} else {
				JOptionPane.showMessageDialog(window, "Add meg az eszkimók és sarkkutatók számát!", "Error", JOptionPane.WARNING_MESSAGE);
			}
		});

		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(newGameButton);
		//Alsó rész beállítása (Kilépés gomb)
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));

		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(exitButton);
	}
}
