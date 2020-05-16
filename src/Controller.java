/**
 * A játékosok irányításáért felelős osztály.
 */
public class Controller {

	static  Game game=Game.getInstance();

	/**
	 * A soron lévő játékos karakterének jelzi, hogy használja a képességét.
	 * @param d az irány száma
	 */
	public static void characterUseAbility(int d) {
		Character c=game.getCurrCharacter();
		IceTable it= c.getIceTable().getNeighbour(new Direction(d));
		c.useAbility(it);
	}

	/**
	 * 	 * A soron lévő játékos karakterének jelzi, hogy mozogjon.
	 * @param d az irány száma
	 */
	public static void moveCharacter(int d) {
		Character c=game.getCurrCharacter();
		c.move(new Direction(d));
	}

	/**
	 *A soron lévő játékos karakterének jelzi, hogy használja a képességét.
	 * @param idx a kivalaszott tárgy indexe
	 */
	public static void useUsable(int idx) {
		Character c=game.getCurrCharacter();
		c.useUsable(idx);
	}

	public static void digCharacter() {
		Character c=game.getCurrCharacter();
		c.dig();
	}

	/**
	 * Jelzi,hogy a soron lévő játékos átadja a körét.
	 */
	public static void passCharacter() {
		Character c=game.getCurrCharacter();
		c.pass();
	}

}
