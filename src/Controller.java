public class Controller {

	static  Game game=Game.getInstance();

	public static void characterUseAbility(int d) {
		Character c=game.getCurrCharacter();
		IceTable it= c.getIceTable().getNeighbour(new Direction(d));
		c.useAbility(it);
	}

	public static void moveCharacter(int d) {
		Character c=game.getCurrCharacter();
		c.move(new Direction(d));
	}

	public static void useUsable(int idx) {
		Character c=game.getCurrCharacter();
		c.useUsable(idx);
	}


	public static void passCharacter() {
		Character c=game.getCurrCharacter();
		c.pass();
	}

}
