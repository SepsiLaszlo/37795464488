import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

/**
 * A játékos inputját fogadó osztály.
 */
public class KeyEventHeandler implements KeyListener {

	enum State {COMMAND, PARAMERTER}

	Consumer<Integer> simpleReference = null;
	State currentState = State.COMMAND;
	Controller controller;
	Direction dir;

	/**
	 * A KeyListener interész egyik implementáladnó metódusa. A programban nem használjuk, ezért üres a függvény.
	 *
	 * @param c az esemény paramétereit tartalmazza
	 */
	KeyEventHeandler(Controller c) {
		controller = c;
	}

	/**
	 * A KeyListener interész egyik implementáladnó metódusa. A programban nem használjuk, ezért üres a függvény.
	 *
	 * @param e az esemény paramétereit tartalmazza
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * A billentyűlenyomások kezeli.
	 *
	 * @param e az esemény paramétereit tartalmazza
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (currentState == State.COMMAND) {

			switch (e.getKeyCode()) {
				case KeyEvent.VK_1:

					simpleReference = Controller::moveCharacter;
					currentState = State.PARAMERTER;
					return;

				case KeyEvent.VK_2:

					simpleReference = Controller::characterUseAbility;
					currentState = State.PARAMERTER;
					return;

				case KeyEvent.VK_3:

					simpleReference = Controller::useUsable;
					currentState = State.PARAMERTER;
					return;

				case KeyEvent.VK_4:
					Controller.digCharacter();
					return;

				case KeyEvent.VK_5:
					Controller.passCharacter();
					return;

			}
		}
		if (currentState == State.PARAMERTER) {
			simpleReference.accept(Integer.parseInt(String.valueOf(e.getKeyChar())));
			currentState = State.COMMAND;
		}

	}

	/**
	 * A KeyListener interész egyik implementáladnó metódusa. A programban nem használjuk, ezért üres a függvény.
	 *
	 * @param e az esemény paramétereit tartalmazza
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
