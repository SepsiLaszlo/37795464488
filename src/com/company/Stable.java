package com.company;

/**
 * A stabil jégtáblák reprezentálására. Ezekbe Pickable-ek lehetnek befagyva, állhat rajta
 * szereplő és boríthatja hó.
 */
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
        System.out.println(Main.tab + ">Stable.stepOn(Character)");
        characters.add(c);
        System.out.println(Main.tab + "<Stable.stepOn(Character)");
    }

    /**
     * Stabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }
}