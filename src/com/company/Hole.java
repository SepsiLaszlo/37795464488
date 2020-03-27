package com.company;

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
	}

	/**
	 * A kötél hívja meg, amikor vízben lévő játékosokat akarunk kimenteni.
	 * Minden karaktert a characters listából áthelyez
	 * a paraméterben kapott IceTable-re (stepOn(c) függvénnyel).
	 * Ezután törli a characters lista tartalmát.
	 * @param t
	 */
	@Override
	public void removeCharacters(IceTable t) {
	}

	/**
	 * Paraméterül kapott karakterre meghívja a karakter comeOutOfWater() metódusát
	 * és eltávolítja a characters listából.
	 * @param c eltávolítandó karakter
	 */
	@Override
	public void stepOff(Character c) {
	}

}
