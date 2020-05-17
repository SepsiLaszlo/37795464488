import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

/**
 * A játékos inputját fogadó osztály.
 */
public class KeyEventHandler implements KeyListener {

	enum State {COMMAND, DIRECTION_PARAMERTER, NUMBER_PARAMETER,SET_DIRECTION}

	Consumer<Integer> simpleReference = null;
	State currentState = State.COMMAND;
	Controller controller;
	Direction dir;

	/**
	 * A KeyListener interész egyik implementáladnó metódusa. A programban nem használjuk, ezért üres a függvény.
	 *
	 * @param c az esemény paramétereit tartalmazza
	 */
	KeyEventHandler(Controller c) {
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
					currentState = State.DIRECTION_PARAMERTER;
					return;

				case KeyEvent.VK_2:

					simpleReference = Controller::characterUseAbility;
					currentState = State.DIRECTION_PARAMERTER;
					return;

				case KeyEvent.VK_3:

					simpleReference = Controller::useUsable;
					currentState = State.NUMBER_PARAMETER;
					return;

				case KeyEvent.VK_4:
					currentState=State.SET_DIRECTION;
					return;

				case KeyEvent.VK_5:
					Controller.digCharacter();
					return;

				case KeyEvent.VK_6:
					Controller.passCharacter();
					return;
				default:
					System.out.println("Érvénytelen menüpotválasztás!");
					return;

			}
		}
		int param = -1;
		if(currentState==State.SET_DIRECTION){

			try {
				param = Integer.parseInt(String.valueOf(e.getKeyChar()));
			} catch (Exception exp) {
				System.out.println("Az inputot nem lehet számmá konvertálni!");
				return;
			}
			Controller.setDirection(param);
		}


		if (currentState == State.DIRECTION_PARAMERTER) {
			param = convertKeyEventToDirection(e);
			if (param == -1) {
				System.out.println("Az inputot nem lehet iránnyá konvertálni!");
				return;
			}
		}
		if (currentState == State.NUMBER_PARAMETER) {
			try {
				param = Integer.parseInt(String.valueOf(e.getKeyChar()));
			} catch (Exception exp) {
				System.out.println("Az inputot nem lehet számmá konvertálni!");
				return;
			}

		}
		simpleReference.accept(param);
		currentState = State.COMMAND;
	}

	/**
	 * A nyíl billenytűket irányokká alakítja, ha lehetésges
	 *
	 * @param e Leütött billenytűt tartalmazó KeyEvent
	 * @return Ha átlakítható, akkor az irány száma. Ellenkező esetben -1.
	 */
	public int convertKeyEventToDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				return 0;

			case KeyEvent.VK_RIGHT:
				return 1;

			case KeyEvent.VK_DOWN:
				return 2;

			case KeyEvent.VK_LEFT:
				return 3;
		}
		return -1;
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
