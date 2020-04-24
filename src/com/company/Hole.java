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
	 	capacity = 0;
    }

	/**
	 * A paraméterül kapott karakteren meghívja a
	 * fallInWater() metódust és eltárolja a characters listában, majd minden rajta lévő
	 * karakteren meghívja a invadeOtherCharacters() függvényt.
	 * @param c táblára lépő karakter
	 */
    @Override
	public void stepOn(Character c) {
		c.fallInWater();
        characters.add(c);
		for (Character character: characters) {
			character.invadeOtherCharacters();
		}
     }

	/**
	 * A kötél hívja meg, amikor vízben lévő
	 * játékosokat akarunk kimenteni. A táblán lévő karakterek egy lokális változóban
	 * elmentésre kerülnek, majd meghívjuk az osztály stepOff(Characters c) metódusát
	 * minden rajta lévő karakterre. Ezután a paraméterként átadott IceTable-re ráléptetjük
	 * (StepOn(Characters c)) a lokális változóban elmentett karaktereket.
	 * @param t jégtábla, amire kimentett karaktereket helyezi
	 */
	@Override
	public void removeCharacters(IceTable t) {
        for (Character c : characters){
        	stepOff(c);
        	t.stepOn(c);
		}
	}

	/**
	 * Paraméterül kapott karakterten meghívja a
	 * comeOutOfWater() metódust, majd a karaktert eltávolítja a characters listából.
	 * @param c eltávolítandó karakter
	 */
	@Override
	public void stepOff(Character c) {
        c.comeOutOfWater();
        characters.remove(c);
	}

	/**
	 * Visszaadja a saját adattagjait string formátumban. Az alábbi
	 * formában: primitív esetben tagváltozó név: érték, egyébként tagváltozó név: típus.
	 * Tömb típusú tagváltozó esetén kiírjuk a tömb nevét, és alá a tömbben lévő elemeket a
	 * fentebb említett formában. Ez a metódus a tesztelést segíti.
	 * @return adattagok string formátumban
	 */
	public String printStat() {
		return "Hole\n" + super.printStat();
	}
}
