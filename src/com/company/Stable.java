package com.company;

public class Stable extends IceTable {

    /**
	 * Stable osztály konstruktora
	 * @param p a táblán található tárgy (lehet null)
	 */
    public Stable(Pickable p){
        super(p);
    }

    /**
	 * Paraméterül kap egy karaktert, amit eltárol a characters listában.
	 * @param c eltárolandó karakter
	 */
    @Override
    public void stepOn(Character c) {
    }

    /**
     * Stabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }
}