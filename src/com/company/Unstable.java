package com.company;

/**
 *  Az instabil jégtáblák reprezentálására. Ezekbe Pickable-ek lehetnek befagyva, állhat rajta
 * szereplő és boríthatja hó.
 */
public class Unstable extends IceTable {

    /**
     * Unstable osztály konstruktora
     * @param p a táblán található tárgy (lehet null)
     */
    public Unstable(Pickable p) {
        super(p);
    }

    /**
     * Paraméterül kap egy karaktert, amit eltárol a characters
     * listában. Amennyiben a ezzel az új karakterrel már a tárolt karakterek száma
     * meghaladja a tábla kapacitását, akkor az instabil jégtábla átfordul és a rajta lévő
     * karakterek megfulladnak. Ezt úgy szimulálja, hogy a karaktereken meghívja a die()
     * metódust. Viszont ha a tábla nem fordul át, akkor minden rajta álló karakteren
     * meghívja az invadeOtherCharacters() függvényt.
     * @param c táblára lépő karakter
     */
    @Override
    public void stepOn(Character c) {
        if(capacity <= characters.size() + 1) {
            c.die();
            return;
        }
        characters.add(c);
        for (Character character: characters) {
            character.invadeOtherCharacters();
        }
    }

    /**
     * Instabil esetben nem csinál semmit a metódus.
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
    public String printStat() {
        return null;
    }
}