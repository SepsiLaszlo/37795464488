import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

public class KeyEventHeandler implements KeyListener {

	enum State {COMMAND, PARAMERTER}

	;
	Consumer<Integer> simpleReference = null;
	State currentState = State.COMMAND;

	Controller controller;
	Direction dir;

	KeyEventHeandler(Controller c) {
		controller = c;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (currentState == State.COMMAND) {

			switch (e.getKeyCode()) {
				case KeyEvent.VK_1:

					simpleReference = Controller::moveCharacter;
					currentState = State.PARAMERTER;
					break;


				case KeyEvent.VK_2:

					simpleReference = Controller::characterUseAbility;
					currentState = State.PARAMERTER;
					break;


				case KeyEvent.VK_3:

					simpleReference = Controller::useUsable;
					currentState = State.PARAMERTER;
					break;


				case KeyEvent.VK_4:
					Controller.passCharacter();
					break;

			}

		}
		if (currentState == State.PARAMERTER) {
			simpleReference.accept(Integer.parseInt(String.valueOf(e.getKeyChar())));
			currentState=State.COMMAND;
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
