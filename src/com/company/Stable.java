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
        System.out.println(Main.tab + ">IceTable.stepOn(Character)");
        System.out.println(Main.tab + "<stepOn(Character)");
    }

    /**
     * Stabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }
}