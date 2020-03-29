package com.company;
/**
 * A jégtáblák közti lukakat reprezentáló osztály. Ebben nem lehetnek felvehető tárgyak.
 */
public class Hole extends IceTable {

	/**
	 * Hole osztály konstruktora
	 */
	 public Hole(){
	 	super(null);
    }

	/**
	 * Paraméterül kap egy karaktert, amit eltárol a characterslistában,
	 * és meghívja rajta a fallInWater() metódust.
	 * Ezen kívül a karakter alatt beszakad a hó így a snowLayer értéke 0 lesz.
	 * @param c eltárolandó karakter
	 */
    @Override
	public void stepOn(Character c) {
    	System.out.println(Main.tab + ">Hole.stepOn(Character)");
        Main.tab += "\t";

        characters.add(c);
        c.fallInWater();

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<Hole.stepOn(Character)");
	}

	/**
	 * A kötél hívja meg, amikor vízben lévő játékosokat akarunk kimenteni.
	 * 	Minden karaktert a characters listából áthelyez
	 * a paraméterben kapott IceTable-re (stepOn(c) függvénnyel).
	 * Ezután törli a characters lista tartalmát.
	 * @param t
	 */
	@Override
	public void removeCharacters(IceTable t) {
		System.out.println(Main.tab + ">removeCharacters(IceTable)");
        Main.tab += "\t";

        for (Character c : this.characters){
        	stepOff(c);
        	c.comeOutOfWater();
        	t.stepOn(c);
		}

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<removeCharacters(IceTable)");
	}

	/**
	 * Paraméterül kapott karakterre meghívja a karakter comeOutOfWater() metódusát
	 * és eltávolítja a characters listából.
	 * @param c eltávolítandó karakter
	 */
	@Override
	public void stepOff(Character c) {
		System.out.println(Main.tab + ">Hole.stepOff(Character)");
        Main.tab += "\t";

        c.comeOutOfWater();

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<Hole.stepOff(Character)");
	}

}
