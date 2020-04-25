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
	 * Paraméterül kap egy karaktert, amit eltárol a characters
     * listában. Ezután minden karakteren meghívja az invadeOtherCharacters() függvényt.
	 * @param c táblára lépő karakter
	 */
    @Override
    public void stepOn(Character c) {
        characters.add(c);
        for (Character character: characters) {
            character.invadeOtherCharacters();
        }
    }

    /**
     * Stabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }

    /**
     * Visszaadja a saját adattagjait string formátumban. Az alábbi
     * formában: primitív esetben tagváltozó név: érték, egyébként tagváltozó név: típus.
     * Tömb típusú tagváltozó esetén kiírjuk a tömb nevét, és alá a tömbben lévő elemeket a
     * fentebb említett formában. Ez a metódus a tesztelést segíti.
     * @return adattagok string formátumban
     */
    @Override
    public String toString() {
        return String.format( "Stable\n" + super.toString() );
    }
}